package com.weikun.A;

import org.junit.Test;

/**
 * Created by Administrator on 2017/3/4.
 * 约瑟夫环
 */
public class L {


    class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
        }
    }
    @Test
    public void kill(){

        int n = 17;//定义总人数n
        int m = 3;//和出圈数字m

        Node first=new Node(0);
        first.next=first;//第一个节点的时候 ，由于是环 需要首尾相连
        Node last=first;
        //形成单链表
        for( int i= 1 ;i<n;i++){
            Node temp=new Node(i);
            last.next=temp;
            last=last.next;//让其每个节点都遍历到
        }
        //形成约瑟夫环
        last.next=first;

        //出圈

        while(last.next!=last){//一旦相等，证明他就剩下唯一的那个点了，也就是咱们要找的节点

            //越过1,2两个节点
            for(int i=1;i<m;i++){
                last=last.next;
            }
            //即将看到的是跳圈出去的那个人
            //System.out.println(last.data);
            last.next=last.next.next;//让下一节点是跳圈后面的那个节点
        }
        System.out.println(last.data);


    }

}
