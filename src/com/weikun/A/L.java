package com.weikun.A;

import org.junit.Test;

/**
 * Created by Administrator on 2017/3/4.
 * Լɪ��
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

        int n = 17;//����������n
        int m = 3;//�ͳ�Ȧ����m

        Node first=new Node(0);
        first.next=first;//��һ���ڵ��ʱ�� �������ǻ� ��Ҫ��β����
        Node last=first;
        //�γɵ�����
        for( int i= 1 ;i<n;i++){
            Node temp=new Node(i);
            last.next=temp;
            last=last.next;//����ÿ���ڵ㶼������
        }
        //�γ�Լɪ��
        last.next=first;

        //��Ȧ

        while(last.next!=last){//һ����ȣ�֤������ʣ��Ψһ���Ǹ����ˣ�Ҳ��������Ҫ�ҵĽڵ�

            //Խ��1,2�����ڵ�
            for(int i=1;i<m;i++){
                last=last.next;
            }
            //��������������Ȧ��ȥ���Ǹ���
            //System.out.println(last.data);
            last.next=last.next.next;//����һ�ڵ�����Ȧ������Ǹ��ڵ�
        }
        System.out.println(last.data);


    }

}
