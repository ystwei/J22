package com.weikun.C;

/**
 * Created by Administrator on 2017/3/9.
 * //��� ���ͼ����
 */
public class E {

    /*
	 * ����chλ��
	 */
    private int getPosition(char ch) {
        for(int i=0; i<mVexs.length; i++){
            if(mVexs[i]==ch){//�����ֵ��
                return i;
            }
        }
        return -1;
    }

    private char[] mVexs;       // ���㼯��
    private int[][] mMatrix;    // �ڽӾ���
    public E(char[] vexs, char[][] edges) {
        //��ʼ�����㼯��
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
        System.out.println(mMatrix);


    }
    /*
	 * ��ӡ�������ͼ
	 */
    public void print() {
        System.out.printf("�ڽӾ���ͼ�ı���:\n");
        for (int i = 0; i < mVexs.length; i++) {
            for (int j = 0; j < mVexs.length; j++){
                System.out.printf("%d ", mMatrix[i][j]);
            }
            System.out.printf("\n");
        }
    }
    /*
   * ���������������ͼ
   */
    public void DFS() {
        //�����ʹ��ı�Ǽ��� true���Ѿ� false��û�б�����
        boolean [] visited=new boolean[this.mVexs.length];

        for(int i=0;i<visited.length;i++){
            visited[i]=false;
        }
        for(int i=0;i<this.mVexs.length;i++){
            if(visited[i]==false){//û�б����ʹ�
                DFS(i,visited);
            }
        }
        System.out.printf("\n");

    }
    private int firstVertex(int index) {//����index��ָ���������Ķ���������ڽӵ�
        for(int i=0;i<this.mVexs.length;i++){
            if(this.mMatrix[index][i]==1){//�ڽӵ��ҵ���
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
    private void BFS(){//������ȱ���

        int head=0;
        int rear=0;

        boolean [] visited=new boolean[this.mVexs.length];
        int [] queue=new int[this.mVexs.length];
        for(int i=0;i<visited.length;i++){//����һ��ʼ��û�з��ʣ����Զ���Ϊ��
            visited[i]=false;
        }

        for(int i=0;i<this.mVexs.length;i++){
            if(visited[i]==false){//����û������
                visited[i]=true;
                System.out.print(this.mVexs[i]);
                queue[rear++]=i;//��������Ѿ����ʹ����������
            }
            while(head!=rear){//����ö�����Ԫ��
                int j=queue[head++];//������A
                int k=this.firstVertex(i);//B
                while(k>=0){//����A��Ϊ�������еĵ㣬�Ƿ��е��A����
                    if(visited[k]==false) {//����û������
                        visited[k]=true;
                        System.out.print(this.mVexs[k]);
                        queue[rear++]=k;
                    }
                    //j���ǵ�һ�ε��������Ǹ�����������������i������Ҫ�ҵ��ǵ������Ǹ�����ڽӵ㡣
                    k=this.nextVertex(j,k);//�ҵ��¸���iΪ�����������ڽӵ㣬��������
                }
            }
        }


    }
    private void DFS(int index, boolean[] visited) {//index ��A
        visited[index]=true;//�ý��Ѿ���������
        int i=this.firstVertex(index);//�ҵ��ڽӵ�������
        System.out.print(this.mVexs[index]);
        while(i>=0){
            if(visited[i]==false){
                DFS(i,visited);
            }
            i=this.nextVertex(index,i);//B���¸��ڽӵ������
        }
    }
    public static void main(String[] args) {
		/*
		 *        ͼ�μ�PPT
		 */
        char[] vexs = {'A', 'B', 'C', 'D','E','F','G','H','I'};
        char[][] edges = new char[][]{//���Ǹ���ά����
                {'A', 'B'},
                {'A', 'F'},
                {'B', 'G'},
                {'B', 'C'},
                {'B', 'I'},
                {'B', 'A'},
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
                {'E', 'D'},

                {'F', 'G'},
                {'F', 'A'},
                {'F', 'E'},

                {'G', 'H'},
                {'G', 'D'},
                {'G', 'B'},
                {'G', 'F'},

                {'H', 'G'},
                {'H', 'D'},
                {'H', 'E'},
                {'I', 'B'},
                {'I', 'C'},
                {'I', 'D'}

        };
        E pG;

        // �Զ���"ͼ"(����������)
        //pG = new MatrixDG();
        // �������е�"ͼ"
        pG = new E(vexs, edges);
        pG.print();   // ��ӡͼ
        pG.DFS();     // ������ȱ���
        pG.BFS();//������ȱ���
    }
}
