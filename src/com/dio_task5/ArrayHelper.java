package com.dio_task5;

import java.util.Arrays;

public class ArrayHelper {

    public Person[] merge(Person[] leftArray, Person[] rightArray) {
        int count = 0;
        checkFor_Null_And_EmptyArrays(leftArray);
        checkFor_Null_And_EmptyArrays(rightArray);

        Person[] res = Arrays.copyOf(leftArray, leftArray.length + rightArray.length);

        for (Person p : rightArray) {
            if (Arrays.binarySearch(leftArray, p) < 0) {
                res[leftArray.length + count] = p;
                count++;
            }
        }
        Person [] result = Arrays.copyOf(res, leftArray.length + count);
        System.out.println(result);
        return result;
    }

    public Person[] checkFor_Null_And_EmptyArrays(Person p[]){
        if(p.length == 0){
            Arrays.sort(p);
        }
        else if(p[0] == null && p[p.length/2] == null
                && p[p.length-1] == null){
            p = new Person[0];
        }
        else{
            Arrays.sort(p);}
        return p;
    }
}

