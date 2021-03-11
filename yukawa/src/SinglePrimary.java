class SinglePrimary extends Term
{
	Primary primary;

	SinglePrimary(Primary p)
	{
		primary = p;
	}

	String toString(String indent)
	{
		return indent + indent.length() + " <term>\n" +
		       primary.toString(indent+" ");
	}

	Val Eval()
	{
		Val primaryVal = primary.Eval();
		if(primaryVal != null)
			return primaryVal;
		else return null;
	}
}