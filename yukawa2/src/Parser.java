import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**

This class is a top-down, recursive-descent parser for the following syntactic categories:

<assignment list> --> <assignment> | <assignment> <assignment list>
<assignment> --> <id> = <E> ";"
<E> --> <term> | <term> + <E> | <term> - <E>
<term> --> <primary> | <primary> * <term> | <primary> / <term>
<primary> --> <id> | <int> | <float> | <floatE> | "(" <E> ")" 

The definitions of the tokens are given in the lexical analyzer class file "LexArithArray.java". 

The following variables/functions of "IO"/"LexArithArray" classes are used:

static void display(String s)
static void displayln(String s)
static void setIO(String inFile, String outFile)
static void closeIO()

static void setLex()
static String t // holds an extracted token
static State state // the current state of the finite automaton
static int getToken() // extracts the next token

An explicit parse tree is constructed in the form of nested class objects.
 
The main function will display the parse tree in linearly indented form.
Each syntactic category name labeling a node is displayed on a separate line, 
prefixed with the integer i representing the node's depth and indented by i blanks. 

**/


public abstract class Parser extends LexArithArray
{
	static boolean errorFound = false;
        static int [] objectTypes = new int [17];
        
        static HashMap<String, Integer> hashmapObjects  = new HashMap<>();
 	
	public static AssignmentList assignmentList()
	
	// <assignment list> --> <assignment> | <assignment> <assignment list>
	
	{
		Assignment assignment = assignment();
		if ( state == State.Id )
		{
			AssignmentList assignmentList = assignmentList();
			return new MultipleAssignment(assignment, assignmentList);
		}
		else
			return assignment;
	}

	public static Assignment assignment()
	
	// <assignment> --> <id> = <E> ";"
	
	{
		if ( state == State.Id )
		{
			String id = t;
			getToken();
			if ( state == State.Assign )
			{
				getToken();
				E e = E();
				if ( state == State.Semicolon )
				{
					getToken();
					return new Assignment(id, e);
				}
				else
					errorMsg(4);
			}
			else
				errorMsg(3);
		}
		else
			errorMsg(5);
		return null;
	}

	public static E E()

	// <E> --> <term> | <term> + <E> | <term> - <E>

	{
		Term term = term();
		if ( state == State.Plus )
		{			
			getToken();
			E e = E();
			return new AddE(term, e);
		}
		else if ( state == State.Minus )
		{ 
			getToken();
			E e = E();
			return new SubE(term, e);
		}
		else
			return new SingleTerm(term);
	}

	public static Term term()

	// <term> --> <primary> | <primary> * <term> | <primary> / <term>

	{
		Primary primary = primary();
		if ( state == State.Times )
		{			
			getToken();
			Term term = term();
			return new MulTerm(primary, term);
		}
		else if ( state == State.Div )
		{
			getToken();
			Term term = term();
			return new DivTerm(primary, term);
		}
		else
			return new SinglePrimary(primary);
	}

	public static Primary primary()

	// <primary> --> <id> | <int> | <float> | <floatE> | "(" <E> ")"

	{
		switch ( state )
		{
			case Id:
										
				Id id = new Id(t);
				getToken();
				return id;
				
			case Int:

				Int intElem = new Int(Integer.parseInt(t));
				getToken();
				return intElem;

			case Float: case FloatE:

				Floatp floatElem = new Floatp(Float.parseFloat(t));
				getToken();
				return floatElem;

			case LParen:
				
				getToken();
				E e = E();
				if ( state == State.RParen )
				{
					getToken();
					Parenthesized paren = new Parenthesized(e);
					return paren;
				}
				else
				{
					errorMsg(1);
					return null;
				}

			default:

				errorMsg(2);
				return null;
		}
	}
	
	public static void errorMsg(int i)
	{
		errorFound = true;
		
		display(t + " : Syntax Error, unexpected symbol where");

		switch( i )
		{
		case 1:	displayln(" arith op or ) expected"); return;
		case 2: displayln(" id, int, float, or ( expected"); return;
		case 3:	displayln(" = expected"); return;
		case 4:	displayln(" ; expected"); return;
		case 5:	displayln(" id expected"); return;		
		}
	}

        static MultipleAssignment MA;
	public static void main(String argv[])
	{
            
		// argv[0]: input file containing an assignment list
		// argv[1]: output file displaying the parse tree

		setIO( argv[0], argv[1], argv[2] );
		setLex();
                
		getToken();

		AssignmentList assignmentList = assignmentList(); // build a parse tree
		if ( ! t.isEmpty() )
			errorMsg(5);
		else if ( ! errorFound ){
			assignmentList.printParseTree(""); // print the parse tree in linearly indented form in argv[1] file
                        
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
            
            //.....
            
		// In the following, x.traversal() performs depth-first traversal starting from object x.

              displayln2("1st Test Run");
              reverseSortedMap.entrySet().forEach(entry -> {
            	  displayln2(entry.getValue() + entry.getKey());
            	  IO.displayln2("");
              });
              
              assignmentList.traversal();
              
              
              
              displayln2("2nd Test Run");
              reverseSortedMap.entrySet().forEach(entry -> {
            	  displayln2(entry.getValue() + entry.getKey());
            	  IO.displayln2("");
              });
    		((MultipleAssignment)assignmentList).assignment.traversal();
    		assignmentList.traversal();
              
		//AssignmentList assignmentList = assignmentList(); // build a parse tree and print it in argv[1] file if syntax errors not found
		//MA = new MultipleAssignment(((MultipleAssignment)assignmentList).assignment, assignmentList);
            
    		 displayln2("3rd Test Run");
             reverseSortedMap.entrySet().forEach(entry -> {
           	  displayln2(entry.getValue() + entry.getKey());
           	  IO.displayln2("");
             });
             ((MultipleAssignment)assignmentList).assignmentList.traversal();
     		assignmentList.traversal();   
		
		

		//clear and reinitialize the data structure maintaining the constructed objects;
                
                
		 //AssignmentList assignmentList = assignmentList(); // build a 2nd parse tree

//		assignmentList.traversal();

		

		//clear and reinitialize the data structure maintaining the constructed objects
               
                System.out.println("Open File To see test Runs");
		//AssignmentList assignmentList = assignmentList(); // build a 3rd parse tree
//		

		
      }
        
             
            
        
		closeIO();
                
	}
       
}