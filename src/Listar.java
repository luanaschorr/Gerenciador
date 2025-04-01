package estoque;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Listar extends JPanel {

    public Listar(JButton btnVoltar) throws SQLException {
        setLayout(new BorderLayout());

        JPanel painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(0, 1));

        add(painelFundo, BorderLayout.CENTER);
        add(btnVoltar, BorderLayout.SOUTH);
        
        String[] columns = {"ID", "Nome", "Descrição", "Preço", "Quantidade"};
        ArrayList<Object[]> listaProdutos = new ArrayList<>();
        

        String sqlSelect = "SELECT * FROM tb_product";

        try (Connection connection = ConexaoBanco.getConexao();
                PreparedStatement pstmt = connection.prepareStatement(sqlSelect);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("pro_id");
                String name = rs.getString("pro_name");
                String description = rs.getString("pro_desc");
                double price = rs.getDouble("pro_price");
                int quantity = rs.getInt("pro_quantity");
                
                listaProdutos.add(new Object[]{id, name, description, price, quantity});
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JLabel erro = new JLabel("Erro ao carregar os produtos.");
            painelFundo.add(erro);
            add(btnVoltar);
        }
        
        Object[][] arrayProdutos = listaProdutos.toArray(new Object[0][]);
        
        DefaultTableModel tableModel = new DefaultTableModel(arrayProdutos, columns);
        
        JTable tabela = new JTable(tableModel);
        JScrollPane scroll = new JScrollPane(tabela);
        
        add(scroll, BorderLayout.CENTER);
        add(btnVoltar, BorderLayout.SOUTH);
    }
}