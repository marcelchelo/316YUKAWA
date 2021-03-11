import java.util.*;

class Int extends Primary
{
	static int intCount = 0 ;
	
	
	int val;

	//constructor
	Int(int i)
	{
		val = i;
		
		//add to counters
		counter();
		primaryCounter();
	}
	
	public void counter() {
		intCount = intCount +1;
		
	}
	
	public static int getINTCounter() {
		// TODO Auto-generated method stub
		return intCount;
	}
	@Override
	void primaryCounter() {
		//Since ID is child of Primary then we must add 1 to counter of primary in the parent class. 
		setPrimaryCounter(super.getPrimaryCounter() +1);
		
		
	}
	


	void printParseTree(String indent)
	{
		String indent1 = indent+" ";

		super.printParseTree(indent);
		IO.displayln(indent1 + indent1.length() + " " + val);
	}

	Val Eval(HashMap<String,Val> state)
	{
		return new IntVal(val);
	}

	

	

	
}