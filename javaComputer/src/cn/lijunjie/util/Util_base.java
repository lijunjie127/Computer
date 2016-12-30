package cn.lijunjie.util;

public class Util_base {
	
	
	/**
	 * 判断两个字符串，第一个字符串组成的数字大小是否大于第二个
	 * @param str1
	 * @param str2
	 * @return true or false
	 */
	public static boolean judgeFirstBig(String str1, String str2) {
		boolean flag = false;
		if(str1.length() > str2.length()) {
			flag = true;
		} else if(str1.compareToIgnoreCase(str2) > 0) {
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 字符串的格式化，全部变为大写，去除0x字符前缀，去除空格，替换中文括号为英文括号
	 * @param str
	 * @return str
	 */
	public static String initFormat(String str) {
		str = str.replace(" ", "");//去除空格
		str = str.replace("（", "(");
		str = str.replace("）", ")");//替换中文括号
		str = str.toUpperCase();//全部变为大写
		str = str.replace("0X", "");//去除十六进制前缀
		return str;
	}
	
	/**
	 * @param length1
	 * @param length2
	 * @return 两者中长度较大的那个
	 */
	public static int max(int length1, int length2) {
		if(length1 > length2)
			return length1;
		else
			return length2;
	}
	
	/**
	 * @param length1
	 * @param length2
	 * @return 两者中长度较小的那个
	 */
	public static int min(int length1, int length2) {
		if(length1 < length2)
			return length1;
		else
			return length2;
	}

	/**
	 * 临时显示数组元素的，低位下标小，在前面
	 * @param data
	 */
	public static void display(int[] data) {
		for(int i = 0 ; i < data.length ; i ++)
			System.out.print(data[i] + "  ");
		System.out.println();
	}
	
	/**
	 * 字符串转整型数组
	 * @param str 左边为高位
	 * @param 整型数组 下标小的为高位
	 * @return 
	 */
	public static int[] stringToIntArray (String str){
		char[] dataChar = str.toCharArray(); //字符串转字符数组
		int [] data = new int [dataChar.length]; //新建整型数组
		for(int i = 0 ; i < dataChar.length ; i++) {
			data[dataChar.length-i-1] = charToInt(dataChar[i]);//字符转整型，存入整型数组对应位置，倒叙存入
//			System.out.println("测试输出：" + charToInt(dataChar[i]));
		}
		return data;
	}
	
	/**
	 * 整型数组转字符串
	 * @param str
	 * @return
	 */
	public static String intArrayToString (int[] data){
		int length = data.length;
		for(int i = data.length-1 ; i > 0 ; i --){
			if(data[i] == 0){
				length --;
			} else {
				break;//只去除末尾的0
			}
		}
		String str = "";
		for(int i = 0 ; i < length ; i ++){
			if(data[i] > 9 && data[i] < 16){
				str = intToChar(data[i]) + str;
			} else {
				str = data[i] + str;
			}
		}
		return str;
	}
	
	/**
	 * 一个16进制字符型转10进制数
	 * 如：'C'->12 ; '5'->5
	 * @param character
	 * @return
	 */
	public static int charToInt (char character){
		int i = 0;
		switch (character){ 
			case 'A' : i = 10; break; 
			case 'B' : i = 11; break; 
			case 'C' : i = 12; break; 
			case 'D' : i = 13; break; 
			case 'E' : i = 14; break; 
			case 'F' : i = 15; break; 
			case 'a' : i = 10; break; 
			case 'b' : i = 11; break; 
			case 'c' : i = 12; break; 
			case 'd' : i = 13; break; 
			case 'e' : i = 14; break; 
			case 'f' : i = 15; break; 
			default : i = Integer.valueOf(character) - 48; break; 
		} 
		return i;
	}
	
	/**
	 * 一个10进制数转16进制字符型
	 * 如：12->'C' 
	 * 注意：该方法只能处理10-15这几个数 
	 * @param character
	 * @return
	 */
	public static char intToChar (int i){
		char character = 'Z';
		switch (i){ 
			case 10 : character = 'A'; break; 
			case 11 : character = 'B'; break; 
			case 12 : character = 'C'; break; 
			case 13 : character = 'D'; break; 
			case 14 : character = 'E'; break; 
			case 15 : character = 'F'; break; 
			default : break; 
		} 
		return character;
	}
}
