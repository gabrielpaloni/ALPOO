package ALPOO.Ex04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TesteBotoes {

    public void testeBotoes(){
        JFrame janela = new JFrame();
        janela.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton botaoInnerClass = new JButton("Botão  InnerClass");
        janela.add(botaoInnerClass);
        botaoInnerClass.addActionListener(new AcaoBotao());

        JButton botaoClasseAnonima = new JButton("Botão Classe Anônima");
        janela.add(botaoClasseAnonima);
        botaoClasseAnonima.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botão Classe Anônima pressionado!");
            }
        });

        JButton botaoLambda = new JButton("Botão Lambda Expression");
        janela.add(botaoLambda);
        botaoLambda.addActionListener(e -> System.out.println("Botão Lambda pressionado!"));

        janela.pack();
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janela.setVisible(true);
    }
    class AcaoBotao implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Botão InnerClass pressionado!");
        }
    }

    public static void main(String[] args) {
    new TesteBotoes().testeBotoes();
    }
}
