
import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;

public class Listar extends JPanel {
    JScrollPane barraRolagem;
    JPanel painelFundo;
    JTable tabela;
    Object[][] dados = {
            { "produto", "id", "descrição" },
            { "João da Silva", "48 8890-3345", "joaosilva@hotmail.com" },
            { "Pedro Cascaes", "48 9870-5634", "pedrinho@gmail.com" }
    };

    String[] colunas = { "Nome", "id", "descricao" };

    public Listar(JButton btnVoltar) {
        JPanel painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(3, 3));

        tabela = new JTable(dados, colunas);
        barraRolagem = new JScrollPane(tabela);
        painelFundo.add(barraRolagem);

        add(btnVoltar);
    }

}