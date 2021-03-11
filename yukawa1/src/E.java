import java.util.*;

abstract class E extends Obj
{
	private static int ecount = 0;  //static can be retrieved by other classes without instantiating 
	
	
	Term term;

	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <E>");
	}

	abstract Val Eval(HashMap<String,Val> state);

	abstract void eCounter(); //This method will be implemented by the child class(that inherits it)
	
	
	public static int getEcounter() {
		return ecount;
	}
	public static void setEcounter(int ecount) {
		E.ecount = ecount;
		
		
	}; 



}