package ru.pchurzin.unilecs;

public class Task211 {

    public static Node merge(Node first, Node second) {
        if (first == null && second == null) {
            return null;
        }
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }

        Node result;

        if (first.value <= second.value) {
            result = first;
            first = first.next;
        } else {
            result = second;
            second = second.next;
        }
        Node r = result;
        while (first != null && second != null) {
            if (first.value <= second.value) {
                r.next = first;
                first = first.next;
            } else {
                r.next = second;
                second = second.next;
            }
            r = r.next;
        }
        if (first == null) {
            r.next = second;
        }
        if (second == null) {
            r.next = first;
        }
        return result;
    }

    public static class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
