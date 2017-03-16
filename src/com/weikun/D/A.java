package com.weikun.D;

/**
 * Created by Administrator on 2017/3/16.
 * AVLƽ�������
 */
public class A {
    private static int arr[]= {3,2,1,4,5,6,7,10,9,8};

    private AVLTreeNode mRoot;    // �����

    class AVLTreeNode {
        int key;                // �ؼ���(��ֵ)
        int height;         // ��ǰ�ڵ����ӽڵ�����߶�
        AVLTreeNode left;    // ����
        AVLTreeNode right;    // �Һ���

        public AVLTreeNode(int key, AVLTreeNode left, AVLTreeNode right) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }

    /*
	 * ��ȡ���ĸ߶�
	 */
    private int height(AVLTreeNode tree) {

        if(tree!=null){
            return tree.height;
        }
        return 0;
    }
    //���������� a b�����ֵ
    public int max(int a,int b){
        return a>b?a:b;
    }

    /*
	 * LL�������Ӧ�����(����ת--��˳ʱ����ת)��
	 *         2
	 *     A                     B
	 *    /  1                 /   \
	 *   B   -->>LL--->>      X     A
	 *  /  \                       /
	 * X    C                     C
	 * ����ֵ����ת��ĸ��ڵ�
	 * (����Ľڵ�������������߽ڵ�)
	 */
    private AVLTreeNode leftLeftRotation(AVLTreeNode k2) {//K2��A
        AVLTreeNode k1=k2.left;//B
        //B������Cһ������A����������ΪC��AС
        k2.left=k1.right;
        k1.right=k2;//A����B������
        //����ÿ���ӽڵ�ĸ߶ȣ�ȡ����͵����ڵ��heigh��
        k2.height=this.max(height(k2.left),height(k2.right))+1;
        k1.height=this.max(height(k1.left),k2.height)+1;
        return k1;
    }


    /*
	 * RR�����Ҷ�Ӧ�����(�ҵ���ת)��
	 *
	 *      -2                              0
	 *     A                               B
	 *      \ -1                         /0  \0
	 *       B         -->>RR--->>      A     X
	 *     /  \ 0                        \
	 *    C    X                          C
	 *
	 *(����ڵ������������ұ߽ڵ�)
	 * ����ֵ����ת��ĸ��ڵ�
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
	 * LR�����Ҷ�Ӧ�����(��˫��ת)��--��Ӧ��RR-��LL
	 *(����ڵ������������ұ߽ڵ�)
	 * ����ֵ����ת��ĸ��ڵ�
	 *
	 *        A             A               X
	 *      /             /               /  \
	 *     B   =��RR     X  =��LL        B    A
	  *    \            /
	  *     X          B
	 */
    private AVLTreeNode leftRightRotation(AVLTreeNode k3) {//A

            k3.left=this.rightRightRotation(k3.left);
            return this.leftLeftRotation(k3);
    }

    /*
	 * RL�������Ӧ�����(��˫��ת)����Ӧ LL-RR
	 *(����ڵ�������������߽ڵ�)
	 * ����ֵ����ת��ĸ��ڵ�
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
	 * �������뵽AVL���У������ظ��ڵ�	 *
	 * ����˵����
	 *     tree AVL���ĸ����
	 *     key ����Ľ��ļ�ֵ
	 * ����ֵ��
	 *     ���ڵ�
	 */
    private AVLTreeNode insert(AVLTreeNode tree, int key) {
        if(tree==null){//���û�нڵ㣬�򴴽����ڵ�
            tree=new AVLTreeNode(key,tree.left,tree.right);

        }
        if(key<tree.key){//һ�����������ϼ���Ѱ�ң�
            tree.left=this.insert(tree.left,key);
            //�����Ƿ����ƽ��

            if(this.height(tree.left)-this.height(tree.right)==2){//����ƽ��
                if(key<tree.left.key){//��һ����״
                    tree=this.leftLeftRotation(tree);
                }else{

                    tree=this.leftRightRotation(tree);
                }

            }

        }else{


        }
    }





}
