package estoque;
import javax.swing.*;
import java.awt.*;
public class CampoArredondado extends JTextField {
   private int arcWidth;
   private int arcHeight;
   public CampoArredondado(int columns, int arcWidth, int arcHeight) {
       super(columns);
       this.arcWidth = arcWidth;
       this.arcHeight = arcHeight;
       setOpaque(false);
       setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
   }
   @Override
   protected void paintComponent(Graphics g) {
       Graphics2D g2 = (Graphics2D) g.create();
       g2.setColor(getBackground());
       g2.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);
       super.paintComponent(g);
       g2.dispose();
   }
   @Override
   protected void paintBorder(Graphics g) {
       Graphics2D g2 = (Graphics2D) g.create();
       g2.setColor(Color.GRAY); // cor da borda
       g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcWidth, arcHeight);
       g2.dispose();
   }
}
