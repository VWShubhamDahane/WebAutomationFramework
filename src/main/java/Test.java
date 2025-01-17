
import java.util.Date;

public class Test {
	public static void main(String[] args) {
	Date date = new Date();
	System.out.println(date.toString().replaceFirst(" ", "_"));
	System.out.println(date);        
	System.out.println(System.currentTimeMillis());
      
}
	

}
