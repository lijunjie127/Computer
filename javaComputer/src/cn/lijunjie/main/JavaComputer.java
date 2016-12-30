package cn.lijunjie.main;

import cn.lijunjie.util.Util_base;

public class JavaComputer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * 八位16进制正数表达式求值
		 * 两个问题没解决
		 * 1.取反后存储的值，原码，补码问题
		 * 2.现在处理的数据全部是正值，负数还没考虑
		 * 3.逆波兰表达式处理单目运算符
		 * 面试的题目主要考察数据结构和效率，并没有涉及高精度计算问题：输入是字符串数字都是16进制并且没有0x前缀
		 */
		String input = "0xdfees+0x23dacc1+~-0xeefe";
		input = Util_base.initFormat(input);//格式化
		System.out.println(input);
//		String[] data = input.split("\\+");
//		String[] data = input.split("-");
//		if(data.length > 1) {
//			System.out.println(Util_operation.add(data[0], data[1]));
//		} else {
//			System.out.println("没有此类运算");
//		}
	}

}
