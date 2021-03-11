class AddE extends E
{
	Term term;
	E e;

	AddE(Term t, E e_)
	{
		term = t;
		e = e_;
	}

	String toString(String indent)
	{
		String indent1 = indent + " ";

		return indent + indent.length() + " <E>\n" +
		       term.toString(indent1) + "\n" +
		       indent1 + indent1.length() + " +\n" +
		       e.toString(indent1);
	}

	Val Eval(){
	Val eVal = e.Eval();
	Val termVal = term.Eval();
	if(eVal == null || termVal == null)
		return null;
	String valType_e = eVal.getClass().getName();
	String valType_t = termVal.getClass().getName();

	if ( valType_e.startsWith("I") && valType_t.startsWith("I") )
	{
		((IntVal)eVal).val = ((IntVal)eVal).val + ((IntVal)termVal).val;
		return eVal;
	}
	else if ( valType_e.startsWith("I") && valType_t.startsWith("F") )
	{
		((FloatVal)termVal).val = ((IntVal)eVal).val + ((FloatVal)termVal).val;
		return termVal;
	}
	else if ( valType_e.startsWith("F") && valType_t.startsWith("I") )
	{
		((FloatVal)eVal).val = ((FloatVal)eVal).val + ((IntVal)termVal).val;
		return eVal;
	}
	else if ( valType_e.startsWith("F") && valType_t.startsWith("F") )
	{
		((FloatVal)eVal).val = ((FloatVal)eVal).val + ((FloatVal)termVal).val;
		return eVal;
	}
	else
	{
		System.out.println( "Error: + operator cannot be applied to boolean" );
		return null;	
	}
	}
}