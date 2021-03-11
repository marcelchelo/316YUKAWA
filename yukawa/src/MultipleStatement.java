class MultipleStatement extends SList
{
	Statement statement;
	SList slist;

	MultipleStatement(Statement st, SList sl)
	{
		statement = st;
		slist = sl;
	}
 
	String toString(String indent)
	{
		String indent1 = indent + " ";

		return indent + indent.length() + " <slist>\n" +
		       statement.toString(indent1) + "\n" +
		       slist.toString(indent1);
	}

	void M()
	{
		if(statement != null)
		     statement.M();
	}
}
