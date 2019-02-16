/*
* The MIT License
* 
* Copyright: Copyright (C) 2017 T2Ti.COM
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
package com.t2tierp.model.dao.frentecaixa;

import com.t2tierp.model.dao.nfce.NfceDaoGenerico;
import com.t2tierp.model.bean.frentecaixa.Logss;
import javax.persistence.Query;

public class LogssDao extends NfceDaoGenerico<Logss> {

    private static final long serialVersionUID = 1L;

    public LogssDao() {
        super(Logss.class);
    }

    private Logss logss;
    private Long totalProduto = 0l;
    private Long totalR01 = 0l;
    private Long totalR02 = 0l;
    private Long totalR03 = 0l;
    private Long totalR04 = 0l;
    private Long totalR05 = 0l;
    private Long totalR06 = 0l;
    private Long totalR07 = 0l;
    private Long totalTipoPagamento = 0l;

    public void atualizarQuantidades() throws Exception {
        buscaRegistroLog();
        buscaQuantidades();

        logss.setProduto(totalProduto.intValue());
        logss.setR01(totalR01.intValue());
        logss.setR02(totalR02.intValue());
        logss.setR03(totalR03.intValue());
        logss.setR04(totalR04.intValue());
        logss.setR05(totalR05.intValue());
        logss.setR06(totalR06.intValue());
        logss.setR07(totalR07.intValue());
        logss.setTtp(totalTipoPagamento.intValue());

        merge(logss);
    }

    public boolean verificarQuantidade() throws Exception {
        buscaRegistroLog();
        buscaQuantidades();
        if (logss.getProduto().intValue() == totalProduto.intValue()
                && logss.getR01().intValue() == totalR01.intValue()
                && logss.getR02().intValue() == totalR02.intValue()
                && logss.getR03().intValue() == totalR03.intValue()
                && logss.getR04().intValue() == totalR04.intValue()
                && logss.getR05().intValue() == totalR05.intValue()
                && logss.getR06().intValue() == totalR06.intValue()
                && logss.getR07().intValue() == totalR07.intValue()
                && logss.getTtp().intValue() == totalTipoPagamento.intValue()) {
            return true;
        }
        return false;
    }

    private void buscaRegistroLog() throws Exception {
        logss = getBean(1);
        if (logss == null) {
            throw new Exception("Registro de LOG não encontrado.");
        }
    }

    private void buscaQuantidades() throws Exception {
        try {
            abrirConexao();
            Query query;
            query = em.createQuery("SELECT COUNT(o.id) FROM Produto o");
            totalProduto = (Long) query.getSingleResult();
            query = em.createQuery("SELECT COUNT(o.id) FROM R01 o");
            totalR01 = (Long) query.getSingleResult();
            query = em.createQuery("SELECT COUNT(o.id) FROM R02 o");
            totalR02 = (Long) query.getSingleResult();
            query = em.createQuery("SELECT COUNT(o.id) FROM R03 o");
            totalR03 = (Long) query.getSingleResult();
            query = em.createQuery("SELECT COUNT(o.id) FROM EcfVendaCabecalho o");
            totalR04 = (Long) query.getSingleResult();
            query = em.createQuery("SELECT COUNT(o.id) FROM EcfVendaDetalhe o");
            totalR05 = (Long) query.getSingleResult();
            query = em.createQuery("SELECT COUNT(o.id) FROM R06 o");
            totalR06 = (Long) query.getSingleResult();
            query = em.createQuery("SELECT COUNT(o.id) FROM R07 o");
            totalR07 = (Long) query.getSingleResult();
            query = em.createQuery("SELECT COUNT(o.id) FROM EcfTotalTipoPagamento o");
            totalTipoPagamento = (Long) query.getSingleResult();
        } catch (Exception e) {
            throw e;
        } finally {
            if (isAutoCommit()) {
                fecharConexao();
            }
        }
    }
}
