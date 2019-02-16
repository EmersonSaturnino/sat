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
package com.t2tierp.infra.frentecaixa;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class MonetarioDocument extends PlainDocument {

    private static final long serialVersionUID = 1L;

    private int qtdeMaximaDigitos = 12;
    private int qtdeCasasDecimais = 2;

    public MonetarioDocument() {
    }

    public MonetarioDocument(int qtdeCasasDecimais, int qtdeMaximaDigitos) {
        this.qtdeCasasDecimais = qtdeCasasDecimais;
        this.qtdeMaximaDigitos = qtdeMaximaDigitos;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        String texto = getText(0, getLength());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)) {
                return;
            }
        }
        if (texto.length() < this.qtdeMaximaDigitos) {
            super.remove(0, getLength());
            texto = texto.replace(".", "").replace(",", "");
            StringBuffer s = new StringBuffer(texto + str);

            if (s.length() > 0 && s.charAt(0) == '0') {
                s.deleteCharAt(0);
            }

            while (s.length() < (qtdeCasasDecimais + 1)) {
                s.insert(0, "0");
            }

            s.insert(s.length() - qtdeCasasDecimais, ",");

            int inserirPonto = qtdeCasasDecimais + 4;
            while (inserirPonto < s.length()) {
                s.insert(s.length() - inserirPonto, ".");
                inserirPonto += 4;
            }

            super.insertString(0, s.toString(), a);
        }
    }

    public void remove(int offset, int length) throws BadLocationException {
        super.remove(offset, length);
        String texto = getText(0, getLength());
        texto = texto.replace(",", "");
        texto = texto.replace(".", "");
        super.remove(0, getLength());
        insertString(0, texto, null);
    }
}
