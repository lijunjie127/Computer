package cn.lijunjie.test;


public class TestKnowledge {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 0xffdeffde;
		int b = 0xef11ef11;
		System.out.println(Integer.toHexString(a + b));
		System.out.println(Integer.toHexString(a - b));
		System.out.println(Integer.toHexString(a * b));
		System.out.println(Integer.toHexString(a ^ b));
		System.out.println(Integer.toHexString(a & b));
		System.out.println(Integer.toHexString(a | b));
		System.out.println(Integer.toHexString(a / b));
		System.out.println(Integer.toHexString(a % b));
		
//		int c = ~-0xeefe;
//		int c = 0x3;
//		System.out.println(Integer.toHexString(c));
//		System.out.println(c);
//		System.out.println(Integer.toHexString(~c));
//		System.out.println(~c);
		
//		int a = 0x32;
//		int b = 0x31;
//		a=a^b;
//		b=a^b;
//		a=a^b;
//		System.out.println(a);
//		System.out.println(b);
		
//		int n1 = 14;
//		System.out.println(Integer.toHexString(n1));
		
//		System.out.println(Integer.MAX_VALUE);
		
//		System.out.println("f".compareTo("d"));
		
//		System.out.println((int)'9');
		
//		System.out.println("0".matches("[0-9A-F]"));
		
//		System.out.println(Integer.toHexString(0x34&0x22));
//		System.out.println(Util_operation.weiYu("34", "22"));
		
	}

}
