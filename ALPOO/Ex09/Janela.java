package ALPOO.Ex09;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Janela extends JFrame{

    public void init() {

        setLayout(new FlowLayout());

        Contador contadorA = new Contador();
        JButton botaoA= new JButton("Botao A");
        botaoA.addActionListener(new AcaoBotao("A", contadorA));
        add(botaoA);

        Contador contadorB = new Contador();
        JButton botaoB= new JButton("Botao B");
        botaoB.addActionListener(new AcaoBotao("B", contadorB));
        add(botaoB);

        JButton botaoReseta= new JButton("Botao Reseta");
        ResetaContagens rc= new ResetaContagens();
        rc.addContador(contadorA);
        rc.addContador(contadorB);
        botaoReseta.addActionListener(rc);
        add(botaoReseta);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    class Contador {

        private int contagem = 0;

        public int getContagem() {return contagem;}
        public void aumenta() {contagem++;}
        public void reset() {contagem=0;}

    }

    class AcaoBotao implements ActionListener{

        private String nome;
        private Contador contador;

        public AcaoBotao(String aNome, Contador aCont) {
            this.nome = aNome;
            this.contador = aCont;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            contador.aumenta();
            int contagem = contador.getContagem();
            System.out.println("Botao "+nome+" pressionado "+contagem+" vezes");
        }

    }

    class ResetaContagens implements ActionListener{

        private List<Contador> contadores;

        public ResetaContagens() {
            this.contadores = new ArrayList<>();
        }

        public void addContador(Contador c) {
            this.contadores.add(c);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            for(Contador c : contadores) {
                c.reset();
            }
            System.out.println("Contagens resetadas");
        }

    }
}