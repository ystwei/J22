package com.weikun.B;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/4.
 * 父节点表示法表示树
 */
public class A {
    @Test
    public void test(){
        A0 a0=new A0(0);//根节点

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
    //树节点的数量
    private int treeSize =100;
    //使用一个Node[]数组来记录该树里的所有节点
    private Node[] nodes;
    //记录节点数
    private int nodeNums;
    public A0(int data){
        nodes=new Node[treeSize];//开辟空间
        nodes[0]=new Node(data,-1);//生成第一个节点，没有父亲
        nodeNums++;//种子累加
    }

    //根据节点，找到其在数组中的索引号
    public int pos(Node node){

        for(int i=0;i<nodes.length;i++){
            if(nodes[i]==node){
                return i;
            }

        }
        return -1;
    }
    //返回根节点
    public Node root(){
        return nodes[0];
    }
    /**
     *
     * @param parent:将要查询的父亲节点
     * @return：所有的儿子节点集合
     */

    //返回指定节点（非叶子节点）的所有子节点。
    public List<Node> getChildren(Node parent){
        List<Node> list=new ArrayList<Node>();
        for(int i=0;i<treeSize;i++){
            if(nodes[i]!=null&&nodes[i].parent==pos(parent)){

                list.add(nodes[i]);
            }

        }
        return list;
    }

    //返回该树的深度:树中节点的最大层次值
    public int deep(){
        int max=0;
        //不超过范围，且节点存在
        for(int i=0;i<this.treeSize&&nodes[i]!=null;i++){
            int def=1;//初始化种子，每找到一个父亲都需要对其进行累加

            int m=nodes[i].parent;//找到其父亲索引
            while( m!=-1&&nodes[m]!=null ){//证明父亲存在

                m=nodes[m].parent;//在往上找他的父亲，
                def++;
            }
            if(max<def){//最大值付过去
                max=def;
            }

        }
        return max;
    }
    //为指定父节点添加子节点

    /**
     *
     * @param data:该节点数据
     * @param parent：该节点的父亲是谁
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
        //节点数据
        int data;
        //记录其父节点的位置
        int parent;

        public Node(int data , int parent){
            this.data = data;
            this.parent = parent;
        }
        public String toString(){
            return "父节点表示法[data=" + data + ", parent="+ parent + "]";
        }
    }

}



