package com.weikun.E;

import org.junit.Test;

/**
 * Created by Administrator on 2017/3/19.
 * ֱ������
 */
public class A {

    private int [] data={21,30,49,39,16,9};
    @Test
    public void test(){

        for(int i=0;i<data.length-1;i++){//data1.length-1

            for(int j=i+1;j<data.length;j++){

                int tmp=0;
                if(data[i]-data[j]>0){//ǰһ�����ݱȺ�һ������Ҫ��С�ķŵ�ǰ��
                    tmp=data[j];
                    data[j]=data[i];
                    data[i]=tmp;


                }
            }
        }

        for(int i :data){
            System.out.printf("%d ",i);
        }

    }

}
