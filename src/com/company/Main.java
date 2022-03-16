package com.company;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        IntArrayList List = new IntArrayList();
        System.out.println("Пустой список - " +  List);
        System.out.println("--------------------------------------------------");

        List.add(5);
        List.add(23);
        List.add(3);
        List.add(3);
        List.add(165);
        List.add(36);
        List.add(22);
        List.add(6);
        List.add(4);
        System.out.println("Метод  add() - " + List);
        System.out.println("--------------------------------------------------");
        List.add(3,202);
        List.add(5,999);
        System.out.println("Метод  add(). Добавление по индексу- " + List );
        System.out.println("--------------------------------------------------");

        List.remove(3);
        System.out.println("Удаление элемента с индексом 3 - " + List);
        System.out.println("--------------------------------------------------");
        List.removeByValue(3);
        System.out.println("Удаление элемента со значением - 3: " + List);
        System.out.println("--------------------------------------------------");

        System.out.println("Элемент с индексом  5 : " + List.get(5));
        System.out.println("--------------------------------------------------");
        List.set(0,86);
        System.out.println("Устанавливаем элемент cо значением 86 на позицию 0  - " + List);
        System.out.println("--------------------------------------------------");

        System.out.println("Проверка на пустоту: " + List.isEmpty());

        System.out.println("--------------------------------------------------");

        System.out.println("Элементов в списке - " + List.size() + "\nВозможное кол-во элементов в списке  - " + List.capacity());
        System.out.println("--------------------------------------------------");

        System.out.print("Метод toArray(). Список в массив: ");
        int[] arr = List.toArray();
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println("\n--------------------------------------------------");
        System.out.println("Метод SubList: возвращаем список элеметов с индексами в диапазоне (2 - 5): "+ List.subList(2,5));
        System.out.println("--------------------------------------------------");
        System.out.println("Метод toString: " + Arrays.toString(arr));
        System.out.println("--------------------------------------------------");
        List.clear();
        System.out.println("Проверка на пустоту после метода clear(): " + List.isEmpty() + "\n");
    }
}

