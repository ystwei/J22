package com.weikun.E;

import org.junit.Test;

/**
 * Created by Administrator on 2017/3/19.
 * 堆排序
 */
public class B {
    private int [] data={9,79,46,30,58,49};
    @Test
    public  void heapSort() {//建堆
        /*
		 *        9
		 *      /   \
		 *    79    46
		 *   / \   /
		 * 30  58 49
		 */
        int arrayLength=data.length;
        for(int i=0;i<arrayLength-1;i++){
            System.out.println("开始堆排序");

            buildHead(arrayLength-1-i);//构建的是大顶堆，也就是在整个堆中把最大的元素放到顶端

            swap(0,arrayLength-1-i);//把每次大的元素都放到相对最后的那个索引位置，使其数组是按从小到大排列

        }
        for(int i :data){
            System.out.printf("%d ",i);

        }

    }

    /**
     *
     * @param lastIndex:代表的是子节点的索引号
     */
    public void buildHead(int lastIndex){

        for(int i=(lastIndex-1)/2;i>=0;i--){
            // /由儿子的索引lastIndex，通过公司变成父亲索引，在通过递减过程，挨个访问儿子，
            int k=i;
            while(k*2+1<=lastIndex ){//要判断的点是否在合理区间内
                int bigIndex=k*2+1;
                //两个兄弟先比，记住大的那个索引号
                if(bigIndex<lastIndex){

                    if(data[bigIndex]-data[bigIndex+1]<0){//左子比右子小,记录右子
                        bigIndex++;
                    }
                    //如果不满足条件，是不是就是大的索引就是bigIndex,左子比右子大
                }

                //较大的索引号的元素再个父亲比
                if(data[k]-data[bigIndex]<0){
                    swap(k,bigIndex);//如果父亲比儿子小，进行交换
                }else{

                    break;
                }

            }

        }




    }
    //i:父亲的索引，j：儿子的索引
    private  void swap( int i , int j){
        int tmp=data[i];
        data[i]=data[j];
        data[j]=tmp;

    }
}
