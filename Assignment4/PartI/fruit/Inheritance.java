package fruit;
public class Inheritance {
	public static void main(String[] args) {
		// Here's some scratch space to experiment/debug your Fruit objects
		Fruit f1 = new Apple();
		Fruit f2 = new Citrus();
		Fruit f3 = new Fruit();
		Fruit f4 = new Lemon();
		Fruit f5 = new Orange();
		Apple f6 = new Apple("sweet","soft","red",true);
		Citrus f7 = new Citrus("sour","orange",false);
		Fruit f8 = new Fruit("blue",false);
		Lemon f9 = new Lemon(0,null,false);
		Orange f10 =new Orange("","",false);				
		System.out.println(f1.toString());
		System.out.println(f2.toString());
		System.out.println(f3.toString());
		System.out.println(f4.toString());
		System.out.println(f5.toString());
		System.out.println();		
		System.out.println(f6.toString());
		System.out.println(f7.toString());
		System.out.println(f8.toString());
		System.out.println(f9.toString());
		System.out.println(f10.toString());
		System.out.println();		
		System.out.println(f1.equals(f2));
		System.out.println();		
		System.out.println(f1.equals(f6));
		System.out.println(f2.equals(f7));
		System.out.println(f3.equals(f8));
		System.out.println(f4.equals(f9));
		System.out.println(f5.equals(f10));
		f3.deleteFruit();
		System.out.println(f3.toString());
	}
}