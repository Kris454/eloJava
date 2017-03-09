
import java.awt.geom.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.math.*;
import javax.swing.JPanel;

public class Ball extends Thread {

	private static final int XSIZE = 30;
	private static final int YSIZE = 30;
	private int x = 0;
	private int y = 0;
	private int predkosc = 8;
	private static int kat;
	private double dx = Math.sin(kat * 3.1415923865 / 180) * predkosc;
	private double dy = Math.cos(kat * 3.1415923865 / 180) * predkosc;
	private volatile boolean running = true;
	private Component panel;
	public static int DELAY = 25;
	public static Graphics grafika;
	public static Box elo = new Box();
	private boolean srodek = false;

	public int getX() {

		return x;
	}

	public int getY() {
		return y;
	}

	public Ball(Component aPanel, int nx, int ny, int dd) {
		panel = aPanel;

		grafika = aPanel.getGraphics();

		// grafika.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		// RenderingHints.VALUE_ANTIALIAS_ON);
		kat = dd;
	}

	private boolean jestwsrodku(Box box) {
		int startX = box.xs;
		int startY = box.ys;

		return (x >= startX - XSIZE && x <= (box.xe) && y >= startY - XSIZE && y <= (box.ye));
	}

	public boolean changeRunningState() {
		running = !running;
		return this.running;
	}

	@Override
	public void run() {
		try {
			while (true) {
				while (running) {
					move();
					panel.repaint();
					Thread.sleep(25);
					if (elo != null) {
						if (jestwsrodku(elo) && !srodek) {
							srodek = elo.enter();
						}

						else if (!jestwsrodku(elo) && srodek) {
							srodek = false;
							elo.exit();
						}
					}

					// spawdzamy czy juz dotykamy box, jesli dotykamy to wtedy
					// sprawdzamy czt mozemy wejdz jak tak to idziemy i tyle..
					// jak nie to wait na box
				}
			}
		} catch (InterruptedException e) {
			System.out.println("ERROR");
		} catch (NullPointerException e) {
			System.out.println("ERROR NPE");
		}
	}

	public void move() {
		x += dx;
		y += dy;
		if (x <= 0) {
			x = 0;
			dx = -dx;
		}
		if (x + XSIZE >= 800.0) {
			x = 800 - XSIZE;
			dx = -dx;
		}
		if (y <= 0) {
			y = 0;
			dy = -dy;
		}
		if (y + YSIZE >= 540) {
			y = 540 - YSIZE;
			dy = -dy;
		}
	}

	public Ellipse2D getShape() {
		return new Ellipse2D.Double(x, y, XSIZE, YSIZE);

	}

}
