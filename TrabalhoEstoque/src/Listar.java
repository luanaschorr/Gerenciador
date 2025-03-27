
import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;

public class Listar extends JPanel {

    public Listar(JButton btnVoltar) {
        JPanel painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(3, 3));

        add(btnVoltar);
    }

}