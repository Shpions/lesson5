package com.dio_task5;

public class ServiceDelegate {
    private final ArrayHelper resourse;

    public ServiceDelegate(ArrayHelper resourse) {
        this.resourse = resourse;
    }

    public Person[] merge(Person[] leftArray, Person[] rightArray) {
        printArray(leftArray);
        printArray(rightArray);

        checkFor_NullAndEmptyNames(leftArray);
        checkFor_NullAndEmptyNames(rightArray);

        Person [] res = resourse.merge(leftArray, rightArray);

        printArray(res);

        return res;
    }

    public void checkFor_NullAndEmptyNames(Person [] persons){
        for(Person p : persons){
            if(p.getName() == null || p.getName().isEmpty()){
                throw new IllegalArgumentException();
            }
        }
    }

    public void printArray(Person [] persons) {
        for(Person p : persons){
            System.out.println(p);
        }
        System.out.println();
    }
}
