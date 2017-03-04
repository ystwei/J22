package com.weikun.B;

import org.junit.Test;

/**
 * Created by Administrator on 2017/3/4.
 * //二叉树--顺序存储
 */
public class C {
    @Test
    public void test(){
        C0 c0=new C0();
        c0.add(0,1,true);
        c0.add(0,2,false);
        c0.add(1,3,true);
        c0.add(1,4,false);
        System.out.println(c0.left(1));
        System.out.println(c0.right(1));

    }


}
class C0{

    private Integer[] datas;
    private int DEFAULT_DEEP = 8;
    //保存该树的深度
    private int deep;
    private int arraySize;//二叉树总节点的个数
    //以默认的深度来创建二叉树


    //以默认的深度来创建二叉树
    public C0(){
        this.deep = DEFAULT_DEEP;
        //二叉树总节点的个数
        this.arraySize = (int)Math.pow(2 , deep) - 1;//是个公式,按满二叉树开的节点个数
        datas = new Integer[arraySize];
        datas[0] = 0;//根
    }


    //以指定深度来创建二叉树
    public C0(int deep){
        this.deep = deep;
        this.arraySize = (int)Math.pow(2 , deep) - 1;
        datas = new Integer[arraySize];
    }
    //以指定深度,指定根节点创建二叉树
    public C0(int deep , int data){
        this.deep = deep;
        this.arraySize = (int)Math.pow(2 , deep) - 1;
        datas = new Integer[arraySize];
        datas[0] = data;//根
    }

    /**
     *
     * @param index:指定的父亲索引
     * @param data：该节点数据
     * @param left：是否是左节点
     */
    public void add(int index,int data,boolean left){
        if(datas[index]==null){
            System.out.println("该父亲节点不存在，不能添加");
            return;
        }
        if(2*index+1>=this.arraySize){//左子结点，越界

            System.out.println("子节点数目已经越界了！");
            return;
        }
        if(left){//左子
            datas[2*index+1]=data;

        }else{

            datas[2*index+2]=data;
        }


    }

    /**
     *
     * @param index:父亲的索引号
     * @return 返回左子结点
     */
    public int left(int index){

        return   datas[2*index+1];
    }

    /**
     *
     * @param index:父亲的索引号
     * @return 返回右子结点
     */
    public int right(int index){

        return   datas[2*index+2];
    }
}