package list;
import java.util.*;
import java.io.*;

public class list {
	public static void main(String[] args){
		int option;
		LinkedList l=new LinkedList();
		while(true){
			System.out.println("Enter your choice");
			System.out.println("1. Insert Begin"+"\n"+"2. Insert End"+"\n"+"3. Insert Position"+"\n"+"4. Delete First"+"\n"+"5. Delete End"+"\n"+"6. Delete Position");
			System.out.println("Enter 0 to exit");
			Scanner sc=new Scanner(System.in);
			option=sc.nextInt();
			switch(option){
			case 1: l.insertBegin();
			l.print();
			break;
			case 2: l.insertEnd();
			l.print();
			break;
			case 3: l.insertPos();
			l.print();
			break;
			case 4: l.deleteFirst();
			l.print();
			break;
			case 5: l.deleteEnd();
			l.print();
			break;
			case 6: l.deletePos();
			l.print();
			break;
			case 7: l.deleteDups(l.head);
			l.print();
			break;
			case 8: l.nToLast(l.head, 3);
			case 0: System.exit(0);
			}
		}
	}
}
class LinkedList{
	private class Node{
		int data;
		Node next;
	}
	Node head=null;
	
	//Delete Duplicates
	public void deleteDups(Node n){
		Hashtable h=new Hashtable();
		h.put(head.data, true);
		Node previous=null;
		while(n!=null){
			if(h.containsKey(n.data)){
				previous.next=n.next;
			}
			else{
				h.put(n.data, true);
				previous=n;
			}
			n=n.next;
		}
	}
	
	//nth to last element
	public void nToLast(Node head, int n){
		Node p=head;
		Node q=head;
		if(head==null && n<1){
			System.out.println("Invalid Entry");
		}
		else{
			for(int i=0; i<n-1; i++){
				if(q.next==null){
					System.out.println();
				}
				else{
					q=q.next;
				}
			}
			while(q.next!=null){
				p=p.next;
				q=q.next;
			}
			System.out.println(p.data);
		}
	}
	//Print
	
	public void print(){
		Node n=new Node();
		n=head;
		while(n!=null){
			System.out.print(n.data+"->");
			n=n.next;
		}
	}
	//Insert Method

	//Insert Begin
	
	public void insertBegin(){
		Node node=new Node();
		if(head==null){
			head=node;
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the element");
			head.data=sc.nextInt();
			head.next=null;
		}
		else{
			node.next=head;
			System.out.println("Enter the element");
			Scanner sc=new Scanner(System.in);
			node.data=sc.nextInt();
			head=node;
		}
	}
	
	//Insert End
	
	public void insertEnd(){
		Node node=new Node();
		Node temp=head;
		if(head==null){
			head=node;
			System.out.println("Enter the data");
			Scanner sc=new Scanner(System.in);
			head.data=sc.nextInt();
			head.next=null;
		}
		else{
			while(temp.next!=null){
				temp=temp.next;
			}
			temp.next=node;
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the element");
			node.data=sc.nextInt();
			node.next=null;
		}
	}
	
	//Insert middle
	
	public void insertPos(){
		Node node=new Node();;
		int i, pos;
		System.out.println("Enter the position");
		Scanner sc=new Scanner(System.in);
		pos=sc.nextInt();
		if(head==null){
			head=node;
			System.out.println("Enter the data");
			head.data=sc.nextInt();
			head.next=null;
		}
		else{
			Node p=head;
			Node q=new Node();
			i=1;
			if(pos==i){
				insertBegin();
			}
			else{
				while(p.next!=null && pos!=i){
					q=p;
					p=p.next;
					i=i+1;
				}
				if(pos>i){
					p.next=node;
					System.out.println("Enter a value");
					node.data=sc.nextInt();
					node.next=null;
				}
				else{
					System.out.println("Enter Value");
					node.data=sc.nextInt();
					node.next=p;
					q.next=node;
				}
			}
		}
	}
	
	//Deleting
	
	//Delete first
	public void deleteFirst(){
		Node temp=head;
		if(head==null){
			System.out.println("No elements in the list");
		}
		else if(head.next==null){
			head=null;
		}
		else{
			head=temp.next;
			temp=null;
		}
	}
	
	//Delete End
	public void deleteEnd(){
		Node node=new Node();
		Node temp=head;
		Node temp2=null;
		if(head==null){
			System.out.println("No elements in the list");
		}
		else{
			while(temp.next!=null){
				temp2=temp;
				temp=temp.next;
			}
			if(temp2==null){
				head=null;
			}
			else{
				temp2.next=null;
				temp=null;
			}
		}
	}
	
	//Delete at Position
	public void deletePos(){
		Node node=new Node();
		int i, pos;
		System.out.println("Enter the position");
		Scanner sc=new Scanner(System.in);
		pos=sc.nextInt();
		i=1;
		if(head.next==null){
			head=null;
		}
		else{
			Node p=head;
			Node q=null;
			if(pos==i){
				deleteFirst();
			}
			else{
				while(p.next!=null && pos!=i){
					q=p;
					p=p.next;
					i=i+1;
				}
				if(pos>i){
					System.out.println("Invalid Index");
				}
				else{
					q.next=p.next;
					p=null;
				}
			}
		}
	}
}