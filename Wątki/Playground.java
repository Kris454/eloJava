	
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;

public class Playground extends JFrame implements MouseListener {

	private BallComponent comp;
	public int mousex, mousey; 
	private Random generator = new Random();
	public Playground() {
		super();
		comp = new BallComponent();
		comp.addMouseListener(this);
		this.setBounds(0, 0, 800, 600);
		add(comp, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();

		addButton(buttonPanel, "Dodaj", new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				addBall();
			}

		});

		add(buttonPanel, BorderLayout.SOUTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void addBall() {
		generator.nextInt(89);
		int dd;
		dd = generator.nextInt(89);
		
		Ball ball = new Ball(comp,0,0,dd);

		comp.addBall(ball);

		ball.start();

	}

	public void stopBall() {
	//	comp.stopBalls();
	}

	public void addButton(Container c, String title, ActionListener listener) {
		JButton button = new JButton(title);
		c.add(button);
		button.addActionListener(listener);

	}
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new Playground();
				frame.setVisible(true);
			}
		});
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		//System.out.println("STOP");
	    if(e.getButton() == MouseEvent.BUTTON1)
	    {
			mousex = e.getX();
			mousey = e.getY();
			//System.out.println("STOP");
			comp.stopBalls(mousex, mousey);
	    }	    
	    else if(e.getButton() == MouseEvent.BUTTON3)
	    {
	     //label.setText("Detected Mouse Right Click!");
	    	mousex = e.getX();
			mousey = e.getY();
			//System.out.println("STOP");
			try {
				comp.endBalls(mousex, mousey);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    }
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
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
