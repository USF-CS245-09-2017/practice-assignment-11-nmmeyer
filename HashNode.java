
public class HashNode{
	private  String key;
	private  String value;
	private HashNode next; 

	public HashNode(String key, String value){
		this.key = key;
		this.value = value;
		
	}
	
	public String getValue(){
		return this.value; 
	}
	
	public String getKey(){
		return this.key; 
	}
	
	public HashNode getNext(){
		return this.next; 
	}
	public void setKey(String key){
		 this.key = key; 
	}
	
	public void setValue(String value){
		this.value = value; 
	}
	
	public void setNext(HashNode next){
		this.next = next; 
	}
}