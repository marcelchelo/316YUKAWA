class Id extends Primary
{
	String id;

	Id(String ident)
	{
		id = ident;
	}

	String toString(String indent)
	{
		return indent + indent.length() + " <primary> " + id;
	}

	Val Eval()
	{
	
		return null;
	}
}