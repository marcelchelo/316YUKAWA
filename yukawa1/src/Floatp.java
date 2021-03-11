import java.util.*;

class Floatp extends Primary
{
	static int floatPcounter = 0 ;
	
	float val;

	//constructor
	Floatp(float f)
	{
		val = f;
		
		//counters
		counter();
		primaryCounter();
	}
	
	public void counter() {
		floatPcounter = floatPcounter +1;
		
	}
	
	@Override
	void primaryCounter() {
		setPrimaryCounter(super.getPrimaryCounter() +1);
		
	}
	
	public static int getFloatPcounter() {
		// TODO Auto-generated method stub
		return floatPcounter;
	}
	

	void printParseTree(String indent)
	{
		String indent1 = indent+" ";

		super.printParseTree(indent);
		IO.displayln(indent1 + indent1.length() + " " + val);
	}

	Val Eval(HashMap<String,Val> state)
	{
		return new FloatVal(val);
	}

	
}