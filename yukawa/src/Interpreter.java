import java.io.*;
import java.util.*;

public abstract class Interpreter extends Parser
{
	public static HashMap<String,Val> state = new HashMap<String,Val>(); // program state

	public static void main(String argv[])
	{
		setLex( argv[0], argv[1] );

		getToken();
		Statement statement = statement(); // build a parse tree		                    
		
		if ( ! t.isEmpty() )
			displayln(t + "  -- unexpected symbol");
		else if ( ! errorFound )
		{
		//	displayln(statement.toString("")); // display the parse tree
			statement.M();                     // interpret the statement
			System.out.println( state );       // print out the program state
			displayln(""+state);
		}
		closeIO();
 	}
}