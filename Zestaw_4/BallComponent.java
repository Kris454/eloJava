import java.awt.*;
import java.util.*;
import javax.swing.*;
public class BallComponent  extends JPanel{
	public static final int DEFAULT_WIDTH = 800;
	public static final int DEFAULT_HEIGHT = 600;
	private java.util.List<Ball> balls = new ArrayList<>();
	public void add(Ball b)
	{
		balls.add(b);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		for (Ball b: balls)
		{
			g2.fill(b.getShape());
		}
	}
	public Dimension getPreferredSize(){
		return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}
}
