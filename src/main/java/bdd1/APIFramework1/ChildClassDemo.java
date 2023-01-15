package bdd1.APIFramework1;

public class ChildClassDemo extends ParentClassDemo{
	
	public void engine()
	{
		System.out.println("Child class engine method");
	}
 public void color()
 {
	 System.out.println(color);
 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChildClassDemo cd = new ChildClassDemo();
		cd.color();

	}

}
