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
package com.t2tierp.model.bean.nfe;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "NFE_DETALHE_IMPOSTO_ICMS")
public class NfeDetalheImpostoIcms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "ORIGEM_MERCADORIA")
    private Integer origemMercadoria;
    @Column(name = "CST_ICMS")
    private String cstIcms;
    @Column(name = "CSOSN")
    private String csosn;
    @Column(name = "MODALIDADE_BC_ICMS")
    private Integer modalidadeBcIcms;
    @Column(name = "TAXA_REDUCAO_BC_ICMS")
    private BigDecimal taxaReducaoBcIcms;
    @Column(name = "BASE_CALCULO_ICMS")
    private BigDecimal baseCalculoIcms;
    @Column(name = "ALIQUOTA_ICMS")
    private BigDecimal aliquotaIcms;
    @Column(name = "VALOR_ICMS")
    private BigDecimal valorIcms;
    @Column(name = "VALOR_ICMS_OPERACAO")
    private BigDecimal valorIcmsOperacao;
    @Column(name = "PERCENTUAL_DIFERIMENTO")
    private BigDecimal percentualDiferimento;
    @Column(name = "VALOR_ICMS_DIFERIDO")
    private BigDecimal valorIcmsDiferido;
    @Column(name = "MOTIVO_DESONERACAO_ICMS")
    private Integer motivoDesoneracaoIcms;
    @Column(name = "VALOR_ICMS_DESONERADO")
    private BigDecimal valorIcmsDesonerado;
    @Column(name = "MODALIDADE_BC_ICMS_ST")
    private Integer modalidadeBcIcmsSt;
    @Column(name = "PERCENTUAL_MVA_ICMS_ST")
    private BigDecimal percentualMvaIcmsSt;
    @Column(name = "PERCENTUAL_REDUCAO_BC_ICMS_ST")
    private BigDecimal percentualReducaoBcIcmsSt;
    @Column(name = "VALOR_BASE_CALCULO_ICMS_ST")
    private BigDecimal valorBaseCalculoIcmsSt;
    @Column(name = "ALIQUOTA_ICMS_ST")
    private BigDecimal aliquotaIcmsSt;
    @Column(name = "VALOR_ICMS_ST")
    private BigDecimal valorIcmsSt;
    @Column(name = "VALOR_BC_ICMS_ST_RETIDO")
    private BigDecimal valorBcIcmsStRetido;
    @Column(name = "VALOR_ICMS_ST_RETIDO")
    private BigDecimal valorIcmsStRetido;
    @Column(name = "VALOR_BC_ICMS_ST_DESTINO")
    private BigDecimal valorBcIcmsStDestino;
    @Column(name = "VALOR_ICMS_ST_DESTINO")
    private BigDecimal valorIcmsStDestino;
    @Column(name = "ALIQUOTA_CREDITO_ICMS_SN")
    private BigDecimal aliquotaCreditoIcmsSn;
    @Column(name = "VALOR_CREDITO_ICMS_SN")
    private BigDecimal valorCreditoIcmsSn;
    @Column(name = "PERCENTUAL_BC_OPERACAO_PROPRIA")
    private BigDecimal percentualBcOperacaoPropria;
    @Column(name = "UF_ST")
    private String ufSt;
    @Column(name = "VALOR_BC_FPC")
    private BigDecimal valorBcFpc;
    @Column(name = "PERCENTUAL_FPC")
    private BigDecimal percentualFpc;
    @Column(name = "VALOR_FPC")
    private BigDecimal valorFpc;
    @Column(name = "VALOR_BC_FPC_ST")
    private BigDecimal valorBcFpcSt;
    @Column(name = "PERCENTUAL_BC_FPC_ST")
    private BigDecimal percentualBcFpcSt;
    @Column(name = "VALOR_FPC_ST")
    private BigDecimal valorFpcSt;
    @Column(name = "FPC_CONSUMIDOR_FINAL")
    private BigDecimal fpcConsumidorFinal;
    @Column(name = "VALOR_BC_FPC_RETIDO")
    private BigDecimal valorBcFpcRetido;
    @Column(name = "PERCENTUAL_BC_FPC_RETIDO")
    private BigDecimal percentualBcFpcRetido;
    @Column(name = "VALOR_FPC_RETIDO")
    private BigDecimal valorFpcRetido;
    @Column(name = "VALOR_BC_FPC_UF_DESTINO")
    private BigDecimal valorBcFpcUfDestino;
    @Column(name = "VALOR_BS_ICMS_UF_DESTINO")
    private BigDecimal valorBsIcmsUfDestino;
    @Column(name = "PERCENTUAL_FPC_UF_DESTINO")
    private BigDecimal percentualFpcUfDestino;
    @Column(name = "ALIQUOTA_INTERNA_UF_DESTINO")
    private BigDecimal aliquotaInternaUfDestino;
    @Column(name = "ALIQUOTA_INTERESTADUAL_UFS")
    private BigDecimal aliquotaInterestadualUfs;
    @Column(name = "PERCENTUAL_PROVISORIO_PARTILHA")
    private BigDecimal percentualProvisorioPartilha;
    @Column(name = "VALOR_ICMS_FPC_UF_DESTINO")
    private BigDecimal valorIcmsFpcUfDestino;
    @Column(name = "VALOR_ICMS_INTER_UF_DESTINO")
    private BigDecimal valorIcmsInterUfDestino;
    @Column(name = "VALOR_ICMS_INTER_UF_REMETENTE")
    private BigDecimal valorIcmsInterUfRemetente;
    @JoinColumn(name = "ID_NFE_DETALHE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private NfeDetalhe nfeDetalhe;

    public NfeDetalheImpostoIcms() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrigemMercadoria() {
        return origemMercadoria;
    }

    public void setOrigemMercadoria(Integer origemMercadoria) {
        this.origemMercadoria = origemMercadoria;
    }

    public String getCstIcms() {
        return cstIcms;
    }

    public void setCstIcms(String cstIcms) {
        this.cstIcms = cstIcms;
    }

    public String getCsosn() {
        return csosn;
    }

    public void setCsosn(String csosn) {
        this.csosn = csosn;
    }

    public Integer getModalidadeBcIcms() {
        return modalidadeBcIcms;
    }

    public void setModalidadeBcIcms(Integer modalidadeBcIcms) {
        this.modalidadeBcIcms = modalidadeBcIcms;
    }

    public BigDecimal getTaxaReducaoBcIcms() {
        return taxaReducaoBcIcms;
    }

    public void setTaxaReducaoBcIcms(BigDecimal taxaReducaoBcIcms) {
        this.taxaReducaoBcIcms = taxaReducaoBcIcms;
    }

    public BigDecimal getBaseCalculoIcms() {
        return baseCalculoIcms;
    }

    public void setBaseCalculoIcms(BigDecimal baseCalculoIcms) {
        this.baseCalculoIcms = baseCalculoIcms;
    }

    public BigDecimal getAliquotaIcms() {
        return aliquotaIcms;
    }

    public void setAliquotaIcms(BigDecimal aliquotaIcms) {
        this.aliquotaIcms = aliquotaIcms;
    }

    public BigDecimal getValorIcms() {
        return valorIcms;
    }

    public void setValorIcms(BigDecimal valorIcms) {
        this.valorIcms = valorIcms;
    }

    public BigDecimal getValorIcmsOperacao() {
        return valorIcmsOperacao;
    }

    public void setValorIcmsOperacao(BigDecimal valorIcmsOperacao) {
        this.valorIcmsOperacao = valorIcmsOperacao;
    }

    public BigDecimal getPercentualDiferimento() {
        return percentualDiferimento;
    }

    public void setPercentualDiferimento(BigDecimal percentualDiferimento) {
        this.percentualDiferimento = percentualDiferimento;
    }

    public BigDecimal getValorIcmsDiferido() {
        return valorIcmsDiferido;
    }

    public void setValorIcmsDiferido(BigDecimal valorIcmsDiferido) {
        this.valorIcmsDiferido = valorIcmsDiferido;
    }

    public Integer getMotivoDesoneracaoIcms() {
        return motivoDesoneracaoIcms;
    }

    public void setMotivoDesoneracaoIcms(Integer motivoDesoneracaoIcms) {
        this.motivoDesoneracaoIcms = motivoDesoneracaoIcms;
    }

    public BigDecimal getValorIcmsDesonerado() {
        return valorIcmsDesonerado;
    }

    public void setValorIcmsDesonerado(BigDecimal valorIcmsDesonerado) {
        this.valorIcmsDesonerado = valorIcmsDesonerado;
    }

    public Integer getModalidadeBcIcmsSt() {
        return modalidadeBcIcmsSt;
    }

    public void setModalidadeBcIcmsSt(Integer modalidadeBcIcmsSt) {
        this.modalidadeBcIcmsSt = modalidadeBcIcmsSt;
    }

    public BigDecimal getPercentualMvaIcmsSt() {
        return percentualMvaIcmsSt;
    }

    public void setPercentualMvaIcmsSt(BigDecimal percentualMvaIcmsSt) {
        this.percentualMvaIcmsSt = percentualMvaIcmsSt;
    }

    public BigDecimal getPercentualReducaoBcIcmsSt() {
        return percentualReducaoBcIcmsSt;
    }

    public void setPercentualReducaoBcIcmsSt(BigDecimal percentualReducaoBcIcmsSt) {
        this.percentualReducaoBcIcmsSt = percentualReducaoBcIcmsSt;
    }

    public BigDecimal getValorBaseCalculoIcmsSt() {
        return valorBaseCalculoIcmsSt;
    }

    public void setValorBaseCalculoIcmsSt(BigDecimal valorBaseCalculoIcmsSt) {
        this.valorBaseCalculoIcmsSt = valorBaseCalculoIcmsSt;
    }

    public BigDecimal getAliquotaIcmsSt() {
        return aliquotaIcmsSt;
    }

    public void setAliquotaIcmsSt(BigDecimal aliquotaIcmsSt) {
        this.aliquotaIcmsSt = aliquotaIcmsSt;
    }

    public BigDecimal getValorIcmsSt() {
        return valorIcmsSt;
    }

    public void setValorIcmsSt(BigDecimal valorIcmsSt) {
        this.valorIcmsSt = valorIcmsSt;
    }

    public BigDecimal getValorBcIcmsStRetido() {
        return valorBcIcmsStRetido;
    }

    public void setValorBcIcmsStRetido(BigDecimal valorBcIcmsStRetido) {
        this.valorBcIcmsStRetido = valorBcIcmsStRetido;
    }

    public BigDecimal getValorIcmsStRetido() {
        return valorIcmsStRetido;
    }

    public void setValorIcmsStRetido(BigDecimal valorIcmsStRetido) {
        this.valorIcmsStRetido = valorIcmsStRetido;
    }

    public BigDecimal getValorBcIcmsStDestino() {
        return valorBcIcmsStDestino;
    }

    public void setValorBcIcmsStDestino(BigDecimal valorBcIcmsStDestino) {
        this.valorBcIcmsStDestino = valorBcIcmsStDestino;
    }

    public BigDecimal getValorIcmsStDestino() {
        return valorIcmsStDestino;
    }

    public void setValorIcmsStDestino(BigDecimal valorIcmsStDestino) {
        this.valorIcmsStDestino = valorIcmsStDestino;
    }

    public BigDecimal getAliquotaCreditoIcmsSn() {
        return aliquotaCreditoIcmsSn;
    }

    public void setAliquotaCreditoIcmsSn(BigDecimal aliquotaCreditoIcmsSn) {
        this.aliquotaCreditoIcmsSn = aliquotaCreditoIcmsSn;
    }

    public BigDecimal getValorCreditoIcmsSn() {
        return valorCreditoIcmsSn;
    }

    public void setValorCreditoIcmsSn(BigDecimal valorCreditoIcmsSn) {
        this.valorCreditoIcmsSn = valorCreditoIcmsSn;
    }

    public BigDecimal getPercentualBcOperacaoPropria() {
        return percentualBcOperacaoPropria;
    }

    public void setPercentualBcOperacaoPropria(BigDecimal percentualBcOperacaoPropria) {
        this.percentualBcOperacaoPropria = percentualBcOperacaoPropria;
    }

    public String getUfSt() {
        return ufSt;
    }

    public void setUfSt(String ufSt) {
        this.ufSt = ufSt;
    }

    public BigDecimal getValorBcFpc() {
        return valorBcFpc;
    }

    public void setValorBcFpc(BigDecimal valorBcFpc) {
        this.valorBcFpc = valorBcFpc;
    }

    public BigDecimal getPercentualFpc() {
        return percentualFpc;
    }

    public void setPercentualFpc(BigDecimal percentualFpc) {
        this.percentualFpc = percentualFpc;
    }

    public BigDecimal getValorFpc() {
        return valorFpc;
    }

    public void setValorFpc(BigDecimal valorFpc) {
        this.valorFpc = valorFpc;
    }

    public BigDecimal getValorBcFpcSt() {
        return valorBcFpcSt;
    }

    public void setValorBcFpcSt(BigDecimal valorBcFpcSt) {
        this.valorBcFpcSt = valorBcFpcSt;
    }

    public BigDecimal getPercentualBcFpcSt() {
        return percentualBcFpcSt;
    }

    public void setPercentualBcFpcSt(BigDecimal percentualBcFpcSt) {
        this.percentualBcFpcSt = percentualBcFpcSt;
    }

    public BigDecimal getValorFpcSt() {
        return valorFpcSt;
    }

    public void setValorFpcSt(BigDecimal valorFpcSt) {
        this.valorFpcSt = valorFpcSt;
    }

    public BigDecimal getFpcConsumidorFinal() {
        return fpcConsumidorFinal;
    }

    public void setFpcConsumidorFinal(BigDecimal fpcConsumidorFinal) {
        this.fpcConsumidorFinal = fpcConsumidorFinal;
    }

    public BigDecimal getValorBcFpcRetido() {
        return valorBcFpcRetido;
    }

    public void setValorBcFpcRetido(BigDecimal valorBcFpcRetido) {
        this.valorBcFpcRetido = valorBcFpcRetido;
    }

    public BigDecimal getPercentualBcFpcRetido() {
        return percentualBcFpcRetido;
    }

    public void setPercentualBcFpcRetido(BigDecimal percentualBcFpcRetido) {
        this.percentualBcFpcRetido = percentualBcFpcRetido;
    }

    public BigDecimal getValorFpcRetido() {
        return valorFpcRetido;
    }

    public void setValorFpcRetido(BigDecimal valorFpcRetido) {
        this.valorFpcRetido = valorFpcRetido;
    }

    public BigDecimal getValorBcFpcUfDestino() {
        return valorBcFpcUfDestino;
    }

    public void setValorBcFpcUfDestino(BigDecimal valorBcFpcUfDestino) {
        this.valorBcFpcUfDestino = valorBcFpcUfDestino;
    }

    public BigDecimal getValorBsIcmsUfDestino() {
        return valorBsIcmsUfDestino;
    }

    public void setValorBsIcmsUfDestino(BigDecimal valorBsIcmsUfDestino) {
        this.valorBsIcmsUfDestino = valorBsIcmsUfDestino;
    }

    public BigDecimal getPercentualFpcUfDestino() {
        return percentualFpcUfDestino;
    }

    public void setPercentualFpcUfDestino(BigDecimal percentualFpcUfDestino) {
        this.percentualFpcUfDestino = percentualFpcUfDestino;
    }

    public BigDecimal getAliquotaInternaUfDestino() {
        return aliquotaInternaUfDestino;
    }

    public void setAliquotaInternaUfDestino(BigDecimal aliquotaInternaUfDestino) {
        this.aliquotaInternaUfDestino = aliquotaInternaUfDestino;
    }

    public BigDecimal getAliquotaInterestadualUfs() {
        return aliquotaInterestadualUfs;
    }

    public void setAliquotaInterestadualUfs(BigDecimal aliquotaInterestadualUfs) {
        this.aliquotaInterestadualUfs = aliquotaInterestadualUfs;
    }

    public BigDecimal getPercentualProvisorioPartilha() {
        return percentualProvisorioPartilha;
    }

    public void setPercentualProvisorioPartilha(BigDecimal percentualProvisorioPartilha) {
        this.percentualProvisorioPartilha = percentualProvisorioPartilha;
    }

    public BigDecimal getValorIcmsFpcUfDestino() {
        return valorIcmsFpcUfDestino;
    }

    public void setValorIcmsFpcUfDestino(BigDecimal valorIcmsFpcUfDestino) {
        this.valorIcmsFpcUfDestino = valorIcmsFpcUfDestino;
    }

    public BigDecimal getValorIcmsInterUfDestino() {
        return valorIcmsInterUfDestino;
    }

    public void setValorIcmsInterUfDestino(BigDecimal valorIcmsInterUfDestino) {
        this.valorIcmsInterUfDestino = valorIcmsInterUfDestino;
    }

    public BigDecimal getValorIcmsInterUfRemetente() {
        return valorIcmsInterUfRemetente;
    }

    public void setValorIcmsInterUfRemetente(BigDecimal valorIcmsInterUfRemetente) {
        this.valorIcmsInterUfRemetente = valorIcmsInterUfRemetente;
    }

    public NfeDetalhe getNfeDetalhe() {
        return nfeDetalhe;
    }

    public void setNfeDetalhe(NfeDetalhe nfeDetalhe) {
        this.nfeDetalhe = nfeDetalhe;
    }

    @Override
    public String toString() {
        return "com.t2tierp.model.bean.nfe.NfeDetalheImpostoIcms[id=" + id + "]";
    }

}
