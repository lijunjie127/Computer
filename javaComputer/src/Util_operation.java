
public class Util_operation {
	/**
	 * 加法运算
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static String add(String str1, String str2){
		int[] data1 = null;
		int[] data2 = null;
		if(str1.length() > str2.length()) { //保证data1的数比data2的数大
			data1 = Util_base.stringToIntArray(str1);
			data2 = Util_base.stringToIntArray(str2);
		} else {
			data1 = Util_base.stringToIntArray(str2);
			data2 = Util_base.stringToIntArray(str1);
		}
		int[] data = new int[data1.length + 1];
		
//		Util_base.display(data1);
//		Util_base.display(data2);
//		Util_base.display(data);
//		System.out.println("------------");
		
		for(int i = 0 ; i < data2.length ; i ++){
			data[i] = data[i] + data1[i] + data2[i];
			if(data[i] > 15) {
				data[i+1] = data[i+1] + (data[i] / 16); // 产生进位
				data[i] = data[i] % 16;
			}
//			Util_base.display(data);
//			System.out.println("------------");
		}
		for(int i = data2.length; i < data1.length ; i ++){
			data[i] = data[i] + data1[i];
//			Util_base.display(data);
//			System.out.println("------------");
		}
		return Util_base.intArrayToString(data);
	}
	
	/**
	 * 减法运算
	 * @param str1
	 * @param str2
	 * @return str1-str2
	 */
	public static String del(String str1, String str2){
		int[] data1 = null;
		int[] data2 = null;
		boolean flag = false;
		if(str1.length() == str2.length()) {
			if(str1.compareToIgnoreCase(str2) > 0)
				flag = true;//说明str1比较大
		} else if(flag || str1.length() > str2.length()) { //保证data1的位数不小于data2的位数
			data1 = Util_base.stringToIntArray(str1);
			data2 = Util_base.stringToIntArray(str2);
		} else {
			data1 = Util_base.stringToIntArray(str2);
			data2 = Util_base.stringToIntArray(str1);
		}
		int[] data = new int[data1.length + 1];
		for(int i = 0 ; i < data2.length ; i ++ ){
			data[i] = data[i] + data1[i] - data2[i];
			if(data[i] < 0){
				data[i+1] --;
				data[i] = 16 + data[i];
			}
//			Util_base.display(data);
		}
		for(int i = data2.length ; i < data1.length ; i ++ ) {
			data[i] = data[i] + data1[i];
//			Util_base.display(data);
		}
		
		return Util_base.intArrayToString(data);
	}
	
	/**
	 * 乘运算
	 * @param str1
	 * @param str2
	 * @return str1 ^ str2
	 */
	public static String mul(String str1, String str2){
		int[] data1 = null;
		int[] data2 = null;
		if(str1.length() > str2.length()) { //保证data1的位数不小于data2的位数
			data1 = Util_base.stringToIntArray(str1);
			data2 = Util_base.stringToIntArray(str2);
		} else {
			data1 = Util_base.stringToIntArray(str2);
			data2 = Util_base.stringToIntArray(str1);
		}
		int[] data = new int[data1.length + data2.length];//数组相乘的位数为两乘数位数相加
		
		for(int i = 0 ; i < data1.length ; i ++ ){
			for(int j = 0 ; j < data2.length ; j ++ ){
				data[i+j] = data[i+j] + data1[i] * data2[j];
				if(data[i+j] > 15) {
					data[i+j+1] = data[i+j+1] + (data[i+j] / 16); // 产生进位
					data[i+j] = data[i+j] % 16;
				}
			}
		}
		
		return Util_base.intArrayToString(data);
	}
	
	/**
	 * 异或运算
	 * @param str1
	 * @param str2
	 * @return str1 ^ str2
	 */
	public static String xOr(String str1, String str2){
		int[] data1 = null;
		int[] data2 = null;
		if(str1.length() > str2.length()) { //保证data1的位数不小于data2的位数
			data1 = Util_base.stringToIntArray(str1);
			data2 = Util_base.stringToIntArray(str2);
		} else {
			data1 = Util_base.stringToIntArray(str2);
			data2 = Util_base.stringToIntArray(str1);
		}
		int[] data = new int[data1.length];
		
		for(int i = 0 ; i < data2.length ; i ++ ){
			data[i] = data1[i] ^ data2[i];
		}
		for(int i = data2.length ; i < data1.length ; i ++ ){
			data[i] = data1[i] ;//异或相同为零，相反为1 ，与0异或为本身
		}
		
		return Util_base.intArrayToString(data);
	}
}
