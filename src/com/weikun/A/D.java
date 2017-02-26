package com.weikun.A;

import java.util.Stack;

/**
 * Created by Administrator on 2017/2/26.
 * 迪杰斯特拉的双栈算法，计算诸如如下式子
 *  ((2+(3*4))+5)
 */
public class D {

    static Stack<Double> vals = new Stack<Double>();//运算数栈
    static Stack<Character> op = new Stack<Character>();//运算符栈

    public static void main(String[] args) {
        String str="((2+(8/4))+5)";
        System.out.println(evl(str));
    }
    /**
     *
     * @param express:送的四则表达式
     * @return最终结果
     */
    public static double evl(String express){
        char [] cs=express.toCharArray();
        for(int i=0;i<cs.length;i++){
            if(cs[i]=='+'){
                op.push('+');
            }else if(cs[i]=='-'){
                op.push('-');
            }else if(cs[i]=='*'){
                op.push('*');
            }else if(cs[i]=='/'){
                op.push('/');
            }else if(cs[i]=='('){//不动

            }else if(cs[i]==')'){//发现右括号，开始计算值

                double d1=vals.pop();//运算数
                char c1=op.pop();//运算符号
                if(c1=='+'){
                    vals.push(d1+vals.pop());

                }else if(c1=='-'){
                    vals.push(vals.pop()-d1);

                }else if(c1=='*'){
                    vals.push(d1*vals.pop());

                }else if(c1=='/'){
                    vals.push(vals.pop()/d1);

                }

            }else {//纯数
                vals.push(Double.parseDouble(new Character(cs[i]).toString()));
            }


        }
        return vals.pop();

    }


}
