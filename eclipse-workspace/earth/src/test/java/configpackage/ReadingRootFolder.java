package configpackage;

public class ReadingRootFolder {

	public static void main(String[] args)
	{
		//1 approch
		System.out.println(System.getProperty("user.dir"));

		//2 approch
		String RootFloder = System.getProperty("user.dir");
		System.out.println("RootFloder is " +RootFloder);
	}

}
