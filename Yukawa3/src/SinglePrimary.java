class SinglePrimary extends Term
{
	// Primary primary; inherited from Term
	// added new local variables 
	
	
	SinglePrimary(Primary p)
	{
		primary = p;
	}

	void printParseTree(String indent)
	{
		super.printParseTree(indent);
		primary.printParseTree(indent+" ");
	}

	//local Variable
	Val evalPrimary;
	Val Eval()
	{
		AREvalPrimary arMvalPrimary = new AREvalPrimary();
		AR.arCounter ++;
		RuntimeStack.push(arMvalPrimary);
		Val v_ = primary.Eval();
		arMvalPrimary.evalPrimary();
		IO.displayln2(RuntimeStack.peek().toString());
		evalPrimary = arMvalPrimary.returval;
		
		RuntimeStack.pop();
		//print from the top of the stack down. 
		
		for(int i = RuntimeStack.list.size()-1; i>=0; i--) {
			IO.displayln2(RuntimeStack.list.get(i).toString());
		}
		arMvalPrimary.returval = v_;
			return v_;
		
		//return primary.Eval();
	}
}