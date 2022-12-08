package com.company;

import com.company.DoublyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DoublyLinkedListTest {

    @Test
    void addFirst() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addFirst(4);
        list.addFirst(5);
        Assertions.assertEquals(list, new DoublyLinkedList<>(5, 4));
    }

    @Test
    void addLast() {
        DoublyLinkedList<Float> list = new DoublyLinkedList<>();
        list.addLast(4.2F);
        list.addLast(5.7F);
        Assertions.assertEquals(list, new DoublyLinkedList<>(4.2F, 5.7F));
    }

    @Test
    void getFirst() throws Exception {
        DoublyLinkedList<String> list = new DoublyLinkedList<>("abc", "fff", "t");
        Assertions.assertEquals(list.getFirst(), "abc");
    }

    @Test
    void getLast() throws Exception {
        DoublyLinkedList<String> list = new DoublyLinkedList<>("abc", "fff", "t");
        Assertions.assertEquals(list.getLast(), "t");
    }

    @Test
    void get() throws Exception {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>(0, 2, 7, 18, 3, 6, 8, 5, 9);
        Assertions.assertEquals(list.get(3), 18);
        Assertions.assertEquals(list.get(7), 5);
        Assertions.assertEquals(list.get(0), 0);
        Assertions.assertEquals(list.get(8), 9);
    }

    @Test
    void removeFirst() throws Exception {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>(0, 2, 7, 18, 3, 6, 8, 5, 9);
        Assertions.assertEquals(list.removeFirst(), 0);
        Assertions.assertEquals(list, new DoublyLinkedList<>(2, 7, 18, 3, 6, 8, 5, 9));
    }

    @Test
    void removeLast() throws Exception {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>(0, 2, 7, 18, 3, 6, 8, 5, 9);
        Assertions.assertEquals(list.removeLast(), 9);
        Assertions.assertEquals(list, new DoublyLinkedList<>(0, 2, 7, 18, 3, 6, 8, 5));
    }

    @Test
    void remove() throws Exception {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>(0, 2, 7, 18, 3, 6, 8, 5, 9);
        Assertions.assertEquals(list.remove(3), 18);
        Assertions.assertEquals(list, new DoublyLinkedList<>(0, 2, 7, 3, 6, 8, 5, 9));
    }

    @Test
    void removeAll() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>(0, 3, 7, 18, 3, 3, 8, 5, 3);
        list.removeAll(3);
        Assertions.assertEquals(list, new DoublyLinkedList<>(0, 7, 18, 8, 5));
    }

    @Test
    void insert() throws Exception {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>(0, 7, 18, 8, 5);
        list.insert(3, 77);
        Assertions.assertEquals(list, new DoublyLinkedList<>(0, 7, 18, 77, 8, 5));
    }

    @Test
    void clear() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>(0, 7, 18, 8, 5);
        list.clear();
        Assertions.assertEquals(list, new DoublyLinkedList<>());
    }

    @Test
    void getCount() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>(0, 7, 18, 8, 5);
        Assertions.assertEquals(list.getCount(), 5);
    }
}