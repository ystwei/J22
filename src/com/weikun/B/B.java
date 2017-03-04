package com.weikun.B;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/4.
 * �ӽڵ�����ʾ��
 */
public class B {
    @Test
    public void test(){

        B0 b0=new B0(0);
        B0.Node root=b0.root();//���ڵ�

        B0.Node b1=b0.addNode(1,root);
        b0.addNode(2,root);
        b0.addNode(3,root);


        b0.addNode(4,b1);

        List<B0.Node> list=b0.getChildren(b1);

        for(B0.Node node :list){

            System.out.println(node.data);
        }

        System.out.println(b0.deep(b1));


    }
}
class B0{

    //�ӽڵ�
    public static class Node{
        int data;//�ýڵ�����
        //��¼��һ���ӽڵ�:���ڱ���Ը��ӽڵ��������ã�ͨ�����ֹ�ϵ �����Լ�¼���нڵ�֮��ĸ��ӹ�ϵ��
        SonNode first;
        public Node(int data){
            this.data = data;
            this.first = null;
        }

    }

    private int treeSize = 100;
    //ʹ��һ��Node[]��������¼����������нڵ�
    private Node [] nodes;
    //��¼�ڵ���Ŀ
    private int nodeNums;

    public static class SonNode{//�ӽڵ���
        //��¼��ǰ�ڵ��λ��
        private int pos;
        //�ӽڵ���м�¼����һ���ӽڵ�Ķ���
        private SonNode next;
        public SonNode(int pos , SonNode next){
            this.pos = pos;//��ǰ�ڵ�λ��
            this.next = next;//��һ�ڵ�λ��
        }
    }
    //Ϊָ���ڵ�����ӽڵ�

    /**
     *
     * @param data:�ýڵ�����
     * @param parent���ýڵ�ĸ��׽ڵ�
     */

    public Node  addNode(int data , Node parent){
        SonNode node=null;
        for(int i=0;i<treeSize;i++){
            if(nodes[i]==null){//��λ��
                nodes[i]=new Node(data);
                if(parent.first==null){//��ǰ���ڵ��� ��û���ӽڵ���
                    node=new SonNode(i,null);
                    parent.first=node;//������ӽڵ����ҽӵ���ǰ�ĸ��ڵ���
                }else{//�������Ѿ��������ӽڵ�������Ҫ�������������ҵ����һ���ӽڵ� �ٹҽ�
                    SonNode next=parent.first;
                    while(next.next!=null){

                        next=next.next;
                    }
                    node=new SonNode(i,null);
                    next.next=node;//�ҽӵ�����ӽڵ�����

                }
                this.nodeNums++;
                return nodes[i];
            }


        }
        return null;

    }

    /**
     *
     * @param parent:��Ҫ�ҵ��Ǹ����ڵ�
     * @return���ӽڵ㼯��
     */
    //����ָ���ڵ㣨��Ҷ�ӽڵ㣩�������ӽڵ㡣
    public List<Node> getChildren(Node parent){
        List<Node> list=new ArrayList<Node>();
        SonNode next=parent.first;

        while(next!=null){
            list.add(nodes[next.pos]);
            next=next.next;
        }

        return list;
    }

    /**
     *
     * @param node Ҫ�ҵ���ȵĸýڵ�
     * @return ���
     */
    //���ظýڵ����ȣ�����һ���ݹ鷽����ÿ�����������Ϊ������������������ + 1
    public int deep(Node node){
        if(node.first==null){//û���ӽڵ�
            return 1;
        }else{//
            int max=0;
            SonNode next=node.first;
            while( next!=null ){

                int tmp=deep(nodes[next.pos]);//�ҵ���node��������������Ӧ�Ľڵ�
                if(tmp>max){
                    max=tmp;
                }
                next=next.next;
            }

            return max+1;
        }

    }
    //���ظ��ڵ�
    public Node root(){
        //���ظ��ڵ�
        return nodes[0];
    }


    public B0(int data){
        nodes=new Node[treeSize];
        nodes[0]=new Node(0);//�γɵ�һ���ڵ�
        nodeNums++;
    }
}
