package com.weikun.A;

import org.junit.Test;

/**
 * Created by Administrator on 2017/2/26.
 * ��ʽ�������
 */
public class G {
    private int size=0;

    private class Node {
        //����ڵ������
        private int data;
        //ָ���¸��ڵ������
        private Node next;

        //��ʼ��ȫ�����ԵĹ�����
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    private Node front;
    private Node rear;
    public  G(){
        front=new Node(1,null);
        rear=front;
        size++;
    }
    public void add(int data){
        if(front==null){
            front=new Node(1,null);
            rear=front;

        }else{
            Node newNode=new Node(data,null);
            rear.next=newNode;
            rear=newNode;
        }


        size++;

    }

    public int remove(){
        Node oldNode=front;//l�ϵ��׽��

        front=front.next;//�Ͻڵ����һ���ڵ��ַ���¶��еĶ���
        oldNode.next=null;//����
        size--;
        return oldNode.data;

    }
    @Test
    public void test(){
        this.add(10);
        this.add(20);
        this.add(30);
        System.out.println(this.remove());
        System.out.println(this.remove());
        System.out.println(this.remove());
        System.out.println(this.remove());
    }


}
