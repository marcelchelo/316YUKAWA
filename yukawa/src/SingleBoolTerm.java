class SingleBoolTerm extends Expr
{
	BoolTerm boolTerm;

	SingleBoolTerm(BoolTerm b)
	{
		boolTerm = b;
	}

	String toString(String indent)
	{
		return indent + indent.length() + " <expr>\n" +
		       boolTerm.toString(indent+" ");
	}

	Val Eval()
	{
		Val boolTermVal = boolTerm.Eval();
		return boolTermVal;
		
	}
}
