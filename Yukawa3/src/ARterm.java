// the class of activation records of term() function

class ARterm extends AR
{
	Primary primary;
	Term termMul;
	Term termDiv;

	Term returnVal;
	
	
	void term() {
		ARprimary arp = new ARprimary();
		arCounter++;
		RuntimeStack.push(arp);
		arp.primary();
		IO.displayln2(RuntimeStack.peek().toString());
		primary = arp.returnVal;
		RuntimeStack.pop();
		
		for(int i= RuntimeStack.list.size()-1; i>=0 ; i--)
			IO.displayln2(RuntimeStack.list.get(i).toString());
		
		
		if ( LexArithArray.state == LexArithArray.State.Times) {
			LexArithArray.getToken();
			
			ARterm arp2 = new ARterm();
			arCounter++;
			RuntimeStack.push(arp2);
			arp2.term();
			termMul = arp2.returnVal;
			RuntimeStack.pop();
			
			returnVal = new MulTerm(primary , termMul);
			
			
		}
		else if (LexArithArray.state == LexArithArray.State.Div) {
			LexArithArray.getToken();
			
			ARterm arp3 = new ARterm();
			arCounter++;
			RuntimeStack.push(arp3);
			arp3.term();
			termDiv = arp3.returnVal;
			RuntimeStack.pop();
			
			returnVal = new DivTerm(primary , termDiv);
			
		}
		
		else returnVal = new SinglePrimary(primary);
		
			
		}
	}

