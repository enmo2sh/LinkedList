package eg.edu.alexu.csd.datastructure.linkedList;

public class Operations {
	public static OpNode headA=null;
	public static OpNode headB=null;
	public static OpNode headC=null;
	public static OpNode headR=null;
 
	void setPolynomial(char poly, int[][] terms) {
		OpNode head= new OpNode();
		OpNode x= new OpNode();
		int s=0;
		while(terms[s][0]==0)
			s++;
		head.coof=terms[s][0];
		head.exp=terms[s][1];
		x=head;
 
		for(int i=s+1;i<terms.length;i++) {
			OpNode temp=new OpNode();
			if(terms[i][0]!=0) {
				temp.coof=terms[i][0];
				temp.exp=terms[i][1];
				x.next=temp;
				x=x.next;
			}
		}
		if(poly=='A' || poly=='a')
			headA =head;
		else if(poly=='B' || poly=='b')
			headB =head;
		else if(poly=='C' || poly=='c')
			headC =head;
	}
 
	String print(char poly) {
		OpNode head= new OpNode();
		if(poly=='A' || poly=='a')
			head =headA;
		else if(poly=='B' || poly=='b')
			head =headB;
		else if(poly=='C' || poly=='c')
			head =headC;
		else if(poly=='R' || poly=='r')
			head =headR;
		if(head==null)
			return "{0,0}";
		OpNode i=head.next;
		String expression = Integer.toString(head.coof)+'x'+'^'+Integer.toString(head.exp);
		while(i!=null) {
			if(i.coof!=0)
				expression+=" + " +Integer.toString(i.coof)+'x'+'^'+Integer.toString(i.exp);
			i=i.next;
		}
		return expression;
	}
 
	void clearPolynomial(char poly) {
		OpNode head=new OpNode();
		if(poly=='A' || poly=='a')
			headA =null;
		else if(poly=='B' || poly=='b')
			headB =null;
		else if(poly=='C' || poly=='c')
			headC =null;
	}
 
	float evaluatePolynomial(char poly, float value) {
		float val=0;
		OpNode head= new OpNode();
		if(poly=='A' || poly=='a')
			head =headA;
		else if(poly=='B' || poly=='b')
			head =headB;
		else if(poly=='C' || poly=='c')
			head =headC;
		while(head!=null) {
			val+=head.coof*Math.pow(value, head.exp);
			head=head.next;
		}
		return val;
	}
 
	int[][] add(char poly1, char poly2){
		OpNode head1= new OpNode();
		if(poly1=='A' || poly1=='a')
			head1 =headA;
		else if(poly1=='B' || poly1=='b')
			head1 =headB;
		else if(poly1=='C' || poly1=='c')
			head1 =headC;
		OpNode head2= new OpNode();
		if(poly2=='A' || poly2=='a')
			head2 =headA;
		else if(poly2=='B' || poly2=='b')
			head2 =headB;
		else if(poly2=='C' || poly2=='c')
			head2 =headC;
		OpNode head3= new OpNode();
		headR=head3;
		while(head1!=null && head2!=null) {
			if(head1.exp>head2.exp) {
				head3.coof=head1.coof;
				head3.exp=head1.exp;
				head3.next=new OpNode();
				head3=head3.next;
				head1=head1.next;
			}
			else if(head1.exp<head2.exp) {
				head3.coof=head2.coof;
				head3.exp=head2.exp;
				head3.next=new OpNode();
				head3=head3.next;
				head2=head2.next;
			}
			else {
				head3.coof=head1.coof+head2.coof;
				head3.exp=head1.exp;
				head3.next=new OpNode();
				head3=head3.next;
				head1=head1.next;
				head2=head2.next;
			}
		}
		while(head1!=null) {
			head3.coof=head1.coof;
			head3.exp=head1.exp;
			head3.next=new OpNode();
			head3=head3.next;
			head1=head1.next;
		}
		while(head2!=null) {
			head3.coof=head2.coof;
			head3.exp=head2.exp;
			head3.next=new OpNode();
			head3=head3.next;
			head2=head2.next;
		}
		head3=null;
		OpNode head = headR;
		int count=0;
		while(head.next!=null) {
			count++;
			head=head.next;
		}
		int sum [][]= new int[count][2];
		head=headR;
		count=0;
		while(head.next!=null) {
			sum[count][0]=head.coof;
			sum[count][1]=head.exp;
			count++;
			head=head.next;
		}
		return sum;
	}
 
