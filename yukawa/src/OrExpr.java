class OrExpr extends Expr
{
	BoolTerm boolTerm;
	Expr expr;

	OrExpr(BoolTerm b, Expr e)
	{
		boolTerm = b;
		expr = e;
	}

	String toString(String indent)
	{
		String indent1 = indent + " ";

		return indent + indent.length() + " <expr>\n" +
		       boolTerm.toString(indent1) + "\n" +
		       indent1 + indent1.length() + " ||\n" +
		       expr.toString(indent1);
	}

	Val Eval()
	{
		Val exprVal = expr.Eval();
		Val boolTermVal = boolTerm.Eval();
		if(boolTermVal == exprVal)
		return exprVal;
		else
			return
			boolTermVal;
	}
}


