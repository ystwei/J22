package com.weikun.B;

import org.junit.Test;

/**
 * Created by Administrator on 2017/3/5.
 * //����������
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


        System.out.print("== �������: ");
        ilen = arr.length;
        for(i=0; i<ilen; i++) {
            System.out.print(arr[i]+" ");
            BSTNode node=new BSTNode(arr[i],null,null,null);
            this.insert(node);
        }
        System.out.print("\n== ǰ�����DLR: ");
        this.preOrder(this.mRoot);

        System.out.print("\n== �������LDR: ");
        this.middleOrder(this.mRoot);

        System.out.print("\n== �������LRD: ");
        this.backOrder(this.mRoot);
        System.out.println();

        System.out.print("\n== ɾ���ڵ�: "+ 5);

        BSTNode node=this.search(this.mRoot,5);
        this.remove(node);

        System.out.print("\n== �������LDR: ");
        this.middleOrder(this.mRoot);

    }

    /*�ݹ�ʵ�֣����Ҷ�����x�м�ֵΪkey�Ľڵ�
	 *
	 */
    private BSTNode search(BSTNode x,int key){
        if(x==null){
            return x;
        }
        int cmp=key-x.key;
        if(cmp<0){//С�ڵ�ǰ�ڵ��ֵ�����������в�
            return search(x.left,key);
        }else if(cmp>0){//���ڵ�ǰ�ڵ��ֵ�����������в�
            return search(x.right,key);
        }else{
            return x;
        }
    }



    private BSTNode mRoot;//���ڵ�

    public class BSTNode{
        int key;//�ؼ���(��ֵ)
        BSTNode left;//����
        BSTNode right;//�Һ���
        BSTNode parent;//���ڵ�
        public BSTNode(int key,BSTNode parent,BSTNode left,BSTNode right){
            this.key=key;
            this.parent=parent;
            this.left=left;
            this.right=right;
        }
    }
    //ǰ����� DLR
    private void preOrder(BSTNode tree){
        if(tree!=null){
            System.out.print(tree.key+":");
            this.preOrder(tree.left);
            this.preOrder(tree.right);
        }

    }

    //������� LDR
    private void middleOrder(BSTNode tree){
        if(tree!=null){
            this.middleOrder(tree.left);
            System.out.print(tree.key);
            this.middleOrder(tree.right);
        }

    }


    //������� LRD
    private void backOrder(BSTNode tree){
        if(tree!=null){
            this.backOrder(tree.left);

            this.backOrder(tree.right);
            System.out.print(tree.key);
        }

    }

    /**
     * �ҵ�tree�����ڵ㡣һ����������
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
     * �ҵ�tree����С�ڵ㡣һ����������
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
	 * //���Ҹýڵ�(x)��ǰ���ڵ㣬�����Ҷ�����������ֵС�ڸýڵ�����ڵ�
	 */
    public BSTNode predecessor(BSTNode x){
        //һ�������������ֵ
        //1���x��������
        if(x.left!=null){
           return  this.maximum(x.left);
        }
        //2xû�����ӣ�a��x��һ���Һ��ӣ�ǰ�����Ǹ��׽ڵ�
        if(x.parent==null){
            System.out.println("û��ǰ���ڵ㣡");
            return null;

        }

        //�ҵ����ĸ���
        BSTNode y=x.parent;

        while(y!=null&&x==y.left){//x��y�����ӣ���y����
            x=y;
            y=y.parent;
        }
        return y;


    }


    /*��̽ڵ�
	 * �ҽ��x�ĺ�̽ڵ㣬�������Ҷ�����������ֵ���ڸýڵ����С�ڵ�
	 */
    public BSTNode successor(BSTNode x){
        if(x.right!=null){//x�����Һ���,���������ϵ���С�ڵ�
            return this.min(x.right);
        }

        BSTNode y=x.parent;

        while(y!=null && x==y.right){
            x=y;
            y=y.parent;

        }

        return y;

    }

    /* ���ڵ���뵽��������
	 * tree��������
	 * z������Ľڵ� */
    private void insert(BSTNode z){
        int cmp=0;
        BSTNode y=null;
        BSTNode x=this.mRoot;//���ڵ�

        while(x!=null){
            cmp=x.key-z.key;
            y=x;//��Ҫ�����Ǹ��ڵ��λ��
            if(cmp>0){//�½ڵ�ȸ��ڵ��Ӧ��������
                x=x.left;

            }else if(cmp<0){//�½ڵ�ȸ��ڵ��Ӧ��������
                x=x.right;

            }else{
                return ;//���������
            }
        }

        //y��Ҫ�����Ǹ��ڵ��λ��

        z.parent=y;//y���½ڵ�ĸ���

        if(y==null){
            this.mRoot=z;
        }else{//�Ǹ��ڵ�
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
	 * ɾ���ڵ�z�������ر�ɾ���Ľڵ�
	 * bst��������
	 * zɾ���Ľڵ�
	 * 1.û�ж��ӣ���ΪҶ��㡣ֱ�ӰѸ����Ķ�Ӧ����ָ����ΪNULL����OK�ˡ�
	   2.ֻ��һ�����ӡ���ô�Ѹ�������Ӧ����ָ��ָ����ӵĶ����ӣ�ɾ�����ӽ��ҲOK�ˡ�
	   3.���������ӡ��������鷳���������Ϊ��ɾ���ڵ�֮�󣬻�Ҫ��֤���������������Ľṹ����ʵҲ�Ƚ����ף�
	   ���ǿ���ѡ��������е����Ԫ�ػ����Ҷ����е���СԪ�طŵ���ɾ���ڵ��λ�ã��Ϳ��Ա�֤�ṹ�Ĳ��䡣
	   ��Ȼ����Ҫ�ǵõ����������Ͼ��ֳ����˽ڵ�ɾ����ϰ���ϴ��ѡ��������е����Ԫ�أ���ʵѡ���Ҷ��ӵ���СԪ��Ҳһ����
	   û���κβ��ֻ������ϰ�ߴ������ҡ���������Ҳѡ������ӵ����Ԫ�أ������ŵ���ɾ����λ�á�
	   ����ӵ����Ԫ����ʵ�ܺ��ң�ֻҪ˳������Ӳ��ϵ�ȥ�����������Ϳ����ˣ�ֱ���ҵ�һ��û���������Ľ�㡣�Ǿ��������ˡ�
	 */
    private BSTNode remove(BSTNode z){

        BSTNode y=null;
        BSTNode x=null;
        if(z.left==null || z.right==null){
            y=z;

        }else{//3���Һ��Ӷ���
            y=this.successor(z);//�ҵ����̽ڵ�
        }
        if(y.left!=null){
            x=y.left;

        }else{
            x=y.right;

        }

        if(x!=null){
            x.parent=y.parent;//�����ĺ�̵ĸ��׳䵱���������ӵĸ���
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



