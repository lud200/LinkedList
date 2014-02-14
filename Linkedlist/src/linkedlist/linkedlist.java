package linkedlist;

public class linkedlist {
	public static void main(String[] args){
		append(0, "pumpstation");
		append(3050, "hello");
		append(3060, "bad");
		//insert(30,"ho", 5);
		traverse();
	}
	public static void append(int pos, String descr){
		node newnode=new node(pos, descr, null);
		if(headnode==null){
			headnode=newnode;
		}
		else{
			tailnode.nextnode=newnode;
		}
		tailnode=newnode;
	}
	/*public static void insert(int pos, String descr, int index){
		node currentnode=headnode;
		node newnode=new node(pos, descr, null);
		int nodenum=-1;
		do{
			nodenum++;
			currentnode=currentnode.nextnode;
			if(newnode.position<currentnode.position){
				newnode.nextnode=currentnode.nextnode;
				currentnode.nextnode=newnode;
			}
			else{
				tailnode.nextnode=newnode;
			}
		}while(currentnode!=null);
		tailnode=newnode;
	}*/
	public static void traverse(){
		node currentnode=headnode;
		int nodeNum=-1;
		do{
			nodeNum++;
			System.out.println("Node Number"+nodeNum);
			System.out.println("Position"+currentnode.position);
			System.out.println("Description"+currentnode.description);
			System.out.println("");
			currentnode=currentnode.nextnode;
		}while(currentnode!=null);
	}
	public static node headnode=null;
	public static node tailnode=null;
}
class node{
	int position;
	String description;
	node nextnode;
	public node(int pos, String descr, node ptr){
		position=pos;
		description=descr;
		nextnode=ptr;
	}
}