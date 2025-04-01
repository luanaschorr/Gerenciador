
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class TelaInicial extends JFrame {

    public TelaInicial() throws SQLException {

        setTitle("Tela Inicial");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);// deixa a tela no centro da tela

        JPanel painel = new JPanel();
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        JLabel bemVindo = new JLabel("Bem-vindo! Escolha uma das opções abaixo", SwingConstants.CENTER);
        painel.add(bemVindo);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setPreferredSize(new Dimension(200, 50));

        JButton btnVoltarCadastro = new JButton("Voltar");
        JButton btnVoltarListar = new JButton("Voltar");
        JButton btnVoltarAtualizacao = new JButton("Voltar");
        JButton btnVoltarExcluir = new JButton("Voltar");

        JPanel cadastrar = new CadastrarProduto(btnVoltarCadastro);
        JPanel listar = new Listar(btnVoltarListar);
        JPanel atualizar = new AtualizarProduto(btnVoltarAtualizacao);
        JPanel excluir = new ExcluirProduto(btnVoltarExcluir);

        btnVoltarCadastro.addActionListener(e -> {
            remove(cadastrar);
            add(painel);
            revalidate();
            repaint();
        });

        btnVoltarListar.addActionListener(e -> {
            remove(listar);
            add(painel);
            revalidate();
            repaint();
        });

        btnVoltarAtualizacao.addActionListener(e -> {
            remove(atualizar);
            add(painel);
            revalidate();
            repaint();
        });

        btnVoltarExcluir.addActionListener(e -> {
            remove(excluir);
            add(painel);
            revalidate();
            repaint();
        });

        JButton btnCadastrar = new JButton("Cadastrar Produto");
        btnCadastrar.setPreferredSize(new Dimension(200, 50));
        btnCadastrar.addActionListener(e -> {
            remove(painel);
            add(cadastrar);
            revalidate();
            repaint();
        });
        painel.add(btnCadastrar);

        JButton btnListar = new JButton("Listar");
        btnListar.setPreferredSize(new Dimension(200, 50));
        btnListar.addActionListener(e -> {
            remove(painel);
            add(listar);
            revalidate();
            repaint();
        });
        painel.add(btnListar);

        JButton btnAtualizar = new JButton("Atualizar Produto");
        btnAtualizar.setPreferredSize(new Dimension(200, 50));

        btnAtualizar.addActionListener(e -> {
            remove(painel);
            add(atualizar);
            revalidate();
            repaint();
        });

        painel.add(btnAtualizar);

        JButton btnExcluir = new JButton("Excluir");
        btnExcluir.setPreferredSize(new Dimension(200, 50));

        btnExcluir.addActionListener(e -> {
            remove(painel);
            add(excluir);
            revalidate();
            repaint();
        });

        painel.add(btnExcluir);
        add(painel);
    }

    public static void main(String[] args) {
        try {
            TelaInicial tela = new TelaInicial();
            tela.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados: " + e.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}