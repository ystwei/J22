package com.weikun.C;

/**
 * Created by Administrator on 2017/3/11.
 * 克鲁斯卡尔最小生成树
 */
public class G {
    private int ecount;        // 边的数量edge count
    private char[] tops;       // 顶点集合
    private int[][] mMatrix;    // 邻接矩阵
    private static final int INF = Integer.MAX_VALUE;   // 最大值

    public G(char[] vexs, int[][] matrix) {
        int count = vexs.length;
        tops = new char[vexs.length];
        //初始化顶点
        for (int i = 0; i < tops.length; i++) {
            tops[i] = vexs[i];
        }
        mMatrix=new int[vexs.length][vexs.length];
        //初始化mMatrix 邻接矩阵
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                mMatrix[i][j] = matrix[i][j];

            }
        }
        //统计边的个数
        for (int i = 0; i < mMatrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                if (mMatrix[i][j] != INF) {//有效
                    ecount++;
                }
            }
        }


    }

    // 边的结构体
    private static class EData {
        char start; // 边的起点
        char end;   // 边的终点
        int weight; // 边的权重

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


        pG.kruskal();   // Kruskal算法生成最小生成树
    }

    /*
	 * 获取图中的边
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
 * 对边按照权值大小进行排序(由小到大)
 * 通过中介变量，交换权值，
 */
    private void sortEdges(EData[] edges, int elen) {
        for (int i = 0; i < elen; i++) {
            for (int j = i; j < elen; j++) {//冒泡排序
                EData tmp = null;

                if (edges[i].weight > edges[j].weight) {//交换位置
                    tmp = edges[i];
                    edges[i] = edges[j];
                    edges[j] = tmp;

                }
            }

        }
    }

    private void kruskal() {
        int index = 0;//结果集的索引
        int[] tends = new int[tops.length];//最小生成树中每个边的终点的索引

        //初始化边
        EData[] rets = new EData[ecount];
        EData[] ret = getEdges();
        this.sortEdges(ret, ret.length);

        for(int i=0;i<ret.length;i++){

            int start=this.getPosition(ret[i].start);//E

            int end=this.getPosition(ret[i].end);//F

            int p1=this.getEnd(tends,start);
            int p2=this.getEnd(tends,end);
            if(p1!=p2){//不是一个终点。没有形成回路
                tends[p1]=p2;//把p1指的是起点索引，p2是终点索引
                //把结果送入到结果集合中
                rets[i]=ret[i];

            }
        }
        //统计其权值和
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
	 * 获取i的终点，第一次选取的点，并没有终点，因为默认的元素都是0
	 */
    private int getEnd(int[] tends, int i) {

        while(tends[i]!=0){//i是起点的索引，找到其i指定的终点值tends[i]
            i=tends[i];

        }
        return i;
    }
    /*
	 * 返回ch位置
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
