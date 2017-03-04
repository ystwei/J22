package com.weikun.A;

import org.junit.Test;

/**
 * Created by Administrator on 2017/3/2.
 * �������ʽ��
 */
public class J {

    public class Node{
        //����ڵ������
        public int data;
        //ָ���¸��ڵ������
        private Node next;

        //��ʼ��ȫ�����ԵĹ�����
        public Node(int data , Node next)	{
            this.data = data;
            this.next = next;
        }

    }
    private int size;
    private Node head;//ͷ���
    private Node tail;//β���
    /**
     *
     * @param data :�ڵ�����
     * @param index�����ĸ���������ýڵ�
     */
    public void insert(int data,int index){
        if(index<0 ||index>size){
            System.out.println("�����Ҳ壡");
            return;
        }
        if(head==null){//֤����û���γ���������Ӧ���ȼӵ�һ���ڵ�
            addTail(data);
        }else {//���������ڵ�
            if(index==0){//���ײ�����
                this.addHeader(data);
            }else {//��һ�����������
                Node prev=this.getNodeByIndex(index-1);//�ҵ�Ҫ����ڵ�λ�õ�ǰһ���ڵ�

                prev.next=new Node(data,prev.next);

            }
        }
        size++;

    }
    public void printNodes(){//��ӡ����
        StringBuffer sb=new StringBuffer();
        for(Node node=head;node!=null;node=node.next){

            sb.append(node.data);
        }
        System.out.println(sb);
    }

    /**
     *
     * @param index:ɾ������ڵ������
     * @return ɾ���ڵ��ֵ
     */
    public int delete(int index){
        if(index<0 ||index>size-1){
            System.out.println("�����Ҳ壡");
            return -1;
        }
        Node node=null;
        if(index==0){//ɾ�������׽��
            node=head;
            head=head.next;
        }else{//ɾ��indexָ��������ڵ�

            Node prev =this.getNodeByIndex(index-1);//Ҫɾ���ڵ��ǰһ�ڵ�

            node=prev.next;

            prev.next=node.next;//ǰһ�ڵ��next����Ҫɾ���ڵ����һ�ڵ�ĵ�ַ

            node.next=null;


        }
        size--;
        return node.data;
    }

    /**
     *  tͨ�������ţ��ҵ��ڵ�
     * @param index ������
     * @return �ҵ��ĸýڵ�
     */

    public Node getNodeByIndex(int index){
        if(index<0 ||index>size-1){
            System.out.println("�����Ҳ壡");
            return null;
        }
        Node currentNode=this.head;
        for(int i=0;i<size;i++){

            if(i==index){//�ҵ��˸�����ָ���Ľڵ�
                return currentNode;
            }
            currentNode=currentNode.next;
        }
        return currentNode;

    }
    //���ײ����½ڵ�
    public void addHeader(int data){
        Node  node=new Node(data,null);//�½ڵ�
        head=node;
        if(tail==null){//֤����ǰ������ǿյ�
            tail=head;

        }
        size++;

    }

    private void addTail(int data) {
        if(head==null){//��û��һ���ڵ���
            Node node=new Node(data,null);//�½ڵ�
            head=node;
            tail=head;//��һ���ڵ�

        }else{//��ǰ������һ���ڵ㣬�½ڵ�ͱ������Ǹ��ڵ�ĺ���׷��

            Node node=new Node(data,null);//�½ڵ�
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
