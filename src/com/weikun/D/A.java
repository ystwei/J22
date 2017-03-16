package com.weikun.D;

/**
 * Created by Administrator on 2017/3/16.
 * AVL平衡二叉树
 */
public class A {
    private static int arr[]= {3,2,1,4,5,6,7,10,9,8};

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
            tree=new AVLTreeNode(key,tree.left,tree.right);

        }
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

        }else{


        }
    }





}
