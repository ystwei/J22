package com.weikun.C;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Administrator on 2017/3/12.
 * 拓扑排序
 */
public class I {

    // 邻接表中表对应的链表的顶点
    private class ENode {
        int itop;       // 该边所指向的顶点的位置
        ENode next; // 指向下一条弧的指针
    }

    // 邻接表中表的顶点
    private class VNode {
        char data;          // 顶点信息
        ENode firstEdge;    // 指向第一条依附该顶点的弧
    }

    ;

    private List<VNode> mVexs;  // 顶点数组

    char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};//顶点数组
    char[][] edges = new char[][]{//边数组，例如A->G B->A等
            {'A', 'G'},
            {'B', 'A'},
            {'B', 'D'},

            {'C', 'G'},
            {'C', 'F'},
            {'D', 'E'},
            {'D', 'F'}
    };

    @Test
    public void test() {

        int vlen = vexs.length;//顶点的个数
        int elen = edges.length;//边的个数
        mVexs = new ArrayList<VNode>();

        for (int i = 0; i < vlen; i++) {
            VNode tmp = new VNode();
            tmp.data = vexs[i];
            tmp.firstEdge = null;
            mVexs.add(tmp);//形成顶点集合
        }
        //初始化边，形成链
        for (int i = 0; i < elen; i++) {
            char c1 = edges[i][0];
            char c2 = edges[i][1];
            int i1 = this.getPosition(c1);
            int i2 = this.getPosition(c2);
            //初始化边
            ENode enode = new ENode();
            enode.itop = i2;//G
            if (mVexs.get(i1).firstEdge == null) {//把A--G进行关联
                mVexs.get(i1).firstEdge = enode;
            } else {//找到所有该顶点中边的最后位置，在进行关联
                this.linkLast(mVexs.get(i1).firstEdge, enode);
            }
        }
        print();
        sort();
    }

    public void sort() {
        //声明入度数组
        int num = this.mVexs.size();
        int in[] = new int[num];
        Queue<Integer> queue=new LinkedList<Integer>();//进入的是入栈为0的队列顶点

        //统计每个节点的入度数，并放入到入度数组中
        ENode node = null;
        for (int i = 0; i < num; i++) {
            node = this.mVexs.get(i).firstEdge;
            while (node!=null) {
                in[node.itop]++;
                node=node.next;
            }
        }
        for (int i=0;i<num;i++){
            if(in[i]==0){//入度为零
                queue.offer(i);//BC
            }
        }

        int index=0;
        char [] results=new char[num];
        //拆边
        while(!queue.isEmpty()){//证明里面有元素

            int i=queue.poll();
            results[index++]=this.mVexs.get(i).data;//首先出的元素就是结果集的元素
            ENode enode=this.mVexs.get(i).firstEdge;

            while(enode!=null){
                in[enode.itop]--;//循环一次，拆解一次，让其入度--
                if(in[enode.itop]==0){//入度为0后，代表该节点拆解完毕，
                    queue.offer(enode.itop);//把当前边对象所指定的节点索引加入队列中
                }
                enode=enode.next;
            }



        }

        for(int i=0;i<results.length;i++){

            System.out.printf("%s ",results[i]);
        }


    }

    public void print() {


        for (int i = 0; i < this.mVexs.size(); i++) {
            System.out.printf("%s ", this.mVexs.get(i).data);
            ENode node = this.mVexs.get(i).firstEdge;
            while (node != null) {
                System.out.printf("%s ", this.mVexs.get(node.itop).data);
                node = node.next;
            }
            System.out.println();


        }
    }

    /**
     * list尾部挂接last
     *
     * @param list:老节点
     * @param last     新节点
     */
    public void linkLast(ENode list, ENode last) {
        ENode p = list;
        while (p.next != null) {


            p = p.next;
        }
        p.next = last;
    }

    /**
     * @param c:查找的顶点
     * @return在顶点集合的位置
     */
    public int getPosition(char c) {
        for (int i = 0; i < vexs.length; i++) {
            if (c == vexs[i]) {
                return i;
            }

        }
        return -1;
    }
}
