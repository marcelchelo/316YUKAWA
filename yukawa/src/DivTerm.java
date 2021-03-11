class DivTerm extends Term
{
	Primary primary;
	Term term;

	DivTerm(Primary p, Term t)
	{
		primary = p;
		term = t;
	}

	String toString(String indent)
	{
		String indent1 = indent + " ";

		return indent + indent.length() + " <term>\n" +
		       primary.toString(indent1) + "\n" +
		       indent1 + indent1.length() + " /\n" +
		       term.toString(indent1);
	}
	
	Val Eval(){
		
		Val primaryVal = primary.Eval();
		Val termVal = term.Eval();
		if ( primaryVal == null || termVal == null )
			return null;

	String valType_p = primaryVal.getClass().getName();
	String valType_t = termVal.getClass().getName();

	if ( valType_p.startsWith("I") && valType_t.startsWith("I") )
	{
		((IntVal)primaryVal).val = ((IntVal)primaryVal).val / ((IntVal)termVal).val;
		return primaryVal;
	}
	else if ( valType_p.startsWith("I") && valType_t.startsWith("F") )
	{
		((FloatVal)termVal).val = ((IntVal)primaryVal).val / ((FloatVal)termVal).val;
		return termVal;
	}
	else if ( valType_p.startsWith("F") && valType_t.startsWith("I") )
	{
		((FloatVal)primaryVal).val = ((FloatVal)primaryVal).val / ((IntVal)termVal).val;
		return primaryVal;
	}
	else if ( valType_p.startsWith("F") && valType_t.startsWith("F") )
	{
		((FloatVal)primaryVal).val = ((FloatVal)primaryVal).val / ((FloatVal)termVal).val;
		return primaryVal;
	}
	else
	{
		System.out.println( "Error: / operator cannot be applied to boolean" );
		return null;	
	}
	}
}