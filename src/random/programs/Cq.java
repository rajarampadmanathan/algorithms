package random.programs;

@A1(value=1)
public class Cq implements I1{
	
	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return I1.getValuehelper();
	}
	public static void main(String[] args) {
		System.out.println(new Cq().getClass().getAnnotations().length);
	}
	@Override
	public int getValues() {
		// TODO Auto-generated method stub
		return 0;
	}
}