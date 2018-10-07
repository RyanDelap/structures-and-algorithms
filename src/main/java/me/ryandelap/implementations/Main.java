package me.ryandelap.implementations;

import me.ryandelap.implementations.datastructures.SinglyLinkedList;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.append(1);
        list.append(234);
        list.append(123452345);

        for (Integer s : list) {
            System.out.println(s);
        }
    }
    List list = new ArrayList<>();
}
