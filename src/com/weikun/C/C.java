package com.weikun.C;

import org.junit.Test;

/**
 * Created by Administrator on 2017/3/9.
 * ����ͼ���ڽӱ��ʾ
 */
public class C {
    class VNode{
        String data;
        ENode firstedge;
    }
    // �ڽӱ��б��Ӧ������Ķ���
    class ENode {
        int tp;       // �ñ���ָ��Ķ����λ��
        ENode nextEdge; // ָ����һ������ָ��
    }

    private VNode[] top;  // ��������
    @Test
    public void test(){

        String[] vexs = {"V0", "V1", "V2", "V3"};
        String[][] edges = new String[][]{//����ͼ��ȫ����ʾ�ڵ�֮��Ĺ�ϵ����
                {"V0", "V1"},
                {"V0", "V2"},
                {"V0", "V3"},
                {"V1", "V2"},
                {"V3", "V2"}
        };

        //��ʼ����������

        int vlen=vexs.length;
        int elen=edges.length;
        top=new VNode[vlen];

        for(int i=0;i<vlen;i++){
            VNode node=new VNode();
            node.data=vexs[i];
            node.firstedge=null;
            top[i]=node;

        }
        //��ʼ����


        for(int i=0;i<elen;i++){
            int p1=this.getPosition(edges[i][0]);//V0
            int p2=this.getPosition(edges[i][1]);//V1

            ENode node=new ENode();
            node.tp=p2;//һ���ǵڶ������㣬��Ϊ��һ������VNode��data��

            if(top[p1].firstedge==null){//��û�йҽӵ��Ǹ��������
                top[p1].firstedge=node;
            }else{
                this.linkLast(top[p1].firstedge,node);
            }
            //��������ͼ�����붥�㻥��ָ
            ENode node1=new ENode();
            node1.tp=p1;//һ���ǵڶ������㣬��Ϊ��һ������VNode��data��

            if(top[p2].firstedge==null){//��û�йҽӵ��Ǹ��������
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
     * �Ե���������йҽӣ�һ��Ҫ�ҵ�����Ǹ�Ԫ��
     * @param list ����һ��������
     * @param node�� �ҽӵ��Ǹ�����
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
     * @param ch Ҫ���ҵĶ���ֵ
     * @return��tops�е�����
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
