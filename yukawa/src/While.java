class While extends Statement
{
	Expr expr;
	Statement statement;

	While(Expr e, Statement s)
	{
		expr = e;
		statement = s;
	}

	String toString(String indent)
	{
		String indent1 = indent + " ";

		return indent + indent.length() + " <statement>\n" +
		       indent1 + indent1.length() + " while\n" +
		       expr.toString(indent1) + "\n" +
		       statement.toString(indent1);
	}

	void M()
	{
		Val exprVal = expr.Eval();
		while ( exprVal != null && ((BoolVal)exprVal).val )
		{
			statement.M();
			exprVal = expr.Eval();
		}
	}
}

