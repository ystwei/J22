package com.weikun.A;

import java.util.Stack;

/**
 * Created by Administrator on 2017/2/26.
 * �Ͻ�˹������˫ջ�㷨��������������ʽ��
 *  ((2+(3*4))+5)
 */
public class D {

    static Stack<Double> vals = new Stack<Double>();//������ջ
    static Stack<Character> op = new Stack<Character>();//�����ջ

    public static void main(String[] args) {
        String str="((2+(8/4))+5)";
        System.out.println(evl(str));
    }
    /**
     *
     * @param express:�͵�������ʽ
     * @return���ս��
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
            }else if(cs[i]=='('){//����

            }else if(cs[i]==')'){//���������ţ���ʼ����ֵ

                double d1=vals.pop();//������
                char c1=op.pop();//�������
                if(c1=='+'){
                    vals.push(d1+vals.pop());

                }else if(c1=='-'){
                    vals.push(vals.pop()-d1);

                }else if(c1=='*'){
                    vals.push(d1*vals.pop());

                }else if(c1=='/'){
                    vals.push(vals.pop()/d1);

                }

            }else {//����
                vals.push(Double.parseDouble(new Character(cs[i]).toString()));
            }


        }
        return vals.pop();

    }


}
