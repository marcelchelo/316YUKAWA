class Do extends Statement
{
	Statement statement;
	Expr expr;

	Do(Statement s, Expr e)
	{
		statement = s;
		expr = e;
	}

	String toString(String indent)
	{
		String indent1 = indent + " ";

		return indent + indent.length() + " <statement>\n" +
		       indent1 + indent1.length() + " do\n" +
		       statement.toString(indent1) + "\n" +
		       indent1 + indent1.length() + " while\n" +
		       expr.toString(indent1);
	}

	void M()
	{
         statement.M();
         Val exprVal = expr.Eval();
         while(exprVal != null && ((BoolVal)exprVal).val){
        	 statement.M();
        	 exprVal = expr.Eval();
         }
	}
}

