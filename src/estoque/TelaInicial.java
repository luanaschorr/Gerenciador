package estoque;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
public class TelaInicial extends JFrame {
   public TelaInicial() throws SQLException {
       setTitle("Tela Inicial");
       setSize(400, 450);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       setLocationRelativeTo(null);// deixa a tela no centro da tela
       try {
           
    	   ImageIcon icone = new ImageIcon(getClass().getResource("/estoque/estoque-pronto.png"));
    	   setIconImage(icone.getImage());
       } catch (Exception e) {
           System.out.println("Ícone não encontrado! Usando ícone padrão.");
       }
       JPanel painel = new JPanel();
       painel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));
      
  
       JLabel bemVindo = new JLabel("Bem-vindo ao Gerenciador de Estoque!", SwingConstants.CENTER);
       bemVindo.setFont(new Font("SansSerif", Font.PLAIN, 13));
       JLabel linha2 = new JLabel("Escolha uma das opções abaixo para iniciar!", SwingConstants.CENTER);
       linha2.setFont(new Font("SansSerif", Font.PLAIN, 13));
       JPanel painelTexto = new JPanel();
       painelTexto.setLayout(new BoxLayout(painelTexto, BoxLayout.Y_AXIS));
       painelTexto.setOpaque(false); // sem fundo
       painelTexto.add(bemVindo);
       painelTexto.add(Box.createVerticalStrut(5)); // espaço menor entre as linhas
       painelTexto.add(linha2);
     
       bemVindo.setAlignmentX(Component.CENTER_ALIGNMENT);
       linha2.setAlignmentX(Component.CENTER_ALIGNMENT);
       painel.add(painelTexto);
       JButton btnVoltar = new JButton("Voltar");
      
       btnVoltar.setPreferredSize(new Dimension(300, 150));
       JButton btnVoltarCadastro = new BotaoArredondado("Voltar", 20, 20);
       JButton btnVoltarListar = new BotaoArredondado("Voltar", 20, 20);
       JButton btnVoltarAtualizacao = new BotaoArredondado("Voltar", 20, 20);
       JButton btnVoltarExcluir = new BotaoArredondado("Voltar", 20, 20);
       
       JPanel cadastrar = new CadastrarProduto(btnVoltarCadastro);
       JPanel listar = new Listar(btnVoltarListar);
       JPanel atualizar = new AtualizarProduto(btnVoltarAtualizacao);
       JPanel excluir = new ExcluirProduto(btnVoltarExcluir);
       btnVoltarCadastro.addActionListener(e -> {
           remove(cadastrar);
           add(painel);
           revalidate();
           repaint();
       });
       btnVoltarListar.addActionListener(e -> {
           remove(listar);
           add(painel);
           revalidate();
           repaint();
       });
       btnVoltarAtualizacao.addActionListener(e -> {
           remove(atualizar);
           add(painel);
           revalidate();
           repaint();
       });
       btnVoltarExcluir.addActionListener(e -> {
           remove(excluir);
           add(painel);
           revalidate();
           repaint();
       });
       JButton btnCadastrar = new BotaoArredondado("Cadastrar Produto", 20,20);
       btnCadastrar.setBackground(Color.WHITE);
       btnCadastrar.setPreferredSize(new Dimension(300, 50));
       btnCadastrar.setContentAreaFilled(false);
       btnCadastrar.setOpaque(false);
       btnCadastrar.addActionListener(e -> {
           remove(painel);
           add(cadastrar);
           revalidate();
           repaint();
       });
       painel.add(btnCadastrar);
       JButton btnListar = new BotaoArredondado("Listar", 20,20);
       btnListar.setBackground(Color.WHITE);
       btnListar.setPreferredSize(new Dimension(300, 50));
       btnListar.setContentAreaFilled(false);
       btnListar.setOpaque(false);
       btnListar.addActionListener(e -> {
           remove(painel);
           add(listar);
           revalidate();
           repaint();
       });
       painel.add(btnListar);
       JButton btnAtualizar = new BotaoArredondado("Atualizar Produto", 20,20);
       btnAtualizar.setBackground(Color.WHITE);
       btnAtualizar.setContentAreaFilled(false);
       btnAtualizar.setOpaque(false);
       btnAtualizar.setPreferredSize(new Dimension(300, 50));
       btnAtualizar.addActionListener(e -> {
           remove(painel);
           add(atualizar);
           revalidate();
           repaint();
       });
       painel.add(btnAtualizar);
       JButton btnExcluir = new BotaoArredondado("Excluir", 20,20);
       btnExcluir.setBackground(Color.WHITE);
       btnExcluir.setContentAreaFilled(false);
       btnExcluir.setOpaque(false);
       btnExcluir.setPreferredSize(new Dimension(300, 50));
       btnExcluir.addActionListener(e -> {
           remove(painel);
           add(excluir);
           revalidate();
           repaint();
       });
       painel.add(btnExcluir);
       add(painel);
   }
   public static void main(String[] args) {
       try {
           TelaInicial tela = new TelaInicial();
           tela.setVisible(true);
       } catch (SQLException e) {
           e.printStackTrace();
           JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados: " + e.getMessage(), "Erro",
                   JOptionPane.ERROR_MESSAGE);
       }
   }
}
