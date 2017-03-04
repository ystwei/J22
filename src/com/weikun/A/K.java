package com.weikun.A;

import org.junit.Test;

/**
 * Created by Administrator on 2017/3/2.
 * ˫������
 */
public class K {

    private class Node{
        //����ڵ������
        private int data;
        //ָ���ϸ��ڵ������
        private Node prev;
        //ָ���¸��ڵ������
        private Node next;

        //��ʼ��ȫ�����ԵĹ�����
        public Node(int data , Node prev , Node next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
    //����������ͷ�ڵ�
    private Node header;
    //����������β�ڵ�
    private Node tail;
    //������������Ѱ����Ľڵ���
    private int size;

    /**
     *
     *
     * @param index: Ҫɾ���Ľڵ�����
     * @return Ҫɾ���Ľڵ��ֵ
     */
    public int delete(int index){
        if(index<0 ||index>size-1){
            System.out.println("�����Ҳ壡");
            return -1 ;
        }
        Node del=null;
        if(index==0){//Ҫɾ���Ľڵ����׽��

            del=header;
            header=header.next;
            del.next=null;
            header.prev=null;

        }else{//����ڵ��ɾ��
            Node prev=this.getNode(index-1);//ɾ���ڵ��ǰһ�ڵ�
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
     * @param element:Ԫ��
     * @param index ��������ֵ
     */
    public void insert(int element , int index){
        if(index<0 ||index>size){
            System.out.println("�����Ҳ壡");
            return ;
        }
        if(header==null){//m����û�нڵ�
            this.addTail(element);

        }else{
            if(index==0){//��ͷ����
                addHead(element);
            }else{//��������
                Node prev= getNode(index-1);

                Node next=prev.next;//����ڵ��ǰһ�ڵ����һ�ڵ�
                Node newNode=new Node(element,prev,next);

                prev.next=newNode;//�½ڵ���ǰһ�ڵ����һ�ڵ�

                next.prev=newNode;//�½ڵ㻹��ǰһ�ڵ����һ�ڵ��ǰһ�ڵ�


            }

        }
        size++;




    }
    /*
        �ҵ�indexָ���Ľڵ�
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
     * @param element:��Ԫ��
     */
    private void addHead(int element) {

        if(tail==null){//��û�нڵ�
            Node node=new Node(element,null,null);
            tail=node;
            header=tail;
        }else{//������һ���ڵ�
            Node node=new Node(element,null,header);
            header.prev=node;//�ϵ�β������һ�ڵ�����½ڵ�
            header=node;           //�½ڵ����β���

        }
        size++;
    }

    //����β�巨Ϊ��������½ڵ㡣
    public void addTail(int element){
        if(header==null){//��û�нڵ�
            Node node=new Node(element,null,null);
            header=node;
            tail=header;

        }else{//������һ���ڵ�
            Node node=new Node(element,tail,null);
            tail.next=node;//�ϵ�β������һ�ڵ�����½ڵ�
            tail=node;           //�½ڵ����β���

        }
        size++;

    }
}
