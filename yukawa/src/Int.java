class Int extends Primary
{
	int val;

	Int(int i)
	{
		val = i;
	}

	String toString(String indent)
	{
		return indent + indent.length() + " <primary> " + val;
	}

	Val Eval()
	{
		return new IntVal(val);
	}
}