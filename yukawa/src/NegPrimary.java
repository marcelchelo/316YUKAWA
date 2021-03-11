class NegPrimary extends Primary
{
	Primary primary;

	NegPrimary(Primary p)
	{
		primary = p;
	}

	String toString(String indent)
	{
		String indent1 = indent + " ";

		return indent + indent.length() + " <primary>\n" +
		       indent1 + indent1.length() + " -\n" + 
		       primary.toString(indent1);
	}

	Val Eval()
	{
		Val primaryVal = primary.Eval();
		if ( primaryVal == null )
			return null;
		String valType = primaryVal.getClass().getName();

		if ( valType.startsWith("I") )
		{
			((IntVal)primaryVal).val = -((IntVal)primaryVal).val;
			return primaryVal;
		}
		else if ( valType.startsWith("F") )
		{
			((FloatVal)primaryVal).val = -((FloatVal)primaryVal).val;
			return primaryVal;
		}
		else
		{
			System.out.println( "Error: unary minus operator cannot be applied to boolean" );
			return null;
		}
	}
}