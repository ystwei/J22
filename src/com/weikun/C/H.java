package com.weikun.C;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/3/12.
 * 迪杰斯特拉最短路径
 */
public class H {

    public class Node {
        private String name;
        //子节点
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
     *  找到其两个节点之间的最短路径
     * @param start 开始的节点
     */
    public void djstla(Node start){
        Node nearestNode=this.getShortestPath(start);//找到其最短路径的邻接点
        System.out.print(start.getName()+": "+path.get(start.getName())+" ");
        if(nearestNode==null){//根本没有邻接点
            return ;
        }
        close.add(nearestNode);//已经访问过了，加入
        open.remove(nearestNode);//已经访问过了，去掉标记
        Map<Node,Integer> map=nearestNode.getChild();//该邻接点的所有子节点

        for(Node child :map.keySet()  ){//找到该邻接点的所有子节点
            if(open.contains(child)){//还没被访问
                //取 (V0->V1)+(V1-->V2)
                //System.out.print(nearestNode.getName());
                int i1=path.get(nearestNode.getName());
                int i2=map.get(child);
                int distance=i1+i2;
                //计算最新的节点之间的距离
                int i3=path.get(child.getName());
                if(i3>distance){//证明还有更短的路径就是distance
                    path.put(child.getName(),distance);//更新
                }
            }
        }
        djstla(nearestNode);
    }
    private Set<Node> open=new HashSet<Node>();//open用于存储未遍历的点
    private Set<Node> close=new HashSet<Node>();//close用来存储已遍历的节点
    private Map<String,Integer> path=new HashMap<String,Integer>();//封装路径距离

    /**
     *
     * @param node 要查找的节点
     * @return 离该要查找的节点最近的子节点
     */

    private Node getShortestPath(Node node){
        Node res=null;
        int min=Integer.MAX_VALUE;
        Map<Node ,Integer> map=node.getChild();
        for(Node tmp  :map.keySet()){
            if(open.contains(tmp)){//如果该节点没有被访问，
                int distance=map.get(tmp);
                if(distance<min){//比最小的还小，就是我们需要的
                    min=distance;
                    res=tmp;
                }
            }

        }
        //当跳出循环的时候，就是那个距离node节点的最短路径

        return res;
    }

    /**
     * 把节点和节点之间进行有效关联

     * @return 是首结点，node0
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
        ////初始节点放入close 其他节点放入open
        open.add(node1);
        open.add(node2);
        open.add(node3);
        open.add(node4);
        open.add(node5);
        open.add(node6);
        open.add(node7);
        open.add(node8);
        close.add(node0);//初始节点放入close

        path.put("V1", 1);//V0--V1
        path.put("V2", 5);      //V0--V2
        path.put("V3",Integer.MAX_VALUE);//V0--V3,因为没有直线连接，索引用最大值
        path.put("V4", Integer.MAX_VALUE);//V0--V4
        path.put("V5", Integer.MAX_VALUE);//V0--V5
        path.put("V6", Integer.MAX_VALUE);//V0--V6
        path.put("V7", Integer.MAX_VALUE);//V0--V7
        path.put("V8", Integer.MAX_VALUE);//V0--V8

        return node0;

    }

}
