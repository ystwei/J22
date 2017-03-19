package com.weikun.E;

import org.junit.Test;

/**
 * Created by Administrator on 2017/3/19.
 * �鲢����
 * 1���ȷֽ⣬�����ң�
 */
public class E {

    private int[] data={50,10,90,30,70,40,80,60,20};
    @Test
    public  void mergeSort(){
        //�鲢����
        sort(data , 0 , data.length - 1);
        for(int i :data){
            System.out.printf("%d ",i);
        }
    }

    /**
     *
     * @param data:�����������
     * @param left��������
     * @param right��������
     */
    private void sort(int[] data, int left, int right) {
        if(left<right){
            int center=(left+right)/2;//����м�λ������

            sort(data,left,center);//�ֽ�������

            sort(data,center+1,right);//�ֽ�������

            merge(data,left,center,right);


        }

    }
    /** �ϲ�
     * ������������й鲢���鲢ǰ���������Ѿ����򣬹鲢����Ȼ����
     * @param data �������
     * @param left ������ĵ�һ��Ԫ�ص�����
     * @param center ����������һ��Ԫ�ص�������center+1���������һ��Ԫ�ص�����
     * @param right ����������һ��Ԫ�ص�����
     */
    private  void merge(int[] data, int left, int center, int right) {
        //1.��������ʱ����,������������õ�Ԫ��


        int [] tmpArr=new int[data.length];

        int mid=center+1;
        int tmp=left;
        int third=left;
        //�����Ƚϣ���С���͵���ʱ������
        while(left<=center&&mid<=right){
            //��С��ֵ���뵽��ʱ������
            if(data[left]-data[mid]<0){
                tmpArr[third++]=data[left++];//

            }else{
                tmpArr[third++]=data[mid++];
            }
        }

        //���Ҳ��Ǹ��������͵���ʱ������
        while(mid<=right){
            tmpArr[third++]=data[mid++];

        }
        //������Ǹ��������͵���ʱ������
        while(left<=center){
            tmpArr[third++]=data[left++];

        }
        //ÿһ�Σ�����ʱ����������õ�Ԫ���͵�data��
       while(tmp<=right){
            data[tmp]=tmpArr[tmp++];
       }


    }
}
