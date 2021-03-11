class Floatp extends Primary
{
	float val;

	Floatp(float f)
	{
		val = f;
	}

	String toString(String indent)
	{
		return indent + indent.length() + " <primary> " + val;
	}

	Val Eval()
	{
		return new FloatVal(val);
	}
}