class Parenthesized extends Primary
{
	E e;

	Parenthesized(E exp)
	{
		e = exp;
	}

	void printParseTree(String indent)
	{
		super.printParseTree(indent); 
		e.printParseTree(indent+" ");
	}

	
	
	Val Eval()
	{
		//parenthesized also adds one to activation record;
		AR.arCounter++;
		return e.Eval();
	}
}