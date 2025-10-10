package ALPOO.Ex01;
import javax.swing.*;

public class Principal {
    public static void main(String[] args) {

        String livro = JOptionPane.showInputDialog("Digite o nome do livro:");
        String autor = JOptionPane.showInputDialog("Digite o nome do autor:");
        String genero = JOptionPane.showInputDialog("Digite o gênero do livro:");

        int nPaginas = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de páginas:"));
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade em estoque:"));
        double preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preço do livro:"));

        Livraria ObjLivro = new Livraria(livro, autor, nPaginas, genero, quantidade, preco);

        String mensagem = "Detalhes do Livro:\n" +
                          "Livro: " + ObjLivro.getLivro() + "\n" +
                          "Gênero: " + ObjLivro.getGenero() + "\n" +
                          "Quantidade em Estoque: " + ObjLivro.getQuantidade() + "\n" +
                          "Preço unitário: R$ " + String.format("%.2f", ObjLivro.getPreco());

        int totalPaginas = ObjLivro.contaPaginas();
        String autorLivro = ObjLivro.retornaAutor();
        Double precoTotal = ObjLivro.precoTotal();

        String mensagemDetalhes = "\nTotal de Páginas: " + totalPaginas +
                          "\nAutor do Livro: " + autorLivro +
                          "\nPreço Total: R$ " + String.format("%.2f", precoTotal);


        JOptionPane.showMessageDialog(null, mensagem + mensagemDetalhes);
    }
}
