package ALPOO.Ex02;

import javax.swing.*;

public class Principal {
    public static void main(String[] args) {
        Cidade[] cidades = new Cidade[5];
        int somaPopulacao = 0;

        for (int i = 0; i < cidades.length; i++) {
            String nome = JOptionPane.showInputDialog("Digite o nome da cidade " + (i + 1) + ":");
            String estado = JOptionPane.showInputDialog("Digite o estado da cidade " + (i + 1) + ":");
            int populacao = Integer.parseInt(JOptionPane.showInputDialog("Digite a população da cidade " + (i + 1) + ":"));
            double extencao = Double.parseDouble(JOptionPane.showInputDialog("Digite a extensão da cidade " + (i + 1) + " (em km²):"));

            cidades[i] = new Cidade(nome, estado, populacao, extencao);

            int aumento = Integer.parseInt(JOptionPane.showInputDialog("Deseja aumentar a população da cidade " + nome + " em quanto?"));
            cidades[i].aumentaPopulacao(aumento);
            somaPopulacao += cidades[i].getPopulacao();
        }

        double mediaPopulacao = somaPopulacao / 5.0;

        StringBuilder dadosTodas = new StringBuilder("=== DADOS DAS CIDADES ===\n\n");

        for (Cidade c : cidades) {
            dadosTodas.append(c.mostraDados()).append("\n");
        }

        dadosTodas.append("Média de população entre as cidades: ").append(String.format("%.2f", mediaPopulacao));

        JOptionPane.showMessageDialog(null, dadosTodas.toString());
    }
}
