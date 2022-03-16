package com.company;

import java.util.Arrays;

public class IntArrayList  implements IntList {
    private int size;
    private int[] arr;
    private int LastElementIndex = 0;

        public IntArrayList() {
        this.size = 10;
        this.arr = new int[size];
    }

    public int[] expandList(int[] oldArray){
        this.size = arr.length * 3 / 2 + 1;
        int[] newArray = new int[size];
        System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
        return newArray;
    }

    public void trimToSize(){
        this.size = LastElementIndex;
        int[] temp =  new int[LastElementIndex];
        System.arraycopy(arr, 0, temp, 0, temp.length);
        this.arr = temp;
    }

    @Override
    public void add(int element) {
        if(this.LastElementIndex < size){
            arr[LastElementIndex] = element;
            this.LastElementIndex++;
        }
        else {
            arr = expandList(arr);
            add(element);
        }
    }

    @Override
    public boolean add(int index, int element) {
        arr = LastElementIndex == size? expandList(arr) : arr;
        int[] temp = new int[arr.length];
        for (int i = 0; i < LastElementIndex + 1; i++){
            if(i < index){
                temp[i] = arr[i]; }
            else if(i == index){
                temp[i] = element; }
            else {
                temp[i] = arr[i - 1];
            }
        }

        LastElementIndex++;
        arr = temp;
        return true;
    }

    @Override
    public void clear() {
        Arrays.fill(arr, 0);
        LastElementIndex = 0;
    }

    @Override
    public int get(int index) {
        if(index > this.LastElementIndex){
            System.out.println("Нет искомого элемента");
        }
        return arr[index];
    }

    @Override
    public boolean isEmpty() {
        return LastElementIndex == 0;
    }

    @Override
    public boolean remove(int index) {
        int[] temp = new int[arr.length];
        for (int i = 0; i < LastElementIndex - 1; i++){
            if(i < index){ temp[i] = arr[i];
            }
            else if(i == index){ temp[i] = arr[i + 1];
            }
            else { temp[i] = arr[i + 1]; }
        }
        arr = temp;
        LastElementIndex--;
        trimToSize();
        return true;
    }

    @Override
    public boolean removeByValue(int value) {
        for (int i = 0; i < this.arr.length; i++){
            if(arr[i] == value){
                remove(i);
            }
        }

        return true;
    }

    @Override
    public boolean set(int index, int element) {
        if(index > this.LastElementIndex){
            System.out.println("Нет искомого индекса");
            return false;
        }
        else{
            arr[index] = element;
        }
        return true;
    }

    @Override
    public int size() {
        return LastElementIndex;
    }
    @Override
    public int capacity() {
        return this.size;
    }

    @Override
    public IntList subList(int fromIndex, int toIndex) {
        IntArrayList subList = new IntArrayList();
        if(fromIndex <= LastElementIndex && toIndex <= LastElementIndex){
            for(int i = 0; i < arr.length; i++){
                if(i >= fromIndex && i <= toIndex){
                    subList.add(arr[i]);
                }
            }
        }
        else{
            System.out.println("Нет искомых индексов");
        }
        return subList;
    }

    @Override
    public int[] toArray() {
        int[] array = new int[LastElementIndex];
    for(int i=0; i<LastElementIndex; i++) {
        array[i]=arr[i];
        }
        return array;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}

