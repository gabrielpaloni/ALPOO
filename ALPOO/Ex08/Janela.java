package ALPOO.Ex08;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Janela extends JFrame{
    public void init(){

        setLayout(new FlowLayout());

        Contador conta = new Contador();

        JButton botaoAdiciona = new JButton("Adicionar contagem");
        botaoAdiciona.addActionListener(new AumentaContagem(conta));
        add(botaoAdiciona);

        JButton botaoReseta = new JButton("Resetar contagem");
        botaoReseta.addActionListener(new ResetaContagem(conta));
        add(botaoReseta);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    class Contador{
        private int contagem = 0;

        public int getContagem(){ return contagem; }
        public void aumentar(){ contagem++; }
        public void reset(){ contagem = 0; }
    }

    class AumentaContagem implements ActionListener{
        private Contador contador;

        public AumentaContagem(Contador aConta){
            this.contador = aConta;
        }
        public void actionPerformed(ActionEvent e){
            contador.aumentar();
            int contagem = contador.getContagem();
            System.out.println("Contagem aumentada. Total: " + contagem);
        }
    }

    class ResetaContagem implements ActionListener{
        private Contador contador;

        public ResetaContagem(Contador aConta){
            this.contador = aConta;
        }
        public void actionPerformed(ActionEvent e){
            contador.reset();
            System.out.println("Contagem resetada. Total: " + contador.getContagem());
        }
    }
}
