import java.util.*; 
public class Hashtable{
	private HashNode [] slots; 
	private int size; 
	private double lambda = .75;
	private final int initial_size = 315000;
	
	public Hashtable(){
		size = 0; 
		slots = new HashNode [initial_size];
		 
	}
		
	private int getSlot(String key){
		int slot = key.hashCode();
		if (slot<0) {
	 		slot = slot * -1; 
	 	}
		return slot%slots.length; 
	}


	 public String get (String key) {
	 int slot = getSlot(key);
	 HashNode node = slots[slot]; 
	 while (node != null && node.getKey()!=key){
	 	node = node.getNext(); 
	 	}
	 if (node == null){
	 	return null;  
	 	}
	 return node.getValue(); 
	 }
	 
	 public void put (String key, String value){ 
//	 	if (size/slots.length >= lambda){
//	 		reHash(); 
//	 	}
	 	int slot = getSlot(key); 
	 	
	 	HashNode newNode = new HashNode (key,value);
	 	if (slots[slot] != null){
			HashNode tempNode = slots[slot];
			while (tempNode.getNext()!= null) {
				tempNode = tempNode.getNext(); 
			}
			tempNode.setNext(newNode);
		}	
		else{
			slots[slot] = newNode;
		}
	 	++size; 
	 }
	
	 boolean containsKey (String key) {
		 int slot = getSlot(key);
		 HashNode node = slots[slot];
		 while (node != null) {
			 if (node.getKey().equals(key)) {
				 return true;
			 }
	
		 }
		return false; 
		 
	 }
	 
	 public String remove (String key) {
		 HashNode tempNode; 
		 int slot = getSlot(key);
		 
		 if (slots[slot]!=null && slots[slot].getNext()==null) {
			 tempNode = slots[slot];
			 slots[slot] = null;
			 return tempNode.getValue(); 
		 }
		else if(slots[slot] == null) {
			tempNode = slots[slot];
			if (tempNode.getKey() == key){
				slots[slot] = tempNode.getNext();
			
				return tempNode.getValue(); 
			}
			else {
				while (tempNode.getNext() != null) {
					if (tempNode.getNext().getKey()==key) {
						HashNode returnval = tempNode; 
						tempNode = tempNode.getNext(); 
						return returnval.getValue(); 
					}
				}
				
			}
		}	
		return null;
	
	 }
	 
	public void reHash(){
		HashNode [] temp = new HashNode [slots.length*2]; 
		for (HashNode node:slots){
			while (node !=null){
				int slotNum = node.getKey().hashCode()%temp.length; 
				if (temp[slotNum] != null){
					HashNode tempNode = temp[slotNum];
					while (tempNode.getNext()!= null) {
						tempNode = tempNode.getNext(); 
					}
					tempNode.setNext(node);
				}	
				else{
					temp[slotNum] = node; 
				}
			}
		}
	}
				
}
				 

			


		