
public class Example1<K extends Number,V extends Number> {
 
	public Number max(K zmienna1, V number2){
		return (  zmienna1.doubleValue() > number2.doubleValue()) ? zmienna1  : number2;
	}
}
