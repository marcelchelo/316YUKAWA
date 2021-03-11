class If1 extends Statement
{
	Expr expr;
	Statement statement;

	If1(Expr e, Statement s)
	{
		expr = e;
		statement = s;
	}

	String toString(String indent)
	{
		String indent1 = indent + " ";

		return indent + indent.length() + " <statement>\n" +
		       indent1 + indent1.length() + " if\n" +
		       expr.toString(indent1) + "\n" +
		       statement.toString(indent1);
	}

	void M()
	{
		Val exprVal = expr.Eval();
		if (exprVal != null && ((BoolVal)exprVal).val)
		{
			statement.M();
		exprVal = expr.Eval();
		}
	}
}
