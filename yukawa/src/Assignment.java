class Assignment extends Statement
{
	String id;
	Expr expr;
	

	Assignment(String s, Expr e)
	{
		id = s;
		expr = e;
	}

	String toString(String indent)
	{
		String indent1 = indent + " ";
		String indent2 = indent + "  ";

		return indent + indent.length() + " <statement>\n" +
		       indent1 + indent1.length() + " <assignment>\n" +
		       indent2 + indent2.length() + " " + id + "\n" +
		       indent2 + indent2.length() + " =\n" +
		       expr.toString(indent2);
	}

	void M()
	{
	    Val exprVal = expr.Eval();
	    
	//	if(exprVal != null)
	//	{
System.out.println(id);
		
         
          
	}
}
