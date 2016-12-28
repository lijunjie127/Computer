
public class TestMethods {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "0xfe01";
		int [] data = Util_base.stringToIntArray(str);
		Util_base.display(data);
		
		String str1 = Util_base.intArrayToString(data);
		System.out.println(str1);

	}

}
