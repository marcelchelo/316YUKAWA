import java.util.*;

class Assignment extends AssignmentList
{
	String id; // variable on the left side of the assignment
	E e;       // expression on the right side of the assignment
	
	static int assignmentCounter = 0;  //This variable will keep count of the number of times  Assignment is constructed/called. 
	
	//constructor
	Assignment(String s, E exp)
	{
		id = s;
		e = exp;
		
		counter();    
		assignmentListCounter();
		
	}
	
	//Add 1 to assignment counter variable 
	public void counter() {
	 assignmentCounter = assignmentCounter +1 ;

	}
	
	
	//Since Assignment is child of AssignmentList then we must add 1 to counter of AssignmentList in the parent class. 
	void assignmentListCounter(){
		setAssgmntListCounter(super.getAssgmntListCounter() +1);
		
	}
	
	
	
	static int getAssignmentCounter () {
		return assignmentCounter;
		
	}
	
	
	
	void printParseTree(String indent)
	{
		String indent1 = indent + " ";
				
		IO.displayln(indent + indent.length() + " <assignment>");
		IO.displayln(indent1 + indent1.length() + " " + id);
		IO.displayln(indent1 + indent1.length() + " =");
		e.printParseTree(indent1);
	}
	
	void M(HashMap<String,Val> state) // function to interpret this assignment
	{
		Val eVal = e.Eval(state); // evaluate expression e
		if ( eVal != null )
			state.put(id, eVal); // assign the value eVal to id
		
		/* For practical reason of efficiency, the error state is not implemented.
		   Rather, the error state is implicitly assumed whenever Eval returns null representing
		   the runtime error value. */
	}

	
}