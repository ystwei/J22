package com.weikun.A;

import java.util.Stack;

/**
 * Created by Administrator on 2017/2/26.
 * ʹ��JDK�Դ�Stack��LIFO ����ȳ�
 */
public class A {
    public static void main(String[] args) {
        Stack s=new Stack();
        s.push(1);
        s.push("2");
        s.push("A");
        s.push(1);
        s.push("2");
        s.push("A");
        s.push(1);
        s.push("2");
        s.push("A");
        s.push(11);
        s.push(12);
        //System.out.println(s.peek());
       // System.out.println(s.pop());

        System.out.println(s.capacity());
        //System.out.println(s.pop());

    }
}
