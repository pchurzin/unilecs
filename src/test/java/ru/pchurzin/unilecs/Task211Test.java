package ru.pchurzin.unilecs;

import org.junit.Test;
import ru.pchurzin.unilecs.Task211.Node;

import static org.junit.Assert.assertEquals;

public class Task211Test {

    @Test
    public void merge() {
        Node node13 = new Node(4, null);
        Node node12 = new Node(2, node13);
        Node node11 = new Node(1, node12);

        Node node24 = new Node(5, null);
        Node node23 = new Node(4, node24);
        Node node22 = new Node(3, node23);
        Node node21 = new Node(1, node22);

        Node merge = Task211.merge(node11, node21);
        StringBuilder sb = new StringBuilder();
        for (Node n = merge; n != null; n = n.next) {
            sb.append("->").append(n.value);
        }
        String actual = sb.delete(0, "->".length()).toString();
        assertEquals("1->1->2->3->4->4->5", actual);
    }
}