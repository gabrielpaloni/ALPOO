package ALPOO.EX11;
import javax.swing.*;
import java.awt.*;

public class CalculadoraUI extends JFrame {

    private JTextField display;

    public CalculadoraUI() {
        setTitle("Calculadora (Reais)"); // Título atualizado
        setSize(350, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        display = new JTextField();
        display.setEditable(false);
        display.setBackground(Color.WHITE);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 32));
        add(display, BorderLayout.NORTH);

        CalculadoraLogica logica = new CalculadoraLogica(this.display);

        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new GridLayout(5, 4, 10, 10));

        String[] botoes = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C"
        };

        for (String texto : botoes) {
            JButton botao = new JButton(texto);
            botao.setFont(new Font("Arial", Font.BOLD, 20));
            botao.addActionListener(logica);
            panelBotoes.add(botao);
        }

        for (int i = 0; i < 3; i++) {
            panelBotoes.add(new JLabel(""));
        }


        add(panelBotoes, BorderLayout.CENTER);
        ((JPanel) getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculadoraUI().setVisible(true);
        });
    }
}