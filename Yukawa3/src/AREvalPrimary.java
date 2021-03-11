// the class of activation records of Eval() function for <primary>

class AREvalPrimary extends AR
{	
	// make it public maybe
	Val returval;
	//public Val returnval;
	
	
	void evalPrimary() {
		
		IO.displayln2("");
		IO.displayln2( "------------   M Functions-------------------" );
		IO.displayln2("The total number of function calls so far is " + arCounter );
		IO.displayln2("Max Stack Size " + RuntimeStack.maxSize );
		IO.displayln2("AR Runtime stack from top to bottom");
		IO.displayln2("");
		
	}

}