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
@Table(name = "FIN_CLIENTE_GRUPO_DET")
public class FinClienteGrupoDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DIA_LANCAMENTO")
    private String diaLancamento;
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "GERA_BOLETO")
    private String geraBoleto;
    @JoinColumn(name = "ID_FIN_CLIENTE_GRUPO_CAB", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private FinClienteGrupoCab finClienteGrupoCab;
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Cliente cliente;

    public FinClienteGrupoDet() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiaLancamento() {
        return diaLancamento;
    }

    public void setDiaLancamento(String diaLancamento) {
        this.diaLancamento = diaLancamento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getGeraBoleto() {
        return geraBoleto;
    }

    public void setGeraBoleto(String geraBoleto) {
        this.geraBoleto = geraBoleto;
    }

    public FinClienteGrupoCab getFinClienteGrupoCab() {
        return finClienteGrupoCab;
    }

    public void setFinClienteGrupoCab(FinClienteGrupoCab finClienteGrupoCab) {
        this.finClienteGrupoCab = finClienteGrupoCab;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "com.t2tierp.model.bean.financeiro.FinClienteGrupoDet[id=" + id + "]";
    }

}
