class DivTerm extends Term
{
	// Primary primary; inherited from Term

	Term term;

	DivTerm(Primary p, Term t)
	{
		primary = p;
		term = t;
	}

	void printParseTree(String indent)
	{
		String indent1 = indent + " ";

		super.printParseTree(indent);
		primary.printParseTree(indent1);
		IO.displayln(indent1 + indent1.length() + " /");
		term.printParseTree(indent1);
	}
	
	
	//new local variables
	Val evalPrimary;
	Val evalTerm;
	
	
	Val Eval()
	{
		AREvalPrimary arEvalMPrimary = new AREvalPrimary();
		AR.arCounter ++;
		
		RuntimeStack.push(arEvalMPrimary);
		
		Val primaryVal = primary.Eval();
		arEvalMPrimary.evalPrimary();
		
		IO.displayln2(RuntimeStack.peek().toString());
		evalPrimary = arEvalMPrimary.returval;   //Type val from local variable above 
		RuntimeStack.pop();
		
		//print elements from stack from top down.
		for(int i=RuntimeStack.list.size()-1; i >=0 ; i--) {
			IO.displayln2(RuntimeStack.list.get(i).toString());
		}
		
		Val    termVal =    term.Eval();
		if ( primaryVal == null || termVal == null )
			return null;
		if ( termVal.isZero() )
		{
			System.out.println("division by 0");
			return null;
		}
		
		// The result will be float if one or both of the arguments are float.
		
		Class primaryClass = primaryVal.getClass();
		Class    termClass =    termVal.getClass();

		if ( primaryClass == IntVal.class && termClass == IntVal.class )
		{
			((IntVal)primaryVal).val = ((IntVal)primaryVal).val / ((IntVal)termVal).val;
			return primaryVal;
		}
		else if ( primaryClass == IntVal.class ) // termClass == FloatVal.class
		{
			((FloatVal)termVal).val = ((IntVal)primaryVal).val / ((FloatVal)termVal).val;
			return termVal;
		}
		
		else // primaryClass == FloatVal.class
		{
			((FloatVal)primaryVal).val = primaryVal.floatVal() / termVal.floatVal();
			return primaryVal;
		}
	}
}