package com.weikun.D;

import org.junit.Test;

/**
 * Created by Administrator on 2017/3/16.
 * AVL平衡二叉树
 */
public class A {
    private  int arr[]= {3,2,1,4,5,6,7,10,9,8};

    private AVLTreeNode mRoot;    // 根结点

    class AVLTreeNode {
        int key;                // 关键字(键值)
        int height;         // 当前节点中子节点的最大高度
        AVLTreeNode left;    // 左孩子
        AVLTreeNode right;    // 右孩子

        public AVLTreeNode(int key, AVLTreeNode left, AVLTreeNode right) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }

    /*
	 * 获取树的高度
	 */
    private int height(AVLTreeNode tree) {

        if(tree!=null){
            return tree.height;
        }
        return 0;
    }
    //计算两个数 a b的最大值
    public int max(int a,int b){
        return a>b?a:b;
    }

    /*
	 * LL：左左对应的情况(左单旋转--右顺时针旋转)。
	 *         2
	 *     A                     B
	 *    /  1                 /   \
	 *   B   -->>LL--->>      X     A
	 *  /  \                       /
	 * X    C                     C
	 * 返回值：旋转后的根节点
	 * (插入的节点是左子树的左边节点)
	 */
    private AVLTreeNode leftLeftRotation(AVLTreeNode k2) {//K2是A
        AVLTreeNode k1=k2.left;//B
        //B的右链C一定付给A当左链，因为C比A小
        k2.left=k1.right;
        k1.right=k2;//A当做B的右链
        //计算每个子节点的高度，取大的送到根节点的heigh下
        k2.height=this.max(height(k2.left),height(k2.right))+1;
        k1.height=this.max(height(k1.left),k2.height)+1;
        return k1;
    }


    /*
	 * RR：右右对应的情况(右单旋转)。
	 *
	 *      -2                              0
	 *     A                               B
	 *      \ -1                         /0  \0
	 *       B         -->>RR--->>      A     X
	 *     /  \ 0                        \
	 *    C    X                          C
	 *
	 *(插入节点是右子树的右边节点)
	 * 返回值：旋转后的根节点
	 */
    private AVLTreeNode    rightRightRotation(AVLTreeNode k1) {//k1:A

        AVLTreeNode k2=k1.right;//B
        k1.right=k2.left;
        k2.left=k1;

        k1.height=this.max(height(k1.left),height(k1.right))+1;
        k2.height=this.max(height(k2.right),k1.height)+1;
        return k2;
    }

    /*
	 * LR：左右对应的情况(左双旋转)。--对应先RR-再LL
	 *(插入节点是左子树的右边节点)
	 * 返回值：旋转后的根节点
	 *
	 *        A             A               X
	 *      /             /               /  \
	 *     B   =》RR     X  =》LL        B    A
	  *    \            /
	  *     X          B
	 */
    private AVLTreeNode leftRightRotation(AVLTreeNode k3) {//A

            k3.left=this.rightRightRotation(k3.left);
            return this.leftLeftRotation(k3);
    }

    /*
	 * RL：右左对应的情况(右双旋转)。对应 LL-RR
	 *(插入节点是右子树的左边节点)
	 * 返回值：旋转后的根节点
	 *               A           A                    X
	 *               \            \                  /  \
	 *               B   => LL     X   =>    RR     A    B
	 *              /               \
	 *             X                 B
	 *
	 */
    private AVLTreeNode rightLeftRotation(AVLTreeNode k1) {//A

            k1.right=this.leftLeftRotation(k1.right);

            return this.rightRightRotation(k1);
    }


    /*
	 * 将结点插入到AVL树中，并返回根节点	 *
	 * 参数说明：
	 *     tree AVL树的根结点
	 *     key 插入的结点的键值
	 * 返回值：
	 *     根节点
	 */
    private AVLTreeNode insert(AVLTreeNode tree, int key) {
        if(tree==null){//如果没有节点，则创建个节点
            tree=new AVLTreeNode(key,null,null);

        }else{
            if(key<tree.key){//一定在左子树上继续寻找，
                tree.left=this.insert(tree.left,key);
                //计算是否打破平衡

                if(this.height(tree.left)-this.height(tree.right)==2){//打破平衡
                    if(key<tree.left.key){//哪一种形状
                        tree=this.leftLeftRotation(tree);
                    }else{

                        tree=this.leftRightRotation(tree);
                    }

                }

            }else if(key>tree.key){//一定在右子树上继续寻找，
                tree.right=this.insert(tree.right,key);


                if(height(tree.right)-height(tree.left)==2){//高度打破平衡
                    if(key<tree.right.key){
                        tree=this.rightLeftRotation(tree);
                    }else{

                        tree=this.rightRightRotation(tree);
                    }

                }
            }else{
                System.out.println("不可以添加重复的节点");
                return null;
            }

        }

        tree.height=this.max(height(tree.left),height(tree.right))+1;
        return tree;
    }


    /*
	 * 前序遍历"AVL树"
	 * DLR
	 */
    private void preOrder(AVLTreeNode tree) {
        if(tree != null) {
            System.out.print(tree.key+" ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    /*
	 * 后序遍历"AVL树"
	 * LRD
	 */
    private void postOrder(AVLTreeNode tree) {
        if(tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(tree.key+" ");
        }
    }

    /*
	 * 中序遍历"AVL树"
	 * LDR
	 */
    private void inOrder(AVLTreeNode tree) {
        if(tree != null){
            inOrder(tree.left);
            System.out.print(tree.key+" ");
            inOrder(tree.right);
        }
    }
    @Test
    public void test(){
        for(int i=0;i<this.arr.length;i++){
            this.mRoot=this.insert(this.mRoot,arr[i]);
            System.out.printf("%d ",arr[i]);
        }
        System.out.println();
        preOrder(this.mRoot);
        System.out.println();

        postOrder(this.mRoot);
    }


}
