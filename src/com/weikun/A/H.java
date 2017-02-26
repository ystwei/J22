package com.weikun.A;

import org.junit.Test;

/**
 * Created by Administrator on 2017/2/26.
 * ��ʽ��˫�����
 */
public class H {

    public class Node {//�����
        int data;     //������
        Node next; //���ָ�룬���           ����
        Node previous; //ǰ��ָ�룬���       ����
        Node(int data) {
            this.data = data;
        }
        void displayLink() {
            System.out.println("�����ǣ� " + data);
        }
    }

    private Node head;     //�׽��
    private Node rear;     //β��ָ��



    public int deleteRear() {//ɾ�� ��β

        Node temp=null;
        if(empty()){
            return -1;
        }else{
            temp=rear;
            if(rear.previous!=null){//ԭʼ���в�ֹһ���ڵ�
                rear.previous.next=null;//�����ϵĶ�β��ǰһ�ڵ�䵱��β
                rear=rear.previous;//�ϵĶ�β��ǰһ�ڵ�����µĶ�β
            }else{
                head=null;
            }

        }
        return temp.data;
    }

    public int deleteHead() {//ɾ�� ��ͷ
        Node temp=null;
        if(empty()){
            return -1;
        }else{
            temp=head;
            if(head.next!=null){//ԭʼ���в�ֹһ���ڵ�
                head.next.previous=null;//�ϵĶ�����һ�ڵ��ǰһ�ڵ�Ϊ��
                head=head.next;//�ϵĶ��׵���һ�ڵ�����µĶ���
            }else{//����һ���ڵ㣬ɾ��Ҳ��û��
                rear=null;
            }

        }
        return temp.data;

    }




    public void insertRear(int data){//��β��
        Node newNode=new Node(data);
        if(empty()){

            head=newNode;

        }else{//�нڵ�

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

        }else{//�нڵ�
            newNode=new Node(data);
            head.previous=newNode;//�½ڵ����ϵ��׽���ǰһ���ڵ�

        }
        newNode.next=head;//�½ڵ����һ�ڵ�����ϵ��׽��
        head=newNode;//��������������½ڵ㶼���Ͻڵ�ĵ�ַ
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
