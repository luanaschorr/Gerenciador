import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;

public class AtualizarProduto extends JPanel {

    public AtualizarProduto(JButton btnVoltar) {
        JPanel painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(3, 3));

        add(btnVoltar);
    }

}