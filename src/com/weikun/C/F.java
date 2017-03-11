package com.weikun.C;

import org.junit.Test;

/**
 * Created by Administrator on 2017/3/11.
 * Prim�㷨���ҵ���С������
 */
public class F {
    private char[] mVexs;       // ���㼯��
    private int[][] mMatrix;    // �ڽӾ���
    private static final int INF = Integer.MAX_VALUE;   // ���ֵ,Ҳ�������ڽӾ����У����������û�бߣ��ͱ�����ֵ
    @Test
    public  void test() {
        //����
        char[] mVexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        this.mVexs=mVexs;
        //INF���ֵ,Ҳ�������ڽӾ����У����������û�бߣ��ͱ�����ֵ
        //0 ���Լ����Լ��ĵ�ı��

        int matrix1[][] = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
         /*A*/ {   0,  12, INF, INF, INF,  16,  14},
         /*B*/ {  12,   0,  10, INF, INF,   7, INF},
         /*C*/ { INF,  10,   0,   3,   5,   6, INF},
         /*D*/ { INF, INF,   3,   0,   4, INF, INF},
         /*E*/ { INF, INF,   5,   4,   0,   2,   8},
         /*F*/ {  16,   7,   6, INF,   2,   0,   9},
         /*G*/ {  14, INF, INF, INF,   8,   9,   0}
        };
        this.mMatrix=matrix1;

        prim(0);



    }

    /**
     *
     * @param start:�����������ʼ�ҵ���ͼ����С������
     */
    public void prim(int start) {
        int count=this.mVexs.length;
        int index=0;//�������������
        char [] prim=new char[count];//�����
        int weight[]=new int[mMatrix.length];//Ȩֵ����
        prim[index++]=this.mVexs[start];//A

        for(int i=0;i<count;i++) {
            weight[i] = mMatrix[start][i];//A�����ж����Ȩֵ// ��
        }
        for(int i=0;i<count-1;i++){
            //����start��ʼ�ĵ�������ڽӵ��Ȩֵ��Сֵ

            int j=0;
            int k=0;
            int min=INF;
            while(j<count){

                if(weight[j]!=0&&weight[j]<min){
                    min=weight[j];
                    k=j;
                }
                j++;
            }

            //k������һ�е���С����
            //�����Ǹ��ڵ�
            prim[index++]=this.mVexs[k];
            //����Ȩֵ����Ϊ���Ѿ����ʹ���
            weight[k]=0;
            //���������ʹ��Ķ��㵽kָ��������ڽӵ��Ȩֵ��������

            for(j=0;j<count;j++){
                if(weight[j]!=0&&this.mMatrix[k][j]<weight[j]){

                    weight[j]=this.mMatrix[k][j];//����Ȩֵ
                }

            }

        }
        //������С��������Ȩֵ

        int sum=0;
        System.out.print(prim[0]);//A
        for(int i=1;i<index;i++){
            int min=INF;
            int n=this.getPosition(prim[i]);//B
            for(int j=0;j<i;j++){//B֮ǰ�����ж���
                int m=this.getPosition(prim[j]);//A
                if(this.mMatrix[m][n]<min){
                    min=this.mMatrix[m][n];
                }

            }
            sum+=min;
            System.out.print(prim[i]);
        }
        System.out.println(sum);
    }
    /*
	 * ����ch�ڶ��������е�λ��
	 */
    private int getPosition(char ch) {
        for(int i=0;i<this.mVexs.length;i++){
            if(ch==this.mVexs[i]){
                return i;

            }
        }
        return -1;


    }
}
