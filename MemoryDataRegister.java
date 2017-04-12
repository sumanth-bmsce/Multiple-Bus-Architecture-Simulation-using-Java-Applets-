package java_assignment;
import java.applet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemoryDataRegister {
    String ins;
	boolean mdrin = false;
	boolean mdrout = false;
	Bus bus = new Bus();
	
	public void paint(Graphics g)
	{
		
		bus.busA = false;
		mdrin=true;
		mdrout=true;
		if(mdrin == true && mdrout == true && bus.busA==false)
		{
			for(int x=250;x<=750;x=x+9)
			{
				g.fillOval(x, 560, 6, 6);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				bus.busA = true;
			}
			
		}
		
	}
	public void travelbus(Graphics g)
	{
		if(bus.busA==true)
		{
			for(int x=750;x>=650;x=x-9)
			{
				g.fillOval(x, 550, 6, 6);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			bus.busA=false;
		}
		for(int y=550;y>=330;y=y-9)
		{
			g.fillOval(650,y, 6, 6);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int x=650;x<750;x=x+9)
		{
			g.fillOval(x, 330, 6, 6);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	
}
