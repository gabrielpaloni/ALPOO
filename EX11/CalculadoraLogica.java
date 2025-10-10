package ALPOO.EX11;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraLogica implements ActionListener {

    private JTextField display;
    private String primeiroNumero = "";
    private String segundoNumero = "";
    private String operador = "";
    private boolean resultadoExibido = false;

    public CalculadoraLogica(JTextField display) {
        this.display = display;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if ("0123456789".contains(comando)) {
            if (resultadoExibido) {
                resetarVariaveis();
                display.setText("");
            }
            if (operador.isEmpty()) {
                primeiroNumero += comando;
            } else {
                segundoNumero += comando;
            }
        }
        else if (comando.equals(".")) {
            if (resultadoExibido) {
                resetarVariaveis();
                display.setText("");
            }
            if (operador.isEmpty()) {
                if (!primeiroNumero.contains(".")) {
                    primeiroNumero += ".";
                }
            }
            else {
                if (!segundoNumero.contains(".")) {
                    segundoNumero += ".";
                }
            }
        }
        else if (comando.equals("C")) {
            resetarVariaveis();
            display.setText("");
            return;
        }
        else if (comando.equals("=")) {
            if (!segundoNumero.isEmpty()) {
                calcular();
            }
            return;
        }
        else { // Operadores
            if (!primeiroNumero.isEmpty() && !segundoNumero.isEmpty()) {
                calcular();
            }
            if (!primeiroNumero.isEmpty()) {
                operador = comando;
                resultadoExibido = false;
            }
        }

        atualizarDisplay();
    }

    private void atualizarDisplay() {
        if (resultadoExibido) return;
        String texto = primeiroNumero;
        if (!operador.isEmpty()) {
            texto += " " + operador;
            if (!segundoNumero.isEmpty()) {
                texto += " " + segundoNumero;
            }
        }
        display.setText(texto);
    }

    private void calcular() {
        try {
            // <<< MUDANÇA PRINCIPAL: de int para double >>>
            double num1 = Double.parseDouble(primeiroNumero);
            double num2 = Double.parseDouble(segundoNumero);
            double resultado = 0;

            switch (operador) {
                case "+": resultado = num1 + num2; break;
                case "-": resultado = num1 - num2; break;
                case "*": resultado = num1 * num2; break;
                case "/":
                    if (num2 == 0.0) { // Comparação com double
                        display.setText("Erro: Divisão por 0");
                        resetarVariaveis();
                        return;
                    }
                    resultado = num1 / num2;
                    break;
            }

            display.setText(String.valueOf(resultado));

            primeiroNumero = String.valueOf(resultado);
            segundoNumero = "";
            operador = "";
            resultadoExibido = true;

        } catch (NumberFormatException ex) {
            display.setText("Erro de formato");
            resetarVariaveis();
        }
    }

    private void resetarVariaveis() {
        primeiroNumero = "";
        segundoNumero = "";
        operador = "";
        resultadoExibido = false;
    }
}