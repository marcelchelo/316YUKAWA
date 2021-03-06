import java.util.*;

class MulTerm extends Term
{	
	static int mulTermCounter = 0 ;
	
	// Primary primary; inherited from Term

	Term term;

	MulTerm(Primary p, Term t)
	{
		primary = p;
		term = t;
		
		counter();
		termCounter();
	}
	
	@Override
	void termCounter() {
		setTermCounter(super.getTermCounter() +1);
		
	}
	

	private void counter() {
		mulTermCounter =mulTermCounter +1;
		
	}
	
	
	//To store in array data structure. 
	public static int getMulTermCounter() {
		return mulTermCounter;
	}

	void printParseTree(String indent)
	{
		String indent1 = indent + " ";

		super.printParseTree(indent);
		primary.printParseTree(indent1);
		IO.displayln(indent1 + indent1.length() + " *");
		term.printParseTree(indent1);
	}

	Val Eval(HashMap<String,Val> state)
	{
		Val primaryVal = primary.Eval(state);
		Val    termVal =    term.Eval(state);
		if ( primaryVal == null || termVal == null )
			return null;
		
		// The result will be float if one or both of the arguments are float.
		
		Class primaryClass = primaryVal.getClass();
		Class    termClass =    termVal.getClass();

		if ( primaryClass == IntVal.class && termClass == IntVal.class )
		{
			((IntVal)primaryVal).val = ((IntVal)primaryVal).val * ((IntVal)termVal).val;
			return primaryVal;
		}
		else if ( primaryClass == IntVal.class ) // termClass == FloatVal.class
		{
			((FloatVal)termVal).val = ((IntVal)primaryVal).val * ((FloatVal)termVal).val;
			return termVal;
		}
		
		else // primaryClass == FloatVal.class
		{
			((FloatVal)primaryVal).val = primaryVal.floatVal() * termVal.floatVal();
			return primaryVal;
		}
	

}

	
}