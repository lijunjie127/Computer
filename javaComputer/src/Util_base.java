
public class Util_base {
	/**
	 * @param length1
	 * @param length2
	 * @return 两者中较大的那个
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
	 * @return 两者中较小的那个
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
		str = str.toUpperCase();//全部变为大写
		str = str.replace("0X", "");//去掉十六进制的前缀
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
		str = "0X" + str;
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
