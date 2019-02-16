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
package com.t2tierp.view.sat;

import com.t2tierp.controller.nfce.SessaoUsuario;
import com.t2tierp.controller.sat.SatController;
import com.t2tierp.controller.sat.TratarRetornoSAT;
import java.awt.Font;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Caixa extends com.t2tierp.view.nfce.Caixa {

    public static void main(String args[]) {
        //seta o look and feel para o do SO
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Caixa c = new Caixa();
                c.setVisible(true);
                c.executaProcedimentosConfiguracao();
            }
        });
    }    
    
    @Override
    protected void definirMenuOperacoes() {
        super.definirMenuOperacoes();
        modelMenuOperacoes.clear();
        modelMenuOperacoes.addElement("Consultar SAT");
        modelMenuOperacoes.addElement("Bloquear SAT");
        modelMenuOperacoes.addElement("Desbloquear SAT");
    }

    @Override
    protected void teclouEnter() {
        if (this.getFocusOwner() == listaMenuOperacoes) {
            //Consulta SAT
            if (listaMenuOperacoes.getSelectedIndex() == 0) {
                String resposta = SatController.sat.ConsultarSAT(new Random().nextInt(999999));
                JOptionPane.showMessageDialog(this, resposta, "Consultar SAT", JOptionPane.INFORMATION_MESSAGE);
            }

            //Bloquear SAT
            if (listaMenuOperacoes.getSelectedIndex() == 1) {
                if (SessaoUsuario.statusCaixa != SC_VENDA_EM_ANDAMENTO) {
                    String resposta = SatController.sat.BloquearSAT(new Random().nextInt(999999), SatController.codigoAtivacao);
                    JOptionPane.showMessageDialog(this, resposta, "Bloquear SAT", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Existe uma venda em andamento.", "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);
                }
            }

            //Desbloquear SAT
            if (listaMenuOperacoes.getSelectedIndex() == 2) {
                if (SessaoUsuario.statusCaixa != SC_VENDA_EM_ANDAMENTO) {
                    String resposta = SatController.sat.DesbloquearSAT(new Random().nextInt(999999), SatController.codigoAtivacao);
                    JOptionPane.showMessageDialog(this, resposta, "Bloquear SAT", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Existe uma venda em andamento.", "Aviso do Sistema", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } else {
            super.teclouEnter();
        }
    }

    @Override
    protected void concluiEncerramentoVenda() {
        try {
            FinalizaVenda finalizaVenda = new FinalizaVenda(this, true);
            finalizaVenda.setLocationRelativeTo(null);
            finalizaVenda.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao concluir a venda.\n" + ex.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    protected void cancelaInutilizaNota() {
        try {
            UIManager.put("OptionPane.messageFont", new Font("Courier New", Font.PLAIN, 12));
            String resultado = TratarRetornoSAT.retornoStatusOperacional(SatController.sat.ConsultarStatusOperacional(new Random().nextInt(999999), SatController.codigoAtivacao));
            JOptionPane.showMessageDialog(this, resultado, "Status Operacional", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao consultar o status operacional.\n" + ex.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

    
}
