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
package com.t2tierp.model.bean.cadastros;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "CEST")
public class Cest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ITEM")
    private Integer item;
    @Column(name = "CEST")
    private String cest;
    @Column(name = "NCM_SH")
    private String ncmSh;
    @Column(name = "DESCRICAO_SEGMENTO")
    private String descricaoSegmento;
    @Column(name = "DESCRICAO_CEST")
    private String descricaoCest;
    @Column(name = "SIGLA_UNIDADE")
    private String siglaUnidade;
    @Column(name = "DESCRICAO_UNIDADE")
    private String descricaoUnidade;

    public Cest() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public String getCest() {
        return cest;
    }

    public void setCest(String cest) {
        this.cest = cest;
    }

    public String getNcmSh() {
        return ncmSh;
    }

    public void setNcmSh(String ncmSh) {
        this.ncmSh = ncmSh;
    }

    public String getDescricaoSegmento() {
        return descricaoSegmento;
    }

    public void setDescricaoSegmento(String descricaoSegmento) {
        this.descricaoSegmento = descricaoSegmento;
    }

    public String getDescricaoCest() {
        return descricaoCest;
    }

    public void setDescricaoCest(String descricaoCest) {
        this.descricaoCest = descricaoCest;
    }

    public String getSiglaUnidade() {
        return siglaUnidade;
    }

    public void setSiglaUnidade(String siglaUnidade) {
        this.siglaUnidade = siglaUnidade;
    }

    public String getDescricaoUnidade() {
        return descricaoUnidade;
    }

    public void setDescricaoUnidade(String descricaoUnidade) {
        this.descricaoUnidade = descricaoUnidade;
    }

    @Override
    public String toString() {
        return "com.t2tierp.model.bean.cadastros.Cest[id=" + id + "]";
    }

}
