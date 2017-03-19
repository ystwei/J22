package com.weikun.E;

import org.junit.Test;

/**
 * Created by Administrator on 2017/3/19.
 * 归并排序
 * 1、先分解，（左，右）
 */
public class E {

    private int[] data={50,10,90,30,70,40,80,60,20};
    @Test
    public  void mergeSort(){
        //归并排序
        sort(data , 0 , data.length - 1);
        for(int i :data){
            System.out.printf("%d ",i);
        }
    }

    /**
     *
     * @param data:待排序的数组
     * @param left：左索引
     * @param right：右索引
     */
    private void sort(int[] data, int left, int right) {
        if(left<right){
            int center=(left+right)/2;//相对中间位置索引

            sort(data,left,center);//分解左数组

            sort(data,center+1,right);//分解右数组

            merge(data,left,center,right);


        }

    }
    /** 合并
     * 将两个数组进行归并，归并前两个数组已经有序，归并后依然有序。
     * @param data 数组对象
     * @param left 左数组的第一个元素的索引
     * @param center 左数组的最后一个元素的索引，center+1是右数组第一个元素的索引
     * @param right 右数组的最后一个元素的索引
     */
    private  void merge(int[] data, int left, int center, int right) {
        //1.声明个临时数组,用来放置排序好的元素


        int [] tmpArr=new int[data.length];

        int mid=center+1;
        int tmp=left;
        int third=left;
        //两两比较，较小的送到临时数组中
        while(left<=center&&mid<=right){
            //把小的值送入到临时数组中
            if(data[left]-data[mid]<0){
                tmpArr[third++]=data[left++];//

            }else{
                tmpArr[third++]=data[mid++];
            }
        }

        //把右侧那个数据在送到临时数组中
        while(mid<=right){
            tmpArr[third++]=data[mid++];

        }
        //把左侧那个数据在送到临时数组中
        while(left<=center){
            tmpArr[third++]=data[left++];

        }
        //每一次，把临时数组中排序好的元素送到data中
       while(tmp<=right){
            data[tmp]=tmpArr[tmp++];
       }


    }
}
