package com.weikun.A;

import org.junit.Test;

/**
 * Created by Administrator on 2017/2/26.
 * ������ʵ�ֶ���
 */
public class E {

    private Integer[] os=new Integer[10];
    private int front=0;//����
    private int rear=0;//��β
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
     * @return ����ɾ��Ԫ��ֵ
     */
    public int remove(){
        int old=os[front];
        os[front++]=null;
        return old;
    }

    /**
     *
     * @param i ���ӵ���Ԫ��
     */
    public void add(int i){
        os[rear++]=i;
    }
}
