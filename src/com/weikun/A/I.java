package com.weikun.A;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by Administrator on 2017/3/2.
 */
public class I {

    private Stack<Integer> s1;//压入栈
    private Stack<Integer> s2;//弹出栈栈
    public I(){
        s1=new Stack();
        s2=new Stack();
    }
    public void add(int newValue){//内容进栈
       s1.push(newValue);
    }

    public int pull(){//查看栈顶，且删除该元素
        if(s1.empty()&&s2.empty()){//压入栈为空，不能执行
            System.out.println("不能执行任务！");
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


