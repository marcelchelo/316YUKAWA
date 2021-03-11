class Decrement extends Statement
{
	String id;

	Decrement(String s)
	{
		id = s;
	}

	String toString(String indent)
	{
		String indent1 = indent + " ";
		String indent2 = indent + "  ";

		return indent + indent.length() + " <statement>\n" +
		       indent1 + indent1.length() + " <decrement>\n" +
		       indent2 + indent2.length() + " " + id + "\n" +
		       indent2 + indent2.length() + " --";
	}

	void M()
	{
			
	        
	         
			
	}

}
