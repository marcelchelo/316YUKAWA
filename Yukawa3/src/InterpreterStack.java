import java.util.*;

public abstract class InterpreterStack extends ParserStack
{
	public static HashMap<String, Val> varState = new HashMap<String, Val>(); 
	              // program state, i.e., virtual memory for variables
		
	
	public static void main(String argv[])
	{
		// argv[0]: input file containing an assignment list
		// argv[1]: output file displaying the parse tree
		// argv[2]: output file displaying runtime stack data
		// The interpretation result will be displayed on the terminal.
		
		setIO (argv[0] , argv[1], argv[2]);
		setLex();
		
		getToken();
		AssignmentList assignmentList; // local variable
		ARassignmentList ar = new ARassignmentList();
		AR.arCounter++;
		RuntimeStack.push(ar);
		ar.assignmentList();
		assignmentList = ar.returnVal;
		
		RuntimeStack.pop();
		
		
		if( ! t.isEmpty() )
			errorMsg(5);
		else if ( ! errorFound ) {
			assignmentList.printParseTree("");
			ARMassignmentList arM = new ARMassignmentList();
			AR.arCounter ++ ;
			RuntimeStack.push (arM);
			RuntimeStack.pop();
			System.out.println(Interpreter.varState.toString());
		}
		closeIO();
}
}