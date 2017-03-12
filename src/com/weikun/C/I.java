package com.weikun.C;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Administrator on 2017/3/12.
 * ��������
 */
public class I {

    // �ڽӱ��б��Ӧ������Ķ���
    private class ENode {
        int itop;       // �ñ���ָ��Ķ����λ��
        ENode next; // ָ����һ������ָ��
    }

    // �ڽӱ��б�Ķ���
    private class VNode {
        char data;          // ������Ϣ
        ENode firstEdge;    // ָ���һ�������ö���Ļ�
    }

    ;

    private List<VNode> mVexs;  // ��������

    char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};//��������
    char[][] edges = new char[][]{//�����飬����A->G B->A��
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

        int vlen = vexs.length;//����ĸ���
        int elen = edges.length;//�ߵĸ���
        mVexs = new ArrayList<VNode>();

        for (int i = 0; i < vlen; i++) {
            VNode tmp = new VNode();
            tmp.data = vexs[i];
            tmp.firstEdge = null;
            mVexs.add(tmp);//�γɶ��㼯��
        }
        //��ʼ���ߣ��γ���
        for (int i = 0; i < elen; i++) {
            char c1 = edges[i][0];
            char c2 = edges[i][1];
            int i1 = this.getPosition(c1);
            int i2 = this.getPosition(c2);
            //��ʼ����
            ENode enode = new ENode();
            enode.itop = i2;//G
            if (mVexs.get(i1).firstEdge == null) {//��A--G���й���
                mVexs.get(i1).firstEdge = enode;
            } else {//�ҵ����иö����бߵ����λ�ã��ڽ��й���
                this.linkLast(mVexs.get(i1).firstEdge, enode);
            }
        }
        print();
        sort();
    }

    public void sort() {
        //�����������
        int num = this.mVexs.size();
        int in[] = new int[num];
        Queue<Integer> queue=new LinkedList<Integer>();//���������ջΪ0�Ķ��ж���

        //ͳ��ÿ���ڵ��������������뵽���������
        ENode node = null;
        for (int i = 0; i < num; i++) {
            node = this.mVexs.get(i).firstEdge;
            while (node!=null) {
                in[node.itop]++;
                node=node.next;
            }
        }
        for (int i=0;i<num;i++){
            if(in[i]==0){//���Ϊ��
                queue.offer(i);//BC
            }
        }

        int index=0;
        char [] results=new char[num];
        //���
        while(!queue.isEmpty()){//֤��������Ԫ��

            int i=queue.poll();
            results[index++]=this.mVexs.get(i).data;//���ȳ���Ԫ�ؾ��ǽ������Ԫ��
            ENode enode=this.mVexs.get(i).firstEdge;

            while(enode!=null){
                in[enode.itop]--;//ѭ��һ�Σ����һ�Σ��������--
                if(in[enode.itop]==0){//���Ϊ0�󣬴���ýڵ�����ϣ�
                    queue.offer(enode.itop);//�ѵ�ǰ�߶�����ָ���Ľڵ��������������
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
     * listβ���ҽ�last
     *
     * @param list:�Ͻڵ�
     * @param last     �½ڵ�
     */
    public void linkLast(ENode list, ENode last) {
        ENode p = list;
        while (p.next != null) {


            p = p.next;
        }
        p.next = last;
    }

    /**
     * @param c:���ҵĶ���
     * @return�ڶ��㼯�ϵ�λ��
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
