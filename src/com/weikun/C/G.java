package com.weikun.C;

/**
 * Created by Administrator on 2017/3/11.
 * ��³˹������С������
 */
public class G {
    private int ecount;        // �ߵ�����edge count
    private char[] tops;       // ���㼯��
    private int[][] mMatrix;    // �ڽӾ���
    private static final int INF = Integer.MAX_VALUE;   // ���ֵ

    public G(char[] vexs, int[][] matrix) {
        int count = vexs.length;
        tops = new char[vexs.length];
        //��ʼ������
        for (int i = 0; i < tops.length; i++) {
            tops[i] = vexs[i];
        }
        mMatrix=new int[vexs.length][vexs.length];
        //��ʼ��mMatrix �ڽӾ���
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                mMatrix[i][j] = matrix[i][j];

            }
        }
        //ͳ�Ʊߵĸ���
        for (int i = 0; i < mMatrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                if (mMatrix[i][j] != INF) {//��Ч
                    ecount++;
                }
            }
        }


    }

    // �ߵĽṹ��
    private static class EData {
        char start; // �ߵ����
        char end;   // �ߵ��յ�
        int weight; // �ߵ�Ȩ��

        public EData(char start, char end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    ;


    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int matrix[][] = {
                       /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
				/*A*/ {0, 12, INF, INF, INF, 16, 14},
				/*B*/ {12, 0, 10, INF, INF, 7, INF},
				/*C*/ {INF, 10, 0, 3, 5, 6, INF},
				/*D*/ {INF, INF, 3, 0, 4, INF, INF},
				/*E*/ {INF, INF, 5, 4, 0, 2, 8},
				/*F*/ {16, 7, 6, INF, 2, 0, 9},
				/*G*/ {14, INF, INF, INF, 8, 9, 0}
        };


        G pG = new G(vexs, matrix);


        pG.kruskal();   // Kruskal�㷨������С������
    }

    /*
	 * ��ȡͼ�еı�
	 */
    private EData[] getEdges() {
        EData[] edata = new EData[ecount];
        int index = 0;
        for (int i = 0; i < this.tops.length; i++) {

            for (int j = i + 1; j < this.tops.length; j++) {
                if (this.mMatrix[i][j] < INF) {
                    EData d = new EData(this.tops[i], this.tops[j], this.mMatrix[i][j]);
                    edata[index++] = d;
                }
            }
        }


        return edata;

    }

    /*
 * �Ա߰���Ȩֵ��С��������(��С����)
 * ͨ���н����������Ȩֵ��
 */
    private void sortEdges(EData[] edges, int elen) {
        for (int i = 0; i < elen; i++) {
            for (int j = i; j < elen; j++) {//ð������
                EData tmp = null;

                if (edges[i].weight > edges[j].weight) {//����λ��
                    tmp = edges[i];
                    edges[i] = edges[j];
                    edges[j] = tmp;

                }
            }

        }
    }

    private void kruskal() {
        int index = 0;//�����������
        int[] tends = new int[tops.length];//��С��������ÿ���ߵ��յ������

        //��ʼ����
        EData[] rets = new EData[ecount];
        EData[] ret = getEdges();
        this.sortEdges(ret, ret.length);

        for(int i=0;i<ret.length;i++){

            int start=this.getPosition(ret[i].start);//E

            int end=this.getPosition(ret[i].end);//F

            int p1=this.getEnd(tends,start);
            int p2=this.getEnd(tends,end);
            if(p1!=p2){//����һ���յ㡣û���γɻ�·
                tends[p1]=p2;//��p1ָ�������������p2���յ�����
                //�ѽ�����뵽���������
                rets[i]=ret[i];

            }
        }
        //ͳ����Ȩֵ��
       int sum=0;
       System.out.println(rets.length);
       for( int i=0;i<rets.length;i++){
            if(rets[i]!=null){
                sum+=rets[i].weight;
            }
       }

        for( int i=0;i<rets.length;i++){
            if(rets[i]!=null){
                System.out.printf("%s-%s  ",rets[i].start,rets[i].end);
            }
        }



    }

    /*
	 * ��ȡi���յ㣬��һ��ѡȡ�ĵ㣬��û���յ㣬��ΪĬ�ϵ�Ԫ�ض���0
	 */
    private int getEnd(int[] tends, int i) {

        while(tends[i]!=0){//i�������������ҵ���iָ�����յ�ֵtends[i]
            i=tends[i];

        }
        return i;
    }
    /*
	 * ����chλ��
	 */
    private int getPosition(char ch) {

        for(int i=0;i<this.tops.length;i++){
            if(ch==this.tops[i]){
                return i;
            }

        }
        return -1;
    }
}
