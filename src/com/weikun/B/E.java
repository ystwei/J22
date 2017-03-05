package com.weikun.B;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * Created by Administrator on 2017/3/5.
 * 二叉树的先序 中序 后序遍历
 */
public class E {
    public static void main(String[] args) {
        //初始化二叉树
    /*
	 * 				      1
	 * 				/		   \
	 * 			 2              3
	 * 			/ \          /     \
	 * 		   4    5      6        7
	 *             / \       \     /
	 * 			  8   9       10   11
	 *
	 */

        TreeNode four = new TreeNode(4, null, null);
        TreeNode eight = new TreeNode(8, null, null);
        TreeNode nine = new TreeNode(9, null, null);
        TreeNode ten = new TreeNode(10, null, null);
        TreeNode ele = new TreeNode(11, null, null);


        TreeNode fiv = new TreeNode(5, eight, nine);
        TreeNode six = new TreeNode(6, null, ten);
        TreeNode sev = new TreeNode(7, ele, null);


        TreeNode two = new TreeNode(2, four, fiv);
        TreeNode thr = new TreeNode(3, six, sev);

        TreeNode one = new TreeNode(1, two, thr);

        one.hou(one);
        System.out.println("----------");
        one.xian(one);
        System.out.println("----------");
        one.zhong(one);
        System.out.println("----------");
        one.deep(one);

        System.out.println("----------");
        one.breadth(one);

    }
}


class TreeNode {
    private int data;
    private TreeNode leftNode;
    private TreeNode rightNode;

    //广度
    public void breadth(TreeNode root){
        ArrayDeque<TreeNode> a=new ArrayDeque<TreeNode>();

        a.add(root);

        while(!a.isEmpty()){

            TreeNode node=a.remove();

            System.out.print(node.data+":");

            if(node.leftNode!=null){
                a.add(node.getLeftNode());
            }

            if(node.rightNode!=null){
                a.add(node.getRightNode());
            }
        }

    }

    public void deep(TreeNode root){

        Stack<TreeNode > stack=new Stack<TreeNode> ();
        stack.push(root);//先压根

        while(!stack.isEmpty()){

            TreeNode node=stack.pop();
            System.out.print(node.data+":");
            if(node.rightNode!=null){

                stack.push(node.rightNode);

            }
            if(node.leftNode!=null){
                stack.push(node.leftNode);
            }
        }


    }
    //DLR
    public void xian(TreeNode node){
        printNode(node);

        if(node.leftNode!=null){
            xian(node.getLeftNode());
        }

        if(node.rightNode!=null){
            xian(node.getRightNode());
        }

    }

    //LDR
    public void zhong(TreeNode node){


        if(node.leftNode!=null){
            zhong(node.getLeftNode());
        }

        printNode(node);

        if(node.rightNode!=null){
            zhong(node.getRightNode());
        }

    }
    //LRD
    public void hou(TreeNode node){


        if(node.leftNode!=null){
            hou(node.getLeftNode());
        }

        if(node.rightNode!=null){
            hou(node.getRightNode());
        }
        printNode(node);
    }


    public void printNode(TreeNode node){

        System.out.print(node.data+":");
    }
    public TreeNode(int data, TreeNode leftNode, TreeNode rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public int getData() {
        return data;

    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }


}
