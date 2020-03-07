package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <T>{

    T[] array;

    public ArrayUtility(T[] array){
        this.array = array;
    }

    public Integer getNumberOfOccurrences(T item){
        Integer count = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i].equals(item))
                count++;
        }
        return count;
    }

    public T[] removeValue(T item){
        Integer occurance = getNumberOfOccurrences(item);
        T[] retArray = (T[]) Array.newInstance(item.getClass(), array.length-occurance);
        Integer retArrayCounter = 0;
        for (int i = 0; i < array.length; i++) {
            if(!array[i].equals(item))
                retArray[retArrayCounter] = array[i];
        }
        return retArray;
    }
}
