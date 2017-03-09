
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class BallComponent extends JPanel {

	public static final int DEFAULT_WIDTH = 600;
	public static final int DEFAULT_HEIGHT = 300;
	private java.util.List<Ball> balls = new ArrayList<>();

	public void addBall(Ball b) {
		balls.add(b);
	}

	public void stopBalls(int x, int y) {
		for (Ball b : balls) {
			if (((x - 30) < b.getX() || b.getX() > (x + 30)) && ((y - 30) < b.getY() || b.getY() > (y + 30))) {
				//System.out.println("INSI");
				b.changeRunningState();
			}
		}
	}

	public void endBalls(int x, int y) throws InterruptedException {
		for (Ball b : balls) {
			if (((x - 30) < b.getX() || b.getX() > (x + 30)) && ((y - 30) < b.getY() || b.getY() > (y + 30))) {
				System.out.println("INSIEND");
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.fillRect(200, 150, 300, 300);
		// Color a = g2.getBackground();
		g2.setXORMode(Color.WHITE);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		for (Ball b : balls) {
			g2.fill(b.getShape());
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

}
