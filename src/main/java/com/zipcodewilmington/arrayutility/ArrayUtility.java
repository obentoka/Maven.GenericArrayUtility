package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <T>{

    T[] array;

    public ArrayUtility(T[] array){
        this.array = array;
    }

    public Integer getNumberOfOccurrences(T item){
        return (int)Arrays.stream(array)
                .filter(x -> x.equals(item))
                .count();
    }

    public T[] merge(T[] arrayToMerge){
        T[] retArray = Arrays.copyOf(array, array.length + arrayToMerge.length);
        for (int i = 0; i < array.length; i++) {
            retArray[i] = array[i];
        }
        for (int i = 0; i < arrayToMerge.length; i++) {
            retArray[array.length+i] = arrayToMerge[i];
        }
        return retArray;
    }

    public T[] removeValue(T item){
        Integer occurrence = getNumberOfOccurrences(item);
        T[] retArray = Arrays.copyOf(array, array.length - occurrence);
        Integer retArrayCounter = 0;
        for (int i = 0; i < array.length; i++) {
            if(!array[i].equals(item)) {
                retArray[retArrayCounter] = array[i];
                retArrayCounter++;
            }
        }
        return retArray;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valToEvaluate){
        T[] mergedArray = merge(arrayToMerge);
        return (int) Arrays.stream(mergedArray)
                .filter(x -> x.equals(valToEvaluate))
                .count();
    }

    public T getMostCommonFromMerge(T[] arrayToMerge){
        Integer maxCount = 0;
        T mostCommon = null;
        T[] mergedArray = merge(arrayToMerge);
        for (int i = 0; i < mergedArray.length; i++) {
            Integer count = 0;
            for (int j = 0; j < mergedArray.length; j++) {
                if(mergedArray[i].equals(mergedArray[j]))
                    count++;
            }
            if(count > maxCount){
                mostCommon = mergedArray[i];
                maxCount = count;
            }
        }
        return mostCommon;
    }
}
