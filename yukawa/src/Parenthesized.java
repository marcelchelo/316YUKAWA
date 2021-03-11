class Parenthesized extends Primary
{
	Expr expr;

	Parenthesized(Expr e)
	{
		expr = e;
	}

	String toString(String indent)
	{
		return indent + indent.length() + " <primary>\n" + 
		       expr.toString(indent+" ");
	}

	Val Eval()
	{
		Val exprVal = expr.Eval();
		if(exprVal != null)
			return exprVal;
		else return null;
	}
}