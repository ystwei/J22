package com.weikun.E;

import org.junit.Test;

/**
 * Created by Administrator on 2017/3/19.
 * Shell����
 */
public class D {

    private int [] data={47,55,10,40,15,94,5,70};

    @Test
    public void shellSort(){
        int h=0;
        int arrayLength=data.length;

        //�ȼ���hʱ����

        while (h<=arrayLength/3){
            h=h*3+1;
        }
        while(h>0){
            //1.Ӧ��h����������
            for(int i=h;i<arrayLength;i++){
                int tmp=data[i];//15
                if(data[i]-data[i-h]<0){//���������С��ֵ
                    int j=i-h;//��ʼλ�� 47
                    //��h����ڵ�Ԫ��֮�以��
                    for( ; j>=0 &&data[j]-tmp>0; ){
                        data[j+h]=data[j];
                        j=j-h;
                    }
                    data[j+h]=tmp;//��ʱ������ֵ�͸��˸���Ǹ�������Ԫ��
                }
            }
            h=(h-1)/3;//h���¸�ʱ����
        }
        for(int i :data){
            System.out.printf("%d ",i);
        }
    }
}
