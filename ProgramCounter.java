package java_assignment;
import java.applet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgramCounter extends Applet implements ActionListener{
	int value;;
    
    boolean pcin=false;
	boolean pcout=false;
	Button b;
	public void init()
 	{
 		b= new Button("Start");
 		add(b);
 		this.b.addActionListener(this);
 	}
	
 	
    public void paint(Graphics g)
     {
    	ProgramCounter pgmctr = new ProgramCounter();
    	 pgmctr.pcout=true;
    	 
         
    	 pgmctr.pcout=true;
    	/* gpr gprobj1 = new gpr();
    	 gpr gprobj2 = new gpr();
    	 gpr gprobj3 = new gpr();*/
    	/* Label l =new Label(String.valueOf(pgmctr.value);
    	 add(l);*/
    	 if(pgmctr.pcout==true)
 		{
 			
 			for(int x=740;x>=655;x=x-2)
 			{
 				g.setColor(Color.BLUE);
 				g.fillRect(x, 110, 7, 7);
 				/*try {
 					Thread.sleep(100);
 				} catch (InterruptedException e1) {
 					// TODO Auto-generated catch block
 					e1.printStackTrace();
 				}
 				g.setColor(Color.WHITE);
 				g.fillOval(x, 110, 6,6);*/
 				
 				try {
 					Thread.sleep(40);
 				} catch (InterruptedException e) {
 					// TODO Auto-generated catch block
 					e.printStackTrace();
 				}
 				g.clearRect(x, 110, 7, 7);
 			}
 			for(int y=110;y<=330;y=y+2)
 			{
 				g.setColor(Color.BLUE);
 				g.fillRect(655, y, 7, 7);
 			/*	try {
 				Thread.sleep(100);
 			} catch (InterruptedException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
 			g.setColor(Color.WHITE);
 			g.fillOval(650, y, 8, 8);*/
 				
 				try {
 					Thread.sleep(40);
 				} catch (InterruptedException e) {
 					// TODO Auto-generated catch block
 					e.printStackTrace();
 				}
 				g.clearRect(655,y, 7, 7);
 			}
 		}
     }
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		ProgramCounter pgm = new ProgramCounter();
		pgm.paint(getGraphics());
	}
}
