package ALPOO.EX14;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.MaskFormatter;
import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class TelaCadastro extends JFrame {

    private static List<Cliente> listaDeClientes = new ArrayList<>();
    private static final String NOME_ARQUIVO = "clientes.txt";

    private JLabel lblCodigo, lblNome, lblEndereco, lblIdade, lblCpf;
    private JTextField txtCodigo, txtNome, txtEndereco, txtIdade;
    private JFormattedTextField txtCpf;
    private JButton btnEnviar, btnSair, btnUsuarios;

    public TelaCadastro() {
        carregarClientes();

        setTitle("Cadastro de Cliente");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(20, 20, 80, 25);
        add(lblCodigo);
        txtCodigo = new JTextField();
        txtCodigo.setBounds(100, 20, 100, 25);
        add(txtCodigo);

        lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 55, 80, 25);
        add(lblNome);
        txtNome = new JTextField();
        txtNome.setBounds(100, 55, 300, 25);
        add(txtNome);

        lblEndereco = new JLabel("Endereço:");
        lblEndereco.setBounds(20, 90, 80, 25);
        add(lblEndereco);
        txtEndereco = new JTextField();
        txtEndereco.setBounds(100, 90, 300, 25);
        add(txtEndereco);

        lblIdade = new JLabel("Idade:");
        lblIdade.setBounds(20, 125, 80, 25);
        add(lblIdade);
        txtIdade = new JTextField();
        txtIdade.setBounds(100, 125, 100, 25);
        add(txtIdade);

        lblCpf = new JLabel("CPF:");
        lblCpf.setBounds(20, 160, 80, 25);
        add(lblCpf);
        try {
            MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
            txtCpf = new JFormattedTextField(mascaraCpf);

        } catch (ParseException e) {
            e.printStackTrace();
            txtCpf = new JFormattedTextField();
        }

        txtCpf.setBounds(100, 160, 200, 25);
        add(txtCpf);

        btnEnviar = new JButton("Enviar");
        btnEnviar.setBounds(40, 210, 100, 25);
        add(btnEnviar);

        btnUsuarios = new JButton("Usuários");
        btnUsuarios.setBounds(160, 210, 100, 25);
        add(btnUsuarios);

        btnSair = new JButton("Sair");
        btnSair.setBounds(280, 210, 100, 25);
        add(btnSair);

        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigoStr = txtCodigo.getText().trim();
                String nomeStr = txtNome.getText().trim();
                String enderecoStr = txtEndereco.getText().trim();
                String idadeStr = txtIdade.getText().trim();
                String cpfStr = txtCpf.getText();

                if (codigoStr.isEmpty() || nomeStr.isEmpty() || enderecoStr.isEmpty() || idadeStr.isEmpty() || cpfStr.equals("   .   .   -  ")) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Por favor, preencha todos os campos para continuar.",
                            "Campos Vazios",
                            JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }
                try {
                    int codigo = Integer.parseInt(codigoStr);
                    int idade = Integer.parseInt(idadeStr);

                    Cliente cliente = new Cliente(codigo, nomeStr, enderecoStr, idade, cpfStr);
                    listaDeClientes.add(cliente);
                    JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                    salvarClientes();
                    
                    txtCodigo.setText("");
                    txtNome.setText("");
                    txtEndereco.setText("");
                    txtIdade.setText("");
                    txtCpf.setValue(null);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro: Código e Idade devem ser números válidos.", "Erro de Entrada", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnSair.addActionListener(e -> {
            salvarClientes();
            System.exit(0);
        });

        btnUsuarios.addActionListener(e -> new TelaListaClientes().setVisible(true));

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                salvarClientes();
            }
        });
    }

    private void salvarClientes() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
            for (Cliente cliente : listaDeClientes) {
                // Formata a linha: codigo;nome;endereco;idade;cpf
                String linha = String.format("%d;%s;%s;%d;%s",
                        cliente.getCodigo(),
                        cliente.getNome(),
                        cliente.getEndereco(),
                        cliente.getIdade(),
                        cliente.getCpf());
                writer.write(linha);
                writer.newLine(); // Adiciona uma nova linha para o próximo cliente
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar os clientes: " + e.getMessage(), "Erro de Arquivo", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void carregarClientes() {
        File arquivo = new File(NOME_ARQUIVO);
        if (!arquivo.exists()) {
            return; // Se o arquivo não existe, não há nada a carregar
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";"); // Divide a linha pelo separador ";"
                if (partes.length == 5) { // Verifica se a linha tem todos os 5 campos
                    int codigo = Integer.parseInt(partes[0]);
                    String nome = partes[1];
                    String endereco = partes[2];
                    int idade = Integer.parseInt(partes[3]);
                    String cpf = partes[4];
                    listaDeClientes.add(new Cliente(codigo, nome, endereco, idade, cpf));
                }
            }
        } catch (IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar os clientes: " + e.getMessage(), "Erro de Arquivo", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static List<Cliente> getListaDeClientes() {
        return listaDeClientes;
    }
    public static void main(String[] args) {
        new TelaCadastro().setVisible(true);
    }
}