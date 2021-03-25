package eg.edu.alexu.csd.datastructure.linkedList;

public class Single implements ILinkedList {
	Node head ;
 
	public void add(Object element) {
		Node i =head;
		while(i.next!=null) 
			i=i.next;
		Node in = new Node();
		in.value=element;
		i.next=in;
		in.next=null;
	}
 
	public void add(int index, Object element) {
		int count=size();
		if ((index<0)||(index>count))
			return;
		else {
			Node temp=new Node();
			temp.value=element;
			Node current=head;
			for (int i=0;i<index-1;i++) 
				current=current.next;
			Node temp2=current.next;
			current.next=temp;
			 temp.next=temp2;
		}
	}
 
	public Object get(int index) {
		int count=size();
		if ((index<0)||(index>count))
			return null;
		else {
		Node current=head;
		for (int i=0;i<index;i++)
			current=current.next;
		Object found=current.value;
		return found;
		}
	}
 
	public void set (int index,Object element) {
		Node i =head;
		int count=0;
		while(count!=index) {
			i=i.next;
			count++;
		}
		i.value=element;
	}
 
	public void clear() {
		head=null;
	}
 
	public boolean isEmpty() {
		if(head==null)
			return true;
		else
			return false;
	}
 
	public void remove(int index) {
		int count=size();
		if ((index<0)||(index>count))
			return ;
		else {
		Node current=head;
		for (int i=0;i<index-1;i++)
			current=current.next;
		current.next=current.next.next;
		}
	}
 
	public int size() {
		Node i=head;
		int count=0;
		if(i==null)
			return 0;
		while(i!=null) {
			count++;
			i=i.next;
		}
		return count;
	}
 
	public ILinkedList sublist(int fromIndex, int toIndex) {
        Single x=new Single();
		Node current=head;
		for (int i=0;i<fromIndex;i++)
			current=current.next;
		x.head=current;
		for (int i=fromIndex-1;i<toIndex;i++) {
			x.add(current.value);
			current=current.next;	
		}
		return x;
	}
 
	public boolean contains (Object o) {
		Node i = head;
		while(i!=null) {
			if(i.value==o)
				return true;
			else 
				i=i.next;
		}
		return false;
	}
 
 
}
