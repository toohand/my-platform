package com.lefthand.comm.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 *  通过四则运算表达式字符串，构造逆波兰表达式，计算结果
 *
 * 　(1)从左至右扫描该算术表达式，从第一个字符开始判断，
 *      如果该字符是数字，则分析到该数字串的结束并将该数字串直接输出。
 *
 *　(2)如果不是数字，该字符则是运算符，此时需比较优先关系。
 　　    做法如下：将该字符与运算符栈顶的运算符的优先关系相比较。
 如果，该字符优先关系高于此运算符栈顶的运算符，则将该运算符入栈。
 倘若不是的话，则将栈顶的运算符从栈中弹出，直到栈顶运算符的优先级
 低于当前运算符，将该字符入栈。

 　　(3)重复上述操作(1)-(2)直至扫描完整个简单算术表达式，确定所有字符都得到正确处理，
 我们便可以将中缀式表示的简单算术表达式转化为逆波兰表示的简单算术表达式。
 *
 *
 */
public class Arithmetic {

    /**
     * +
     */
    private final static String OP1 = "+";

    /**
     * -
     */
    private final static String OP2 = "-";

    /**
     * *
     */
    private final static String OP3 = "*";

    /**
     * /
     */
    private final static String OP4 = "/";

    /**
     * (
     */
    private final static String OPSTART = "(";

    /**
     * )
     */
    private final static String OPEND = ")";

    //四则运算式
    private String exp;

    //精确到小数点后几位
    private int precision=2;

    //取舍模式
    private RoundingMode roundingMode=RoundingMode.HALF_UP;

    //四则运算解析
    private List<String> expList = new ArrayList<String>();

    //存放逆波兰表达式
    private List<String> rpnList = new ArrayList<String>();

    /**
     * 四则运算
     * @param exp            四则运算表达式
     * @param precision        精确到小数点后几位
     * @param roundingMode        取舍模式
     */
    public Arithmetic(String exp,int precision,RoundingMode roundingMode) {
        this.exp = exp;
        this.precision=precision;
        this.roundingMode=roundingMode;

        parse();
        createRPN();
    }

    /**
     * 分析四则运算表达式，将数字与运算符进行分解
     */
    private void parse() {
        int length = exp.length();

        String tempStr = "";
        for (int i = 0; i < length; i++) {
            String tempChar = exp.substring(i, i + 1);
            if (isNumber(tempChar)) {
                tempStr += tempChar;
            } else {
                if (!tempStr.equals("")) {
                    expList.add(tempStr);
                }
                expList.add(tempChar);
                tempStr = "";
            }
        }
        if (!tempStr.equals("")) {
            expList.add(tempStr);
        }

    }

    /**
     * 判断当前字符或字符串是否是数字
     * @param str
     * @return
     */
    private boolean isNumber(String str) {
        return str.startsWith("0")
                || str.startsWith("1")
                || str.startsWith("2")
                || str.startsWith("3")
                || str.startsWith("4")
                || str.startsWith("5")
                || str.startsWith("6")
                || str.startsWith("7")
                || str.startsWith("8")
                || str.startsWith("9")
                || str.startsWith(".");

    }

    /**
     * 判断当前字符是否是 (
     * @param str
     * @return
     */
    private boolean isParenthesesStart(String str) {
        return str.equals(OPSTART);
    }

    /**
     * 判断当前字符是否是  )
     * @param str
     * @return
     */
    private boolean isParenthesesEnd(String str) {
        return str.equals(OPEND);
    }

