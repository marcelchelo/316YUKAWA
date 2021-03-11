class MultipleAssignment extends AssignmentList
{
	Assignment assignment;
	AssignmentList assignmentList;

	MultipleAssignment(Assignment a, AssignmentList al)
	{
		assignment = a;
		assignmentList = al;
	}
 
	void printParseTree(String indent)
	{		
		assignment.printParseTree(indent);
		assignmentList.printParseTree(indent);
	}

	void M() // function to interpret this list of multiple assignments
	{
		assignment.M();
		assignmentList.M();
	}
}