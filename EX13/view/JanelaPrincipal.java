package ALPOO.EX13.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JanelaPrincipal extends JFrame {
    JButton botaoMultiplicar,  botaoSomar, botaoSair;

    public JanelaPrincipal(){
        super ("Janela Principal");
        Container tela = getContentPane();
        setLayout(null);

        botaoMultiplicar = new JButton ("Multiplicar");
        botaoSomar = new JButton ("Somar");
        botaoSair = new JButton ("Sair");

        botaoMultiplicar.setBounds(30, 100, 100, 30);
        botaoSomar.setBounds(150, 100, 100, 30);
        botaoSair.setBounds(270, 100, 100, 30);

        botaoMultiplicar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JanelaMultiplica janelaMultiplica = new JanelaMultiplica();
                dispose();
            }
        });

        botaoSomar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JanelaSoma janelaSoma = new JanelaSoma();
                dispose();
            }
        });

        botaoSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        botaoMultiplicar.setBackground(Color.pink);
        botaoSomar.setBackground(Color.cyan);
        botaoSair.setBackground(Color.lightGray);

        tela.add(botaoMultiplicar);
        tela.add(botaoSomar);
        tela.add(botaoSair);

        setSize(400, 300);
        setVisible(true);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
