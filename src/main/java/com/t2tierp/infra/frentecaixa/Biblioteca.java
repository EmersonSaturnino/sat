/*
 * The MIT License
 *
 * Copyright 2014 Claudio.
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

import com.t2tierp.controller.pafecf.Constantes;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Biblioteca {

    public static final String ARQUIVO_CONEXAO_BD = System.getProperty("user.dir") + System.getProperty("file.separator") + "conexao.properties";
    public static final String ARQUIVO_AUXILIAR = System.getProperty("user.dir") + System.getProperty("file.separator") + "arquivoauxiliar.properties";

    public static final String TIPO_CONEXAO_LOCAL = "Local";
    public static final String TIPO_CONEXAO_RETAGUARDA = "Retaguarda";

    private static final SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
    private static final SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");

    public static String md5String(String text)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md;
        md = MessageDigest.getInstance("MD5");
        byte[] md5hash = new byte[32];
        md.update(text.getBytes("iso-8859-1"), 0, text.length());
        md5hash = md.digest();
        return convertToHex(md5hash);
    }

    public static String md5File(String arquivo)
            throws NoSuchAlgorithmException, FileNotFoundException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        File f = new File(arquivo);
        InputStream is = new FileInputStream(f);
        byte[] buffer = new byte[8192];
        int read = 0;
        try {
            while ((read = is.read(buffer)) > 0) {
                digest.update(buffer, 0, read);
            }
            byte[] md5sum = digest.digest();
            BigInteger bigInt = new BigInteger(1, md5sum);
            String output = bigInt.toString(16);
            return output.toUpperCase();
        } catch (IOException e) {
            throw new RuntimeException("Impossível processar o arquivo.", e);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
            }
        }
    }

    private static String convertToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9)) {
                    buf.append((char) ('0' + halfbyte));
                } else {
                    buf.append((char) ('a' + (halfbyte - 10)));
                }
                halfbyte = data[i] & 0x0F;
            } while (two_halfs++ < 1);
        }
        return buf.toString();
    }

    public static String repete(String string, int quantidade) {
        return String.join("", Collections.nCopies(quantidade, string));
    }

    /**
     * Copia arquivos de um local para o outro
     *
     * @param origem - Arquivo de origem
     * @param destino - Arquivo de destino
     * @param overwrite - Confirmação para sobrescrever os arquivos
     * @throws IOException
     */
    public static void copy(File origem, File destino, boolean overwrite) throws IOException {
        if (overwrite) {
            Files.copy(Paths.get(origem.toURI()), Paths.get(destino.toURI()), StandardCopyOption.REPLACE_EXISTING);
        } else {
            Files.copy(Paths.get(origem.toURI()), Paths.get(destino.toURI()));
        }
    }

    public static boolean validaCpfCnpj(String s_aux) {
        if (s_aux.length() == 11) {
            int d1, d2;
            int digito1, digito2, resto;
            int digitoCPF;
            String nDigResult;
            d1 = d2 = 0;
            digito1 = digito2 = resto = 0;
            for (int n_Count = 1; n_Count < s_aux.length() - 1; n_Count++) {
                digitoCPF = Integer.valueOf(s_aux.substring(n_Count - 1, n_Count)).intValue();
                d1 = d1 + (11 - n_Count) * digitoCPF;
                d2 = d2 + (12 - n_Count) * digitoCPF;
            }

            resto = (d1 % 11);
            if (resto < 2) {
                digito1 = 0;
            } else {
                digito1 = 11 - resto;
            }
            d2 += 2 * digito1;
            resto = (d2 % 11);
            if (resto < 2) {
                digito2 = 0;
            } else {
                digito2 = 11 - resto;
            }
            String nDigVerific = s_aux.substring(s_aux.length() - 2, s_aux.length());
            nDigResult = String.valueOf(digito1) + String.valueOf(digito2);
            return nDigVerific.equals(nDigResult);
        } else if (s_aux.length() == 14) {
            int soma = 0, aux, dig;
            String cnpj_calc = s_aux.substring(0, 12);
            char[] chr_cnpj = s_aux.toCharArray();

            for (int i = 0; i < 4; i++) {
                if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                    soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
                }
            }
            for (int i = 0; i < 8; i++) {
                if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9) {
                    soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
                }
            }
            dig = 11 - (soma % 11);
            cnpj_calc += (dig == 10 || dig == 11)
                    ? "0" : Integer.toString(dig);
            soma = 0;
            for (int i = 0; i < 5; i++) {
                if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                    soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
                }
            }
            for (int i = 0; i < 8; i++) {
                if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9) {
                    soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
                }
            }
            dig = 11 - (soma % 11);
            cnpj_calc += (dig == 10 || dig == 11)
                    ? "0" : Integer.toString(dig);
            return s_aux.equals(cnpj_calc);
        } else {
            return false;
        }
    }

    /**
     * Retorna uma strig formatada de acordo com a configuração do sistema
     *
     * @param tipo Q para quantidade ou V para valor
     * @return string formatada
     */
    public static String formatoDecimal(String tipo, double valor) {

        String mascara = "#,##0.";
        if (tipo.equals("Q")) {
            for (int i = 0; i < Constantes.DECIMAIS_QUANTIDADE; i++) {
                mascara += "0";
            }
        } else if (tipo.equals("V")) {
            for (int i = 0; i < Constantes.DECIMAIS_VALOR; i++) {
                mascara += "0";
            }
        }
        DecimalFormat formato = new DecimalFormat(mascara);
        return formato.format(valor);
    }

    /**
     * Método que verifica se uma data no formato dd/mm/aaaa é valida.
     *
     * @param strData a ser validada
     * @return true se a data é valida, false se a data é inválida
     */
    public static boolean isDataValida(String strData) {
        try {
            if ((strData.length() != 10)) {
                return false;
            }
            Calendar dataValida = Calendar.getInstance();
            dataValida.setLenient(false);
            int dia = Integer.valueOf(strData.substring(0, 2));
            int mes = Integer.valueOf(strData.substring(3, 5));
            int ano = Integer.valueOf(strData.substring(6, 10));

            dataValida.set(Calendar.DAY_OF_MONTH, dia);
            dataValida.set(Calendar.MONTH, mes - 1);
            dataValida.set(Calendar.YEAR, ano);

            dataValida.getTime();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String formataData(Date dataFormatar) {
        return formatoData.format(dataFormatar);
    }

    public static String formataHora(Date dataFormatar) {
        return formatoHora.format(dataFormatar);
    }

    /**
     * Verifica se o cnpj informado e valido
     *
     * @param cnpj CNPJ a validar
     * @return boolean
     *
     */
    public static boolean cnpjValido(String cnpj) {
        try {
            if (cnpj == null) {
                throw new Exception("Valor nulo");
            }
            if (cnpj.equals("00000000000000") || cnpj.equals("11111111111111") || cnpj.equals("22222222222222") || cnpj.equals("33333333333333") || cnpj.equals("44444444444444") || cnpj.equals("55555555555555") || cnpj.equals("66666666666666") || cnpj.equals("77777777777777") || cnpj.equals("88888888888888") || cnpj.equals("99999999999999") || (cnpj.length() != 14)) {
                return (false);
            }

            char dig13, dig14;
            int sm, i, r, num, peso;
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 11; i >= 0; i--) {
                // converte o i-esimo caractere do CNPJ em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (int) (cnpj.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig13 = '0';
            } else {
                dig13 = (char) ((11 - r) + 48);
            }

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 12; i >= 0; i--) {
                num = (int) (cnpj.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig14 = '0';
            } else {
                dig14 = (char) ((11 - r) + 48);
            }

            // Verifica se os digitos calculados conferem com os digitos
            // informados.
            if ((dig13 == cnpj.charAt(12)) && (dig14 == cnpj.charAt(13))) {
                return (true);
            } else {
                return (false);
            }
        } catch (Exception e) {
            return (false);
        }
    }

    /**
     * Verifica se o cpf informado e valido
     *
     * @param cpf CPF a validar
     * @return boolean
     *
     */
    public static boolean cpfValido(String cpf) {
        try {
            if (cpf == null) {
                throw new Exception("Valor nulo");
            }
            if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555") || cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("99999999999") || (cpf.length() != 11)) {
                return (false);
            }

            char dig10, dig11;
            int sm, i, r, num, peso;

            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posicao de '0' na tabela ASCII)
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48); // converte no respectivo caractere
                // numerico
            }
            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            // Verifica se os digitos calculados conferem com os digitos
            // informados.
            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static BigDecimal soma(BigDecimal valor1, BigDecimal valor2) {
        BigDecimal resultado = valor1.add(valor2, MathContext.DECIMAL64);
        resultado = resultado.setScale(2, RoundingMode.HALF_UP);
        return resultado;
    }

    public static BigDecimal subtrai(BigDecimal valor1, BigDecimal valor2) {
        BigDecimal resultado = valor1.subtract(valor2, MathContext.DECIMAL64);
        resultado = resultado.setScale(2, RoundingMode.HALF_UP);
        return resultado;
    }

    public static BigDecimal multiplica(BigDecimal valor1, BigDecimal valor2) {
        BigDecimal resultado = valor1.multiply(valor2, MathContext.DECIMAL64);
        resultado = resultado.setScale(2, RoundingMode.HALF_UP);
        return resultado;
    }

    public static BigDecimal divide(BigDecimal valor1, BigDecimal valor2) {
        BigDecimal resultado = valor1.divide(valor2, MathContext.DECIMAL64);
        resultado = resultado.setScale(2, RoundingMode.HALF_UP);
        return resultado;
    }

    public static String hashRegistro(Object bean) throws Exception {
        Field fields[] = bean.getClass().getDeclaredFields();
        String hash = "";
        Method metodo = bean.getClass().getDeclaredMethod("setLogss", String.class);
        metodo.invoke(bean, "0");
        for (Field f : fields) {
            if (!f.getName().equals("serialVersionUID")) {
                metodo = bean.getClass().getDeclaredMethod("get" + primeiraMaiuscula(f.getName()));
                if (f.getType() == Integer.class
                        || f.getType() == String.class
                        || f.getType() == BigDecimal.class
                        || f.getType() == Double.class) {
                    hash += metodo.invoke(bean);
                } else if (f.getType() == Date.class) {
                    Date pData = (Date) metodo.invoke(bean);
                    if (pData != null) {
                        hash += formataData(pData);
                    } else {
                        hash += "null";
                    }
                } else {
                    if (f.getType() != List.class) {
                        Object obj = metodo.invoke(bean);
                        if (obj != null) {
                            metodo = obj.getClass().getDeclaredMethod("getId");
                            hash += metodo.invoke(obj);
                        } else {
                            hash += "null";
                        }
                    }
                }
            }
        }
        return md5String(hash);
    }

    public static String primeiraMaiuscula(String texto) {
        return Character.toUpperCase(texto.charAt(0)) + texto.substring(1);
    }

    public static Date stringToDate(String texto) throws Exception {
        return formatoData.parse(texto);
    }

    public static Date horaToDate(String hora) throws Exception {
        return formatoHora.parse(hora);
    }

    public static Integer modulo11(String codigo) {
        int total = 0;
        int peso = 2;

        for (int i = 0; i < codigo.length(); i++) {
            total += (codigo.charAt((codigo.length() - 1) - i) - '0') * peso;
            peso++;
            if (peso == 10) {
                peso = 2;
            }
        }
        int resto = total % 11;
        return (resto == 0 || resto == 1) ? 0 : (11 - resto);
    }

    /**
     * Assina o arquivo XML
     *
     * @param xml conteudo a ser assinado
     * @param alias nome do certificado
     * @param ks Keystore
     * @param senha senha do certificado
     * @param id identificador que sera assinado
     * @param parent elemento pai
     * @return String
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static String assinaXML(String xml, String alias, KeyStore ks, char[] senha, String id, String parent, String nomeElementoContemId, String nomeAtributoId) throws Exception {
        XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");

        List<Transform> listTransforms = new ArrayList<>();
        listTransforms.add(fac.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null));
        listTransforms.add(fac.newTransform("http://www.w3.org/TR/2001/REC-xml-c14n-20010315", (TransformParameterSpec) null));

        Reference ref = fac.newReference(id, fac.newDigestMethod(DigestMethod.SHA1, null), listTransforms, null, null);
        SignedInfo si = fac.newSignedInfo(fac.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec) null), fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null), Collections.singletonList(ref));

        KeyStore.PrivateKeyEntry keyEntry = (KeyStore.PrivateKeyEntry) ks.getEntry(alias, new KeyStore.PasswordProtection(senha));
        X509Certificate cert = (X509Certificate) keyEntry.getCertificate();

        KeyInfoFactory kif = fac.getKeyInfoFactory();
        List x509Content = new ArrayList();
        x509Content.add(cert);
        X509Data xd = kif.newX509Data(x509Content);
        KeyInfo ki = kif.newKeyInfo(Collections.singletonList(xd));

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        Document doc = dbf.newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes("UTF-8")));
        //Document doc = dbf.newDocumentBuilder().parse(new InputSource(new StringReader(xml)));

        Element element = (Element) doc.getElementsByTagName(nomeElementoContemId).item(0);
        element.setIdAttribute(nomeAtributoId, true);

        DOMSignContext dsc = new DOMSignContext(keyEntry.getPrivateKey(), doc.getElementsByTagName(parent).item(0));

        XMLSignature signature = fac.newXMLSignature(si, ki);

        signature.sign(dsc);

        StringWriter writer = new StringWriter();
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer trans = tf.newTransformer();
        trans.transform(new DOMSource(doc), new StreamResult(writer));

        return writer.toString();
    }

}
