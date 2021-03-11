import java.util.*;

class Parenthesized extends Primary
{
	static int parenthesizedCount = 0 ;
	E e;

	//constructor
	Parenthesized(E exp)
	{
		e = exp;
		
		//counter
		counter();
		primaryCounter();
		
	}
	
	public void counter() {
		parenthesizedCount = parenthesizedCount +1;
		
	}

	
	//child class overrides method from parent 
	@Override
	void primaryCounter() {
		setPrimaryCounter(super.getPrimaryCounter() +1);
		
	}
	

	void printParseTree(String indent)
	{
		super.printParseTree(indent); 
		e.printParseTree(indent+" ");
	}

	Val Eval(HashMap<String,Val> state)
	{
		return e.Eval(state);
	}

	public static int getParenthesizedCounter() {
		// TODO Auto-generated method stub
		return parenthesizedCount;
	}

	
}