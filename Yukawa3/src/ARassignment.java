//import LexArithArray.State;

// the class of activation records of assignment() function
//
//public static Assignment assignment()
//	
//	
//	
//	{
//		if ( state == State.Id )
//		{
//			String id = t;
//			getToken();
//			if ( state == State.Assign )
//			{
//				getToken();
//				E e = E();
//				if ( state == State.Semicolon )
//				{
//					getToken();
//					return new Assignment(id, e);
//				}
//				else
//					errorMsg(4);
//			}
//			else
//				errorMsg(3);
//		}
//		else
//			errorMsg(5);
//		return null;
//	}


// <assignment> --> <id> = <E> ";"

class ARassignment extends AR
{
	//local variables
	E e;
	Assignment returnVal;
	
	void assignment () {
		if(LexArithArray.state == LexArithArray.State.Id) {
			String id = LexArithArray.t;
			LexArithArray.getToken();   // if state is an ID just retrieve id with gettoken method
			
			if(LexArithArray.state == LexArithArray.State.Assign) {
				//Get token method from professor code
				LexArithArray.getToken();
				ARE are_ = new ARE();
				arCounter++;
				RuntimeStack.push(are_);
				are_.E();
				e = are_.returnVal;
				RuntimeStack.pop();
				
				if( LexArithArray.state == LexArithArray.State.Semicolon) {
					LexArithArray.getToken();
					returnVal = new Assignment (id,e);
				}
				else ParserStack.errorMsg(4);
			
			} 
			else ParserStack.errorMsg(3);
		}
		else ParserStack.errorMsg(5);
		
	}
}