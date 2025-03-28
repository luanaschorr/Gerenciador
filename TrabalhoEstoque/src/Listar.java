import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Listar extends JPanel {

    public Listar(JButton btnVoltar) {
        setLayout(new BorderLayout());

        JPanel painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(0, 1));

        add(painelFundo, BorderLayout.CENTER);
        add(btnVoltar, BorderLayout.SOUTH);

        String sqlSelect = "SELECT * FROM tb_product";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sqlSelect);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("pro_id");
                String name = rs.getString("pro_name");
                String description = rs.getString("pro_desc");
                double price = rs.getDouble("pro_price");
                int quantity = rs.getInt("pro_quantity");

                JLabel produto = new JLabel(id + " - " + name + " | " + description + " | R$ " + price + " | " + quantity + " unid.");
                painelFundo.add(produto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JLabel erro = new JLabel("Erro ao carregar os produtos.");
            painelFundo.add(erro);
        }
    }
}
