package random.programs;

enum Person {

	P1;
	private int a,b,c;
	Person(){
System.out.println("Helllllllllllllllllo");
		this.a=-1;
		this.b=-1;
		this.c=-1;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public int getC() {
		return c;
	}
	public void setC(int c) {
		this.c = c;
	}
	
	
}
public class TestPerson{
	
	final static TestPerson tp=new TestPerson();
public static void main(String[] args) {
	System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
	/*Person p=Person.P1;
	System.out.println(Person.values().length);
	p.setA(10);p.setB(20);p.setC(30);
	System.out.println(p.getA()+"--"+p.getB()+"  "+p.getC() );
	Person p2=Person.P1;
	System.out.println(p2.getA()+"--"+p2.getB()+"  "+p2.getC() );*/
}	
}