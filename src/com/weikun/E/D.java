package com.weikun.E;

import org.junit.Test;

/**
 * Created by Administrator on 2017/3/19.
 * Shell排序
 */
public class D {

    private int [] data={47,55,10,40,15,94,5,70};

    @Test
    public void shellSort(){
        int h=0;
        int arrayLength=data.length;

        //先计算h时间间隔

        while (h<=arrayLength/3){
            h=h*3+1;
        }
        while(h>0){
            //1.应用h来划分区间
            for(int i=h;i<arrayLength;i++){
                int tmp=data[i];//15
                if(data[i]-data[i-h]<0){//代表后面有小的值
                    int j=i-h;//起始位置 47
                    //在h间隔内的元素之间互换
                    for( ; j>=0 &&data[j]-tmp>0; ){
                        data[j+h]=data[j];
                        j=j-h;
                    }
                    data[j+h]=tmp;//临时变量的值送给退格的那个索引的元素
                }
            }
            h=(h-1)/3;//h的下个时间间隔
        }
        for(int i :data){
            System.out.printf("%d ",i);
        }
    }
}
