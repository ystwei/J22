package com.weikun.E;

import org.junit.Test;

/**
 * Created by Administrator on 2017/3/19.
 * ��������
 */
public class C {

    int[] nums = {49,38,10,97,76,13,27};
    @Test
    public void inserSort(){

        for(int i=0;i<nums.length;i++){
            int index=-1;//��С��������
            for(int j=0;j<i;j++){
                if(nums[i]-nums[j]<0){//38-49<0//�ҵ���С��֮�������˳�ѭ�������е��ˣ����Ҳ���
                    index=j;
                    break;

                }

            }
            if(index!=-1){//ȷʵ����С��ǰ���Ԫ��
                int tmp=nums[i];//��С��ֵ�ŵ���ʱ������
                moveBack(i,index);//������Ԫ�أ�
                nums[index]=tmp;//��С�ĸ�ֵ����һ������Ԫ�ص��Ǹ�λ����
            }


        }
        for(int i:nums){
            System.out.printf("%d ",i);

        }
    }
    /*
    from:��С��Ԫ������
    to:�ϴ��Ԫ������
     */
    private void moveBack(int from ,int to) {
        for(int i=from;i>to;i-- ){//��ֵ���˵���С���Ǹ��㣬֮����˳�ѭ��
            nums[i]=nums[i-1];

        }

    }
}




