import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class Playground extends JFrame {
private BallComponent comp;
//public static final int STEPS = 1000; 
//public static final int DELAY = 3;
//public static final int DEFAULT_WIDTH = 800;
//public static final int DEFAULT_HEIGHT = 600;
//private java.util.List<Ball> balls = new ArrayList<>();

	public Playground(){
	super();
	comp = new BallComponent();
	this.setBounds(0, 0, 800, 600);
	add(comp, BorderLayout.CENTER);
	JPanel buttonPanel = new JPanel();
	addButton(buttonPanel, "Start", new ActionListener()
			{
			public void actionPerformed(ActionEvent event)
			{
			addBall();
			}
			
});
	addButton(buttonPanel, "Stop", new ActionListener()
			{
			public void actionPerformed(ActionEvent event)
			{
			stopBall();
			}
			
});
	add(buttonPanel, BorderLayout.SOUTH);
}
	public void addBall(){
			Ball ball = new Ball(comp);
			comp.add(ball);
			//Runnable r = new BallRunnable(ball, comp);
			//Thread t = new Thread(r);
			ball.start();
			//t.wait();
		}
	public void stopBall(){
		
		
		}
	public void addButton(Container c, String title, ActionListener listener)
	{
		JButton button = new JButton(title);
		c.add(button);
		button.addActionListener(listener);
		
	}
	/*public void add(Ball b)
	{
		balls.add(b);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;
				for (Ball b: balls)
				{
					g2.fill(b.getShape());
				}
	}
	public Dimension getPreferredSize(){
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
	}*/
public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable()
			{
		public void run(){
			JFrame frame = new Playground();
			frame.setVisible(true);
		}
			});
}
}
