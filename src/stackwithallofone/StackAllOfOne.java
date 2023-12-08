package stackwithallofone;

import util.CollectionUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StackAllOfOne {
    private List<StackObject> stackObjectList;
    private long timestamp;
    private int allValue;

    public StackAllOfOne() {
        this.timestamp = System.currentTimeMillis();
    }

    public void push(int val) {
        if (Objects.isNull(stackObjectList)) {
            stackObjectList = new ArrayList<>();
        }
        stackObjectList.add(
                new StackObject(val)
        );
    }

    public void updateAll(int value) {
        this.timestamp = System.currentTimeMillis();
        this.allValue = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        StackObject first = stackObjectList.getFirst();

        if (timestampHigherThan(first)) {
            first.value = allValue;
        }
        stackObjectList.removeFirst();
        return first.value;
    }


    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        StackObject first = stackObjectList.getFirst();

        return timestampHigherThan(first) ? allValue : first.value;
    }

    private boolean timestampHigherThan(StackObject last) {
        return timestamp - last.timestamp > 0;
    }


    private boolean isEmpty() {
        return CollectionUtil.isEmpty(stackObjectList);
    }


    private class StackObject {
        private int value;
        private final long timestamp;

        public StackObject(int value) {
            this.value = value;
            this.timestamp = System.currentTimeMillis();
        }


    }
}
