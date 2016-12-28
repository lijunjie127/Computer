
public class JavaComputer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String str1 = "0xfe";
//		String str2 = "0xe";
//		System.out.println(Util_operation.add(str1, str2));//正数加法运算完成！
//		System.out.println(Util_operation.del(str1, str2));//正数减法运算完成！
//		System.out.println(Util_operation.mul(str1, str2));//正数乘法运算完成！
//		System.out.println(Util_operation.xOr(str1, str2));//正数异或运算完成！
//		System.out.println(Util_operation.weiYu(str1, str2));//正数按位与运算  完成！
//		System.out.println(Util_operation.weiOr(str1, str2));//正数按位或运算  完成！
//		System.out.println(Util_operation.div(str1, str2));//正数取模运算  完成！
//		System.out.println(Util_operation.yu(str1, str2));//正数取余运算  完成！
		
		String str3 = "0xfffffffffffe";
		System.out.println(Util_operation.fan(str3));//正数取余运算
	}
	
	
	
//	/**
//	 * 判断两个字符串，第一个字符串是否大于第二个
//	 * @param str1
//	 * @param str2
//	 * @return
//	 */
//	public static boolean judgeFirstBig(String str1, String str2) {
//		boolean flag = false;
//		if(str1.length() > str2.length()) {
//			flag = true;
//		} else {
//			str1 = str1.toUpperCase();//全部变为大写
//			str1 = str1.replace("0X", "");//去掉十六进制的前缀
//			str2 = str2.toUpperCase();//全部变为大写
//			str2 = str2.replace("0X", "");//去掉十六进制的前缀
//			for(int i = 0 ; i < str1.length() ; i ++) {
//				if(str1.charAt(i) > str2.charAt(i)){
//					flag = true;
//					break;
//				}
//			}
//		}
//		return flag;
//	}
}
