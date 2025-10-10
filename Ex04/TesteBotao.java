package ALPOO.Ex04;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TesteBotao {
    public void testeBotao(){
        JFrame janela = new JFrame();

        JButton botao = new JButton("Botão Teste");
        janela.add(botao);

        AcaoBotao acaoBotao = new AcaoBotao();
        botao.addActionListener(acaoBotao);

        janela.pack();
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janela.setVisible(true);
    }

    class AcaoBotao implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("O Botão foi pressionado!");
        }
    }
    public static void main(String[] args) {
        new TesteBotao().testeBotao();
    }
}
