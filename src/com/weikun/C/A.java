package com.weikun.C;

/**
 * Created by Administrator on 2017/3/9.
 * /����ͼ���ڽӾ����ʾ��
 */
public class A {


    private char[] mVexs;       // ���㼯��
    private int[][] mMatrix;    // �ڽӾ���
    public void print(){
        for(int i=0;i<this.mVexs.length;i++){

            for(int j=0;j<this.mVexs.length;j++){

                System.out.printf("%d ",this.mMatrix[i][j]);
            }
            System.out.println();
        }

    }
    public A(char[] mVexs,char [][] edges){
        this.mVexs=mVexs;//��ʼ������
        int vlen=edges.length;//�����ñ߼��ϵĸ���
        //��ʼ��������mMatrix
        this.mMatrix=new int[vlen][vlen];
        for(int i=0;i<vlen;i++){
            int p1=this.getPosition(edges[i][0]);//A
            int p2=this.getPosition(edges[i][1]);//B
            this.mMatrix[p1][p2]=1;
        }
    }

    /**
     *
     * @param c:����
     * @return���ö����ڶ��㼯�ϵ�������
     */

    private int getPosition(char c) {
        for(int i=0;i<this.mVexs.length;i++){
            if(this.mVexs[i]==c){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D'};//���㼯��
        char[][] edges = new char[][]{//���Ǹ���ά���飬����ͼ�ı߼���
                {'A', 'B'},{'B','A'},
                {'B', 'C'}, {'C', 'B'},
                {'C', 'D'},{'D', 'C'},
                {'A', 'D'},{'D','A'},
                {'A', 'C'},{'C', 'A'}

        };
        A a=new A(vexs,edges);
        a.print();
    }


}

