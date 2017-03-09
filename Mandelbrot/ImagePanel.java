import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Component;

public class ImagePanel extends JPanel implements MouseMotionListener {
	private  int mousex, mousey; 
	private BufferedImage B;
	ImagePanel(){ 
		
		}
	ImagePanel(BufferedImage I){ 
		B = I;
		}
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(B, 0, 0, this);
        //g.setXORMode(Color.RED);
        
	}
	public void update(Graphics g){
		
	}
	public void update(BufferedImage I){
		B = I;
		repaint();		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		mousex = e.getX();
		mousey = e.getY();
		e.consume();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
