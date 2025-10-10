package ALPOO.EX12;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraNovaLogica implements ActionListener {

    private JTextField campoNumero1;
    private JTextField campoNumero2;
    private JTextField campoResposta;
    private JRadioButton radioSoma, radioSubtracao, radioMultiplicacao, radioDivisao;

    public CalculadoraNovaLogica(JTextField campoNumero1, JTextField campoNumero2, JTextField campoResposta,
                                 JRadioButton radioSoma, JRadioButton radioSubtracao,
                                 JRadioButton radioMultiplicacao, JRadioButton radioDivisao) {
        this.campoNumero1 = campoNumero1;
        this.campoNumero2 = campoNumero2;
        this.campoResposta = campoResposta;
        this.radioSoma = radioSoma;
        this.radioSubtracao = radioSubtracao;
        this.radioMultiplicacao = radioMultiplicacao;
        this.radioDivisao = radioDivisao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            int num1 = Integer.parseInt(campoNumero1.getText());
            int num2 = Integer.parseInt(campoNumero2.getText());
            int resultado = 0;

            if (radioSoma.isSelected()) {
                resultado = num1 + num2;
            } else if (radioSubtracao.isSelected()) {
                resultado = num1 - num2;
            } else if (radioMultiplicacao.isSelected()) {
                resultado = num1 * num2;
            } else if (radioDivisao.isSelected()) {
                if (num2 == 0) {
                    campoResposta.setText("Erro: Divisão por 0");
                    return;
                }
                resultado = num1 / num2;
            }
            campoResposta.setText(String.valueOf(resultado));

        } catch (NumberFormatException ex) {
            campoResposta.setText("Erro: Número inválido");
        }
    }
}
