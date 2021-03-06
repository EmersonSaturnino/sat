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
package com.t2tierp.model.bean.financeiro;

import com.t2tierp.model.bean.cadastros.Cliente;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "FIN_COBRANCA")
public class FinCobranca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_CONTATO")
    private Date dataContato;
    @Column(name = "HORA_CONTATO")
    private String horaContato;
    @Column(name = "TELEFONE_CONTATO")
    private String telefoneContato;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_ACERTO_PAGAMENTO")
    private Date dataAcertoPagamento;
    @Column(name = "TOTAL_RECEBER_NA_DATA")
    private BigDecimal totalReceberNaData;
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Cliente cliente;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "finCobranca", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FinCobrancaParcelaReceber> listaFinCobrancaParcelaReceber;
    @Transient
    private BigDecimal totalJuros;
    @Transient
    private BigDecimal totalMulta;
    @Transient
    private BigDecimal totalAtrasado;

    public FinCobranca() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataContato() {
        return dataContato;
    }

    public void setDataContato(Date dataContato) {
        this.dataContato = dataContato;
    }

    public String getHoraContato() {
        return horaContato;
    }

    public void setHoraContato(String horaContato) {
        this.horaContato = horaContato;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    public Date getDataAcertoPagamento() {
        return dataAcertoPagamento;
    }

    public void setDataAcertoPagamento(Date dataAcertoPagamento) {
        this.dataAcertoPagamento = dataAcertoPagamento;
    }

    public BigDecimal getTotalReceberNaData() {
        return totalReceberNaData;
    }

    public void setTotalReceberNaData(BigDecimal totalReceberNaData) {
        this.totalReceberNaData = totalReceberNaData;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "com.t2tierp.model.bean.financeiro.FinCobranca[id=" + id + "]";
    }

    public Set<FinCobrancaParcelaReceber> getListaFinCobrancaParcelaReceber() {
        return listaFinCobrancaParcelaReceber;
    }

    public void setListaFinCobrancaParcelaReceber(Set<FinCobrancaParcelaReceber> listaFinCobrancaParcelaReceber) {
        this.listaFinCobrancaParcelaReceber = listaFinCobrancaParcelaReceber;
    }

    public BigDecimal getTotalJuros() {
        return totalJuros;
    }

    public void setTotalJuros(BigDecimal totalJuros) {
        this.totalJuros = totalJuros;
    }

    public BigDecimal getTotalMulta() {
        return totalMulta;
    }

    public void setTotalMulta(BigDecimal totalMulta) {
        this.totalMulta = totalMulta;
    }

    public BigDecimal getTotalAtrasado() {
        return totalAtrasado;
    }

    public void setTotalAtrasado(BigDecimal totalAtrasado) {
        this.totalAtrasado = totalAtrasado;
    }

}
