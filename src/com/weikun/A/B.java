package com.weikun.A;

/**
 * Created by Administrator on 2017/2/26.
 * 用数组实现堆
 */
public class B {
    private Object os[]=new Object[2];
    private int size=0;//计数器，看真正的元素个数
    /*
    数组扩容
     */
    public void resize(){
        Object [] temp=new Object[os.length*3];
        for(int i=0;i<os.length;i++){
            temp[i]=os[i];
            os[i]=null;
        }
        os=temp;
    }

    /**
     *
     * @param data:新数据
     * @return：是否添加成功！
     */
    public boolean push(Object data){
        if(size>=os.length){//越界了
            this.resize();//扩容
        }
        os[size++]=data;

        return true;

    }

    /**
     *
     * @return出栈内容
     */
    public Object pop(){
        Object data=this.os[size-1];

        this.os[--size]=null;

        return  data;
    }

    /**
     *
     * @return只看栈顶，不删除
     */
    public Object peek(){
        Object data=this.os[size-1];



        return  data;
    }

    public static void main(String[] args) {
        B b=new B();
        b.push(1);
        b.push(2);
        b.push(3);
        b.push(4);

        System.out.println(b.peek());
        System.out.println(b.pop());
        System.out.println(b.pop());
    }
}
