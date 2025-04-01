import javax.swing.*;
import java.awt.*;

public class AtualizarProduto extends JPanel {
    public AtualizarProduto(JButton btnVoltar) {
        setLayout(new BorderLayout());

        JPanel painelConteudo = new JPanel();
        painelConteudo.setLayout(new BoxLayout(painelConteudo, BoxLayout.Y_AXIS));
        painelConteudo.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));// bargem entre os componentes e a
                                                                                  // borda em cima, esquerda, embaixo, e
                                                                                  // a direita

        painelConteudo.add(new JLabel("Nome do Produto:"));
        JTextField txtNome = new JTextField(10);// 10 caracteres
        painelConteudo.add(txtNome);
        painelConteudo.add(Box.createVerticalStrut(20));// espaço vertical entre os componentes, sem ele ficaria tudo
                                                        // grudado

        painelConteudo.add(new JLabel("Código:"));
        JTextField txtCodigo = new JTextField(10);
        painelConteudo.add(txtCodigo);
        painelConteudo.add(Box.createVerticalStrut(10));

        painelConteudo.add(new JLabel("Preço:"));
        JTextField txtPreco = new JTextField(10);
        painelConteudo.add(txtPreco);
        painelConteudo.add(Box.createVerticalStrut(10));

        painelConteudo.add(new JLabel("Quantidade:"));
        JTextField txtQuantidade = new JTextField(5);
        painelConteudo.add(txtQuantidade);
        painelConteudo.add(Box.createVerticalStrut(10));

        add(painelConteudo, BorderLayout.CENTER);
        add(btnVoltar, BorderLayout.SOUTH);

        JButton btnSalvar = new JButton("Salvar");
        painelConteudo.add(btnSalvar);

    }

}