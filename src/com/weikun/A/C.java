package com.weikun.A;

import java.util.Stack;

/**
 * Created by Administrator on 2017/2/26.
 * ���һ������ջ���ҵ�ջ�����ݵ���Сֵ
 */
public class C {
    private Stack dataStack=new Stack();
    private Stack minStack=new Stack();

    public int getMin(){//����Сջ��ջ��Ԫ�ص�ֵ
        return Integer.parseInt(this.minStack.peek().toString());
    }

    public void push(int data){
        if(minStack.isEmpty()){//���Ϊ�գ�����û�бȽϵİ��ӣ�����
            minStack.push(data);
        }else if(data<=this.getMin()){
            minStack.push(data);
        }
        dataStack.push(data);
    }
    public static void main(String[] args) {
        C c=new C();

        c.push(5);
        c.push(2);
        c.push(1);
        c.push(4);

        System.out.println(c.minStack.peek());

    }
}
