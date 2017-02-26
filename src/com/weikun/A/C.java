package com.weikun.A;

import java.util.Stack;

/**
 * Created by Administrator on 2017/2/26.
 * 设计一个特殊栈，找到栈中数据的最小值
 */
public class C {
    private Stack dataStack=new Stack();
    private Stack minStack=new Stack();

    public int getMin(){//看最小栈的栈顶元素的值
        return Integer.parseInt(this.minStack.peek().toString());
    }

    public void push(int data){
        if(minStack.isEmpty()){//如果为空，代表还没有比较的靶子，进入
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
