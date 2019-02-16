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
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "IBPT")
public class Ibpt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NCM")
    private String ncm;
    @Column(name = "EX")
    private String ex;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "NACIONAL_FEDERAL")
    private BigDecimal nacionalFederal;
    @Column(name = "IMPORTADOS_FEDERAL")
    private BigDecimal importadosFederal;
    @Column(name = "ESTADUAL")
    private BigDecimal estadual;
    @Column(name = "MUNICIPAL")
    private BigDecimal municipal;
    @Temporal(TemporalType.DATE)
    @Column(name = "VIGENCIA_INICIO")
    private Date vigenciaInicio;
    @Temporal(TemporalType.DATE)
    @Column(name = "VIGENCIA_FIM")
    private Date vigenciaFim;
    @Column(name = "CHAVE")
    private String chave;
    @Column(name = "VERSAO")
    private String versao;
    @Column(name = "FONTE")
    private String fonte;

    public Ibpt() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getNacionalFederal() {
        return nacionalFederal;
    }

    public void setNacionalFederal(BigDecimal nacionalFederal) {
        this.nacionalFederal = nacionalFederal;
    }

    public BigDecimal getImportadosFederal() {
        return importadosFederal;
    }

    public void setImportadosFederal(BigDecimal importadosFederal) {
        this.importadosFederal = importadosFederal;
    }

    public BigDecimal getEstadual() {
        return estadual;
    }

    public void setEstadual(BigDecimal estadual) {
        this.estadual = estadual;
    }

    public BigDecimal getMunicipal() {
        return municipal;
    }

    public void setMunicipal(BigDecimal municipal) {
        this.municipal = municipal;
    }

    public Date getVigenciaInicio() {
        return vigenciaInicio;
    }

    public void setVigenciaInicio(Date vigenciaInicio) {
        this.vigenciaInicio = vigenciaInicio;
    }

    public Date getVigenciaFim() {
        return vigenciaFim;
    }

    public void setVigenciaFim(Date vigenciaFim) {
        this.vigenciaFim = vigenciaFim;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    @Override
    public String toString() {
        return "com.t2tierp.model.bean.cadastros.Ibpt[id=" + id + "]";
    }

}
