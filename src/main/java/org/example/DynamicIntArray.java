package org.example;
/* 1) У вас есть класс DynamicIntArray. Внутри него есть 3 характеристики:
- int lenght(реальный размер хранимых данных),
- int capacity(размер массива),
- массив int размером capacity (arr[capacity]),
константы:
- начальный размер массива по умолчанию (DEFAULT_CAPACITY),
- % изменения размера массива при автоматическом увеличениию (PROCENT_CHANGE).

Реализуйте 2 конструктора:
- по умолчанию (создается массив arr размером DEFAULT_CAPACITY)
- с параметром capacity (создается массив arr размер которого передается параметром  capacity).

Реализуйте методы:
- add(int element) - добавление элемента в конец (не забывайте про ограничения размера массива).
- add(int[] elements) - добавление массива элементов в конец нашего массива(не забывайте про ограничения размера массива).
- insert (int index, int element) - вставка элемента в место с нужным индексом (не забывайте про ограничения размера
массива и смещение элементов вправо)
- delete (int index) - удаление элемента (не забывайте про смещение элементов влево при операции).
 -get(int index) - вернуть значение элемента по index */

import java.util.Arrays;

public class DynamicIntArray {
    private int lenght;
    private int capacity;
    int[] arr = new int[capacity];
    private static final int DEFAULT_CAPACITY = 5;
    private static final double PROCENT_CHANGE = 0.5;

    public DynamicIntArray() {
        arr = new int[DEFAULT_CAPACITY];
    }

    public DynamicIntArray(int capacity) {
        if (capacity <= 0) {
            System.out.println("Размер массива должен быть больше 0");
        }
        arr = new int[capacity];
    }

    // add(int element) - добавление элемента в конец (не забывайте про ограничения размера массива).
    public void add(int element) {
        int[] newArr = Arrays.copyOf(arr, arr.length + 1);
        arr = Arrays.copyOf(newArr, newArr.length);
        arr[arr.length - 1] = element;
    }

    // add(int[] elements) - добавление массива элементов в конец нашего массива(не забывайте про
    // ограничения размера массива).

    public void add(int[] elements) {
        int[] newArr = new int[arr.length + elements.length];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        System.arraycopy(elements, 0, newArr, arr.length, elements.length);
        arr = Arrays.copyOf(newArr, newArr.length);
    }

    // insert (int index, int element) - вставка элемента в место с нужным индексом (не забывайте про ограничения размера
    // массива и смещение элементов вправо)
    public void insert(int index, int element) {
        int[] resArray = new int[arr.length + 1];
        System.arraycopy(arr, 0, resArray, 0, index);
        System.arraycopy(arr, index, resArray, index + 1, arr.length - index);
        resArray[index] = element;
        arr = resArray;
    }

    // delete (int index) - удаление элемента (не забывайте про смещение элементов влево при операции).
    public void delete1(int index) {
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr = Arrays.copyOfRange(arr, 0, arr.length - 1);
    }

    public void delete2(int index) {
        int[] resArray = new int[arr.length - 1];
        System.arraycopy(arr, 0, resArray, 0, index);
        System.arraycopy(arr, index + 1, resArray, index, arr.length - index - 1);
        arr = resArray;
    }

    // get(int index) - вернуть значение элемента по index
    public void get(int index) {
        System.out.println(arr[index]);
    }

    public static void main(String[] args) {
        DynamicIntArray dynamicIntArray = new DynamicIntArray();
        dynamicIntArray.arr[0] = 1;
        dynamicIntArray.arr[1] = 2;
        dynamicIntArray.arr[2] = 3;
        dynamicIntArray.arr[3] = 4;
        dynamicIntArray.arr[4] = 5;

        System.out.println(Arrays.toString(dynamicIntArray.arr));
        System.out.println("---------------------------");

        dynamicIntArray.add(6);
        System.out.println(Arrays.toString(dynamicIntArray.arr));
        System.out.println("---------------------------");

        int[] oldArray = {7, 8, 9, 10};
        dynamicIntArray.add(oldArray);
        System.out.println(Arrays.toString(dynamicIntArray.arr));
        System.out.println("---------------------------");

        dynamicIntArray.get(2);
        System.out.println("---------------------------");

        dynamicIntArray.delete1(2);
        System.out.println(Arrays.toString(dynamicIntArray.arr));
        System.out.println("---------------------------");

        dynamicIntArray.delete2(1);
        System.out.println(Arrays.toString(dynamicIntArray.arr));
        System.out.println("---------------------------");

        dynamicIntArray.insert(2, 20);
        System.out.println(Arrays.toString(dynamicIntArray.arr));
    }
}