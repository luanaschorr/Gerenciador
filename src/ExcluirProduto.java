import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;

public class ExcluirProduto extends JPanel {

    public ExcluirProduto(JButton btnVoltar) {
        JPanel painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(3, 3));

        add(btnVoltar);
    }

}