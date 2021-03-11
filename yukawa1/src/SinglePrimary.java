import java.util.*;

class SinglePrimary extends Term
{
	static int singlePrimaryCounter = 0 ;
	
	// Primary primary; inherited from Term

	
	//constructor
	SinglePrimary(Primary p)
	{
		primary = p;
		
		//keep count of classes
		counter();
		termCounter();
	}

	//Add 1 to assignment counter variable 
	public void counter() {
		singlePrimaryCounter = singlePrimaryCounter +1;
		
	}
	
	//Since Assignment is child of AssignmentList then we must add 1 to counter of AssignmentList in the parent class. 
	@Override
	void termCounter() {
		setTermCounter(super.getTermCounter() +1);
		
	}
	
	static int getSinglePrimaryCounter () {
		return singlePrimaryCounter;
	}
	
	

	void printParseTree(String indent)
	{
		super.printParseTree(indent);
		primary.printParseTree(indent+" ");
	}

	Val Eval(HashMap<String,Val> state)
	{
		return primary.Eval(state);
	}

	
}