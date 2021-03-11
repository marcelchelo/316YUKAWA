import java.util.*;

abstract class AssignmentList extends Obj
{
	private static int assgmntListCounter =0;  //static can be retrieved by other classes without instantiating 
	
	abstract void printParseTree(String indent);
	abstract void M(HashMap<String,Val> state); // function to interpret this assignment list
	
	
	
	abstract void assignmentListCounter(); //This method will be implemented by the child class(that inherits it)
	
	public static int getAssgmntListCounter() {
		return assgmntListCounter;
	}
	public static void setAssgmntListCounter(int assgmntListCounter) {
		AssignmentList.assgmntListCounter = assgmntListCounter;
		
		
	}; 
}