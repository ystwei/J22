package com.weikun.E;

import org.junit.Test;

/**
 * Created by Administrator on 2017/3/19.
 * ������
 */
public class B {
    private int [] data={9,79,46,30,58,49};
    @Test
    public  void heapSort() {//����
        /*
		 *        9
		 *      /   \
		 *    79    46
		 *   / \   /
		 * 30  58 49
		 */
        int arrayLength=data.length;
        for(int i=0;i<arrayLength-1;i++){
            System.out.println("��ʼ������");

            buildHead(arrayLength-1-i);//�������Ǵ󶥶ѣ�Ҳ�������������а�����Ԫ�طŵ�����

            swap(0,arrayLength-1-i);//��ÿ�δ��Ԫ�ض��ŵ���������Ǹ�����λ�ã�ʹ�������ǰ���С��������

        }
        for(int i :data){
            System.out.printf("%d ",i);

        }

    }

    /**
     *
     * @param lastIndex:��������ӽڵ��������
     */
    public void buildHead(int lastIndex){

        for(int i=(lastIndex-1)/2;i>=0;i--){
            // /�ɶ��ӵ�����lastIndex��ͨ����˾��ɸ�����������ͨ���ݼ����̣��������ʶ��ӣ�
            int k=i;
            while(k*2+1<=lastIndex ){//Ҫ�жϵĵ��Ƿ��ں���������
                int bigIndex=k*2+1;
                //�����ֵ��ȱȣ���ס����Ǹ�������
                if(bigIndex<lastIndex){

                    if(data[bigIndex]-data[bigIndex+1]<0){//���ӱ�����С,��¼����
                        bigIndex++;
                    }
                    //����������������ǲ��Ǿ��Ǵ����������bigIndex,���ӱ����Ӵ�
                }

                //�ϴ�������ŵ�Ԫ���ٸ����ױ�
                if(data[k]-data[bigIndex]<0){
                    swap(k,bigIndex);//������ױȶ���С�����н���
                }else{

                    break;
                }

            }

        }




    }
    //i:���׵�������j�����ӵ�����
    private  void swap( int i , int j){
        int tmp=data[i];
        data[i]=data[j];
        data[j]=tmp;

    }
}
