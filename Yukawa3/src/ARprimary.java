
public class ARprimary extends AR {
	E e;
	Primary returnVal;
	
	
	
	void primary() {
		switch (LexArithArray.state) {
			
		case Id:
			Id id = new Id(LexArithArray.t);
			LexArithArray.getToken();
			returnVal = id;
			break;
			
		case Int:
			Int intElem = new Int (Integer.parseInt(LexArithArray.t));
			LexArithArray.getToken();
			returnVal = intElem;
			break;
			
		case Float:
			Floatp floatElem= new Floatp (Float.parseFloat(LexArithArray.t));
			LexArithArray.getToken();
			returnVal = floatElem;
			break;
			
		case LParen:
			LexArithArray.getToken();
			ARE ar = new ARE();
			arCounter++;
			RuntimeStack.push(ar);
			ar.E();
			e = ar.returnVal;
			RuntimeStack.pop();
			
			if( LexArithArray.state == LexArithArray.State.RParen) {
				LexArithArray.getToken();
				Parenthesized paren =  new Parenthesized(e);
				returnVal = paren;
			}
			else {
				ParserStack.errorMsg(1);
			}
			break;
			
		default:
			ParserStack.errorMsg(2);
			returnVal = null;
		}
	
		
	IO.displayln2(" -------------------------------");
	IO.displayln2("The total number of function call so far = " + arCounter);
	IO.displayln2("The maximun stock size so far is " + RuntimeStack.maxSize);
	IO.displayln2("The ARs of the runtime stack will be displayed from top to bottom");
	IO.displayln2("");
	
		
	}
	
	
}
