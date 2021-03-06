class AddE extends E
{
	// Term term; inherited from E

	E e;

	AddE(Term t, E e_)
	{
		term = t;
		e = e_;
	}

	void printParseTree(String indent)
	{
		String indent1 = indent + " ";

		super.printParseTree(indent);
		term.printParseTree(indent1);
		IO.displayln(indent1 + indent1.length() + " +");
		e.printParseTree(indent1);
	}
	
	
	//moddifications
	Val evalTerm;
	Val eValE;
	

	Val Eval()
	{
		AREvalTerm arValSum =  new AREvalTerm();
		AR.arCounter++;
		
		RuntimeStack.push(arValSum);
			
		
		Val termVal = term.Eval();
		 
		//must add to evalTerm
		evalTerm = arValSum.returnval;
		
		Val    eVal =    e.Eval();
		if ( termVal == null || eVal == null )
			return null;
		
		// The result will be float if one or both of the arguments are float.
		
		Class termClass = termVal.getClass();
		Class    eClass =    eVal.getClass();

		if ( termClass == IntVal.class && eClass == IntVal.class )
		{
			((IntVal)termVal).val = ((IntVal)termVal).val + ((IntVal)eVal).val;
			return termVal;
		}
		else if ( termClass == IntVal.class ) // eClass == FloatVal.class
		{
			((FloatVal)eVal).val = ((IntVal)termVal).val + ((FloatVal)eVal).val;
			return eVal;
		}
		else // termClass == FloatVal.class
		{
			((FloatVal)termVal).val = termVal.floatVal() + eVal.floatVal();
			return termVal;
		}
	}
}