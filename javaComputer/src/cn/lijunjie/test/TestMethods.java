package cn.lijunjie.test;

import cn.lijunjie.util.Util_operation;

public class TestMethods {

	/**
	 * 注意测试主要用大写的字母测试，计算的值都是十六进制
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = "34";
		String str2 = "22";
//		System.out.println("加：" + Util_operation.add(str1, str2));//正数加法运算完成！
//		System.out.println("减：" + Util_operation.del(str1, str2));//正数减法运算完成！
//		System.out.println("乘：" + Util_operation.mul(str1, str2));//正数乘法运算完成！
		System.out.println("异或：" + Util_operation.xOr(str1, str2));//正数异或运算完成！
		System.out.println("与：" + Util_operation.weiYu(str1, str2));//正数按位与运算  完成！
//		System.out.println("或：" + Util_operation.weiOr(str1, str2));//正数按位或运算  完成！
//		System.out.println("模：" + Util_operation.div(str1, str2));//正数取模运算  完成！
//		System.out.println("余：" + Util_operation.yu(str1, str2));//正数取余运算  完成！
		
//		String str3 = "-0xeeff";
//		System.out.println(Util_operation.fan(str3));//正数取余运算
	/**
String str1 = "0xffde";
String str2 = "0xef11";
1eeef
10cd
eef13fbe
10cf
ef10
ffdf
1
10cd


String str1 = "FFDEFFDE";
String str2 = "EF11EF11";
eef0eeef
10cd10cd
6e6d3fbe
10cf10cf
ef10ef10
ffdfffdf
0
ffdeffde
	 */
//		String str = "0xfe01";
//		int [] data = Util_base.stringToIntArray(str);
//		Util_base.display(data);
//		
//		String str1 = Util_base.intArrayToString(data);
//		System.out.println(str1);
		
//		String str1 = "0X1111";
//		String str2 = "0xfee";
//		System.out.println(Util_base.judgeFirstBig(str1, str2));
//		System.out.println(Util_operation.add(str1, str2));

//		String str = "  0xdklsf(  4(    3（2（1）0（1） 2）3 )4  ) _";
//		System.out.println(str);
//		System.out.println(Util_base.initFormat(str));
//		System.out.println(str);
		
		
	}

}
