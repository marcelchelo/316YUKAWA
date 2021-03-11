class SingleTerm extends E
{
	Term term;

	SingleTerm(Term t)
	{
		term = t;
	}

	String toString(String indent)
	{
		return indent + indent.length() + " <E>\n" +
		       term.toString(indent+" ");
	}

	Val Eval()
	{
		Val termVal = term.Eval();
		if(termVal != null)
		return termVal;
		else return null;

	}
}