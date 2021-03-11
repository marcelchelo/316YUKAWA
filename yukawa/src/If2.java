class If2 extends Statement
{
	Expr expr;
	Statement statement1;
	Statement statement2;

	If2(Expr e, Statement s1, Statement s2)
	{
		expr = e;
		statement1 = s1;
		statement2 = s2;
	}

	String toString(String indent)
	{
		String indent1 = indent + " ";

		return indent + indent.length() + " <statement>\n" +
		       indent1 + indent1.length() + " if\n" +
		       expr.toString(indent1) + "\n" +
		       statement1.toString(indent1) + "\n" +
		       indent1 + indent1.length() + " else\n" +
		       statement2.toString(indent1) + "\n";
	}

	void M()
	{
		Val exprVal = expr.Eval();
		if (exprVal != null && ((BoolVal)exprVal).val)
		{
			statement1.M();
		exprVal = expr.Eval();
	}
		else {
			statement2.M();
			exprVal = expr.Eval();
			}
		}
}

