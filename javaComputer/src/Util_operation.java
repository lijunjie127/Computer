
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
			if(data[i] > 15) {
				data[i+1] = data[i+1] + (data[i] / 16); // 产生进位
				data[i] = data[i] % 16;
			}
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
		} 
		if(flag || str1.length() > str2.length()) { //保证data1的位数不小于data2的位数
			data1 = Util_base.stringToIntArray(str1);
			data2 = Util_base.stringToIntArray(str2);
		} else {
			data1 = Util_base.stringToIntArray(str2);
			data2 = Util_base.stringToIntArray(str1);
		}
//		Util_base.display(data1);
//		Util_base.display(data2);
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
	
//	/**
//	 * 减法运算
//	 * @param int[] data1
//	 * @param int[] data2
//	 * 已经确定data1位数不小于data2,暂时只用于除法计算的一部分
//	 * @return str1-str2
//	 */
//	public static int[] del(int[] data1, int[] data2){
//		int[] data = new int[data1.length + 1];
//		for(int i = 0 ; i < data2.length ; i ++ ){
//			data[i] = data[i] + data1[i] - data2[i];
//			if(data[i] < 0){
//				data[i+1] --;
//				data[i] = 16 + data[i];
//			}
////			Util_base.display(data);
//		}
//		for(int i = data2.length ; i < data1.length ; i ++ ) {
//			data[i] = data[i] + data1[i];
////			Util_base.display(data);
//		}
//		
//		return data;
//	}
	
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
	 * "/"运算 (效率有待提高，大数除大数无法计算)
	 * @param str1
	 * @param str2
	 * 以7546除23为例。
	 * 先减去23的100倍，就是2300，可以减3次，余下646。   此时商就是300；
	 * 然后646减去23的10倍，就是230，可以减2次，余下186。此时商就是320；
	 * 然后186减去23，可以减8次，此时商就是328.
	 * @return str1 / str2
	 */
	public static String div(String str1, String str2){
		int[] data1 = Util_base.stringToIntArray(str1);
		int[] data2 = Util_base.stringToIntArray(str2);
		
		if(data1.length < data2.length) {
			return "0X0";
		} else {
			int[] data = new int[data1.length];
			for(int i = data1.length - data2.length ; i >= 0 ; i --){
//				System.out.println("第" + i + "次进入for循环");
				int temp_i = i;
				String temp_str2 = str2;
				while(temp_i-- > 0){
					temp_str2 = temp_str2 + "0";
//					System.out.println("temp_i:" + temp_i + ", temp_str2:" + temp_str2);//--------------------
				}
				int count = 0;
				while(true){
					if(str1.length() > temp_str2.length() || str1.compareToIgnoreCase(temp_str2) >= 0){//说明还要继续减
						str1 = Util_operation.del(str1, temp_str2);
						count ++;
					} 
//					System.out.println("str1:" + str1);//--------------------
//					System.out.println("temp_str2:" + temp_str2);//--------------------
//					System.out.println("count:" + count);//--------------------
					if(str1.length() < temp_str2.length() || (str1.length() == temp_str2.length() && str1.compareToIgnoreCase(temp_str2) <= 0))
						break;
				}
				data[i] = count;
			}
			
			return Util_base.intArrayToString(data);
		}
	}
	
	/**
	 * "%"运算
	 * @param str1
	 * @param str2
	 * @return str1 % str2
	 */
	public static String yu(String str1, String str2){
		int[] data1 = Util_base.stringToIntArray(str1);
		int[] data2 = Util_base.stringToIntArray(str2);
		
		if(data1.length < data2.length) {
			return str1;
		} else {
			for(int i = data1.length - data2.length ; i >= 0 ; i --){
//				System.out.println("第" + i + "次进入for循环");
				int temp_i = i;
				String temp_str2 = str2;
				while(temp_i-- > 0){
					temp_str2 = temp_str2 + "0";
//					System.out.println("temp_i:" + temp_i + ", temp_str2:" + temp_str2);//--------------------
				}
				while(true){
					if(str1.length() > temp_str2.length() || str1.compareToIgnoreCase(temp_str2) >= 0){//说明还要继续减
						str1 = Util_operation.del(str1, temp_str2);
					} 
//					System.out.println("str1:" + str1);//--------------------
//					System.out.println("temp_str2:" + temp_str2);//--------------------
					if(str1.length() < temp_str2.length() || (str1.length() == temp_str2.length() && str1.compareToIgnoreCase(temp_str2) <= 0))
						break;
				}
			}
			return str1;
		}
	}
	
	/**
	 * "&"运算
	 * @param str1
	 * @param str2
	 * @return str1 & str2
	 */
	public static String weiYu(String str1, String str2){
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
		
		for(int i = 0 ; i < data2.length ; i ++){
			data[i] = data1[i] & data2[i];
		}
		for(int i = data2.length; i < data1.length ; i ++){
			data[i] = data1[i] & 0;
		}
		
		return Util_base.intArrayToString(data);
		
	}
	
	/**
	 * "|"运算
	 * @param str1
	 * @param str2
	 * @return str1 | str2
	 */
	public static String weiOr(String str1, String str2){
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

		for(int i = 0 ; i < data2.length ; i ++){
			data[i] = data1[i] | data2[i];
		}
		for(int i = data2.length; i < data1.length ; i ++){
			data[i] = data1[i] | 0;
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
	
	/**
	 * "~"运算
	 * 所有正整数的按位取反是其本身+1的负数
	 * 所有负整数的按位取反是其本身+1的绝对值
	 * 零的按位取反是 -1
	 * @param str1
	 * @return ~str1
	 */
	public static String fan(String str){
		int[] data1 = null;
		String str1 = null;
		boolean flag = true;
		if(str.startsWith("-")){
			str = str.replace("-", "");
			flag = false;//负数为假，正数为真
		}
		data1 = Util_base.stringToIntArray(str);
		str1 = Util_base.intArrayToString(data1);//格式化一下，转大写，去掉多余的0
		if("0X0".equals(str1)) {//0
//			System.out.println("是0");
			return "-0X1";
		} else if(flag){//正数
//			System.out.println("是正数");
			System.out.println(str1);
			return "-" + Util_operation.add(str1, "0X1");
		} else {//负数
//			System.out.println("是负数");
			return Util_operation.del(str1, "0X1");
		}
	}
}
