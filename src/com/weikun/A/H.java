package com.weikun.A;

import org.junit.Test;

/**
 * Created by Administrator on 2017/2/26.
 * 链式的双向队列
 */
public class H {

    public class Node {//链结点
        int data;     //数据域
        Node next; //后继指针，结点           链域
        Node previous; //前驱指针，结点       链域
        Node(int data) {
            this.data = data;
        }
        void displayLink() {
            System.out.println("数据是： " + data);
        }
    }

    private Node head;     //首结点
    private Node rear;     //尾部指针



    public int deleteRear() {//删除 链尾

        Node temp=null;
        if(empty()){
            return -1;
        }else{
            temp=rear;
            if(rear.previous!=null){//原始队列不止一个节点
                rear.previous.next=null;//设置老的队尾的前一节点充当队尾
                rear=rear.previous;//老的队尾的前一节点就是新的队尾
            }else{
                head=null;
            }

        }
        return temp.data;
    }

    public int deleteHead() {//删除 链头
        Node temp=null;
        if(empty()){
            return -1;
        }else{
            temp=head;
            if(head.next!=null){//原始队列不止一个节点
                head.next.previous=null;//老的队首下一节点的前一节点为空
                head=head.next;//老的队首的下一节点就是新的队首
            }else{//仅有一个节点，删了也就没了
                rear=null;
            }

        }
        return temp.data;

    }




    public void insertRear(int data){//队尾加
        Node newNode=new Node(data);
        if(empty()){

            head=newNode;

        }else{//有节点

            rear.next=newNode;//

        }
        newNode.previous=rear;//
        rear=newNode;//

    }
    public void insertHead(int data){
        Node newNode=null;
        if(empty()){
            newNode=new Node(data);
            rear=newNode;

        }else{//有节点
            newNode=new Node(data);
            head.previous=newNode;//新节点是老的首结点的前一个节点

        }
        newNode.next=head;//新节点的下一节点就是老的首结点
        head=newNode;//无论哪种情况，新节点都是老节点的地址
    }
    public boolean empty(){
        return head==null;
    }
    @Test
    public void test(){

        this.insertHead(1);
        this.insertHead(2);
        this.insertRear(3);
        this.insertRear(4);

        System.out.println(this.deleteHead());
        System.out.println(this.deleteHead());


        System.out.println(this.deleteRear());
        System.out.println(this.deleteRear());
    }
}
