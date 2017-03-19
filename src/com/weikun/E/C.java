package com.weikun.E;

import org.junit.Test;

/**
 * Created by Administrator on 2017/3/19.
 * 插入排序
 */
public class C {

    int[] nums = {49,38,10,97,76,13,27};
    @Test
    public void inserSort(){

        for(int i=0;i<nums.length;i++){
            int index=-1;//较小的索引号
            for(int j=0;j<i;j++){
                if(nums[i]-nums[j]<0){//38-49<0//找到较小的之后，立刻退出循环，进行倒退，并且插入
                    index=j;
                    break;

                }

            }
            if(index!=-1){//确实后面小于前面的元素
                int tmp=nums[i];//较小的值放到临时变量上
                moveBack(i,index);//做回退元素，
                nums[index]=tmp;//把小的赋值到第一个后退元素的那个位置上
            }


        }
        for(int i:nums){
            System.out.printf("%d ",i);

        }
    }
    /*
    from:较小的元素索引
    to:较大的元素索引
     */
    private void moveBack(int from ,int to) {
        for(int i=from;i>to;i-- ){//退值，退到较小的那个点，之后就退出循环
            nums[i]=nums[i-1];

        }

    }
}




