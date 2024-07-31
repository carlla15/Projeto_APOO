package codigoFinal;

public class Aluno extends ClasseBase implements Mensalidade {
    private String cpf;
    private String nome;
    private String endereco;
    private int idade;

    private Aluno(Builder builder) {
        this.cpf = builder.cpf;
        this.nome = builder.nome;
        this.endereco = builder.endereco;
        this.idade = builder.idade;
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

    public double getValor() {
        return 200;
    }

    public static class Builder {
        private String cpf;
        private String nome;
        private String endereco;
        private int idade;
    
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
    
        public Aluno build() {
            return new Aluno(this);
            }}    }
    