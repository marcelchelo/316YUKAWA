class InvPrimary extends Primary
{
	Primary primary;

	InvPrimary(Primary p)
	{
		primary = p;
	}

	String toString(String indent)
	{
		String indent1 = indent + " ";

		return indent + indent.length() + " <primary>\n" +
		       indent1 + indent1.length() + " !\n" + 
		       primary.toString(indent1);
	}

	Val Eval()
	{
		Val primaryVal = primary.Eval();
		if(primaryVal != null)
			return primaryVal;
		else return null;
	}
}