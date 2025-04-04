package estoque;
import javax.swing.*;
import java.awt.*;
public class BotaoArredondado extends JButton {
	    private int arcWidth;
	    private int arcHeight;
	   
	    public BotaoArredondado(String text, int arcWidth, int arcHeight) {
	        super(text);
	        this.arcWidth = arcWidth;
	        this.arcHeight = arcHeight;
	        setContentAreaFilled(false);
	        setFocusPainted(false);
	        setBorderPainted(false);
	    }
	    @Override
	    protected void paintComponent(Graphics g) {
	        Graphics2D g2 = (Graphics2D) g;
	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	       
	        // Cor de fundo do botão
	        g2.setColor(getBackground());
	        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arcWidth, arcHeight);
	       
	        super.paintComponent(g);
	    }
	}
