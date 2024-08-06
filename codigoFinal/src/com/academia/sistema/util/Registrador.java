package com.academia.sistema.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Registrador {

    private static Registrador instancia;
    private static final String ARQUIVO_LOG = "sistema.log";
    private static final DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private Registrador() {}

    public static synchronized Registrador getInstancia() {
        if (instancia == null) {
            instancia = new Registrador();
        }
        return instancia;
    }

    public void registrar(String mensagem) {
        try (FileWriter escritorArquivo = new FileWriter(ARQUIVO_LOG, true);
             PrintWriter escritor = new PrintWriter(escritorArquivo)) {
            String dataHora = LocalDateTime.now().format(FORMATO_DATA_HORA);
            escritor.println(dataHora + " - " + mensagem);
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }

    public void registrarErro(String mensagem, Throwable excecao) {
        try (FileWriter escritorArquivo = new FileWriter(ARQUIVO_LOG, true);
             PrintWriter escritor = new PrintWriter(escritorArquivo)) {
            String dataHora = LocalDateTime.now().format(FORMATO_DATA_HORA);
            escritor.println(dataHora + " - ERRO - " + mensagem);
            excecao.printStackTrace(escritor);
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}
