package Queue;

import java.util.Arrays;

public class Array<E> {
    private E[] data;
    private int size;
    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }
    public Array(){
        this(10);
    }
    public Array(E[] arr){
        size = arr.length;
        data = Arrays.copyOf(arr,arr.length);
    }
    public int getSize(){
        return size;
    }
    public int getCapacity(){
        return data.length;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void addLast(E e){
        add(size,e);
    }
    public void addFirst(E e){
        add(0,e);
    }
    public void add(int index, E e){
        if(size == data.length)
            resize(2 * data.length);
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add faild. Required index >= 0 and index <= size");
        for(int i = size;i > index;i --){
            data[i] = data[i - 1];
        }
        data[index] = e;
        size ++;
    }
    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal");
        return data[index];
    }
    public E getLast(){
        return get(size - 1);
    }
    public E getFirst(){
        return get(0);
    }
    void set(int index, E e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal");
        data[index] = e;
    }
    public boolean contains(E e){
        for(int i = 0; i < size; i++){
            if(data[i] == e)
                return true;
        }
        return false;
    }
    public int find(E e){
        for(int i = 0; i < size; i++){
            if(data[i] == e)
                return i;
        }
        return -1;
    }
    public E remove(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Remove faild. Index is illegal");
        E ret = data[index];
        for(int i = index + 1;i < size;i++){
            data[i - 1] = data[i];
        }
        size --;
        data[size] = null; //loitering object != memory leak;
        if(size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return ret;
    }
    public E removeFirst(){
        return remove(0);
    }
    public E removeLast(){
        return remove(size -1);
    }
    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append('[');
        for(int i = 0;i < size;i++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(',');
        }
        res.append(']');
        return res.toString();
    }
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0;i < size;i++){
            newData[i] = data[i];
        }
        data = newData;
    }
}
