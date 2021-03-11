class SingleTerm extends E
{
	// Term term; inherited from E

	SingleTerm(Term t)
	{
		term = t;
	}

	void printParseTree(String indent)
	{
		super.printParseTree(indent);
		term.printParseTree(indent+" ");
	}
	
	Val evalTerm;
	
	Val Eval()
	{
		AREvalTerm arEvalMfunc = new AREvalTerm(); // new AREvalTem object created
		AR.arCounter ++;             //increase the counter
		RuntimeStack.push(arEvalMfunc);
		Val v_ = term.Eval();
		evalTerm = arEvalMfunc.returnval;
		
		
		arEvalMfunc.returnval = v_;
		
		return v_;
		//return term.Eval();
	}
}