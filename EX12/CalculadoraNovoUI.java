package ALPOO.EX12;

import javax.swing.*;
import java.awt.*;

public class CalculadoraNovoUI extends JFrame {

    private JTextField campoNumero1;
    private JTextField campoNumero2;
    private JTextField campoResposta;
    private JRadioButton radioSoma, radioSubtracao, radioMultiplicacao, radioDivisao;
    private JButton botaoCalcular;

    public CalculadoraNovoUI() {
        setTitle("Calculadora (Novo Layout)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 20));

        // --- Criação dos Componentes ---
        campoNumero1 = new JTextField(5);
        campoNumero2 = new JTextField(5);
        campoResposta = new JTextField(10);
        campoResposta.setEditable(false);
        campoResposta.setFont(new Font("Arial", Font.BOLD, 20));

        botaoCalcular = new JButton("=");
        botaoCalcular.setFont(new Font("Arial", Font.BOLD, 20));

        radioSoma = new JRadioButton("+");
        radioSubtracao = new JRadioButton("-");
        radioMultiplicacao = new JRadioButton("*");
        radioDivisao = new JRadioButton("/");
        radioSoma.setSelected(true);

        Font fonteCampos = new Font("Arial", Font.PLAIN, 20);
        campoNumero1.setFont(fonteCampos);
        campoNumero2.setFont(fonteCampos);

        ButtonGroup grupoOperacoes = new ButtonGroup();
        grupoOperacoes.add(radioSoma);
        grupoOperacoes.add(radioSubtracao);
        grupoOperacoes.add(radioMultiplicacao);
        grupoOperacoes.add(radioDivisao);

        JPanel painelOperacoes = new JPanel();
        painelOperacoes.setLayout(new BoxLayout(painelOperacoes, BoxLayout.Y_AXIS));
        painelOperacoes.add(radioSoma);
        painelOperacoes.add(radioSubtracao);
        painelOperacoes.add(radioMultiplicacao);
        painelOperacoes.add(radioDivisao);

        JPanel painelSuperior = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        painelSuperior.add(campoNumero1);
        painelSuperior.add(painelOperacoes);
        painelSuperior.add(campoNumero2);

        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        painelInferior.add(botaoCalcular);
        painelInferior.add(campoResposta);

        add(painelSuperior, BorderLayout.CENTER);
        add(painelInferior, BorderLayout.SOUTH);

        ((JPanel) getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));


        CalculadoraNovaLogica logica = new CalculadoraNovaLogica(
                campoNumero1,
                campoNumero2,
                campoResposta,
                radioSoma,
                radioSubtracao,
                radioMultiplicacao,
                radioDivisao
        );

        botaoCalcular.addActionListener(logica);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculadoraNovoUI().setVisible(true);
        });
    }
}