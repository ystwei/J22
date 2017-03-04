package com.weikun.B;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/4.
 * 子节点链表示法
 */
public class B {
    @Test
    public void test(){

        B0 b0=new B0(0);
        B0.Node root=b0.root();//根节点

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

    //子节点
    public static class Node{
        int data;//该节点数据
        //记录第一个子节点:用于保存对该子节点链的引用，通过这种关系 ，可以记录树中节点之间的父子关系。
        SonNode first;
        public Node(int data){
            this.data = data;
            this.first = null;
        }

    }

    private int treeSize = 100;
    //使用一个Node[]数组来记录该树里的所有节点
    private Node [] nodes;
    //记录节点数目
    private int nodeNums;

    public static class SonNode{//子节点链
        //记录当前节点的位置
        private int pos;
        //子节点的中记录的下一个子节点的对象
        private SonNode next;
        public SonNode(int pos , SonNode next){
            this.pos = pos;//当前节点位置
            this.next = next;//下一节点位置
        }
    }
    //为指定节点添加子节点

    /**
     *
     * @param data:该节点数据
     * @param parent：该节点的父亲节点
     */

    public Node  addNode(int data , Node parent){
        SonNode node=null;
        for(int i=0;i<treeSize;i++){
            if(nodes[i]==null){//有位置
                nodes[i]=new Node(data);
                if(parent.first==null){//当前父节点中 还没有子节点链
                    node=new SonNode(i,null);
                    parent.first=node;//代表把子节点链挂接到当前的父节点上
                }else{//代表父亲已经存在了子节点链，需要遍历整个链，找到最后一个子节点 再挂接
                    SonNode next=parent.first;
                    while(next.next!=null){

                        next=next.next;
                    }
                    node=new SonNode(i,null);
                    next.next=node;//挂接到最后子节点链中

                }
                this.nodeNums++;
                return nodes[i];
            }


        }
        return null;

    }

    /**
     *
     * @param parent:将要找的那个父节点
     * @return：子节点集合
     */
    //返回指定节点（非叶子节点）的所有子节点。
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
     * @param node 要找到深度的该节点
     * @return 深度
     */
    //返回该节点的深度，这是一个递归方法：每棵子树的深度为其所有子树的最大深度 + 1
    public int deep(Node node){
        if(node.first==null){//没有子节点
            return 1;
        }else{//
            int max=0;
            SonNode next=node.first;
            while( next!=null ){

                int tmp=deep(nodes[next.pos]);//找到在node集合中索引所对应的节点
                if(tmp>max){
                    max=tmp;
                }
                next=next.next;
            }

            return max+1;
        }

    }
    //返回根节点
    public Node root(){
        //返回根节点
        return nodes[0];
    }


    public B0(int data){
        nodes=new Node[treeSize];
        nodes[0]=new Node(0);//形成第一个节点
        nodeNums++;
    }
}
