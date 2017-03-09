
//package mandelbrot;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class Mandelbrot extends JFrame implements ActionListener, MouseMotionListener, MouseListener {

	private int MAX_ITER = 1000;
	private final double ZOOM = 200;
	private double PROMIEN = 4;
	public BufferedImage I, C;
	private double zx, zy, cX, cY, tmp;
	private Complex d = new Complex(0, 0);
	private int mousexs, mousexe, mouseys, mouseye;
	ImagePanel right;

	public void generuj(double ZOOM, int s, int e, int itere, int prom) {
		for (int y = 0; y < getHeight(); y++) {
			for (int x = 0; x < getWidth(); x++) {
				zx = zy = 0;
				cX = (x - 400 + s) / ZOOM;
				cY = (y - 300 + e) / ZOOM;
				int iter = itere;
				MAX_ITER = itere;
				PROMIEN = prom;
				Complex p = new Complex(cX, cY);
				d.setIm(0);
				d.setRe(0);
				while (d.sqrAbs() < 4 && iter > 0) {					
					d = (d.mul(d)).add(p);
					iter--;
				}
				I.setRGB(x, y, iter | (iter << 1000));
			}
		}

	}

	public void generuj(double ZOOM, int s, int e) {
		for (int y = 0; y < getHeight(); y++) {
			for (int x = 0; x < getWidth(); x++) {
				zx = zy = 0;
				cX = (x - 400 + s) / ZOOM;
				cY = (y - 300 + e) / ZOOM;
				int iter = MAX_ITER;
				while (zx * zx + zy * zy < PROMIEN && iter > 0) {
					tmp = zx * zx - zy * zy + cX;
					zy = 2.0 * zx * zy + cY;
					zx = tmp;
					iter--;
				}
				I.setRGB(x, y, iter | (iter << 1000));
			}
		}

	}

	Mandelbrot() {
		super("Mandelbrot Set");
		JPanel panel = new JPanel();
		final JTextField interset = new JTextField("Iteracje");
		final JTextField prom = new JTextField("Promień");
		JButton rysuj = new JButton("Rysuj");
		JPanel left = new JPanel();
		left.setLayout(new GridLayout(4, 1));
		left.setMaximumSize(new Dimension(200, 200));
		setBounds(0, 0, 800, 600);
		I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		left.add(interset);
		left.add(prom);
		left.add(rysuj);
		generuj(200, 0, 0, 1000, 4);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		right = new ImagePanel(I);
		right.addMouseMotionListener(this);
		right.addMouseListener(this);
		rysuj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				generuj(200, 0, 0, Integer.parseInt(interset.getText()), Integer.parseInt(prom.getText()));
				right.update(I);
				right.setVisible(true);
			}

		});

		panel.add(left);
		panel.add(right);
		add(panel);

	}

	public static void main(String[] args) {
		new Mandelbrot().setVisible(true);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		mousexs = e.getX();
		mouseys = e.getY();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

		mousexe = e.getX();
		mouseye = e.getY();
		int z = (800 * 600) / ((mousexe - mousexs) * (mouseye - mouseys));
		int b = 0;
		b = b + z;
		// Mandelbrot man = new Mandelbrot(width,height,100,width/4);
		// bImage = man.bImage;
		generuj(200 * b, mousexs * z, mouseys * z);
		right.update(I);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
