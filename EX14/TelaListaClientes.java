package ALPOO.EX14;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaListaClientes extends JFrame {

    private JTextArea areaTextoClientes;
    private JButton btnApagarCliente, btnApagarTodos, btnFechar;
    private JTextField txtCodigoApagar;
    private JLabel lblCodigoApagar;

    public TelaListaClientes() {
        setTitle("Lista de Clientes Cadastrados");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        areaTextoClientes = new JTextArea();
        areaTextoClientes.setEditable(false);
        areaTextoClientes.setFont(new Font("Monospaced", Font.PLAIN, 12));

        JScrollPane scrollPane = new JScrollPane(areaTextoClientes);
        scrollPane.setBounds(20, 20, 440, 400);
        add(scrollPane);

        lblCodigoApagar = new JLabel("Código para apagar:");
        lblCodigoApagar.setBounds(20, 440, 150, 25);
        add(lblCodigoApagar);

        txtCodigoApagar = new JTextField();
        txtCodigoApagar.setBounds(160, 440, 80, 25);
        add(txtCodigoApagar);

        btnApagarCliente = new JButton("Apagar Cliente");
        btnApagarCliente.setBounds(250, 440, 150, 25);
        add(btnApagarCliente);

        btnApagarTodos = new JButton("Apagar Todos");
        btnApagarTodos.setBounds(40, 500, 150, 30);
        btnApagarTodos.setForeground(Color.RED);
        add(btnApagarTodos);

        btnFechar = new JButton("Fechar");
        btnFechar.setBounds(280, 500, 150, 30);
        add(btnFechar);

        btnFechar.addActionListener(e -> dispose());

        btnApagarTodos.addActionListener(e -> apagarTodosClientes());

        btnApagarCliente.addActionListener(e -> apagarClienteEspecifico());

        atualizarListaClientes();
    }

    private void atualizarListaClientes() {
        areaTextoClientes.setText("");
        List<Cliente> clientes = TelaCadastro.getListaDeClientes();

        if (clientes.isEmpty()) {
            areaTextoClientes.setText("Nenhum cliente cadastrado.");
        } else {
            for (Cliente cliente : clientes) {
                areaTextoClientes.append(cliente.toString() + "\n");
                areaTextoClientes.append("----------------------------------------\n");
            }
        }
    }

    private void apagarTodosClientes() {
        int resposta = JOptionPane.showConfirmDialog(
                this,
                "Tem certeza que deseja apagar TODOS os clientes?\nEsta ação não pode ser desfeita.",
                "Confirmar Exclusão Total",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (resposta == JOptionPane.YES_OPTION) {
            TelaCadastro.getListaDeClientes().clear();
            JOptionPane.showMessageDialog(this, "Todos os clientes foram apagados.");
            atualizarListaClientes();
        }
    }

    private void apagarClienteEspecifico() {
        try {
            int codigoParaApagar = Integer.parseInt(txtCodigoApagar.getText());
            List<Cliente> clientes = TelaCadastro.getListaDeClientes();

            boolean removeu = clientes.removeIf(cliente -> cliente.getCodigo() == codigoParaApagar);

            if (removeu) {
                JOptionPane.showMessageDialog(this, "Cliente com código " + codigoParaApagar + " foi apagado.");
                txtCodigoApagar.setText("");
                atualizarListaClientes();
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum cliente encontrado com o código informado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um código numérico válido.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
        }
    }
}
