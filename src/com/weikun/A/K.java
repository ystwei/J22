package com.weikun.A;

import org.junit.Test;

/**
 * Created by Administrator on 2017/3/2.
 * 双向链表
 */
public class K {

    private class Node{
        //保存节点的数据
        private int data;
        //指向上个节点的引用
        private Node prev;
        //指向下个节点的引用
        private Node next;

        //初始化全部属性的构造器
        public Node(int data , Node prev , Node next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
    //保存该链表的头节点
    private Node header;
    //保存该链表的尾节点
    private Node tail;
    //保存该链表中已包含的节点数
    private int size;

    /**
     *
     *
     * @param index: 要删除的节点索引
     * @return 要删除的节点的值
     */
    public int delete(int index){
        if(index<0 ||index>size-1){
            System.out.println("不能乱插！");
            return -1 ;
        }
        Node del=null;
        if(index==0){//要删除的节点是首结点

            del=header;
            header=header.next;
            del.next=null;
            header.prev=null;

        }else{//任意节点的删除
            Node prev=this.getNode(index-1);//删除节点的前一节点
            del=prev.next;

            prev.next=del.next;

            del.next.prev=prev;


            del.prev=null;
            del.next=null;

        }
        size--;
        return del.data;
    }
    @Test
    public void test(){
        this.addTail(0);
        this.insert(9,0);
        this.insert(8,1);

        this.insert(7,2);
        this.insert(6,3);
        this.delete(1);

        printNode();
    }
    public void printNode(){
        StringBuffer sb=new StringBuffer();
        for(Node current=header;current!=null;current=current.next){

            sb.append(current.data);

        }
        System.out.println(sb);

    }
    /**
     *
     *
     * @param element:元素
     * @param index 任意索引值
     */
    public void insert(int element , int index){
        if(index<0 ||index>size){
            System.out.println("不能乱插！");
            return ;
        }
        if(header==null){//m代表还没有节点
            this.addTail(element);

        }else{
            if(index==0){//从头加入
                addHead(element);
            }else{//任意点加入
                Node prev= getNode(index-1);

                Node next=prev.next;//插入节点的前一节点的下一节点
                Node newNode=new Node(element,prev,next);

                prev.next=newNode;//新节点是前一节点的下一节点

                next.prev=newNode;//新节点还是前一节点的下一节点的前一节点


            }

        }
        size++;




    }
    /*
        找到index指定的节点
     */

    private Node  getNode(int index) {
        Node currentNode=header;
        for( int  i=0;i<size;i++){
            if(i==index){

                break;
            }

            currentNode=currentNode.next;
        }
        return currentNode;
    }


    /**
     *
     * @param element:新元素
     */
    private void addHead(int element) {

        if(tail==null){//还没有节点
            Node node=new Node(element,null,null);
            tail=node;
            header=tail;
        }else{//至少有一个节点
            Node node=new Node(element,null,header);
            header.prev=node;//老的尾结点的下一节点就是新节点
            header=node;           //新节点就是尾戒点

        }
        size++;
    }

    //采用尾插法为链表添加新节点。
    public void addTail(int element){
        if(header==null){//还没有节点
            Node node=new Node(element,null,null);
            header=node;
            tail=header;

        }else{//至少有一个节点
            Node node=new Node(element,tail,null);
            tail.next=node;//老的尾结点的下一节点就是新节点
            tail=node;           //新节点就是尾戒点

        }
        size++;

    }
}
