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

import com.t2tierp.infra.frentecaixa.Biblioteca;
import com.t2tierp.model.bean.frentecaixa.DavCabecalho;
import com.t2tierp.model.bean.frentecaixa.DavDetalhe;
import java.util.List;
import javax.persistence.Query;

public class DavDao extends DaoGenerico<DavCabecalho> {

    private static final long serialVersionUID = 1L;

    public DavDao() {
        super(DavCabecalho.class, Biblioteca.TIPO_CONEXAO_RETAGUARDA);
    }

    public List<DavCabecalho> getDavPendentes() throws Exception{
        try {
            abrirConexao();
            Query query = em.createQuery("SELECT DISTINCT d FROM DavCabecalho d LEFT JOIN FETCH d.listaDavDetalhe WHERE d.situacao = 'P' ORDER BY d.numeroDav");
            return query.getResultList();
        } catch (Exception e) {
            throw e;
        } finally {
            if (isAutoCommit()) {
                fecharConexao();
            }
        }
    }

    @Override
    protected void gravaLog(DavCabecalho bean) throws Exception {
        for (DavDetalhe davDetalhe : bean.getListaDavDetalhe()) {
            davDetalhe.setLogss(Biblioteca.hashRegistro(davDetalhe));
        }
        super.gravaLog(bean);
    }

}
