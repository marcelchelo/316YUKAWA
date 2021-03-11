import java.util.*;

abstract class Primary extends Obj
{
	private static int primaryCount = 0;
	
	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <primary>");
	}

	abstract Val Eval(HashMap<String,Val> state);
	
	
	//////////////////////////////////////////////////
	
	
	abstract void primaryCounter(); //This method will be implemented by child classes
	
	public static int getPrimaryCounter() {
		return primaryCount;
	}
	
	public static void setPrimaryCounter(int primaryCount) {
		Primary.primaryCount = primaryCount;
	}
	
}