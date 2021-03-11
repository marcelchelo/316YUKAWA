class SingleBoolPrimary extends BoolTerm
{
	BoolPrimary boolPrimary;
	

	SingleBoolPrimary(BoolPrimary b)
	{
		boolPrimary = b;
	}

	String toString(String indent)
	{
		return indent + indent.length() + " <boolTerm>\n" +
		       boolPrimary.toString(indent+" ");
	}

	Val Eval()
	{
		Val boolPrimaryVal = boolPrimary.Eval();
		return boolPrimaryVal;
	}
}




