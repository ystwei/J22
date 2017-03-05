package com.weikun.B;

/**
 * Created by Administrator on 2017/3/5.
 * 二叉链表存储
 */
public class D {
    public static void main(String[] args) {
        D0 d0=new D0();

        D0.TreeNode d1=d0.addNode(d0.root,1,true);

        d0.addNode(d1,3,true);
        d0.addNode(d1,4,false);

        D0.TreeNode d2=d0.addNode(d0.root,2,false);

        d0.addNode(d2,5,true);
        d0.addNode(d2,6,false);

        System.out.println(d0.left(d2));
        System.out.println(d0.right(d2));
    }
}
class D0{
    //每个节点
    public static class TreeNode{
        int data;//当前节点数据
        TreeNode left;//该节点的左节点地址
        TreeNode right;//该节点的右节点地址
        public TreeNode(){
        }
        public TreeNode(int data){
            this.data = data;
        }
        public TreeNode(int data , TreeNode left, TreeNode right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode root;
    //以默认的构造器来创建二叉树
    public D0(){
        this.root = new TreeNode(0);
    }
    //以指定根元素来创建二叉树
    public D0(int data){
        this.root = new TreeNode(data);
    }
    public int left(TreeNode parent){
        if(parent==null){
            System.out.println("没有父节点，不能查询");
            return -1;
        }

        return parent.left==null?null:parent.left.data;
    }

    public int right(TreeNode parent){
        if(parent==null){
            System.out.println("没有父节点，不能查询");
            return -1;
        }

        return parent.right==null?null:parent.right.data;
    }
    /**
     *
     * @param parent:当前节点从属于哪个父节点
     * @param data:当前节点值
     * @param isleft:是父节点的左还是右
     */
    public TreeNode addNode(TreeNode parent,int data,boolean isleft){
        if(parent==null){
            System.out.println("没有父节点，不能添加");
            return null;
        }
        if(isleft &&parent.left!=null){
            System.out.println("已经有左了，不能添加");
            return null;
        }
        if(!isleft &&parent.right!=null){
            System.out.println("已经有右了，不能添加");
            return null;
        }
        TreeNode newnode=new TreeNode(data);
        if(isleft){
            parent.left=newnode;
        }else{
            parent.right=newnode;
        }
        return newnode;

    }

}
