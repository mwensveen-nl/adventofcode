package nl.mwensveen.adventofcode.year_2018.day_9;

import com.google.common.base.MoreObjects;

public class Circle {

    private Node current;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node print = current;
        builder.append(print.value);
        print = print.next;
        while (current != print) {
            builder.append(", ").append(print.value);
            print = print.next;
        }
        return builder.toString();
    }

    public Circle(int value) {
        current = new Node(value);
    }

    public void add(int value) {
        current = current.next;
        Node newNode = new Node(value, current, current.next);
        current.next = newNode;
        newNode.next.previous = newNode;
        current = newNode;
    }

    public long remove() {
        Node removed = current.previous.previous.previous.previous.previous.previous.previous;
        removed.previous.next = removed.next;
        removed.next.previous = removed.previous;
        current = removed.next;
        return removed.value;
    }

    private static class Node {
        private long value;
        private Node previous;
        private Node next;

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this).add("value", value).toString();
        }

        public Node(long initValue) {
            value = initValue;
            previous = this;
            next = this;
        }

        public Node(long value, Node previous, Node next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }
}
