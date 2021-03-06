import java.util.*;

public abstract class Interpreter extends Parser
{
	public static HashMap<String, Val> varState = new HashMap<String, Val>(); 
	              // program state, i.e., virtual memory for variables
		
	
	public static void main(String argv[])
	{
		// argv[0]: input file containing an assignment list
		// argv[1]: output file displaying the parse tree
		// argv[2]: output file displaying the numbers of constructed objects and
		//          the visited objects in order of the depth-first traversal
		
		setIO( argv[0], argv[1], argv[2]);
		setLex();

		getToken();

		AssignmentList assignmentList = assignmentList(); // build a parse tree
		if ( ! t.isEmpty() )
			displayln(t + " : Syntax Error, unexpected symbol where id expected");
		else if ( ! errorFound )
		{
			assignmentList.printParseTree("");       // print the parse tree in linearly indented form in argv[1] file
			assignmentList.M(varState);              // interpret the assignment list
			System.out.println(varState.toString()); // print the program state on the terminal
			
			
			for (int i = 0; i < Obj.Objecttotal.size(); i++) {
				 
                hashmapObjects.put(Obj.Objecttotal.get(i),0);
                
    }
			for (Map.Entry<String, Integer> e : hashmapObjects.entrySet()){ 
                hashmapObjects.put(e.getKey(),Collections.frequency(Obj.Objecttotal,e.getKey()));
         }
			hashmapObjects.put(" objects class Obj", Obj.Objecttotal.size()/2);
			LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
            hashmapObjects.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

            reverseSortedMap.entrySet().forEach(entry -> {
                displayln2(entry.getValue() + entry.getKey());
		});
		}

		assignmentList.traversal(); // perform depth-first traversal from assignmentList

		closeIO();
	}
}
