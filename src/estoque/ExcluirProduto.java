package estoque;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExcluirProduto extends JPanel {
	
    public ExcluirProduto(JButton btnVoltar) {
        setLayout(new GridLayout(3, 1, 10, 10));

        JLabel lblId = new JLabel("ID do Produto:");
        JTextField txtId = new JTextField();
        JButton btnExcluir = new JButton("Excluir Produto");

        add(lblId);
        add(txtId);
        add(btnExcluir);
        add(btnVoltar);

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idText = txtId.getText().trim();
                if (!idText.isEmpty()) {
                    try {
                        int id = Integer.parseInt(idText);
                        excluirProduto(id);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "ID inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Informe o ID do produto.", "Atenção", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
   


    private void excluirProduto(int id) {
        String sqlDelete = "DELETE FROM tb_product WHERE pro_id = ?";
        try (Connection connection = ConexaoBanco.getConexao();
             PreparedStatement pstmt = connection.prepareStatement(sqlDelete)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Produto não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir produto: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}