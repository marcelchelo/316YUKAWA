import java.util.*;

class MultipleAssignment extends AssignmentList
{
	Assignment assignment;
	AssignmentList assignmentList;
	
	static int multipleAssignmentCounter =0;

	//constructor 
	MultipleAssignment(Assignment a, AssignmentList al)
	{
		assignment = a;
		assignmentList = al;
		
		counter();
		assignmentListCounter();
	}
	
	
	//Add 1 to multipleAssignmentCounter variable 
		public void counter() {
			multipleAssignmentCounter = multipleAssignmentCounter +1 ;

		}
	
	
 
	void printParseTree(String indent)
	{		
		assignment.printParseTree(indent);
		assignmentList.printParseTree(indent);
	}

	void M(HashMap<String,Val> state) // function to interpret this list of multiple assignments
	{
		assignment.M(state);
		assignmentList.M(state);
	}

	
	//Since Assignment is child of AssignmentList then we must add 1 to counter of AssignmentList in the parent class. 
	@Override
	void assignmentListCounter(){
		setAssgmntListCounter(super.getAssgmntListCounter() + 1);
		
	}



	public static int getMLTPLassignmentCounter() {
		// TODO Auto-generated method stub
		return multipleAssignmentCounter;
	}
}