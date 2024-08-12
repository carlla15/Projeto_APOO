package br.edu.ifpe.academia.util;

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

    public void log(String mensagem) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARQUIVO_LOG, true))) {
            String dataHora = LocalDateTime.now().format(FORMATO_DATA_HORA);
            writer.println(dataHora + " - " + mensagem);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
