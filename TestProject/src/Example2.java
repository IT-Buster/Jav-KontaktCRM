
public class Example2 extends Example1<Integer, Integer> {
	public Number max(Integer number1, Integer number2) {
		return super.max(number1, number2);
	}
	public static void main(String[] args) {
		Example1 example1 = new Example1();
		Class clazz = example1.getClass();
		String name = clazz.getName();
		System.out.println(name);
	}
}
