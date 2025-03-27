
import javax.swing.*;
import java.awt.*;

public class CadastrarProduto extends JPanel {

    public CadastrarProduto(JButton btnVoltar) {
        setLayout(new FlowLayout());

        JLabel label = new JLabel("Tela de Cadastro");
        add(label);

        add(btnVoltar);
    }

}
