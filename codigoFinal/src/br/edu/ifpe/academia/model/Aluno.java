package br.edu.ifpe.academia.model;

 
public class Aluno extends ClasseBase implements Mensalidade {
    private String cpf;
    private String nome;
    private String endereco;
    private int idade;
    private double valorMensalidade;

    private Aluno(Builder builder) {
        this.cpf = builder.cpf;
        this.nome = builder.nome;
        this.endereco = builder.endereco;
        this.idade = builder.idade;
        this.valorMensalidade = builder.valorMensalidade; 
    }

    @Override
    public double getValor() {
        return valorMensalidade;
    }

    public void setValor(double valor) {
        this.valorMensalidade = valor;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String getId() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getIdade() {
        return idade;
    }

    public static class Builder {
        private String cpf;
        private String nome;
        private String endereco;
        private int idade;
        private double valorMensalidade; 

        public Builder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder endereco(String endereco) {
            this.endereco = endereco;
            return this;
        }

        public Builder idade(int idade) {
            this.idade = idade;
            return this;
        }

        public Builder mensalidade(double valor) {
            this.valorMensalidade = valor; 
            return this;
        }

        public Aluno build() {
            if (cpf == null || nome == null) {
                throw new IllegalArgumentException("Campos obrigatórios não preenchidos.");
            }
            return new Aluno(this);
        }
    }
}


