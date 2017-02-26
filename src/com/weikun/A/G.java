package com.weikun.A;

import org.junit.Test;

/**
 * Created by Administrator on 2017/2/26.
 * 链式单向对列
 */
public class G {
    private int size=0;

    private class Node {
        //保存节点的数据
        private int data;
        //指向下个节点的引用
        private Node next;

        //初始化全部属性的构造器
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
        Node oldNode=front;//l老的首结点

        front=front.next;//老节点的下一个节点地址是新队列的队首
        oldNode.next=null;//拖链
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
