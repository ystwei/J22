package com.weikun.B;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2017/3/5.
 * 哈夫曼树
 */
public class F {
    public static void main(String[] args) {

    }
    @Test
    public  void createTree(){
        //1先排序其权值
        List<Node > list=new ArrayList<Node>();

        list.add(new Node(1,2) );
        list.add(new Node(2,4) );
        list.add(new Node(3,5) );
        list.add(new Node(4,9) );
        int sum=0;

        while(list.size()>1){
            Collections.sort(list);
            Node left=list.get(0);
            Node right=list.get(1);

            Node parent=new Node(-1,left.getWeight()+right.getWeight());
            sum+=left.getWeight()+right.getWeight();
            parent.setLeft(left);
            parent.setRight(right);
            list.remove(left);
            list.remove(right);
            list.add(parent);

        }
        System.out.println(list.get(0).getWeight());

        System.out.println("WPL"+sum);



    }
}
class Node implements Comparable{
    public Node(int data,int weight){
        this.data=data;
        this.weight=weight;
    }
    private int data;
    private int weight;
    private Node left;
    private Node right;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public int compareTo(Object o) {
        Node n=(Node)o;

        return this.weight-n.weight;
    }
}