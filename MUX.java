package java_assignment;

public class MUX {
	int value;
	boolean constant4=false, selectA=false,selectB=false;
	void setMUXValue(Bus b)
	{
		if(selectA==true)
		{
			this.value=b.a;
		}
		if(selectB==true)
		{
			this.value=b.a;
		}
	}
}

