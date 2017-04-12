package java_assignment;
import java.applet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ALU extends Applet{
	int r;
	void setALUValue(MUX obj,int value)
	{
		if(obj.selectA==true)
		{
			r=obj.value;
		}
		if(obj.selectB==true)
		{
			r=obj.value;
		}
	}
Bus bus = new Bus();
	public void paint(Graphics g)
	{
		
		bus.busB = true;
	if(bus.busB==true)
		{
			for(int x=650;x<=740;x=x+9)
			{
				g.setColor(Color.BLUE);
				g.fillOval(x,330,6,6);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		bus.busB = false;
		bus.busC = true;
		
	
	}
	public void travelBusC(Graphics g)
	{
	if(bus.busC==true)
		{
			for(int x=870;x<=990;x=x+9)
			{
				g.setColor(Color.BLUE);
				g.fillOval(x,315,6,6);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		bus.busC=false;
		
	}
	public void traveltoIR(Graphics g)
	{
	bus.busC=true;
		if(bus.busC==true)
		{
			for(int y=315;y<=480;y=y+9)
			{
				g.setColor(Color.BLUE);
				g.fillOval(1000,y,6,6);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		for(int x=1000;x>870;x=x-9)
		{
			g.setColor(Color.BLUE);
			g.fillOval(x,480,6,6);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
