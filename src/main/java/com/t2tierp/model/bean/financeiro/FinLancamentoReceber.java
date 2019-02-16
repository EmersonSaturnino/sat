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

@Entity
@Table(name = "FIN_LANCAMENTO_RECEBER")
public class FinLancamentoReceber implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "QUANTIDADE_PARCELA")
    private Integer quantidadeParcela;
    @Column(name = "VALOR_TOTAL")
    private BigDecimal valorTotal;
    @Column(name = "VALOR_DESCONTO_CONVENIO")
    private BigDecimal valorDescontoConvenio;
    @Column(name = "VALOR_A_RECEBER")
    private BigDecimal valorAReceber;
    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_LANCAMENTO")
    private Date dataLancamento;
    @Column(name = "NUMERO_DOCUMENTO")
    private String numeroDocumento;
    @Temporal(TemporalType.DATE)
    @Column(name = "PRIMEIRO_VENCIMENTO")
    private Date primeiroVencimento;
    @Column(name = "TAXA_COMISSAO")
    private BigDecimal taxaComissao;
    @Column(name = "VALOR_COMISSAO")
    private BigDecimal valorComissao;
    @Column(name = "INTERVALO_ENTRE_PARCELAS")
    private Integer intervaloEntreParcelas;
    @Column(name = "CODIGO_MODULO_LCTO")
    private String codigoModuloLcto;
    @Column(name = "MESCLADO_PARA")
    private Integer mescladoPara;
    @Column(name = "HASH_MODULO_LCTO")
    private String hashModuloLcto;
    @JoinColumn(name = "ID_FIN_DOCUMENTO_ORIGEM", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private FinDocumentoOrigem finDocumentoOrigem;
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Cliente cliente;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "finLancamentoReceber", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FinParcelaReceber> listaFinParcelaReceber;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "finLancamentoReceber", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FinLctoReceberNtFinanceira> listaFinLctoReceberNtFinanceira;

    public FinLancamentoReceber() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantidadeParcela() {
        return quantidadeParcela;
    }

    public void setQuantidadeParcela(Integer quantidadeParcela) {
        this.quantidadeParcela = quantidadeParcela;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorDescontoConvenio() {
        return valorDescontoConvenio;
    }

    public void setValorDescontoConvenio(BigDecimal valorDescontoConvenio) {
        this.valorDescontoConvenio = valorDescontoConvenio;
    }

    public BigDecimal getValorAReceber() {
        return valorAReceber;
    }

    public void setValorAReceber(BigDecimal valorAReceber) {
        this.valorAReceber = valorAReceber;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Date getPrimeiroVencimento() {
        return primeiroVencimento;
    }

    public void setPrimeiroVencimento(Date primeiroVencimento) {
        this.primeiroVencimento = primeiroVencimento;
    }

    public BigDecimal getTaxaComissao() {
        return taxaComissao;
    }

    public void setTaxaComissao(BigDecimal taxaComissao) {
        this.taxaComissao = taxaComissao;
    }

    public BigDecimal getValorComissao() {
        return valorComissao;
    }

    public void setValorComissao(BigDecimal valorComissao) {
        this.valorComissao = valorComissao;
    }

    public Integer getIntervaloEntreParcelas() {
        return intervaloEntreParcelas;
    }

    public void setIntervaloEntreParcelas(Integer intervaloEntreParcelas) {
        this.intervaloEntreParcelas = intervaloEntreParcelas;
    }

    public String getCodigoModuloLcto() {
        return codigoModuloLcto;
    }

    public void setCodigoModuloLcto(String codigoModuloLcto) {
        this.codigoModuloLcto = codigoModuloLcto;
    }

    public Integer getMescladoPara() {
        return mescladoPara;
    }

    public void setMescladoPara(Integer mescladoPara) {
        this.mescladoPara = mescladoPara;
    }

    public String getHashModuloLcto() {
        return hashModuloLcto;
    }

    public void setHashModuloLcto(String hashModuloLcto) {
        this.hashModuloLcto = hashModuloLcto;
    }

    public FinDocumentoOrigem getFinDocumentoOrigem() {
        return finDocumentoOrigem;
    }

    public void setFinDocumentoOrigem(FinDocumentoOrigem finDocumentoOrigem) {
        this.finDocumentoOrigem = finDocumentoOrigem;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "com.t2tierp.model.bean.financeiro.FinLancamentoReceber[id=" + id + "]";
    }

    public Set<FinParcelaReceber> getListaFinParcelaReceber() {
        return listaFinParcelaReceber;
    }

    public void setListaFinParcelaReceber(Set<FinParcelaReceber> listaFinParcelaReceber) {
        this.listaFinParcelaReceber = listaFinParcelaReceber;
    }

    public Set<FinLctoReceberNtFinanceira> getListaFinLctoReceberNtFinanceira() {
        return listaFinLctoReceberNtFinanceira;
    }

    public void setListaFinLctoReceberNtFinanceira(Set<FinLctoReceberNtFinanceira> listaFinLctoReceberNtFinanceira) {
        this.listaFinLctoReceberNtFinanceira = listaFinLctoReceberNtFinanceira;
    }

}
