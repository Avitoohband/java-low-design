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
        stackObjectList.clear();
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        StackObject last = stackObjectList.getLast();

        if (timestampHigherThan(last)) {
            return allValue;
        }
        stackObjectList.removeLast();
        return last.value;
    }


    public int peek() {
        if (isEmpty()) {
            return -1;
        }
        StackObject last = stackObjectList.getLast();

        return timestampHigherThan(last) ? allValue : last.value;
    }

    private boolean timestampHigherThan(StackObject last) {
        return timestamp - last.timestamp > 0;
    }


    private boolean isEmpty() {
        return CollectionUtil.isEmpty(stackObjectList);
    }


    private class StackObject {
        private final int value;
        private final long timestamp;

        public StackObject(int value) {
            this.value = value;
            this.timestamp = System.currentTimeMillis();
        }

    }
}
