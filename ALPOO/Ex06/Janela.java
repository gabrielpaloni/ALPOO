package ALPOO.Ex06;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Janela extends JFrame {
    public void init(){

        setLayout(new FlowLayout());

        Contador cont = new Contador();

        JButton botaoA = new JButton("Botao A");
        botaoA.addActionListener(cont);
        add(botaoA);

        JButton botaoB = new JButton("Botao B");
        botaoB.addActionListener(cont);
        add(botaoB);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    class Contador implements ActionListener{
        private int contagem = 0;

        @Override
        public void actionPerformed(ActionEvent e){
            contagem++;
            System.out.println("Os botões foram pressionados " + contagem + " vezes");
        }
    }
}
