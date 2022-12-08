package com.company;

import java.util.Iterator;

public class LoopList<T> implements Iterable<T> {
    public LoopList() {}

    @SafeVarargs
    public LoopList(T ... args) {
        int len = args.length;
        if (len == 1) {
            head = new ListNode<>(args[0]);
            tail = head;
        }
        else {
            head = new ListNode<>(args[0], new ListNode<T>(), null);
            ListNode<T> temp = head.next;
            temp.value = args[1];
            temp.prev = head;
            for (int i = 2; i < len; i++) {
                temp.next = new ListNode<>(args[i], null, temp);
                temp.prev = temp;
                temp = temp.next;
            }
            tail = temp;
            tail.next = head;
        }
        count += len;
    }

    private class ListNode<T> {
        public T value;
        public ListNode<T> next;
        public ListNode<T> prev;

        public ListNode(T value, ListNode<T> next, ListNode<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
        public ListNode(T value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        public ListNode() {
        }

        public T getValue() {
            return value;
        }

        public ListNode<T> getNext() {
            return next;
        }

        public ListNode<T> getPrev() {
            return prev;
        }
    }

    private ListNode<T> head = null;
    private ListNode<T> tail = null;
    private int count = 0;

    public void addFirst(T value) {
        head = new ListNode<>(value, head, null);
        if (count == 0)
            tail = head;
        else {
            head.next.prev = head;
            tail.next = head;
        }
        count++;
    }

    public void addLast(T value) {
        ListNode<T> newNode = new ListNode<>(value, null, tail);
        if (count > 0) {
            tail.next = newNode;
            tail.next.next = head;
        } else {
            head = newNode;
        }
        tail = newNode;
        count++;
    }

    private void emptyError() throws Exception {
        if (count == 0) {
            throw new Exception("List is empty");
        }
    }

    public T getFirst() throws Exception {
        emptyError();
        return head.value;
    }

    public T getLast() throws Exception {
        emptyError();
        return tail.value;
    }

    private ListNode<T> getNode(int index) throws Exception {
        if (index < 0 || index >= count) {
            throw new Exception("Wrong index");
        }
        ListNode<T> curr;
        if(index <= count/2) {
            curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
        } else {
            curr = tail;
            for (int i = count - 1; i > index; i--) {
                curr = curr.prev;
            }
        }
        return curr;
    }

    public T get(int index) throws Exception {
        ListNode<T> curr = getNode(index);
        return curr.value;
    }

    public T removeFirst() throws Exception {
        T value = getFirst();
        head = head.next;
        tail.next = head;
        head.prev = tail;
        count--;
        if (count == 0) {
            tail = null;
        }
        return value;
    }

    public T removeLast() throws Exception {
        T value = getLast();
        count--;
        if (count == 0) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
        }
        return value;
    }

    public T remove(int index) throws Exception {
        if (index < 0 || index >= count) {
            throw new Exception("Wrong index");
        }
        T value;
        count--;
        if (index == 0) {
            value = head.value;
            head = head.next;
            tail.next = head;
            head.prev = tail;
            if (count == 0)
                tail = null;
            else head.prev = null;
        } else if (index == count - 1) {
            value = tail.value;
            if (count == 0) {
                head = tail = null;
            } else {
                tail = tail.prev;
                tail.next = head;
                head.prev = tail;
            }
        } else {
            ListNode<T> prev = getNode(index - 1);
            value = prev.next.value;
            prev.next = prev.next.next;
            if (prev.next == null)
                tail = prev;
            else prev.next.prev = prev;
        }
        return value;
    }

    public void removeAll(T value) {
        while (head != null && value.equals(head.value)) {
            head = head.next;
            head.prev = tail;
            tail.next = head;
            count--;
        }
        for (ListNode<T> curr = head; curr != null; curr = curr.next) {
            while (curr.next != null && value.equals(curr.next.value)) {
                curr.next = curr.next.next;
                count--;
            }
            if (curr.next == null)
                tail = curr;
            else curr.next.prev = curr;
        }
    }

    public void insert(int index, T value) throws Exception {
        if (index < 0 || index > count) {
            throw new Exception("Wrong index");
        }
        if (index == 0)
            addFirst(value);
        else if (index == count - 1)
            addLast(value);
        else {
            ListNode<T> prev = getNode(index - 1);
            prev.next = new ListNode<>(value, prev.next, prev);
            prev.next.next.prev = prev.next;
            count++;
        }
    }

    public void clear() {
        head = tail = null;
        count = 0;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[ ");
        for (ListNode<T> a = head; a != null; a = a.next) {
            str.append(a.value).append(", ");
        }
        return str.substring(0, str.length() - 2) +" ]";
    }


    @Override
    public Iterator<T> iterator() {
        class DoublyLinkedListIterator implements Iterator<T> {
            ListNode<T> curr;

            public DoublyLinkedListIterator(ListNode<T> head) {
                curr = head;
            }

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                curr = curr.next;
                return curr.prev.value;
            }
        }
        return new DoublyLinkedListIterator(head);
    }

    @Override
    public boolean equals(Object obj) {
        final float EPS = 1e-7f;
        if (obj.getClass() != this.getClass())
            return false;
        LoopList<T> list = (LoopList<T>) obj;
        try {
            if (count != list.getCount())
                return false;
            if (count == 0) return true;
            ListNode<T> newListNode = list.getNode(0);
            for (ListNode<T> listNode = head; listNode != null; listNode = listNode.next) {
                if (head.value instanceof Float) {
                    if ((float) listNode.value - (float) newListNode.value >= EPS)
                        return false;
                } else if (!listNode.value.equals(newListNode.value))
                    return false;
                newListNode = newListNode.next;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
