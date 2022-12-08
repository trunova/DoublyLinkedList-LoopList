package com.company;

import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoopListTest {
    @Test
    @Ignore
    void addFirst() {
        LoopList<Integer> list = new LoopList<>();
        list.addFirst(4);
        list.addFirst(5);
        Assertions.assertEquals(list, new LoopList<>(5, 4));
    }

    @Test
    void addLast() {
        LoopList<Float> list = new LoopList<>();
        list.addLast(4.2F);
        list.addLast(5.7F);
        Assertions.assertEquals(list, new LoopList<>(4.2F, 5.7F));
    }

    @Test
    void getFirst() throws Exception {
        LoopList<String> list = new LoopList<>("abc", "fff", "t");
        Assertions.assertEquals(list.getFirst(), "abc");
    }

    @Test
    void getLast() throws Exception {
        LoopList<String> list = new LoopList<>("abc", "fff", "t");
        Assertions.assertEquals(list.getLast(), "t");
    }

    @Test
    void get() throws Exception {
        LoopList<Integer> list = new LoopList<>(0, 2, 7, 18, 3, 6, 8, 5, 9);
        Assertions.assertEquals(list.get(3), 18);
        Assertions.assertEquals(list.get(7), 5);
        Assertions.assertEquals(list.get(0), 0);
        Assertions.assertEquals(list.get(8), 9);
    }

    @Test
    void removeFirst() throws Exception {
        LoopList<Integer> list = new LoopList<>(0, 2, 7, 18, 3, 6, 8, 5, 9);
        Assertions.assertEquals(list.removeFirst(), 0);
        Assertions.assertEquals(list, new LoopList<>(2, 7, 18, 3, 6, 8, 5, 9));
    }

    @Test
    void removeLast() throws Exception {
        LoopList<Integer> list = new LoopList<>(0, 2, 7, 18, 3, 6, 8, 5, 9);
        Assertions.assertEquals(list.removeLast(), 9);
        Assertions.assertEquals(list, new LoopList<>(0, 2, 7, 18, 3, 6, 8, 5));
    }

    @Test
    void remove() throws Exception {
        LoopList<Integer> list = new LoopList<>(0, 2, 7, 18, 3, 6, 8, 5, 9);
        Assertions.assertEquals(list.remove(3), 18);
        Assertions.assertEquals(list, new LoopList<>(0, 2, 7, 3, 6, 8, 5, 9));
    }

    @Test
    void removeAll() {
        LoopList<Integer> list = new LoopList<>(0, 3, 7, 18, 3, 3, 8, 5, 3);
        list.removeAll(3);
        Assertions.assertEquals(list, new LoopList<>(0, 7, 18, 8, 5));
    }

    @Test
    void insert() throws Exception {
        LoopList<Integer> list = new LoopList<>(0, 7, 18, 8, 5);
        list.insert(3, 77);
        Assertions.assertEquals(list, new LoopList<>(0, 7, 18, 77, 8, 5));
    }

    @Test
    void clear() {
        LoopList<Integer> list = new LoopList<>(0, 7, 18, 8, 5);
        list.clear();
        Assertions.assertEquals(list, new LoopList<>());
    }

    @Test
    void getCount() {
        LoopList<Integer> list = new LoopList<>(0, 7, 18, 8, 5);
        Assertions.assertEquals(list.getCount(), 5);
    }
}