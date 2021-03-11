import java.util.*;

abstract class Term extends Obj
{
	private static int termCount = 0;
	
	Primary primary;

	
	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <term>");
	}

	abstract Val Eval(HashMap<String,Val> state);
	
	
	
	
	
	abstract void termCounter(); //This method will be implemented by child classes
	
	public static int getTermCounter() {
		return termCount;
	}
	
	public static void setTermCounter(int termCount) {
		Term.termCount = termCount;
	}
}