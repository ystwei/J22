package com.weikun.C;

import org.junit.Test;

/**
 * Created by Administrator on 2017/3/11.
 * Prim算法，找到最小生成树
 */
public class F {
    private char[] mVexs;       // 顶点集合
    private int[][] mMatrix;    // 邻接矩阵
    private static final int INF = Integer.MAX_VALUE;   // 最大值,也就是在邻接矩阵中，两个点如果没有边，就标记最大值
    @Test
    public  void test() {
        //顶点
        char[] mVexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        this.mVexs=mVexs;
        //INF最大值,也就是在邻接矩阵中，两个点如果没有边，就标记最大值
        //0 是自己到自己的点的标记

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
     * @param start:从这个索引开始找到其图的最小生成树
     */
    public void prim(int start) {
        int count=this.mVexs.length;
        int index=0;//结果集的索引号
        char [] prim=new char[count];//结果集
        int weight[]=new int[mMatrix.length];//权值集合
        prim[index++]=this.mVexs[start];//A

        for(int i=0;i<count;i++) {
            weight[i] = mMatrix[start][i];//A到所有顶点的权值// ，
        }
        for(int i=0;i<count-1;i++){
            //找以start开始的点的所有邻接点的权值最小值

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

            //k就是这一行的最小索引
            //加入那个节点
            prim[index++]=this.mVexs[k];
            //更改权值，因为他已经访问过了
            weight[k]=0;
            //把曾经访问过的顶点到k指定顶点的邻接点的权值挨个更新

            for(j=0;j<count;j++){
                if(weight[j]!=0&&this.mMatrix[k][j]<weight[j]){

                    weight[j]=this.mMatrix[k][j];//更新权值
                }

            }

        }
        //计算最小生成树的权值

        int sum=0;
        System.out.print(prim[0]);//A
        for(int i=1;i<index;i++){
            int min=INF;
            int n=this.getPosition(prim[i]);//B
            for(int j=0;j<i;j++){//B之前的所有顶点
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
	 * 返回ch在顶点数组中的位置
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
