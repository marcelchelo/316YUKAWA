class Bool extends Primary
{
	boolean val;

	Bool(boolean b)
	{
		val = b;
	}

	String toString(String indent)
	{
		return indent + indent.length() + " <primary> " + val;
	}

	Val Eval()
	{
		return new BoolVal(val);
	}
}