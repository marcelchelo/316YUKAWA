class RelPrimary extends BoolPrimary
{
	static String[] relop_st = { "<", "<=", ">", ">=", "==", "!=" };

	E e1;
	E e2;
	State relop;

	RelPrimary(E e_1, E e_2, State rel)
	{
		e1 = e_1;
		e2 = e_2;
		relop = rel;
	}

	String toString(String indent)
	{
		String indent1 = indent + " ";

		return indent + indent.length() + " <boolPrimary>\n" +
		       e1.toString(indent1) + "\n" +
		       indent1 + indent1.length() + " " + relop_st[relop.ordinal()-9] + "\n" + 
		       e2.toString(indent1);
	}

	Val Eval()
	{
		return null;
	}
}