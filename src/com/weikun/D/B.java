package com.weikun.D;

import org.junit.Test;

/**
 * Created by Administrator on 2017/3/18.
 * 自己写HashMap
 *
 */
public class B {

    class Entity{//一旦发生冲突，就用链表进行协调，
        Entity next;//下一个元素的地址。
        Integer key;
        Integer value;
        int hash;
        Entity(Integer key,Integer value,int hash){
            this.key=key;
            this.value=value;
            this.hash=hash;
        }


    }

    private int size;// 当前容量
    private static int INIT_CAPACITY = 16;// 默认容量
    private Entity [] container=null;//装载元素的容器，是个对象数组
    private static float LOAD_FACTOR = 0.75f;//
    //装载因子:就是hash表中已经存储的关键字个数，
    //与可以散列位置的比值，表征着hash表中的拥挤情况，
    //一般而言，该值越大则越容易发生冲突，相应地ASL(平均查找长度)也增大
    private int max;// 能存的最大的数=capacity*factor 0.75越接近1，代表其越逼近16，也代表该容器越挤，
    //冲突越大

    public B(){
        this(INIT_CAPACITY,LOAD_FACTOR);
    }

    /**
     *
     * @param key:键
     * @param value：值
     * @return添加成功，返回true，否则返回false
     */
    public boolean put(Integer key,Integer value){
        int hash=key.hashCode();
        Entity ne=new Entity(key,value,hash);//新元素

        if(this.setEntry(ne,container)){
            this.size++;
            return true;
        }


        return false;
    }

    /**
     *
     * @param temp:x新元素
     * @param table：元素的集合
     * @return ：true：增加成功，false：增加失败
     */
    private boolean setEntry(Entity temp,Entity[] table){

        //根据hash码，计算容器下标值,尽量保持唯一，如果不唯一，就得使用单链的形式存储冲突的元素，速度变慢
        int index=this.indexFor(temp.hash,table.length);
       // System.out.printf("%d---%d\n",index,temp.key);
        Entity entity=table[index];//index指定的元素是否存在
        if(entity!=null){//存在
            while(entity!=null){
                //1判断新元素是否和老元素相同
                if((temp.key==entity.key || temp.key.equals(entity.key))&&(temp.value==entity.value||temp.value.equals(entity.value))&&(temp.hash==entity.hash)){
                    return false;
                }else if(entity.next==null){//可以添加元素了，添加到最后一个老元素的next，因为是个单链表
                    break;

                }

                entity=entity.next;
            }

            addLast(temp,entity);

        }
        //增加该元素
        setFirstEntry(temp,index,table);

        return true;
    }

    /**
     *
     * @param temp:新元素
     * @param entity：老元素
     */

    private void addLast(Entity temp, Entity entity) {
        if(size>max){
            reSize(container.length*4);
        }

        entity.next=temp;
    }

    /**
     * 将指定结点temp，添加到指定的hash表table的指定下标index中
     * @param temp ：新元素
     * @param index ：在数组中的索引号
     * @param table ：数组容器
     */
    private void setFirstEntry(Entity temp, int index, Entity[] table) {
        if(size>max){

           this.reSize(table.length*4);//开辟新空间

        }
        //无论是否扩容，都要走该句
        table[index]=temp;
        temp.next=null;
    }
    /**
     * 扩容，把老数组的内容送到新数组中
     *
     * @param newSize
     */
    private void reSize(int newSize) {
        Entity [] c=new Entity[newSize];
        //1.需要重新计算max
        this.max=(int)(LOAD_FACTOR*newSize);
        //2需要把老数组中的所有元素付给新数组
        for(int i=0;i<this.container.length;i++){

            Entity temp=this.container[i];//老元素

            while(temp!=null){//因为每个元素都是以单链表形式存在的，

                this.setEntry(temp,c);//把老数组的每个元素都送入到新数组中。

                temp=temp.next;
            }

        }

        //3把新数组的地址付给老数组
        this.container=c;

    }

    /**
     * 根据hash码，容器数组的长度,计算该哈希码在容器数组中的下标值
     *
     * @param hashcode
     * @param containerLength
     * @return
     */
    public int indexFor(int hashcode, int containerLength) {
        return hashcode & (containerLength-1);
    }

    /**
     *
     * @param init_cap；自定义的初始化容量
     * @param load_fac：自定义的加载因子
     */
    public B(int init_cap,float load_fac){
        INIT_CAPACITY=init_cap;
        LOAD_FACTOR=load_fac;
        this.max=(int)(INIT_CAPACITY*LOAD_FACTOR);//12
        container=new Entity[INIT_CAPACITY];//开辟容器的空间//16
    }



    /**
     * 根据键，取值
     *
     * @param k :键
     * @return ：该键对应的值
     */
    public int get(Integer k) {
        Entity temp=null;
        int index=this.indexFor(k.hashCode(),this.container.length);

        temp=this.container[index];//O1直接找到其对象

        if(temp==null){
            return -1;
        }else{

            while(temp!=null){

                if(temp.key==k || temp.key.equals(k)){

                    return temp.value;
                }
                temp=temp.next;
            }
        }
        return -1;


    }
    public void test(){
        long start=System.currentTimeMillis();

        for(int i=0;i<10000000;i++){

            this.put(i,i);
        }

        long end=System.currentTimeMillis();

        System.out.println("所得的时间是："+(end-start));
        System.out.println(this.get(73));
    }
    public static void main(String[] args) {
        B b=new B();
        b.test();
    }


}
