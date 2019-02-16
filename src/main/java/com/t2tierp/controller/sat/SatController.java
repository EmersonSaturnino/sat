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
package com.t2tierp.controller.sat;

import com.sun.jna.Native;
import com.t2tierp.controller.pafecf.Tipos;
import javax.swing.JOptionPane;

public class SatController implements Tipos {

    public static ComunicacaoSAT sat;
    public static String assinaturaSAT = "akldfioquekrjlfjkljadjajdkfjadnfdjfal8712389uq2rq9u1j4kljdfqa0df0dfjadf08dfadf156f4a3f1a6df3a1df6a3dfadf4a3df1a6df3adf456a1df3a6dfa3fd1a6df31fa64df31a9df7a6df43a1f976df1a4df6adfa3df1a31dfa6df4a3df32a1f3a1df6a4d3f1a6df4a61fa3df6adf32a1df64adf231a65df4a3df165a1f23d1f6a13df1a65f1a23f16af49as74f9a4df3a1f65af4a561fa3f46a1f3a1f6a1df3a1df561a3df21a5";
    public static String codigoAtivacao = "12345678";

    private SatController() {
    }

    static {
        try {
            //define informações para comunicação com o equipamento SAT
            System.setProperty("jna.library.path", "C:/SAT/");
            sat = (ComunicacaoSAT) Native.loadLibrary("SAT", ComunicacaoSAT.class);
        } catch (UnsatisfiedLinkError | Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao definir a configuração do SAT.\n" + e.getMessage(), "Erro do Sistema", JOptionPane.ERROR_MESSAGE);
        }
    }

}
