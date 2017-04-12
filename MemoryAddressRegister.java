package java_assignment;
import java.applet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MemoryAddressRegister extends Applet {
	boolean marin=false;
	boolean marout=false;
	public void paint(Graphics g)
	{
		g.setColor(Color.BLUE);
		for(int y=315;y<=620;y=y+9)
		{
			g.fillOval(990,y,6,6);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int x=990;x>=870;x=x-9)
		{
			g.fillOval(x, 620, 6, 6);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int x=750;x>250;x=x-9)
		{
			g.fillOval(x,620,6,6);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*for(int x=650;x<750;x=x+9)
		{
			g.fillOval(x,250,6,6);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
	}
	

}
