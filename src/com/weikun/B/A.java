package com.weikun.B;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/4.
 * ���ڵ��ʾ����ʾ��
 */
public class A {
    @Test
    public void test(){
        A0 a0=new A0(0);//���ڵ�

        A0.Node a1=a0.addNode(1,a0.root());

        A0.Node a2=a0.addNode(2,a1);

        A0.Node a3=a0.addNode(3,a0.root());

        List<A0.Node> list=a0.getChildren(a1);


        for(A0.Node node :list){
            System.out.println(node.data);
        }
        System.out.println(a0.deep());

    }



}
class A0{
    //���ڵ������
    private int treeSize =100;
    //ʹ��һ��Node[]��������¼����������нڵ�
    private Node[] nodes;
    //��¼�ڵ���
    private int nodeNums;
    public A0(int data){
        nodes=new Node[treeSize];//���ٿռ�
        nodes[0]=new Node(data,-1);//���ɵ�һ���ڵ㣬û�и���
        nodeNums++;//�����ۼ�
    }

    //���ݽڵ㣬�ҵ����������е�������
    public int pos(Node node){

        for(int i=0;i<nodes.length;i++){
            if(nodes[i]==node){
                return i;
            }

        }
        return -1;
    }
    //���ظ��ڵ�
    public Node root(){
        return nodes[0];
    }
    /**
     *
     * @param parent:��Ҫ��ѯ�ĸ��׽ڵ�
     * @return�����еĶ��ӽڵ㼯��
     */

    //����ָ���ڵ㣨��Ҷ�ӽڵ㣩�������ӽڵ㡣
    public List<Node> getChildren(Node parent){
        List<Node> list=new ArrayList<Node>();
        for(int i=0;i<treeSize;i++){
            if(nodes[i]!=null&&nodes[i].parent==pos(parent)){

                list.add(nodes[i]);
            }

        }
        return list;
    }

    //���ظ��������:���нڵ�������ֵ
    public int deep(){
        int max=0;
        //��������Χ���ҽڵ����
        for(int i=0;i<this.treeSize&&nodes[i]!=null;i++){
            int def=1;//��ʼ�����ӣ�ÿ�ҵ�һ�����׶���Ҫ��������ۼ�

            int m=nodes[i].parent;//�ҵ��丸������
            while( m!=-1&&nodes[m]!=null ){//֤�����״���

                m=nodes[m].parent;//�����������ĸ��ף�
                def++;
            }
            if(max<def){//���ֵ����ȥ
                max=def;
            }

        }
        return max;
    }
    //Ϊָ�����ڵ�����ӽڵ�

    /**
     *
     * @param data:�ýڵ�����
     * @param parent���ýڵ�ĸ�����˭
     */
    public Node addNode(int data , Node parent){
        for(int i=0;i<this.treeSize;i++){

            if(nodes[i]==null){
                nodes[i]=new Node(data,this.pos(parent));
                nodeNums++;
                return nodes[i];
            }


        }
        return null;

    }
    public static class Node{
        //�ڵ�����
        int data;
        //��¼�丸�ڵ��λ��
        int parent;

        public Node(int data , int parent){
            this.data = data;
            this.parent = parent;
        }
        public String toString(){
            return "���ڵ��ʾ��[data=" + data + ", parent="+ parent + "]";
        }
    }

}



