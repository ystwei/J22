package com.weikun.C;

/**
 * Created by Administrator on 2017/3/9.
 * /有向图的邻接矩阵表示法
 */
public class B{


    private String[] mVexs;       // 顶点集合
    private int[][] mMatrix;    // 邻接矩阵
    public void print(){
        for(int i=0;i<this.mVexs.length;i++){

            for(int j=0;j<this.mVexs.length;j++){

                System.out.printf("%d ",this.mMatrix[i][j]);
            }
            System.out.println();
        }

    }
    public B(String[] mVexs,String [][] edges){
        this.mVexs=mVexs;//初始化顶点
        int vlen=edges.length;//必须用边集合的个数
        //初始化边数组mMatrix
        this.mMatrix=new int[vlen][vlen];
        for(int i=0;i<vlen;i++){
            int p1=this.getPosition(edges[i][0]);//A
            int p2=this.getPosition(edges[i][1]);//B
            this.mMatrix[p1][p2]=1;
        }
    }

    /**
     *
     * @param c:顶点
     * @return：该顶点在顶点集合的索引号
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
        String[] vexs = {"V0", "V1","V2","V3"};//顶点集合
        String[][] edges = new String[][]{//边是个二维数组，无向图的边集合
                {"V0","V3"},{"V1","V0"},
                {"V2","V0"},{"V1","V2"},
                {"V2","V1"}

        };
        B a=new B(vexs,edges);
        a.print();
    }


}

