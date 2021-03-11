class SingleE extends BoolPrimary
{
	E e;

	SingleE(E e_)
	{
		e = e_;
	}

	String toString(String indent)
	{
		return indent + indent.length() + " <boolPrimary>\n" +
		       e.toString(indent+" ");
	}

	Val Eval()
	{
		Val eVal = e.Eval();
		return eVal;
	}
}