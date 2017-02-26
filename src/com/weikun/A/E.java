package com.weikun.A;

import org.junit.Test;

/**
 * Created by Administrator on 2017/2/26.
 * 用数组实现队列
 */
public class E {

    private Integer[] os=new Integer[10];
    private int front=0;//队首
    private int rear=0;//队尾
    @Test
    public void test(){
        this.add(1);
        this.add(2);
        this.add(3);

        System.out.println(this.remove());
        System.out.println(this.remove());
    }
    /**
     *
     * @return 返回删除元素值
     */
    public int remove(){
        int old=os[front];
        os[front++]=null;
        return old;
    }

    /**
     *
     * @param i 增加的新元素
     */
    public void add(int i){
        os[rear++]=i;
    }
}
