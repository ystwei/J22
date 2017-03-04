package com.weikun.B;

import org.junit.Test;

/**
 * Created by Administrator on 2017/3/4.
 * //������--˳��洢
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
    //������������
    private int deep;
    private int arraySize;//�������ܽڵ�ĸ���
    //��Ĭ�ϵ����������������


    //��Ĭ�ϵ����������������
    public C0(){
        this.deep = DEFAULT_DEEP;
        //�������ܽڵ�ĸ���
        this.arraySize = (int)Math.pow(2 , deep) - 1;//�Ǹ���ʽ,�������������Ľڵ����
        datas = new Integer[arraySize];
        datas[0] = 0;//��
    }


    //��ָ�����������������
    public C0(int deep){
        this.deep = deep;
        this.arraySize = (int)Math.pow(2 , deep) - 1;
        datas = new Integer[arraySize];
    }
    //��ָ�����,ָ�����ڵ㴴��������
    public C0(int deep , int data){
        this.deep = deep;
        this.arraySize = (int)Math.pow(2 , deep) - 1;
        datas = new Integer[arraySize];
        datas[0] = data;//��
    }

    /**
     *
     * @param index:ָ���ĸ�������
     * @param data���ýڵ�����
     * @param left���Ƿ�����ڵ�
     */
    public void add(int index,int data,boolean left){
        if(datas[index]==null){
            System.out.println("�ø��׽ڵ㲻���ڣ��������");
            return;
        }
        if(2*index+1>=this.arraySize){//���ӽ�㣬Խ��

            System.out.println("�ӽڵ���Ŀ�Ѿ�Խ���ˣ�");
            return;
        }
        if(left){//����
            datas[2*index+1]=data;

        }else{

            datas[2*index+2]=data;
        }


    }

    /**
     *
     * @param index:���׵�������
     * @return �������ӽ��
     */
    public int left(int index){

        return   datas[2*index+1];
    }

    /**
     *
     * @param index:���׵�������
     * @return �������ӽ��
     */
    public int right(int index){

        return   datas[2*index+2];
    }
}