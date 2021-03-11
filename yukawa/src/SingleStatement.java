class SingleStatement extends SList
{
	Statement statement;

	SingleStatement(Statement s)
	{
		statement = s;
	}

	String toString(String indent)
	{
		String indent1 = indent + " ";

		return indent + indent.length() + " <slist>\n" +
		       statement.toString(indent1);
	}

	void M()
	{
        if(statement != null)
	     statement.M();
	}
}
