package ALPOO.Ex02;

public class Cidade {
    private String nome;
    private String estado;
    private int populacao;
    private Double extencao;

    public Cidade (){
    }
    public Cidade (String nome, String estado, int populacao, Double extencao){
        this.nome = nome;
        this.estado = estado;
        this.extencao = extencao;
        this.populacao = populacao;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getExtencao() {
        return extencao;
    }
    public void setExtencao(Double extencao) {
        this.extencao = extencao;
    }

    public int getPopulacao() {
        return populacao;
    }
    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void aumentaPopulacao (int incrementaPopulacao){
        this.populacao += incrementaPopulacao;
    }
    public String mostraDados(){
        return "Cidade: " + nome + "\nEstado: " + estado +
                "\nPopulação: " + populacao +
                "\nExtensão: " + extencao + " km²\n";
    }

}
