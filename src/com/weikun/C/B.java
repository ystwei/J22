package com.weikun.C;

/**
 * Created by Administrator on 2017/3/9.
 * /����ͼ���ڽӾ����ʾ��
 */
public class B{


    private String[] mVexs;       // ���㼯��
    private int[][] mMatrix;    // �ڽӾ���
    public void print(){
        for(int i=0;i<this.mVexs.length;i++){

            for(int j=0;j<this.mVexs.length;j++){

                System.out.printf("%d ",this.mMatrix[i][j]);
            }
            System.out.println();
        }

    }
    public B(String[] mVexs,String [][] edges){
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

    private int getPosition(String c) {
        for(int i=0;i<this.mVexs.length;i++){
            if(this.mVexs[i].equals(c)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] vexs = {"V0", "V1","V2","V3"};//���㼯��
        String[][] edges = new String[][]{//���Ǹ���ά���飬����ͼ�ı߼���
                {"V0","V3"},{"V1","V0"},
                {"V2","V0"},{"V1","V2"},
                {"V2","V1"}

        };
        B a=new B(vexs,edges);
        a.print();
    }


}

