package com.weikun.A;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by Administrator on 2017/3/2.
 */
public class I {

    private Stack<Integer> s1;//ѹ��ջ
    private Stack<Integer> s2;//����ջջ
    public I(){
        s1=new Stack();
        s2=new Stack();
    }
    public void add(int newValue){//���ݽ�ջ
       s1.push(newValue);
    }

    public int pull(){//�鿴ջ������ɾ����Ԫ��
        if(s1.empty()&&s2.empty()){//ѹ��ջΪ�գ�����ִ��
            System.out.println("����ִ������");
            return -1;
        }

        while(!s1.empty()){
            s2.push(s1.pop());
        }
        return s2.pop();
    }
    @Test
    public void test(){
        add(1);
        add(2);
        add(3);
        add(4);
        System.out.println(pull());
        System.out.println(pull());
        System.out.println(pull());
        System.out.println(pull());


    }


}


