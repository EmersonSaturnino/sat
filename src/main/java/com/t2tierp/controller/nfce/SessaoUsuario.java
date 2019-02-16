/*
 * The MIT License
 *
 * Copyright: Copyright (C) 2014 T2Ti.COM
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * 
 * The author may be contacted at: t2ti.com@gmail.com
 * 
 * @author Claudio de Barros (T2Ti.com)
 * 
 */
package com.t2tierp.controller.nfce;

import com.t2tierp.controller.nfe.StatusServico;
import com.t2tierp.controller.pafecf.Tipos;
import com.t2tierp.model.bean.nfce.NfceConfiguracao;
import com.t2tierp.model.bean.nfce.NfceMovimento;
import com.t2tierp.model.bean.nfce.NfceOperador;
import com.t2tierp.model.bean.nfce.NfceTipoPagamento;
import com.t2tierp.model.bean.nfe.NfeCabecalho;
import com.t2tierp.model.dao.nfce.NfceDaoGenerico;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.util.List;
import javax.swing.JOptionPane;

public class SessaoUsuario implements Tipos {

    private static NfceConfiguracao configuracao;
    public static NfceMovimento movimento = null;
    public static int statusCaixa = SC_ABERTO;
    public static int menuAberto = NAO;
    public static NfceOperador usuario;
    public static NfeCabecalho vendaAtual;
    private static List<NfceTipoPagamento> listaTipoPagamento;
    public static KeyStore certificado;
    public static char[] senhaCertificado;

    private SessaoUsuario() {
    }

    static {
        NfceDaoGenerico<NfceConfiguracao> dao = new NfceDaoGenerico<>(NfceConfiguracao.class);
        NfceDaoGenerico<NfceTipoPagamento> tipoPagamentoDao = new NfceDaoGenerico<>(NfceTipoPagamento.class);
        try {
            
            listaTipoPagamento = tipoPagamentoDao.getBeans();
            configuracao = dao.getBean(1);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao buscar as configurações do sistema.\n" + ex.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static NfceConfiguracao getConfiguracao() {
        return configuracao;
    }

    public static List<NfceTipoPagamento> getListaTipoPagamento() {
        return listaTipoPagamento;
    }

    public static void autenticaUsuario(String login, String senha) {
        try {
            NfceDaoGenerico<NfceOperador> dao = new NfceDaoGenerico<>(NfceOperador.class);
            usuario = dao.getBean("login", login, "senha", senha);
        } catch (Exception ex) {
        }
    }

    public static NfceOperador autenticaGerenteSupervisor(String login, String senha) {
        try {
            NfceDaoGenerico<NfceOperador> dao = new NfceDaoGenerico<>(NfceOperador.class);
            NfceOperador operador = dao.getBean("login", login, "senha", senha);
            if (operador.getNivelAutorizacao().equals("G")
                    || operador.getNivelAutorizacao().equals("S")) {
                return operador;
            }
            return null;
        } catch (Exception ex) {
            return null;
        }
    }

    public static void carregaCertificado() throws Exception {
        certificado = KeyStore.getInstance("PKCS12");
        senhaCertificado = configuracao.getCertificadoDigitalSenha().toCharArray();
        certificado.load(new FileInputStream(configuracao.getCertificadoDigitalCaminho()), senhaCertificado);
        certificado.aliases().nextElement();
    }

    public static void statusServico() {
        try {
            StatusServico statusNfe = new StatusServico();
            String resposta = statusNfe.verificaStatusServico(certificado, certificado.aliases().nextElement(), senhaCertificado);
            JOptionPane.showMessageDialog(null, resposta, "Informação do Sistema", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar o status do serviço.\n" + e.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }
}
