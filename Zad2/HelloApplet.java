import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;


public class HelloApplet extends JApplet {
public void init()
{
	EventQueue.invokeLater(new Runnable()
	{
		public void run()
		{
			setLayout(new BorderLayout());
			
			JLabel label = new JLabel(getParameter("greeting"), SwingConstants.CENTER);
			label.setFont(new Font("Serif",Font.BOLD, 18));
			add(label, BorderLayout.CENTER);
			
			
		}
	});
	
	
}
}	

