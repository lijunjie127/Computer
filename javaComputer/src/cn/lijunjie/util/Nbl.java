package cn.lijunjie.util;

import java.util.ArrayList;
import java.util.List;

import cn.lijunjie.pojo.MyStack;

/**
 * java实现逆波兰表达式算法
 */
public class Nbl {
    private static MyStack ms1 = new MyStack();//生成逆波兰表达式的栈
    private static MyStack ms2 = new MyStack();//运算栈

    /**
     * 将字符串转换为中序表达式，数字是十六进制
     */
    public static List<String> zb16(String s) {
        List<String> ls = new ArrayList<String>();//存储中序表达式
        int i = 0;
        String str;
        String regex = "[0-9A-F]";//十六进制数的一位
        do {
            if ( ! (s.charAt(i) + "").matches(regex)) {//不是数字
                ls.add("" + s.charAt(i));//运算符直接放入列表
                i++;
            } else {
                str = "";
                while (i < s.length() && ((s.charAt(i) + "").matches(regex))) {
                    str += s.charAt(i);
                    i++;
                }
                ls.add(str);
            }

        } while (i < s.length());
        return ls;
    }
    
    /**
     * 将中序表达式转换为逆波兰表达式
     */
    public static List<String> parse(List<String> ls) {
        List<String> lss = new ArrayList<String>();
        String regex = "[0-9A-F]+";//至少一位十六进制数
        for (String ss : ls) {
            if (ss.matches(regex)) {
                lss.add(ss);
            } else if (ss.equals("(")) {
                ms1.push(ss);
            } else if (ss.equals(")")) {

                while (!ms1.top.equals("(")) {
                    lss.add(ms1.pop());
                }
                ms1.pop();
            } else {
                while (ms1.size() != 0 && getValue(ms1.top) >= getValue(ss)) {
                    lss.add(ms1.pop());
                }
                ms1.push(ss);
            }
        }
        while (ms1.size() != 0) {
            lss.add(ms1.pop());
        }
//        System.out.println("逆波兰表达式：" + lss);
        return lss;
    }
    
    /**
     * 对逆波兰表达式进行求值，十六进制大数
     */
    public static String jisuan(List<String> ls) {
    	String data = null;
    	String regex = "[0-9A-F]+";//至少一位十六进制数
        for (String s : ls) {
            if (s.matches(regex)) {
                ms2.push(s);
            } else {
                String str2 = ms2.pop();
                String str1 = ms2.pop();
                if (s.equals("+")) {
                	data = Util_operation.add(str1, str2);
                } else if (s.equals("-")) {
                	data = Util_operation.del(str1, str2);
                } else if (s.equals("*")) {
                	data = Util_operation.mul(str1, str2);
                } else if (s.equals("/")) {
                	data = Util_operation.div(str1, str2);
                } else if (s.equals("%")) {
                	data = Util_operation.div_yu(str1, str2);
                } else if (s.equals("&")) {
                	data = Util_operation.weiYu(str1, str2);
                } else if (s.equals("^")) {
                	data = Util_operation.xOr(str1, str2);
                } else if (s.equals("|")) {
                	data = Util_operation.weiOr(str1, str2);
                }
                ms2.push(data);
            }
        }
        return ms2.pop();
    }
    
    /**
     * 获取运算符的优先级
     * ()为0  |为1  ^为2  &为3  +,-为4  *,/,%为5  ~为6 
     */
    public static int getValue(String s) {
        if (s.equals("|")) {
            return 1;
        } else if (s.equals("^")) {
            return 2;
        } else if (s.equals("&")) {
            return 3;
        } else if (s.equals("+") || s.equals("-")) {
            return 4;
        } else if (s.equals("*") || s.equals("/") || s.equals("%")) {
            return 5;
        } else if (s.equals("~")) {
            return 6;
        }
        return 0;
    }

    public static void main(String[] args) {
//        System.out.println(jisuan(parse(zb("0-8+((1+2)*4)-3+(2*7-2+2)"))));
//    	System.out.println(zb16("12+34*(24-15%D)"));
//    	System.out.println(parse(zb16("12+34*(24-15%D)")));
//    	System.out.println(jisuan(parse(zb16("12+34*(24-15%13)"))));
//    	System.out.println(zb16("(11888-4)/10"));
//    	System.out.println(parse(zb16("(11888-4)/10")));
//    	System.out.println(jisuan(parse(zb16("(11888-4)/10"))));
    	System.out.println(jisuan(parse(zb16("12^34&22"))));
    	System.out.println(jisuan(parse(zb16("(10&(24-14))-1"))));
    	System.out.println(Integer.toHexString(0x12^0x34&0x22));
    	System.out.println(Integer.toHexString(0x10&(0x24-0x14)));
    	
    	System.out.println(jisuan(parse(zb16("12"))));
    }

}
