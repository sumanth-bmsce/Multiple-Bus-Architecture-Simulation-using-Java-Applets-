package java_assignment;
import java.applet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.AttributedCharacterIterator;
import java.util.HashMap;

public class Simulation extends Applet implements ActionListener{
	Choice insSelect;
	Choice sourceSelect ;
	Choice sourceaddressSelect;
	Choice destSelect;
	Choice destaddressSelect;
	Button finalizeInstruction;
	
	 Label lpgm;
	 int insDecode[] = new int[5];
	 Button startSimulation;
	 InstructionDecoder id = new InstructionDecoder();
	 ProgramCounter pgmctr = new ProgramCounter();
	 ALU alu = new ALU();
	 MUX multiplex = new MUX();
	 Bus busA = new Bus();
	 Bus busB = new Bus();
	 Bus busC = new Bus();
	 MemoryAddressRegister mar = new MemoryAddressRegister();
	 MemoryDataRegister mdr = new MemoryDataRegister();
	 RAMMemory ram = new RAMMemory();
	 GeneralPurposeRegister general =new GeneralPurposeRegister();
	 ir insreg = new ir();
	 GeneralPurposeRegister[] gprobj;
	 RAMMemory[] ramMemoryLocation;
	 void initialize()
	 {
		 GeneralPurposeRegister[] gprobj = new GeneralPurposeRegister[32];
		 int j=0;
		 for(int i=0;i<32;i++)
		 {
			
			 gprobj[i] = new GeneralPurposeRegister();
			 gprobj[i].v=++j;
		 }
		 RAMMemory[] ramMemoryLocation = new RAMMemory[6];
		 int i = 0;
		 for(j=0;j<6;j++)
		 {
			 
			 ramMemoryLocation[j] = new RAMMemory();
			 ramMemoryLocation[j].ramValue=++i;
		 }
	 }
	 //GeneralPurposeRegister GeneralPurposeRegisterobj2 = new GeneralPurposeRegister();
	 //GeneralPurposeRegister GeneralPurposeRegisterobj3 = new GeneralPurposeRegister();
	 Color pccolor1 = Color.RED;
	 Color aluColor = Color.WHITE;
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
 	public void init()
	{
 		//initialize();
 		finalizeInstruction = new Button("Submit");
		insSelect  = new Choice();
		
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
		//insSelect.setLocation(10,10);
		add(sourceSelect);
		//sourceSelect.setLocation(30, 10);
		add(sourceaddressSelect);
		//sourceaddressSelect.setLocation(50, 10);
		add(destSelect);
		add(destaddressSelect);
		add(finalizeInstruction);
		finalizeInstruction.addActionListener(this);
 		
 		mdr.ins="";
 		insreg.val = "";
		pgmctr.value=1000;
		startSimulation = new Button("Start");
		add(startSimulation);
		startSimulation.addActionListener(this);
		lpgm = new Label();
		add(lpgm);
	}
	
