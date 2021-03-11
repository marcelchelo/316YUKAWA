import java.util.ArrayList;
import java.util.List;

//This class contains the activation records as they are simmulated in the javacode. 


public class RuntimeStack {
	
	//Accept elements of type AR
	static List<AR> list = new ArrayList<>();
	static int maxSize =0;
	
	
	
	static void push (AR activationRecords) {
		list.add(activationRecords);
		if(maxSize < list.size())
				maxSize = list.size();
	}
	
	
	static public AR pop() {
		if (list.isEmpty()) {
			return null;
		}
		AR top = list.get(list.size() -1);
		list.remove(list.size() -1);
		return top;
	}
	
	static AR peek() {
		if (list.isEmpty()) {
			return null;
			
		}
		return list.get(list.size() -1);
	}
	
	
}
