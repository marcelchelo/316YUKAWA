abstract class Obj
{
	static int objcounter =0;
	
	Obj()

	// This constructor will be invoked every time the constructor of any descendant class is invoked.
	
	//WE can keep a counter for every time an object is created. 

	{
		objcounter = objcounter +1;
	}

	

	
	

	
}