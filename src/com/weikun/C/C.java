package com.weikun.C;

import org.junit.Test;

/**
 * Created by Administrator on 2017/3/9.
 * 无向图的邻接表表示
 */
public class C {
    class VNode{
        String data;
        ENode firstedge;
    }
    // 邻接表中表对应的链表的顶点
    class ENode {
        int tp;       // 该边所指向的顶点的位置
        ENode nextEdge; // 指向下一条弧的指针
    }

    private VNode[] top;  // 顶点数组
    @Test
    public void test(){

        String[] vexs = {"V0", "V1", "V2", "V3"};
        String[][] edges = new String[][]{//无向图，全部表示节点之间的关系即可
                {"V0", "V1"},
                {"V0", "V2"},
                {"V0", "V3"},
                {"V1", "V2"},
                {"V3", "V2"}
        };

        //初始化顶点数组

        int vlen=vexs.length;
        int elen=edges.length;
        top=new VNode[vlen];

        for(int i=0;i<vlen;i++){
            VNode node=new VNode();
            node.data=vexs[i];
            node.firstedge=null;
            top[i]=node;

        }
        //初始化边


        for(int i=0;i<elen;i++){
            int p1=this.getPosition(edges[i][0]);//V0
            int p2=this.getPosition(edges[i][1]);//V1

            ENode node=new ENode();
            node.tp=p2;//一定是第二个顶点，因为第一个是在VNode的data中

            if(top[p1].firstedge==null){//还没有挂接的那个顶点对象
                top[p1].firstedge=node;
            }else{
                this.linkLast(top[p1].firstedge,node);
            }
            //由于无向图，必须顶点互相指
            ENode node1=new ENode();
            node1.tp=p1;//一定是第二个顶点，因为第一个是在VNode的data中

            if(top[p2].firstedge==null){//还没有挂接的那个顶点对象
                top[p2].firstedge=node1;
            }else{
                this.linkLast(top[p2].firstedge,node1);
            }


        }

        print();
    }
    public void print(){

        for(int i=0;i<this.top.length;i++){
            System.out.print(this.top[i].data+":");//V0

            ENode node=top[i].firstedge;
            while(node!=null ){
                System.out.println(this.top[node.tp].data);
                node=node.nextEdge;
            }

        }
        System.out.println("ok");

    }
    /**
     * 对单向链表进行挂接，一定要找到最后那个元素
     * @param list ：第一个顶点类
     * @param node： 挂接的那个顶点
     */
    private void linkLast(ENode list, ENode node) {
        ENode p=list;
        while(p.nextEdge!=null){

            p=p.nextEdge;
        }
        p.nextEdge=node;
    }

    /**
     *
     * @param ch 要查找的顶点值
     * @return在tops中的索引
     */
    public int getPosition(String ch){
        for(int i=0;i<top.length;i++ ){
            if(top[i].data.equals(ch)){
                return i;
            }
        }
        return -1;
    }

}
