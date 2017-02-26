package com.weikun.A;

import org.junit.Test;

/**
 * Created by Administrator on 2017/2/26.
 * 循环队列
 */
public class F {

    private int capacity=3;//队列的元素个数
    private Integer[] os=new Integer[capacity];
    private int front=0;//队首
    private int rear=0;//队尾
    public boolean empty(){
        return os[front]==null;
    }
    @Test
    public void test(){
        this.add(1);
        this.add(2);
        this.add(3);
        this.add(4);//rear=0

        System.out.println(this.remove());
        System.out.println(this.remove());
        System.out.println(this.remove());
        System.out.println(this.remove());


    }
    /**
     *
     * @return 返回删除元素值
     */
    public int remove(){
        if(empty()){
            System.out.println("该循环队列已经是空的了！");
            return -1;

        }
        int old=os[front];
        os[front++]=null;
        front=front==capacity? 0:front ;
        return old;
    }
    /**
     *
     * @param i 增加的新元素
     */
    public void add(int i){
        os[rear++]=i;
        rear=rear==capacity?0:rear;//如果等于容量，由于是循环对象，我们需要重新对其进行置零。

    }
}
