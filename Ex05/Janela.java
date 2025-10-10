package ALPOO.Ex05;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Janela extends JFrame{

    public void init() {

        setLayout(new FlowLayout());

        JButton botaoA= new JButton("Botao A");
        botaoA.addActionListener(new Contador("A"));
        add(botaoA);

        JButton botaoB= new JButton("Botao B");
        botaoB.addActionListener(new Contador("B"));
        add(botaoB);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    class Contador implements ActionListener{

        private String nome;
        private int contagem = 0;

        public Contador(String aNome) {
            this.nome = aNome;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            contagem++;
            System.out.println("O Botao "+nome+" foi pressionado "+contagem+" vezes");
        }

    }
}