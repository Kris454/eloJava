import java.awt.geom.*;
import java.awt.*;

public class Ball extends Thread{
private static final int XSIZE = 30;
private static final int YSIZE = 30;
private double x= 0; 
private double y= 0;
private double dx = 0.5;
private double dy = 0.5;
volatile boolean running = true;
	private Component component;
	public static final int STEPS = 3000;
	public static final int DELAY = 5;
	public Ball(Component aComponent){
		component = aComponent;
		
	}
	public void run(){
	try
	{
		while(running)
		{
			move(component.getBounds());
			component.repaint();
			//repaint();
			Thread.sleep(DELAY);
		}
	}
	catch(InterruptedException e){
		
	}
}
public void move(Rectangle2D bounds)
{
	x += dx;
	y += dy;
	if(x < bounds.getMinX())
	{
		x = bounds.getMinX();
		dx = -dx;
	}
	if(x+XSIZE >= bounds.getMaxX())
	{
		x =bounds.getMaxX() - XSIZE;
		dx = -dx;
	}
	if(y < bounds.getMinY())
	{
		y = bounds.getMinY();
		dy = -dy;	
	}
	if(y + YSIZE >= bounds.getMaxY())
	{
		y = bounds.getMaxY() - YSIZE;
		dy = -dy;
	}
	
}
public Ellipse2D getShape()
{
return new Ellipse2D.Double(x, y, XSIZE, YSIZE);	
	
}
	
}

