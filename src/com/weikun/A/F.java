package com.weikun.A;

import org.junit.Test;

/**
 * Created by Administrator on 2017/2/26.
 * ѭ������
 */
public class F {

    private int capacity=3;//���е�Ԫ�ظ���
    private Integer[] os=new Integer[capacity];
    private int front=0;//����
    private int rear=0;//��β
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
     * @return ����ɾ��Ԫ��ֵ
     */
    public int remove(){
        if(empty()){
            System.out.println("��ѭ�������Ѿ��ǿյ��ˣ�");
            return -1;

        }
        int old=os[front];
        os[front++]=null;
        front=front==capacity? 0:front ;
        return old;
    }
    /**
     *
     * @param i ���ӵ���Ԫ��
     */
    public void add(int i){
        os[rear++]=i;
        rear=rear==capacity?0:rear;//�������������������ѭ������������Ҫ���¶���������㡣

    }
}
