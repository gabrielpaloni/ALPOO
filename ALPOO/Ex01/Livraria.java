package ALPOO.Ex01;

public class Livraria {
    private String livro;
    private String autor;
    private int nPaginas;
    private String genero;
    private int quantidade;
    private double preco;

    public Livraria(String livro, String autor, int nPaginas, String genero, int quantidade, double preco) {
        this.livro = livro;
        this.autor = autor;
        this.nPaginas = nPaginas;
        this.genero = genero;
        this.quantidade = quantidade;
        this.preco = preco;
    }
    public Livraria(){
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getLivro() {
        return livro;
    }
    public void setLivro(String livro) {
        this.livro = livro;
    }

    public int getnPaginas() {
        return nPaginas;
    }
    public void setnPaginas(int nPaginas) {
        this.nPaginas = nPaginas;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    public int contaPaginas (){
        return nPaginas;
    }
    public String retornaAutor (){
        return autor;
    }
    public Double precoTotal() {
        return quantidade * preco;
    }

    @Override
    public String toString(){
        return "Livro: " + livro + "\nAutor: " + autor + "\nGênero: " + genero +
                "\nPáginas: " + nPaginas + "\nQuantidade: " + quantidade +
                "\nPreço unitário: R$" + preco;
    }

}
