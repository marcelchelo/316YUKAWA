class Block extends Statement
{
	SList slist;

	Block(SList s)
	{
		slist = s;
	}

	String toString(String indent)
	{
		String indent1 = indent + " ";

		return indent + indent.length() + " <statement>\n" +
		       indent1 + indent1.length() + "<block>\n" +
		       slist.toString(indent1+" ");
	}

	void M()
	{
       if(slist != null)
    	   slist.M();
	}
}