	public void paint(Graphics g)
	{   
		initialize();
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
		// Setting register labels
		if(insDecode[1]<32 && insDecode[3]<32)
		{
		g.drawString("R"+String.valueOf(insDecode[1]+1),880,165);
		g.drawString("R"+String.valueOf(insDecode[3]+1),880,195);
		}
		else if(insDecode[1]>=32 && insDecode[3]<32){
			g.drawString("LOC"+String.valueOf((char)(insDecode[1]-32+65)),880,165);
			g.drawString("R"+String.valueOf(insDecode[3]+1),880,195);
		}
		else if(insDecode[1]<32 && insDecode[3]>=32){
			g.drawString("R"+String.valueOf((char)(insDecode[1]+1)),880,165);
			g.drawString("R"+String.valueOf((char)insDecode[3]-32+65),880,195);
		}
		else if(insDecode[1]>=32 && insDecode[3]>=32){
			g.drawString("LOC"+String.valueOf((char)(insDecode[1]-32+65)),880,165);
			g.drawString("LOC"+String.valueOf((char)(insDecode[3]-32+65)),880,195);
		}
		// For Bus A
		g.drawLine(500,0,500,800);
		// For Bus B
		g.drawLine(650,0, 650, 800);
		// For Bus C
		g.drawLine(1000, 0, 1000, 800);
		// For PC
		g.setColor(Color.BLACK);
		g.drawRect(749,89,121,41);
		g.setColor(pccolor1);
		g.fillRect(750,90,120,40);
		//pgmctr.value = 1000;
		//GeneralPurposeRegisterobj1.value = "3";
	   //GeneralPurposeRegisterobj2.value = "4";
	    g.setColor(Color.BLACK);
		g.drawString(String.valueOf(pgmctr.value), 790, 110);
		    // For GeneralPurposeRegister
		    g.setColor(Color.BLACK);
			g.drawRect(750,150,120,20);
			g.drawRect(750, 180, 120, 20);
			g.drawRect(750, 210, 120, 20);
		//	g.drawString(GeneralPurposeRegisterobj1.value,780,165);
			//g.drawString(GeneralPurposeRegisterobj2.value,780,195);
		    //g.drawString(GeneralPurposeRegisterobj3.value,780,225);
			// For ALU
			g.setColor(Color.BLACK);
			g.drawRect(749,279,121,81);
			g.setColor(aluColor);
			g.fillRect(750, 280, 120, 80);
			// For MAR
			g.setColor(Color.BLACK);
			g.drawRect(750, 600, 120, 40);
			// For RAM
			g.drawRect(200, 350,200, 170);
		g.drawString(ram.instructions.keySet().toString(), 205, 370);
			g.drawString(ram.instructions.values().toString(),270,370);
			// For MDR
			g.drawRect(750,520 , 120, 50);
			g.drawString(mdr.ins,780 , 545);
			// For IR
			g.drawRect(750,460,120,40);
			g.drawString(insreg.val,760 , 470);
			//gprobj[insDecode[3]].v=0;
		//	g.drawString(String.valueOf(gprobj[insDecode[3]].v),10,10);
			
		
		  //  g.drawString("bye",10, 10);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	if(e.getActionCommand()=="Start")
	{
		execute(getGraphics());
       repaint();
      /* pccolor1=Color.BLACK;
       update(getGraphics());*/
       pgmctr.paint(getGraphics());
       pccolor1=Color.WHITE;
       aluColor=Color.RED;
       update(getGraphics());
       alu.paint(getGraphics());
       alu.travelBusC(getGraphics());
       aluColor = Color.WHITE;
       update(getGraphics());
       pgmctr.value = pgmctr.value+4;
       update(getGraphics());
       mar.paint(getGraphics());
       update(getGraphics());
       
       
       mdr.paint(getGraphics());
       mdr.ins = ram.instructions.values().toString();
       update(getGraphics());
       mdr.travelbus(getGraphics());
       update(getGraphics());
       alu.travelBusC(getGraphics());
       update(getGraphics());
       alu.traveltoIR(getGraphics());
     //  update(getGraphics());
       insreg.val =convertInsArrayToString();
       update(getGraphics());
       general.paint(getGraphics());
       update(getGraphics());
     //Graphics g=null;
	  this.execute(getGraphics());
	 
    // update(getGraphics());
       
	}
	if(e.getActionCommand()=="Submit")
	{
		repaint();
		ram.instructions.put("1000",convertInsToString());
		
		repaint();
		
		
	}   
	}
	String convertInsToString()
	{
		String ramstr = insSelect.getSelectedItem().toString();
		ramstr += " ";
		if(sourceaddressSelect.getSelectedItem()=="POINTER")
		{
			ramstr += "(" + sourceSelect.getSelectedItem()+ ")";
		}
		else
		{
			ramstr += sourceSelect.getSelectedItem();
		}
		ramstr+= " , ";
		if(destaddressSelect.getSelectedItem()=="POINTER")
		{
			ramstr += "(" + destSelect.getSelectedItem()+ ")";
		}
		else
		{
			ramstr +=  destSelect.getSelectedItem();
		}
		return ramstr;
	}
String convertInsArrayToString()
{
	String arrayStr="";
	for(int i=0;i<=4;i++)
	{
		arrayStr += String.valueOf(insDecode[i]);
	}
	return arrayStr;
}
void execute(Graphics g)
{
	 GeneralPurposeRegister[] gprobj = new GeneralPurposeRegister[32];
	 int j=0;
	 for(int i=0;i<32;i++)
	 {
		
		 gprobj[i] = new GeneralPurposeRegister();
		 gprobj[i].v=++j;
	 }
	 RAMMemory[] ramMemoryLocation = new RAMMemory[6];
	 int i = 0;
	 for(j=0;j<6;j++)
	 {
		 
		 ramMemoryLocation[j] = new RAMMemory();
		 ramMemoryLocation[j].ramValue=++i;
	 }
	 g.drawString(String.valueOf(gprobj[insDecode[1]].v),760,160);
	 g.drawString(String.valueOf(gprobj[insDecode[3]].v), 760, 180);
	if(insDecode[0]==1&& insDecode[2]==0 && insDecode[4]==0)
	{
		if(insDecode[1]<32)
		{
			gprobj[insDecode[1]].outA=true;
			
			busA.commandBus(gprobj[insDecode[1]]);
			multiplex.selectA=true;
			multiplex.setMUXValue(busA);
			busC.a=multiplex.value;
			gprobj[insDecode[3]].inC=true;
			busC.takeFromBus(gprobj[insDecode[3]]);
		   
	//	gprobj[insDecode[3]].v=0;
			System.out.println(gprobj[insDecode[3]].v);
			
			
		    g.drawString(String.valueOf(gprobj[insDecode[3]].v),50,100);
		    g.drawString(String.valueOf(gprobj[insDecode[1]].v),760,160);
			g.drawString(String.valueOf(gprobj[insDecode[3]].v), 760, 200);
		    try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    g.drawString("bye", 50, 20);
		
			
		}
	}
}
}
