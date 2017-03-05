package com.weikun.B;

import org.junit.Test;

/**
 * Created by Administrator on 2017/3/5.
 * //二叉搜索树
 */
public class G {
    private   int arr[] = {1,5,4,3,2,6};

    /*
	 * 		    1
	 * 		     \
	 *            5
	 *          /   \
	 *         4     6
	 *        /
	 *       3
	 *      /
	 *     2
	 */
    @Test
    public void test() {
        int i, ilen;


        System.out.print("== 依次添加: ");
        ilen = arr.length;
        for(i=0; i<ilen; i++) {
            System.out.print(arr[i]+" ");
            BSTNode node=new BSTNode(arr[i],null,null,null);
            this.insert(node);
        }
        System.out.print("\n== 前序遍历DLR: ");
        this.preOrder(this.mRoot);

        System.out.print("\n== 中序遍历LDR: ");
        this.middleOrder(this.mRoot);

        System.out.print("\n== 后序遍历LRD: ");
        this.backOrder(this.mRoot);
        System.out.println();

        System.out.print("\n== 删除节点: "+ 5);

        BSTNode node=this.search(this.mRoot,5);
        this.remove(node);

        System.out.print("\n== 中序遍历LDR: ");
        this.middleOrder(this.mRoot);

    }

    /*递归实现，查找二叉树x中键值为key的节点
	 *
	 */
    private BSTNode search(BSTNode x,int key){
        if(x==null){
            return x;
        }
        int cmp=key-x.key;
        if(cmp<0){//小于当前节点的值，将在左树中查
            return search(x.left,key);
        }else if(cmp>0){//大于当前节点的值，将在右树中查
            return search(x.right,key);
        }else{
            return x;
        }
    }



    private BSTNode mRoot;//根节点

    public class BSTNode{
        int key;//关键字(键值)
        BSTNode left;//左孩子
        BSTNode right;//右孩子
        BSTNode parent;//父节点
        public BSTNode(int key,BSTNode parent,BSTNode left,BSTNode right){
            this.key=key;
            this.parent=parent;
            this.left=left;
            this.right=right;
        }
    }
    //前序遍历 DLR
    private void preOrder(BSTNode tree){
        if(tree!=null){
            System.out.print(tree.key+":");
            this.preOrder(tree.left);
            this.preOrder(tree.right);
        }

    }

    //中序遍历 LDR
    private void middleOrder(BSTNode tree){
        if(tree!=null){
            this.middleOrder(tree.left);
            System.out.print(tree.key);
            this.middleOrder(tree.right);
        }

    }


    //后序遍历 LRD
    private void backOrder(BSTNode tree){
        if(tree!=null){
            this.backOrder(tree.left);

            this.backOrder(tree.right);
            System.out.print(tree.key);
        }

    }

    /**
     * 找到tree的最大节点。一定在右链找
     * @param tree
     * @return
     */
    private BSTNode maximum(BSTNode tree){

        if(tree!=null){

            while(tree.right!=null){
                tree=tree.right;
            }
        }
        return tree;

    }


    /**
     * 找到tree的最小节点。一定在左链找
     * @param tree
     * @return
     */
    private BSTNode min(BSTNode tree){

        if(tree!=null){

            while(tree.left!=null){
                tree=tree.left;
            }
        }
        return tree;

    }

    /*
	 * //查找该节点(x)的前驱节点，即查找二叉树中数据值小于该节点的最大节点
	 */
    public BSTNode predecessor(BSTNode x){
        //一定在左链求最大值
        //1如果x存在左孩子
        if(x.left!=null){
           return  this.maximum(x.left);
        }
        //2x没有左孩子，a。x是一个右孩子，前驱就是父亲节点
        if(x.parent==null){
            System.out.println("没有前驱节点！");
            return null;

        }

        //找到他的父亲
        BSTNode y=x.parent;

        while(y!=null&&x==y.left){//x是y的左孩子，且y存在
            x=y;
            y=y.parent;
        }
        return y;


    }


    /*后继节点
	 * 找结点x的后继节点，即，查找二叉树中数据值大于该节点的最小节点
	 */
    public BSTNode successor(BSTNode x){
        if(x.right!=null){//x存在右孩子,是其右链上的最小节点
            return this.min(x.right);
        }

        BSTNode y=x.parent;

        while(y!=null && x==y.right){
            x=y;
            y=y.parent;

        }

        return y;

    }

    /* 将节点插入到二叉树中
	 * tree：二叉树
	 * z：插入的节点 */
    private void insert(BSTNode z){
        int cmp=0;
        BSTNode y=null;
        BSTNode x=this.mRoot;//根节点

        while(x!=null){
            cmp=x.key-z.key;
            y=x;//将要插入那个节点得位置
            if(cmp>0){//新节点比父节点大，应该在右链
                x=x.left;

            }else if(cmp<0){//新节点比父节点大，应该在左链
                x=x.right;

            }else{
                return ;//不允许相等
            }
        }

        //y将要插入那个节点得位置

        z.parent=y;//y是新节点的父亲

        if(y==null){
            this.mRoot=z;
        }else{//非根节点
            cmp=z.key-y.key;
            if(cmp>0){
                y.right=z;
            }else if(cmp<0){
                y.left=z;
            }else{

                return ;
            }

        }


    }


    /*
	 * 删除节点z，并返回被删除的节点
	 * bst：二叉树
	 * z删除的节点
	 * 1.没有儿子，即为叶结点。直接把父结点的对应儿子指针设为NULL，就OK了。
	   2.只有一个儿子。那么把父结点的相应儿子指针指向儿子的独生子，删除儿子结点也OK了。
	   3.有两个儿子。这是最麻烦的情况，因为你删除节点之后，还要保证满足搜索二叉树的结构。其实也比较容易，
	   我们可以选择左儿子中的最大元素或者右儿子中的最小元素放到待删除节点的位置，就可以保证结构的不变。
	   当然，你要记得调整子树，毕竟又出现了节点删除。习惯上大家选择左儿子中的最大元素，其实选择右儿子的最小元素也一样，
	   没有任何差别，只是人们习惯从左向右。这里咱们也选择左儿子的最大元素，将它放到待删结点的位置。
	   左儿子的最大元素其实很好找，只要顺着左儿子不断的去搜索右子树就可以了，直到找到一个没有右子树的结点。那就是最大的了。
	 */
    private BSTNode remove(BSTNode z){

        BSTNode y=null;
        BSTNode x=null;
        if(z.left==null || z.right==null){
            y=z;

        }else{//3左右孩子都有
            y=this.successor(z);//找到其后继节点
        }
        if(y.left!=null){
            x=y.left;

        }else{
            x=y.right;

        }

        if(x!=null){
            x.parent=y.parent;//把他的后继的父亲充当左子有右子的父亲
        }

        if(y.parent==null){
            this.mRoot=x;
        }else if( y==y.parent.left){
            y.parent.left=x;

        }else{
            y.parent.right=x;
        }

        if(y!=z){
            z.key=y.key;
        }

        return y;
    }



}



