class AndBoolTerm extends BoolTerm
{
	BoolPrimary boolPrimary;
	BoolTerm boolTerm;

	AndBoolTerm(BoolPrimary bp, BoolTerm bt)
	{
		boolPrimary = bp;
		boolTerm = bt;
	}

	String toString(String indent)
	{
		String indent1 = indent + " ";

		return indent + indent.length() + " <boolTerm>\n" +
		       boolPrimary.toString(indent1) + "\n" +
		       indent1 + indent1.length() + " &&\n" +
		       boolTerm.toString(indent1);
	}

	Val Eval(){
		Val boolPrimaryVal = boolPrimary.Eval();
		Val booltermVal = boolTerm.Eval();
		if(boolPrimaryVal == null || booltermVal == null)
			return null;
		String valType_bp = boolPrimaryVal.getClass().getName();
		String valType_bt = booltermVal.getClass().getName();

		if ( valType_bp.startsWith("I") && valType_bt.startsWith("I") )
		{
			((IntVal)boolPrimaryVal).val = ((IntVal)boolPrimaryVal).val + ((IntVal)booltermVal).val;
			return boolPrimaryVal;
		}
		else if ( valType_bp.startsWith("I") && valType_bt.startsWith("F") )
		{
			((FloatVal)booltermVal).val = ((IntVal)boolPrimaryVal).val + ((FloatVal)booltermVal).val;
			return booltermVal;
		}
		else if ( valType_bp.startsWith("F") && valType_bt.startsWith("I") )
		{
			((FloatVal)boolPrimaryVal).val = ((FloatVal)boolPrimaryVal).val + ((IntVal)booltermVal).val;
			return boolPrimaryVal;
		}
		else if ( valType_bp.startsWith("F") && valType_bt.startsWith("F") )
		{
			((FloatVal)boolPrimaryVal).val = ((FloatVal)boolPrimaryVal).val + ((FloatVal)booltermVal).val;
			return boolPrimaryVal;
		}
		else
		{
			System.out.println( "Error: && operator cannot be applied to boolean" );
			return null;	
		}
		}
}