	int[][] subtract(char poly1, char poly2){
		OpNode head1= new OpNode();
		if(poly1=='A' || poly1=='a')
			head1 =headA;
		else if(poly1=='B' || poly1=='b')
			head1 =headB;
		else if(poly1=='C' || poly1=='c')
			head1 =headC;
		OpNode head2= new OpNode();
		if(poly2=='A' || poly2=='a')
			head2 =headA;
		else if(poly2=='B' || poly2=='b')
			head2 =headB;
		else if(poly2=='C' || poly2=='c')
			head2 =headC;
		OpNode head3= new OpNode();
		headR=head3;
		while(head1!=null && head2!=null) {
			if(head1.exp>head2.exp) {
				head3.coof=head1.coof;
				head3.exp=head1.exp;
				head3.next=new OpNode();
				head3=head3.next;
				head1=head1.next;
			}
			else if(head1.exp<head2.exp) {
				head3.coof=-1*head2.coof;
				head3.exp=head2.exp;
				head3.next=new OpNode();
				head3=head3.next;
				head2=head2.next;
			}
			else {
				head3.coof=head1.coof-head2.coof;
				head3.exp=head1.exp;
				head3.next=new OpNode();
				head3=head3.next;
				head1=head1.next;
				head2=head2.next;
			}
		}
		while(head1!=null) {
			head3.coof=head1.coof;
			head3.exp=head1.exp;
			head3.next=new OpNode();
			head3=head3.next;
			head1=head1.next;
		}
		while(head2!=null) {
			head3.coof=-1*head2.coof;
			head3.exp=head2.exp;
			head3.next=new OpNode();
			head3=head3.next;
			head2=head2.next;
		}
		head3=null;
		OpNode head = headR;
		int count=0;
		while(head.next!=null) {
			count++;
			head=head.next;
		}
		int sub [][]= new int[count][2];
		head=headR;
		count=0;
		while(head.next!=null) {
			sub[count][0]=head.coof;
			sub[count][1]=head.exp;
			count++;
			head=head.next;
		}
		return sub;
	}
 
	int[][] multiply(char poly1, char poly2){
		OpNode head1= new OpNode();
		if(poly1=='A' || poly1=='a')
			head1 =headA;
		else if(poly1=='B' || poly1=='b')
			head1 =headB;
		else if(poly1=='C' || poly1=='c')
			head1 =headC;
		OpNode head2= new OpNode();
		if(poly2=='A' || poly2=='a')
			head2 =headA;
		else if(poly2=='B' || poly2=='b')
			head2 =headB;
		else if(poly2=='C' || poly2=='c')
			head2 =headC;
		OpNode head3= new OpNode();
		headR=head3;
		int count1=0;
		int count2=0;
		OpNode w=head1;
		while(w!=null) {
			count1++;
			w=w.next;
		}
		w=head2;
		while(w!=null) {
			count2++;
			w=w.next;
		}
		int [][] multi = new int [count1*count2][2];
		w=head1;
		int c=0;
		while(w!=null) {
			OpNode v=head2;
			while(v!=null) {
				multi[c][0]=w.coof*v.coof;
				multi[c][1]=w.exp+v.exp;
				v=v.next;
				c++;
			}
 
			w=w.next;
		}
		for(int i=0;i<multi.length-1;i++) {
			int max =i;
			for(int j=i+1;j<multi.length;j++) {
				if(multi[j][1]>multi[max][1])
					max=j;
			}
			int temp=multi[i][1];
			multi[i][1]=multi[max][1];
			multi[max][1]=temp;
			temp=multi[i][0];
			multi[i][0]=multi[max][0];
			multi[max][0]=temp;
		}
		for(int i=0;i<multi.length-1;i++) {
			if(multi[i][0]!=0) {
				for(int j=i+1;j<multi.length;j++) {
					if(multi[i][1]==multi[j][1]) {
						multi[i][0]+=multi[j][0];
						multi[j][0]=0;
					}
				}
			}
		}
		int count=0;
		for(int i=0;i<multi.length;i++) {
			if(multi[i][0]!=0)
				count++;
		}
		c=0;
		OpNode head = headR;
		int [][]multi2=new int [count][2];
		for(int i=0;i<multi.length;i++) {
			if(multi[i][0]!=0) {
				multi2[c][0]=multi[i][0];
				multi2[c][1]=multi[i][1];
				head.coof=multi[i][0];
				head.exp=multi[i][1];
				head.next=new OpNode();
				head=head.next;
				c++;
			}
		}
		return multi2;
	}
}
