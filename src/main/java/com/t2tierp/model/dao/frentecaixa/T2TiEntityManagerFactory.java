package com.t2tierp.model.dao.frentecaixa;

import com.t2tierp.infra.frentecaixa.Biblioteca;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class T2TiEntityManagerFactory {

    private static EntityManagerFactory FACTORY_LOCAL;
    private static EntityManagerFactory FACTORY_RETAGUARDA;

    static {
        try {
            configuraConexaoLocal();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            configuraConexaoRetaguarda();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void configuraConexaoLocal() throws Exception {
        Map cfg = new HashMap<>();
        Properties arquivoConexao = new Properties();
        arquivoConexao.load(new FileInputStream(new File(Biblioteca.ARQUIVO_CONEXAO_BD)));

        cfg.put("javax.persistence.jdbc.driver", arquivoConexao.getProperty("sgbd.driver"));
        cfg.put("javax.persistence.jdbc.url", arquivoConexao.getProperty("sgbd.url"));
        cfg.put("javax.persistence.jdbc.user", arquivoConexao.getProperty("sgbd.user"));
        cfg.put("javax.persistence.jdbc.password", arquivoConexao.getProperty("sgbd.password"));

        FACTORY_LOCAL = Persistence.createEntityManagerFactory("t2ti-frente-caixa", cfg);
    }

    private static void configuraConexaoRetaguarda() throws Exception {
        Map cfg = new HashMap<>();
        Properties arquivoConexao = new Properties();
        arquivoConexao.load(new FileInputStream(new File(Biblioteca.ARQUIVO_CONEXAO_BD)));

        cfg.put("javax.persistence.jdbc.driver", arquivoConexao.getProperty("sgbd.retaguarda.driver"));
        cfg.put("javax.persistence.jdbc.url", arquivoConexao.getProperty("sgbd.retaguarda.url"));
        cfg.put("javax.persistence.jdbc.user", arquivoConexao.getProperty("sgbd.retaguarda.user"));
        cfg.put("javax.persistence.jdbc.password", arquivoConexao.getProperty("sgbd.retaguarda.password"));

        FACTORY_RETAGUARDA = Persistence.createEntityManagerFactory("t2tierp", cfg);
    }
    
    public static EntityManager createEntityManagerLocal() throws Exception {
        if (FACTORY_LOCAL == null || !FACTORY_LOCAL.isOpen()) {
            throw new Exception("Erro ao criar o Entity Manager Local.");
        }
        return FACTORY_LOCAL.createEntityManager();
    }

    public static EntityManager createEntityManagerRetaguarda() throws Exception {
        if (FACTORY_RETAGUARDA == null || !FACTORY_RETAGUARDA.isOpen()) {
            throw new Exception("Erro ao criar o Entity Manager Retaguarda.");
        }
        return FACTORY_RETAGUARDA.createEntityManager();
    }

    public static void testaConexaoLocal() throws Exception {
        configuraConexaoLocal();
        createEntityManagerLocal();
    }
    
    public static void testaConexaoRetaguarda() throws Exception {
        configuraConexaoRetaguarda();
        createEntityManagerRetaguarda();
    }
    
}
