package java_assignment;

public class Bus {
	int a;
boolean busA = false, busB = false, busC = false;
void commandBus(GeneralPurposeRegister obj)
{
	if(obj.outA==true)
	{
		this.a=obj.v;
	}
	obj.outA=false;
}
void takeFromBus(GeneralPurposeRegister obj)
{
	if(obj.inC==true)
	{
		obj.v=a;
	}
	obj.inC=false;
}
}
