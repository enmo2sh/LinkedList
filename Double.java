package eg.edu.alexu.csd.datastructure.linkedList;

public class Double implements ILinkedList{
	Node2 head ;
 
	 public void add(int index, Object element) {
		 int count=size();
		if ((index<0)||(index>count))
			return;
		else {
		 Node2 temp=new Node2();
		temp.value=element;
		Node2 current=head;
		for (int i=0;i<index-1;i++) 
			current=current.next;
		Node2 temp2=current.next;
		current.next=temp;
		temp.prev=current;
		temp.next=temp2;
		temp2.prev=temp;
				}
	}
 
	public void add(Object element) {
		Node2 i =head;
		while(i.next!=null) 
			i=i.next;
		Node2 in = new Node2();
		in.value=element;
		i.next=in;
		in.next=null;
		in.prev=i;
	}
 
	public Object get(int index) {
		int count=size();
		if ((index<0)||(index>count))
		return null;
		else {
		Node2 current=head;
		for (int i=0;i<index;i++)
			current=current.next;
		Object found=current.value;
		return found;
		}
	}
 
	public void set (int index,Object element) {
		Node2 i =head;
		int count=0;
		while(count!=index) {
			count++;
			i=i.next;
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
		return;
		else {
		Node2 current=head;
		for (int i=0;i<index-1;i++)
			current=current.next;
		current.next=current.next.next;
		}
	}
 
	public int size() {
		Node2 i=head;
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
		  Double x=new Double();
			Node2 current=head;
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
		Node2 i = head;
		while(i!=null) {
			if(i.value==o)
				return true;
			else 
				i=i.next;
		}
		return false;
	}
 
 
}
