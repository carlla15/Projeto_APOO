//package com.academia.sistema.util;
//
//
//import java.time.format.DateTimeFormatter;
//
//public class Registrador {
//
//    private static Registrador instancia;
//    private static final String ARQUIVO_LOG = "sistema.log";
//    private static final DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//    private Registrador() {}
//
//    public static synchronized Registrador getInstancia() {
//        if (instancia == null) {
//            instancia = new Registrador();
//        }
//        return instancia;
//    
//    }}
//   