package ALPOO.EX13.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import ALPOO.EX13.controller.SomaController;

public class JanelaSoma extends JFrame {
    JLabel rotulo1, rotulo2;
    JTextField texto1, texto2;
    JButton botaoSomar, botaoLimpar, botaoVoltar;

    private SomaController controller;

    public JanelaSoma(){
        super ("Janela Soma");
        Container tela = getContentPane();
        setLayout(null);

        controller = new SomaController();

        rotulo1 = new JLabel ("Número 1: ");
        rotulo2 = new JLabel ("Número 2: ");

        texto1 = new JTextField (5);
        texto2 = new JTextField (5);

        botaoSomar = new JButton ("Somar");
        botaoLimpar = new JButton ("Limpar");
        botaoVoltar = new JButton ("Voltar");

        rotulo1.setBounds(50, 50, 100, 20);
        rotulo2.setBounds(50, 100, 100, 20);

        texto1.setBounds(120, 50, 100, 20);
        texto2.setBounds(120, 100, 100, 20);

        botaoSomar.setBounds(50, 140, 100, 30);
        botaoLimpar.setBounds(160, 140, 100, 30);
        botaoVoltar.setBounds(270, 140, 100, 30);

        botaoSomar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String num1Str = texto1.getText();
                    String num2Str = texto2.getText();

                    double resultado = controller.somar(num1Str, num2Str);

                    JOptionPane.showMessageDialog(
                            JanelaSoma.this,
                            "O resultado da soma é: " + resultado,
                            "Resultado",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            JanelaSoma.this,
                            "Por favor, insira números válidos!",
                            "Erro de Entrada",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        botaoLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto1.setText("");
                texto2.setText("");
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
            }
        });


        tela.add(rotulo1);
        tela.add(rotulo2);
        tela.add(texto1);
        tela.add(texto2);
        tela.add(botaoSomar);
        tela.add(botaoLimpar);
        tela.add(botaoVoltar);

        setSize(400, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
