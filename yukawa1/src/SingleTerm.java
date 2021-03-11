import java.util.*;

class SingleTerm extends E
{
	// Term term; inherited from E
	static int singleTermCounter = 0;  //This variable will keep count of the number of times  Assignment is constructed/called. 
	
	//constructor 
	SingleTerm(Term t)
	{
		term = t;
		
		counter();
		eCounter();
		
	}
	
	
	//Add 1 to assignment counter variable 
		public void counter() {
			singleTermCounter = singleTermCounter +1 ;

		}

	void printParseTree(String indent)
	{
		super.printParseTree(indent);
		term.printParseTree(indent+" ");
	}

	Val Eval(HashMap<String,Val> state)
	{
		return term.Eval(state);
	}
	
	
	//Since SingleTerm is child of E then we must add 1 to counter of E in the parent class.
	@Override  
	void eCounter() {
		setEcounter(super.getEcounter() +1);
		
	}


	public static int getSingleTermCounter() {
		
		return singleTermCounter;
	}

}