    /**
     * 判断当前字符是否是高优先级运算符  * /
     * @param str
     * @return
     */
    private boolean isHeighOperator(String str) {
        if (str.equals(OP3)
                || str.equals(OP4)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 对比两个字符串的优先级
     * @param str1
     * @param str2
     * @return
     */
    private boolean compare(String str1, String str2) {
        if (str1.equals(OPSTART)) {
            return false;
        }
        if (isHeighOperator(str2)) {
            return false;
        } else {
            if (isHeighOperator(str1)) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 将分解后的四则运算列表构建成逆波兰表达式列表
     */
    private void createRPN() {
        Stack stack = new Stack();

        int length = expList.size();
        for (int i = 0; i < length; i++) {
            String c = expList.get(i);

            //如果是数字，直接放到逆波兰链表的最后
            if (isNumber(c)) {
                rpnList.add(c);
            } else {
                //如果不是数字

                //如果是左括号，则直接将左括号压入栈
                if (isParenthesesStart(c)) {
                    stack.push(c);
                } else if (isParenthesesEnd(c)) {
                    //如果是右括号

                    //进行出栈操作，直到栈为空或者遇到第一个左括号
                    while (!stack.isEmpty()) {
                        //将栈顶字符串做出栈操作
                        String tempC = stack.pop();
                        if (!tempC.equals(OPSTART)) {
                            //如果不是左括号，则将字符串直接放到逆波兰链表的最后
                            rpnList.add(tempC);
                        }else{
                            //如果是左括号，退出循环操作
                            break;
                        }
                    }
                } else {
                    //如果栈内为空
                    if (stack.isEmpty()) {
                        //将当前字符串直接压栈
                        stack.push(c);
                    } else {
                        //如果栈不为空

                        //比较栈顶字符串与当前字符串的优先级，
                        if (compare(stack.top(), c)) {
                            //如果栈顶元素的优先级大于当前字符串,则进行出栈操作
                            //将栈顶元素直接放到逆波兰链表的最后
                            //直到栈内为空，或者当前元素的优先级不小于栈顶元素优先级
                            while (!stack.isEmpty() && compare(stack.top(), c)) {
                                rpnList.add(stack.pop());
                            }
                        }
                        //将当前字符串直接压栈
                        stack.push(c);
                    }
                }

            }
        }

        //如果栈不为空，则将栈中所有元素出栈放到逆波兰链表的最后
        while (!stack.isEmpty()) {
            rpnList.add(stack.pop());
        }
    }

    /**
     * 通过逆波兰表达式计算结果
     * @return
     */
    public String calculate() {
        Stack numberStack = new Stack();

        int length=rpnList.size();
        for(int i=0;i<length;i++){
            String temp=rpnList.get(i);
            if(isNumber(temp)){
                numberStack.push(temp);
            }else{
                BigDecimal tempNumber1 = getBigDecimal(numberStack.pop(),
                        precision,
                        roundingMode);

                BigDecimal tempNumber2 = getBigDecimal(numberStack.pop(),
                        precision,
                        roundingMode);

                BigDecimal tempNumber = getBigDecimal("",
                        precision,
                        roundingMode);

                if(temp.equals(OP1)){
                    tempNumber=tempNumber2.add(tempNumber1);
                }else if(temp.equals(OP2)){
                    tempNumber=tempNumber2.subtract(tempNumber1);
                }else if(temp.equals(OP3)){
                    tempNumber=tempNumber2.multiply(tempNumber1);
                }else if(temp.equals(OP4)){
                    tempNumber=tempNumber2.divide(tempNumber1,
                            precision,
                            roundingMode);
                }

                numberStack.push(tempNumber.toString());

            }
        }

        return numberStack.pop();
    }

    /**
     * 获取逆波兰表达式字符串
     * @return
     */
    public String getRPN(){

        String rpn="";

        int rpnLength=rpnList.size();
        for(int i=0;i<rpnLength;i++){
            rpn+=rpnList.get(i)+" ";
        }

        return rpn;
    }

    /**
     * 按精确度计算结果
     * @param numString
     * @param precision
     * @param roundingMode
     * @return
     */
    public static BigDecimal getBigDecimal(String numString,
                                           int precision,
                                           RoundingMode roundingMode){
        String precisionFlag="0";
        if(numString==null || numString.equals("")){
            precisionFlag="0.00";
        }else{
            precisionFlag=numString;
        }
        BigDecimal bigDecimal = new BigDecimal(precisionFlag);
        bigDecimal.setScale(precision,roundingMode);
        return bigDecimal;
    }

    /**
     * 栈
     *
     *
     * @author shiwei
     *
     */
    private class Stack {

        LinkedList<String> stackList = new LinkedList<String>();

        public Stack() {

        }

        /**
         * 入栈
         * @param expression
         */
        public void push(String expression) {
            stackList.addLast(expression);
        }

        /**
         * 出栈
         * @return
         */
        public String pop() {
            return stackList.removeLast();
        }

        /**
         * 栈顶元素
         * @return
         */
        public String top() {
            return stackList.getLast();
        }

        /**
         * 栈是否为空
         * @return
         */
        public boolean isEmpty() {
            return stackList.isEmpty();
        }
    }

    public static void main(String[] args) {

        String str = "1+(2+3)*(100-5*(9+8))/2.3+6-19";

        System.out.println("====================================");

        //将四则运算字符串分解为逆波兰表达式后计算结果
        Arithmetic arithmetic=new Arithmetic(str,10,RoundingMode.HALF_UP);
        String rpn=arithmetic.getRPN();
        System.out.println("逆波兰表达式 : "+rpn);
        System.out.println("计算结果 : "+arithmetic.calculate());
    }

}
