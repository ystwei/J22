package com.weikun.A;

/**
 * Created by Administrator on 2017/2/26.
 * ������ʵ�ֶ�
 */
public class B {
    private Object os[]=new Object[2];
    private int size=0;//����������������Ԫ�ظ���
    /*
    ��������
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
     * @param data:������
     * @return���Ƿ���ӳɹ���
     */
    public boolean push(Object data){
        if(size>=os.length){//Խ����
            this.resize();//����
        }
        os[size++]=data;

        return true;

    }

    /**
     *
     * @return��ջ����
     */
    public Object pop(){
        Object data=this.os[size-1];

        this.os[--size]=null;

        return  data;
    }

    /**
     *
     * @returnֻ��ջ������ɾ��
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
