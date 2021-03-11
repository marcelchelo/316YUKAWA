
public class ARE  extends AR {
	// <E> --> <term> | <term> + <E> | <term> - <E>
	
	//local variables
	Term term;
	E ePlus;
	E eMinus;
	E returnVal;
	
	void E() {
		
		//re-implemented code schema 
		
		ARterm art = new ARterm ();
		//Add to funtion call counter 
		arCounter++;
		RuntimeStack.push(art);
		art.term();
		term = art.returnVal;
		RuntimeStack.pop();
		
		
			if(LexArithArray.state == LexArithArray.State.Plus) {
				//term  + E
				LexArithArray.getToken();   //Step 1 retrieve token
				
				ARE are =  new ARE ();
				arCounter++;
				
				RuntimeStack.push(are);
				are.E();  //call back E() go back to line 11 and do it over, recurssion. 
				ePlus = are.returnVal;
				RuntimeStack.pop();
				
				returnVal = new AddE(term , ePlus);
			}
			else if (LexArithArray.state == LexArithArray.State.Minus) {
				
				//term  - E
				LexArithArray.getToken();
				
				ARE are2 =  new ARE ();
				arCounter++;
				RuntimeStack.push(are2);
				are2.E();
				eMinus = are2.returnVal;
				RuntimeStack.pop();
				
				returnVal = new SubE(term, eMinus);
				
			}
			else {
				
				//If it is a single term 
				returnVal = new SingleTerm(term);
			}
	}
}
