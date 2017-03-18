package com.weikun.D;

import org.junit.Test;

/**
 * Created by Administrator on 2017/3/18.
 * �Լ�дHashMap
 *
 */
public class B {

    class Entity{//һ��������ͻ�������������Э����
        Entity next;//��һ��Ԫ�صĵ�ַ��
        Integer key;
        Integer value;
        int hash;
        Entity(Integer key,Integer value,int hash){
            this.key=key;
            this.value=value;
            this.hash=hash;
        }


    }

    private int size;// ��ǰ����
    private static int INIT_CAPACITY = 16;// Ĭ������
    private Entity [] container=null;//װ��Ԫ�ص��������Ǹ���������
    private static float LOAD_FACTOR = 0.75f;//
    //װ������:����hash�����Ѿ��洢�Ĺؼ��ָ�����
    //�����ɢ��λ�õı�ֵ��������hash���е�ӵ�������
    //һ����ԣ���ֵԽ����Խ���׷�����ͻ����Ӧ��ASL(ƽ�����ҳ���)Ҳ����
    private int max;// �ܴ��������=capacity*factor 0.75Խ�ӽ�1��������Խ�ƽ�16��Ҳ���������Խ����
    //��ͻԽ��

    public B(){
        this(INIT_CAPACITY,LOAD_FACTOR);
    }

    /**
     *
     * @param key:��
     * @param value��ֵ
     * @return��ӳɹ�������true�����򷵻�false
     */
    public boolean put(Integer key,Integer value){
        int hash=key.hashCode();
        Entity ne=new Entity(key,value,hash);//��Ԫ��

        if(this.setEntry(ne,container)){
            this.size++;
            return true;
        }


        return false;
    }

    /**
     *
     * @param temp:x��Ԫ��
     * @param table��Ԫ�صļ���
     * @return ��true�����ӳɹ���false������ʧ��
     */
    private boolean setEntry(Entity temp,Entity[] table){

        //����hash�룬���������±�ֵ,��������Ψһ�������Ψһ���͵�ʹ�õ�������ʽ�洢��ͻ��Ԫ�أ��ٶȱ���
        int index=this.indexFor(temp.hash,table.length);
       // System.out.printf("%d---%d\n",index,temp.key);
        Entity entity=table[index];//indexָ����Ԫ���Ƿ����
        if(entity!=null){//����
            while(entity!=null){
                //1�ж���Ԫ���Ƿ����Ԫ����ͬ
                if((temp.key==entity.key || temp.key.equals(entity.key))&&(temp.value==entity.value||temp.value.equals(entity.value))&&(temp.hash==entity.hash)){
                    return false;
                }else if(entity.next==null){//�������Ԫ���ˣ���ӵ����һ����Ԫ�ص�next����Ϊ�Ǹ�������
                    break;

                }

                entity=entity.next;
            }

            addLast(temp,entity);

        }
        //���Ӹ�Ԫ��
        setFirstEntry(temp,index,table);

        return true;
    }

    /**
     *
     * @param temp:��Ԫ��
     * @param entity����Ԫ��
     */

    private void addLast(Entity temp, Entity entity) {
        if(size>max){
            reSize(container.length*4);
        }

        entity.next=temp;
    }

    /**
     * ��ָ�����temp����ӵ�ָ����hash��table��ָ���±�index��
     * @param temp ����Ԫ��
     * @param index ���������е�������
     * @param table ����������
     */
    private void setFirstEntry(Entity temp, int index, Entity[] table) {
        if(size>max){

           this.reSize(table.length*4);//�����¿ռ�

        }
        //�����Ƿ����ݣ���Ҫ�߸þ�
        table[index]=temp;
        temp.next=null;
    }
    /**
     * ���ݣ���������������͵���������
     *
     * @param newSize
     */
    private void reSize(int newSize) {
        Entity [] c=new Entity[newSize];
        //1.��Ҫ���¼���max
        this.max=(int)(LOAD_FACTOR*newSize);
        //2��Ҫ���������е�����Ԫ�ظ���������
        for(int i=0;i<this.container.length;i++){

            Entity temp=this.container[i];//��Ԫ��

            while(temp!=null){//��Ϊÿ��Ԫ�ض����Ե�������ʽ���ڵģ�

                this.setEntry(temp,c);//���������ÿ��Ԫ�ض����뵽�������С�

                temp=temp.next;
            }

        }

        //3��������ĵ�ַ����������
        this.container=c;

    }

    /**
     * ����hash�룬��������ĳ���,����ù�ϣ�������������е��±�ֵ
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
     * @param init_cap���Զ���ĳ�ʼ������
     * @param load_fac���Զ���ļ�������
     */
    public B(int init_cap,float load_fac){
        INIT_CAPACITY=init_cap;
        LOAD_FACTOR=load_fac;
        this.max=(int)(INIT_CAPACITY*LOAD_FACTOR);//12
        container=new Entity[INIT_CAPACITY];//���������Ŀռ�//16
    }



    /**
     * ���ݼ���ȡֵ
     *
     * @param k :��
     * @return ���ü���Ӧ��ֵ
     */
    public int get(Integer k) {
        Entity temp=null;
        int index=this.indexFor(k.hashCode(),this.container.length);

        temp=this.container[index];//O1ֱ���ҵ������

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

        System.out.println("���õ�ʱ���ǣ�"+(end-start));
        System.out.println(this.get(73));
    }
    public static void main(String[] args) {
        B b=new B();
        b.test();
    }


}
