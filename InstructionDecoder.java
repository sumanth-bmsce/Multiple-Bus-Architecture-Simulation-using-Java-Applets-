package java_assignment;
import java.applet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class InstructionDecoder extends Applet implements ActionListener{

	HashMap<String,Integer>  getRegister= new HashMap<String,Integer>(); 
	{
		int j=0;
		for(int i=1;i<=32;i++)
		{
			getRegister.put("R"+String.valueOf(i),j);
			j++;
		}
		for(int i=65;i<71;i++)
		{
			getRegister.put(String.valueOf((char)i),j++);
		}
	}
	HashMap<String,Integer>  getInstruction= new HashMap<String,Integer>();
	{
		getInstruction.put("ADD",0);
		getInstruction.put("MOVE",1);
	}
	HashMap<String,Integer>  getAddressMode= new HashMap<String,Integer>();
	{
		getAddressMode.put("DIRECT",0);
		getAddressMode.put("POINTER",1);
		//getAddressMode.put("Index",2);
	}
	int insDecode[] = new int[5];
	Choice insSelect;
	Choice sourceSelect ;
	Choice sourceaddressSelect;
	Choice destSelect;
	Choice destaddressSelect;
	Button b;
	
	public void init()
	{
		b = new Button("Submit");
		insSelect  = new Choice();
		insSelect.setLocation(50,50);
		sourceSelect = new Choice();
		sourceaddressSelect = new Choice();
		destSelect = new Choice();
		destaddressSelect = new Choice();
		for(int i=1;i<=32;i++)
		{
			sourceSelect.add("R"+String.valueOf(i));
		}
		for(int i=65;i<71;i++)
		{
			sourceSelect.add(String.valueOf((char)i));
		}
		sourceaddressSelect.add("DIRECT");
		sourceaddressSelect.add("POINTER");
		destaddressSelect.add("DIRECT");
		destaddressSelect.add("POINTER");
		insSelect.add("ADD");
		insSelect.add("MOVE");
		for(int i=1;i<=32;i++)
		{
			destSelect.add("R"+String.valueOf(i));
		}
		for(int i=65;i<71;i++)
		{
			destSelect.add(String.valueOf((char)i));
		}
		add(insSelect);
		add(sourceSelect);
		add(sourceaddressSelect);
		add(destaddressSelect);
		add(destSelect);
		add(b);
		b.addActionListener(this);
	}
	public void paint(Graphics g)
	{
		insDecode[0]=getInstruction.get(insSelect.getSelectedItem().toString());
		g.drawString(String.valueOf(insDecode[0]),100,100);
		insDecode[1]=getRegister.get(sourceSelect.getSelectedItem().toString());
		g.drawString(String.valueOf(insDecode[1]),120,100);
		insDecode[2]=getAddressMode.get(sourceaddressSelect.getSelectedItem().toString());
		g.drawString(String.valueOf(insDecode[2]),140,100);
		insDecode[3]=getRegister.get(destSelect.getSelectedItem().toString());
		g.drawString(String.valueOf(insDecode[3]),160,100);
		insDecode[4]=getAddressMode.get(destaddressSelect.getSelectedItem().toString());
		g.drawString(String.valueOf(insDecode[4]),180,100);
	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}
	
	
	
	
}
