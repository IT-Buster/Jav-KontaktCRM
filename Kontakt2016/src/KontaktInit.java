
public class KontaktInit {

	private static KontaktProperties kontprop;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Starting Apps:");
		kontprop = new KontaktProperties("Test");
		System.out.println( kontprop.getKontaktProp("dbuser") );
		
		
	}

}
