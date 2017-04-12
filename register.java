package java_assignment;
import java.applet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class register {
     String value;
     register()
     {
    	 value="";
     }
}

/*class gpr extends Applet{
	String value="";
	boolean inA=false,outA=false,inB=false,outB=false,inC=false,outC=false;
	Button b;
	public void init()
	{
		repaint();
	}
	
	public void paint(final Graphics g)
	{
		
	Thread t1 = new Thread(new Runnable()
	{
    public void run() {
		// TODO Auto-generated method stub
		g.setColor(Color.ORANGE);
		for(int x=750;x<500;x=x+9)
		{
			
			g.fillOval(x, 160, 6, 6);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
    }
	});
	
	 Thread t2 = new Thread(new Runnable()
	 {
		public void run() {
			// TODO Auto-generated method stub
			g.setColor(Color.GREEN);
			for(int x=750;x<650;x=x+9)
			{
				g.fillOval(x, 190, 6, 6);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	});
	
	}
	
	
}*/

class ir extends register{
	String opcode;
	String mode;
	String val;
	boolean irin,irout;
	
}

