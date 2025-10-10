    package ALPOO.EX14;

    public class Cliente {
        private int codigo;
        private String nome;
        private String endereco;
        private int idade;
        private String cpf;

        public Cliente() {
        }

        public Cliente(int codigo, String nome, String endereco, int idade, String cpf) {
            this.codigo = codigo;
            this.nome = nome;
            this.endereco = endereco;
            this.idade = idade;
            this.cpf = cpf;
        }

        public int getCodigo() {
            return codigo;
        }

        public void setCodigo(int codigo) {
            this.codigo = codigo;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getEndereco() {
            return endereco;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        public int getIdade() {
            return idade;
        }

        public void setIdade(int idade) {
            this.idade = idade;
        }

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

        @Override
        public String toString() {
            return "Dados do Cliente Cadastrado:\n\n" +
                    "Código: " + codigo + "\n" +
                    "Nome: " + nome + "\n" +
                    "Endereço: " + endereco + "\n" +
                    "Idade: " + idade + "\n" +
                    "CPF: " + cpf;
        }
    }
