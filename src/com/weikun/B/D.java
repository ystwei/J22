package com.weikun.B;

/**
 * Created by Administrator on 2017/3/5.
 * ��������洢
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
    //ÿ���ڵ�
    public static class TreeNode{
        int data;//��ǰ�ڵ�����
        TreeNode left;//�ýڵ����ڵ��ַ
        TreeNode right;//�ýڵ���ҽڵ��ַ
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
    //��Ĭ�ϵĹ�����������������
    public D0(){
        this.root = new TreeNode(0);
    }
    //��ָ����Ԫ��������������
    public D0(int data){
        this.root = new TreeNode(data);
    }
    public int left(TreeNode parent){
        if(parent==null){
            System.out.println("û�и��ڵ㣬���ܲ�ѯ");
            return -1;
        }

        return parent.left==null?null:parent.left.data;
    }

    public int right(TreeNode parent){
        if(parent==null){
            System.out.println("û�и��ڵ㣬���ܲ�ѯ");
            return -1;
        }

        return parent.right==null?null:parent.right.data;
    }
    /**
     *
     * @param parent:��ǰ�ڵ�������ĸ����ڵ�
     * @param data:��ǰ�ڵ�ֵ
     * @param isleft:�Ǹ��ڵ��������
     */
    public TreeNode addNode(TreeNode parent,int data,boolean isleft){
        if(parent==null){
            System.out.println("û�и��ڵ㣬�������");
            return null;
        }
        if(isleft &&parent.left!=null){
            System.out.println("�Ѿ������ˣ��������");
            return null;
        }
        if(!isleft &&parent.right!=null){
            System.out.println("�Ѿ������ˣ��������");
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
