package eg.edu.alexu.csd.datastructure.linkedList;
import java.util.*;
public class MAIN {
	public static void main(String [] args) {
		
		int operation;
		while(true) {
			System.out.println("Please choose an action\r\n" + 
					"-----------------------\r\n" + 
					"1- Set a polynomial variable\r\n" + 
					"2- Print the value of a polynomial variable\r\n" + 
					"3- Add two polynomials\r\n" + 
					"4- Subtract two polynomials\r\n" + 
					"5- Multiply two polynomials\r\n" + 
					"6- Evaluate a polynomial at some point\r\n" + 
					"7- Clear a polynomial variable\r\n" +
					"====================================================================");
			Scanner no = new Scanner(System.in);
			operation=no.nextInt();
			if(operation!=1 && operation!=2 && operation!=3 && operation!=4 && operation!=5 && operation!=6 && operation!=7)
				return;
			Operations choose = new Operations();
 
			if(operation==1) {
				System.out.println("Insert the variable name: A, B or C");
				char poly =no.next().charAt(0);
				System.out.println("Insert the polynomial terms in the form:\r\n" + 
						"(coeff1, exponent1), (coeff2, exponent2), ..");
				Scanner scan = new Scanner(System.in);
				String CO = scan.nextLine();
				char []split=CO.toCharArray();
				int count=0;
				for(int i=0;i<split.length-1;i++) {
					if(Character.isDigit(split[i])&&(!(Character.isDigit(split[i+1])))) 
						count++;
					}
				int terms[][]= new int [count/2][2];
				count=0;
				int row=0;
				for(int i=0;i<split.length;i++) {
					int temp=0;
					int flag=0;
					while(Character.isDigit(split[i])) {
						flag=1;
						temp=temp*10+Character.getNumericValue(split[i]);
						i++;
					}
					if(flag==1) {
						count++;
						if(count%2==1) 
							terms[row][0]=temp;
 
						else {
							terms[row][1]=temp;
							row++;
						}
 
					}
 
				}
 
				for(int i=0;i<terms.length-1;i++) {
					int max =i;
					for(int j=i+1;j<terms.length;j++) {
						if(terms[j][1]>terms[max][1])
							max=j;
					}
					int temp=terms[i][1];
					terms[i][1]=terms[max][1];
					terms[max][1]=temp;
					temp=terms[i][0];
					terms[i][0]=terms[max][0];
					terms[max][0]=temp;
				}
				for(int i=0;i<terms.length-1;i++) {
					if(terms[i][0]!=0) {
						for(int j=i+1;j<terms.length;j++) {
							if(terms[i][1]==terms[j][1]) {
								terms[i][0]+=terms[j][0];
								terms[j][0]=0;
							}
						}
					}
				}
 
				choose.setPolynomial(poly, terms);
				System.out.println("Polynomial " + poly + " is set");
				System.out.println("====================================================================");
			}
 
			if(operation==2) {
				System.out.println("Insert the variable name: A, B or C");
				char poly =no.next().charAt(0);
				String expression = choose.print(poly);
				System.out.print("R Value in R: ");
				System.out.println(expression);
				System.out.println("====================================================================");
			}
 
			if(operation==3) {
				System.out.println("Insert first operand variable name: A, B or C");
				char poly1 =no.next().charAt(0);
				System.out.println("Insert the second operand variable name: A, B or C");
				char poly2 =no.next().charAt(0);
				int[][]sum=choose.add(poly1, poly2);
				System.out.println("====================================================================");
			}
 
			if(operation==4) {
				System.out.println("Insert first operand variable name: A, B or C");
				char poly1 =no.next().charAt(0);
				System.out.println("Insert the second operand variable name: A, B or C");
				char poly2 =no.next().charAt(0);
				int[][]sub=choose.subtract(poly1, poly2);
				System.out.println("====================================================================");
			}
 
			if(operation==5) {
				System.out.println("Insert first operand variable name: A, B or C");
				char poly1 =no.next().charAt(0);
				System.out.println("Insert the second operand variable name: A, B or C");
				char poly2 =no.next().charAt(0);
				int[][] multi=choose.multiply(poly1, poly2);
				System.out.println("====================================================================");
			}
 
			if(operation==6) {
				System.out.println("Insert the variable name: A, B or C");
				char poly =no.next().charAt(0);
				System.out.println("Insert the value of the point");
				float value =no.nextFloat();
				float val;
				val=choose.evaluatePolynomial(poly, value);
				System.out.println("The value is "+val);
				System.out.println("====================================================================");
			}
 
			if(operation==7) {
				System.out.println("Insert the variable name: A, B or C");
				char poly =no.next().charAt(0);
				choose.clearPolynomial(poly);
				System.out.println("====================================================================");
			}
 
		} 
 
	 /*  Node2 f=new Node2();
	   Node2 s=new Node2();
	   Node2 t=new Node2();
	    Node2 o=new Node2();
	    Node2 x=new Node2();
	    f.value=1;
	    f.next=s;
	    s.value=5;
	    s.next=t;
	    t.value=3;
	    t.next=o;
	    o.value=6;
	    o.next=x;
	    x.value=0;
	    x.next=null;
	  Double check=new Double();
	   check.head=f;
	   ILinkedList q;
	   q=check.sublist(1, 3);
	   System.out.println(q.get(0));
	   System.out.println(q.get(1));
	   System.out.println(q.get(2));
	   */
	}

}
