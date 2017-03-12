package com.weikun.C;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/3/12.
 * �Ͻ�˹�������·��
 */
public class H {

    public class Node {
        private String name;
        //�ӽڵ�
        private Map<Node,Integer> child=new HashMap<Node,Integer>();
        public Node(String name){
            this.name=name;
        }
        public String getName() {
            return name;
        }

        public Map<Node, Integer> getChild() {
            return child;
        }

    }
    @Test
    public void test(){
        Node node=this.build();//V0
        this.djstla(node);

    }
    /**
     *  �ҵ��������ڵ�֮������·��
     * @param start ��ʼ�Ľڵ�
     */
    public void djstla(Node start){
        Node nearestNode=this.getShortestPath(start);//�ҵ������·�����ڽӵ�
        System.out.print(start.getName()+": "+path.get(start.getName())+" ");
        if(nearestNode==null){//����û���ڽӵ�
            return ;
        }
        close.add(nearestNode);//�Ѿ����ʹ��ˣ�����
        open.remove(nearestNode);//�Ѿ����ʹ��ˣ�ȥ�����
        Map<Node,Integer> map=nearestNode.getChild();//���ڽӵ�������ӽڵ�

        for(Node child :map.keySet()  ){//�ҵ����ڽӵ�������ӽڵ�
            if(open.contains(child)){//��û������
                //ȡ (V0->V1)+(V1-->V2)
                //System.out.print(nearestNode.getName());
                int i1=path.get(nearestNode.getName());
                int i2=map.get(child);
                int distance=i1+i2;
                //�������µĽڵ�֮��ľ���
                int i3=path.get(child.getName());
                if(i3>distance){//֤�����и��̵�·������distance
                    path.put(child.getName(),distance);//����
                }
            }
        }
        djstla(nearestNode);
    }
    private Set<Node> open=new HashSet<Node>();//open���ڴ洢δ�����ĵ�
    private Set<Node> close=new HashSet<Node>();//close�����洢�ѱ����Ľڵ�
    private Map<String,Integer> path=new HashMap<String,Integer>();//��װ·������

    /**
     *
     * @param node Ҫ���ҵĽڵ�
     * @return ���Ҫ���ҵĽڵ�������ӽڵ�
     */

    private Node getShortestPath(Node node){
        Node res=null;
        int min=Integer.MAX_VALUE;
        Map<Node ,Integer> map=node.getChild();
        for(Node tmp  :map.keySet()){
            if(open.contains(tmp)){//����ýڵ�û�б����ʣ�
                int distance=map.get(tmp);
                if(distance<min){//����С�Ļ�С������������Ҫ��
                    min=distance;
                    res=tmp;
                }
            }

        }
        //������ѭ����ʱ�򣬾����Ǹ�����node�ڵ�����·��

        return res;
    }

    /**
     * �ѽڵ�ͽڵ�֮�������Ч����

     * @return ���׽�㣬node0
     */

    public Node build(){
        Node node0=new Node("V0");
        Node node1=new Node("V1");
        Node node2=new Node("V2");
        Node node3=new Node("V3");
        Node node4=new Node("V4");
        Node node5=new Node("V5");
        Node node6=new Node("V6");
        Node node7=new Node("V7");
        Node node8=new Node("V8");

        node0.getChild().put(node1, 1);//V0--V1
        node0.getChild().put(node2, 5);//V0--V2

        node1.getChild().put(node0, 1);
        node1.getChild().put(node2, 3);
        node1.getChild().put(node3, 7);
        node1.getChild().put(node4, 5);

        node2.getChild().put(node0, 5);
        node2.getChild().put(node1, 3);
        node2.getChild().put(node4, 1);
        node2.getChild().put(node5, 7);

        node3.getChild().put(node1, 7);
        node3.getChild().put(node4, 2);
        node3.getChild().put(node6, 3);

        node4.getChild().put(node1, 5);
        node4.getChild().put(node2, 1);
        node4.getChild().put(node3, 2);
        node4.getChild().put(node5, 3);
        node4.getChild().put(node6, 6);
        node4.getChild().put(node7, 9);

        node5.getChild().put(node2, 7);
        node5.getChild().put(node4, 3);
        node5.getChild().put(node7, 5);


        node6.getChild().put(node3, 3);
        node6.getChild().put(node4, 6);
        node6.getChild().put(node7, 2);
        node6.getChild().put(node8, 7);


        node7.getChild().put(node4, 9);
        node7.getChild().put(node6, 2);
        node7.getChild().put(node8, 4);

        node8.getChild().put(node6, 7);
        node8.getChild().put(node7, 4);
        ////��ʼ�ڵ����close �����ڵ����open
        open.add(node1);
        open.add(node2);
        open.add(node3);
        open.add(node4);
        open.add(node5);
        open.add(node6);
        open.add(node7);
        open.add(node8);
        close.add(node0);//��ʼ�ڵ����close

        path.put("V1", 1);//V0--V1
        path.put("V2", 5);      //V0--V2
        path.put("V3",Integer.MAX_VALUE);//V0--V3,��Ϊû��ֱ�����ӣ����������ֵ
        path.put("V4", Integer.MAX_VALUE);//V0--V4
        path.put("V5", Integer.MAX_VALUE);//V0--V5
        path.put("V6", Integer.MAX_VALUE);//V0--V6
        path.put("V7", Integer.MAX_VALUE);//V0--V7
        path.put("V8", Integer.MAX_VALUE);//V0--V8

        return node0;

    }

}
