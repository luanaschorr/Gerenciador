
package estoque;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class AtualizarProduto extends JPanel {
   private Connection connection; //declara a variável para a conexão com o banco
 
   public AtualizarProduto(JButton btnVoltar) {
       setLayout(new BorderLayout());
      
       JPanel painelConteudo = new JPanel();
       painelConteudo.setLayout(new BoxLayout(painelConteudo, BoxLayout.Y_AXIS));//organiza os componentes na vertical.
       painelConteudo.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));//add margem entre os componentes e a borda do painel com 20 no topo, esquerda, enbaixo e direita
       painelConteudo.setBackground(Color.WHITE);
      
       JPanel painelCodigo = new JPanel(new FlowLayout(FlowLayout.CENTER));
       JLabel lblCodigo = new JLabel("Código:");
       painelCodigo.add(lblCodigo);
       painelConteudo.add(painelCodigo);
       painelCodigo.setBackground(Color.WHITE);
       JTextField txtCodigo =  new CampoArredondado(20, 20, 20);
       txtCodigo.setBackground(Color.WHITE);
       txtCodigo.setOpaque(false);
       txtCodigo.setForeground(Color.BLACK);
       txtCodigo.setPreferredSize(new Dimension(200, 25));
       painelConteudo.add(txtCodigo);
       painelConteudo.add(Box.createVerticalStrut(10));//add espaço entre os componentes senão ficariam grudados
     
      
       JPanel painelNome = new JPanel(new FlowLayout(FlowLayout.CENTER));
       JLabel lblNome = new JLabel("Nome do Produto:");
       painelNome.add(lblNome);
       painelConteudo.add(painelNome);
       painelNome.setBackground(Color.WHITE);
       JTextField txtNome = new CampoArredondado(20, 20, 20);
       txtNome.setBackground(Color.WHITE);
       txtNome.setOpaque(false);
       txtNome.setForeground(Color.BLACK);
       txtNome.setPreferredSize(new Dimension(200, 25));
       painelConteudo.add(txtNome);
       painelConteudo.add(Box.createVerticalStrut(10));
       JPanel painelDesc = new JPanel(new FlowLayout(FlowLayout.CENTER));
       JLabel lblDesc = new JLabel("Descrição:");
       painelDesc.add(lblDesc);
       painelConteudo.add(painelDesc);
       painelDesc.setBackground(Color.WHITE);
       JTextField txtDesc = new CampoArredondado(20, 20, 20);
       txtCodigo.setBackground(Color.WHITE);
       txtDesc.setOpaque(false);
       txtDesc.setForeground(Color.BLACK);
       txtDesc.setPreferredSize(new Dimension(200, 25));
       painelConteudo.add(txtDesc);
       painelConteudo.add(Box.createVerticalStrut(10));
       JPanel painelPreco = new JPanel(new FlowLayout(FlowLayout.CENTER));
       JLabel lblPreco = new JLabel("Preço:");
       painelPreco.add(lblPreco);
       painelConteudo.add(painelPreco);
       painelPreco.setBackground(Color.WHITE);
       JTextField txtPreco = new CampoArredondado(20, 20, 20);
       painelPreco.setBackground(Color.WHITE);
       txtPreco.setOpaque(false);
       txtPreco.setForeground(Color.BLACK);
       txtPreco.setPreferredSize(new Dimension(200, 25));
       painelConteudo.add(txtPreco);
       painelConteudo.add(Box.createVerticalStrut(10));
       JPanel painelQuantidade = new JPanel(new FlowLayout(FlowLayout.CENTER));
       JLabel lblQuantidade = new JLabel("Quantidade:");
       painelQuantidade.add(lblQuantidade);
       painelConteudo.add(painelQuantidade);
       painelQuantidade.setBackground(Color.WHITE);
       JTextField txtQuantidade =new CampoArredondado(20, 20, 20);
       txtQuantidade.setBackground(Color.WHITE);
       txtQuantidade.setOpaque(false);
       txtQuantidade.setForeground(Color.BLACK);
       txtQuantidade.setPreferredSize(new Dimension(100, 25));
       painelConteudo.add(txtQuantidade);
       painelConteudo.add(Box.createVerticalStrut(10));
       JButton btnSalvar = new BotaoArredondado("Salvar", 20, 20);
       btnSalvar.setBackground(new Color(76, 175, 80));
       btnSalvar.setForeground(Color.WHITE);
       btnSalvar.setPreferredSize(new Dimension(40, 40));
       btnSalvar.setBackground(Color.GREEN);      
       painelConteudo.add(btnSalvar);
      
       JButton btnAjuda = new JButton();
       btnAjuda.setForeground(Color.WHITE);
       ImageIcon icon = new ImageIcon(getClass().getResource("/estoque/sinal-de-interrogacao.png"));
       Image img = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
       btnAjuda.setIcon(new ImageIcon(img));
       btnAjuda.setPreferredSize(new Dimension(30, 30));
       // Painel para alinhar o botão à direita
       JPanel painelAjuda = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 2));
       painelAjuda.setBackground(Color.WHITE);
       painelAjuda.add(btnAjuda);
       // Adicionando o painel superior corretamente
       add(painelAjuda, BorderLayout.NORTH);
    
       btnAjuda.addActionListener(new ActionListener() {
      
           @Override
           public void actionPerformed(ActionEvent e) {
               JOptionPane.showMessageDialog(null,
                   "Como utilizar a tela de atualização:\n\n"
                 + "1. O código do produto é obrigátorio e precisa existir.\n"
                 + "2. Caso não queira atualizar algum campo deixe-o em branco.\n"
                 + "3. O campo do valor precisa ser usado '.' e não ','.\n"
                 + "4. O campo de quantidade precisa ser um número inteiro positivo \n"
                 + "5. Clique em 'Salvar' para confirmar as alterações.\n",
                   "Ajuda - Atualizar Produto",
                   JOptionPane.INFORMATION_MESSAGE
               );
           }	
       });
      
      
       btnSalvar.setPreferredSize(new Dimension(100, 40));
       btnSalvar.setBackground(new Color(9,187,4));
       btnVoltar.setPreferredSize(new Dimension(100, 40));
       btnVoltar.setBackground(new Color(36,5,209));
       btnVoltar.setForeground(Color.WHITE);
      // btnVoltar.setContentAreaFilled(false);
      // btnVoltar.setOpaque(false);
  
      
       JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
       painelBotoes.setBackground(Color.WHITE);
      
       painelBotoes.add(btnSalvar);
       painelBotoes.add(btnVoltar);
      
       add(painelConteudo, BorderLayout.CENTER);
       add(painelBotoes, BorderLayout.SOUTH);
      
       btnVoltar.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               // limpa os campos quando apertao botao de voltar
               txtCodigo.setText("");
               txtNome.setText("");
               txtDesc.setText("");
               txtPreco.setText("");
               txtQuantidade.setText("");
           }
       });
       btnSalvar.addActionListener(new ActionListener() {
           @Override
           //txtCodigo.getText()pega o texto digitado no campo txtCodigo e assim igual os outros
           public void actionPerformed(ActionEvent e) {
           	salvarProduto(txtCodigo.getText(), txtNome.getText(),txtDesc.getText(),txtPreco.getText(), txtQuantidade.getText());
           }
       });
       //tenta conexao com banco
       try {
           connection = ConexaoBanco.getConexao();
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco: " + e.getMessage());
       }
   }
   private void salvarProduto(String codigoStr, String nome, String desc, String precoStr, String quantidadeStr) {//indica que sao string por isso o str no final
       if (codigoStr.isEmpty()) {
           JOptionPane.showMessageDialog(this, "O código do produto deve ser informado.");
           return;
       }
       int codigo = Integer.parseInt(codigoStr);//faz a conversão de uma String para um int.
       try {
         
           String sqlSelect = "SELECT pro_name, pro_desc, pro_price, pro_quantity FROM tb_product WHERE pro_id = ?";
           PreparedStatement stmtSelect = connection.prepareStatement(sqlSelect);// um objeto que prepara a consulta SQL para ser executada
           stmtSelect.setInt(1, codigo);//substitui o ? pelo valor que foi digitado
           ResultSet rs = stmtSelect.executeQuery();//executa a consulta e armazena o resultado no ResultSet
           if (!rs.next()) {
               JOptionPane.showMessageDialog(this, "Produto não encontrado.");
               return;
           }
           // Se um campo estiver vazio, mantem o valor antigo
           if (nome.isEmpty()) nome = rs.getString("pro_name");
           if (desc.isEmpty()) desc = rs.getString("pro_desc");
     
           double preco;
           int quantidade;
           try {
               preco = precoStr.isEmpty() ? rs.getDouble("pro_price") : Double.parseDouble(precoStr);
           } catch (NumberFormatException e) {
               JOptionPane.showMessageDialog(this, "Preço inválido. Digite um número válido.");
               return;
           }
           try {
               quantidade = quantidadeStr.isEmpty() ? rs.getInt("pro_quantity") : Integer.parseInt(quantidadeStr);
           } catch (NumberFormatException e) {
               JOptionPane.showMessageDialog(this, "Quantidade inválida. Digite um número inteiro válido.");
               return;
           }
           rs.close();
           stmtSelect.close();
          
         
    
           String sqlUpdate = "UPDATE tb_product SET pro_name = ?, pro_desc = ?, pro_price = ?, pro_quantity = ? WHERE pro_id = ?";
           PreparedStatement stmtUpdate = connection.prepareStatement(sqlUpdate);
           stmtUpdate.setString(1, nome);
           stmtUpdate.setString(2, desc);
           stmtUpdate.setDouble(3, preco);
           stmtUpdate.setInt(4, quantidade);
           stmtUpdate.setInt(5, codigo);
           int linhasAfetadas = stmtUpdate.executeUpdate();
           stmtUpdate.close();
           JOptionPane.showMessageDialog(this, linhasAfetadas > 0 ? "Produto atualizado com sucesso!" : "Nenhuma alteração feita.");
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(this, "Erro ao atualizar produto: " + e.getMessage());
       }
   }
}
