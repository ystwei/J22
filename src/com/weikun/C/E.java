package com.weikun.C;

/**
 * Created by Administrator on 2017/3/9.
 * //深度 广度图搜索
 */
public class E {

    /*
	 * 返回ch位置
	 */
    private int getPosition(char ch) {
        for(int i=0; i<mVexs.length; i++){
            if(mVexs[i]==ch){//顶点的值和
                return i;
            }
        }
        return -1;
    }

    private char[] mVexs;       // 顶点集合
    private int[][] mMatrix;    // 邻接矩阵
    public E(char[] vexs, char[][] edges) {
        //初始化顶点集合
        int vlen=vexs.length;
        int elen=edges.length;
        this.mVexs=new char[vlen];
        for(int i=0;i< vexs.length;i++){
            mVexs[i]=vexs[i];
        }
        this.mMatrix=new int[vlen][vlen];
        for(int i=0;i<elen;i++){
            int p1=this.getPosition(edges[i][0]);
            int p2=this.getPosition(edges[i][1]);
            this.mMatrix[p1][p2]=1;

        }


    }
    /*
	 * 打印矩阵队列图
	 */
    public void print() {
        System.out.printf("邻接矩阵图的遍历:\n");
        for (int i = 0; i < mVexs.length; i++) {
            for (int j = 0; j < mVexs.length; j++){
                System.out.printf("%d ", mMatrix[i][j]);
            }
            System.out.printf("\n");
        }
    }
    /*
   * 深度优先搜索遍历图
   */
    public void DFS() {
        //被访问过的标记集合 true：已经 false：没有被访问
        boolean [] visited=new boolean[this.mVexs.length];

        for(int i=0;i<visited.length;i++){
            visited[i]=false;
        }
        for(int i=0;i<this.mVexs.length;i++){
            if(visited[i]==false){//没有被访问过
                DFS(i,visited);
            }
        }
        System.out.printf("\n");

    }
    private int firstVertex(int index) {//返回index所指定的索引的顶点的所有邻接点
        for(int i=0;i<this.mVexs.length;i++){
            if(this.mMatrix[index][i]==1){//邻接点找到了
                return i;
            }
        }
        return -1;
    }

    private int nextVertex(int v, int w) {
        for(int i=w+1;i<this.mVexs.length;i++){
            if(this.mMatrix[v][i]==1){
                return i;
            }
        }
        return -1;
    }
    private void DFS(int index, boolean[] visited) {//index ：A
        visited[index]=true;//该节已经被访问了
        int i=this.firstVertex(index);//找到邻接点索引号
        System.out.print(this.mVexs[index]);
        while(i>=0){
            if(visited[i]==false){
                DFS(i,visited);
            }
            i=this.nextVertex(index,i);//B的下个邻接点的索引
        }
    }
    public static void main(String[] args) {
		/*
		 *        图形见PPT
		 */
        char[] vexs = {'A', 'B', 'C', 'D','E','F','G','H','I'};
        char[][] edges = new char[][]{//边是个二维数组
                {'A', 'B'},
                {'A', 'F'},
                {'B', 'G'},
                {'B', 'C'},
                {'B', 'I'},
                {'C', 'B'},
                {'C', 'I'},
                {'C', 'D'},
                {'D', 'C'},
                {'D', 'I'},
                {'D', 'G'},
                {'D', 'H'},
                {'D', 'E'},
                {'E', 'H'},
                {'E', 'F'},
                {'F', 'G'},
                {'F', 'A'},
                {'F', 'E'},
                {'G', 'H'},
                {'G', 'D'},
                {'G', 'B'},
                {'H', 'G'},
                {'H', 'D'},
                {'H', 'E'},
                {'I', 'B'},
                {'I', 'C'},
                {'I', 'D'}

        };
        E pG;

        // 自定义"图"(输入矩阵队列)
        //pG = new MatrixDG();
        // 采用已有的"图"
        pG = new E(vexs, edges);
        pG.print();   // 打印图
        pG.DFS();     // 深度优先遍历
    }
}
