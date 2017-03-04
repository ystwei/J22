package com.weikun.A;

import org.junit.Test;

/**
 * Created by Administrator on 2017/3/2.
 * 单向的链式表
 */
public class J {

    public class Node{
        //保存节点的数据
        public int data;
        //指向下个节点的引用
        private Node next;

        //初始化全部属性的构造器
        public Node(int data , Node next)	{
            this.data = data;
            this.next = next;
        }

    }
    private int size;
    private Node head;//头结点
    private Node tail;//尾结点
    /**
     *
     * @param data :节点数据
     * @param index：在哪个索引插入该节点
     */
    public void insert(int data,int index){
        if(index<0 ||index>size){
            System.out.println("不能乱插！");
            return;
        }
        if(head==null){//证明还没有形成链，我们应该先加第一个节点
            addTail(data);
        }else {//还有其他节点
            if(index==0){//在首部加入
                this.addHeader(data);
            }else {//不一定在哪里加入
                Node prev=this.getNodeByIndex(index-1);//找到要插入节点位置的前一个节点

                prev.next=new Node(data,prev.next);

            }
        }
        size++;

    }
    public void printNodes(){//打印该链
        StringBuffer sb=new StringBuffer();
        for(Node node=head;node!=null;node=node.next){

            sb.append(node.data);
        }
        System.out.println(sb);
    }

    /**
     *
     * @param index:删除任意节点的索引
     * @return 删除节点的值
     */
    public int delete(int index){
        if(index<0 ||index>size-1){
            System.out.println("不能乱插！");
            return -1;
        }
        Node node=null;
        if(index==0){//删除的是首结点
            node=head;
            head=head.next;
        }else{//删除index指定的任意节点

            Node prev =this.getNodeByIndex(index-1);//要删除节点的前一节点

            node=prev.next;

            prev.next=node.next;//前一节点的next就是要删除节点的下一节点的地址

            node.next=null;


        }
        size--;
        return node.data;
    }

    /**
     *  t通过索引号，找到节点
     * @param index ：索引
     * @return 找到的该节点
     */

    public Node getNodeByIndex(int index){
        if(index<0 ||index>size-1){
            System.out.println("不能乱插！");
            return null;
        }
        Node currentNode=this.head;
        for(int i=0;i<size;i++){

            if(i==index){//找到了该索引指定的节点
                return currentNode;
            }
            currentNode=currentNode.next;
        }
        return currentNode;

    }
    //在首部加新节点
    public void addHeader(int data){
        Node  node=new Node(data,null);//新节点
        head=node;
        if(tail==null){//证明以前这个链是空的
            tail=head;

        }
        size++;

    }

    private void addTail(int data) {
        if(head==null){//还没有一个节点哪
            Node node=new Node(data,null);//新节点
            head=node;
            tail=head;//第一个节点

        }else{//以前至少有一个节点，新节点就必须在那个节点的后面追加

            Node node=new Node(data,null);//新节点
            tail.next=node;
            tail=node;


        }
        size++;
    }
    @Test
    public void test(){
        this.addHeader(0);
        insert(1,1);
        insert(2,2);
        insert(3,3);
       // insert(4,3);
        delete(2);
        insert(9,2);

        this.printNodes();

    }
}
