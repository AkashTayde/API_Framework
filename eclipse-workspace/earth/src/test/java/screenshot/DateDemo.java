package screenshot;

import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {

		Date dt = new Date();
		System.out.println(dt);
		String fn = dt.toString().replace(" ", "_").replace(":","_") +".png";
		System.out.println(fn);
	}

}
