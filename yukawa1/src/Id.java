import java.util.*;

class Id extends Primary
{
	static int idCount = 0 ;
	
	String id;

	//constructor
	Id(String ident)
	{
		id = ident;
		
		//keep coujnt of classes
		counter();
		primaryCounter();
	}
	
	//Add 1 to assignment counter variable 
	public void counter() {
			idCount = idCount +1;
			
		}
	
	static int getIDCounter () {
		return idCount;
	}
	
	public static int getINTCounter() {
		// TODO Auto-generated method stub
		return idCount;
	}

	
	@Override
	//Since ID is child of Primary then we must add 1 to counter of primary in the parent class. 
	void primaryCounter() {
		// TODO Auto-generated method stub
		setPrimaryCounter(super.getPrimaryCounter() +1);
	}
	
	

	void printParseTree(String indent)
	{
		String indent1 = indent+" ";

		super.printParseTree(indent);
		IO.displayln(indent1 + indent1.length() + " " + id);
	}

	Val Eval(HashMap<String,Val> state)
	{
		Val idVal = state.get(id);
		if ( idVal != null )
			return idVal.cloneVal();
		else
		{
			System.out.println( "variable "+id+" does not have a value" );
			return null;
		}
	}


	
}