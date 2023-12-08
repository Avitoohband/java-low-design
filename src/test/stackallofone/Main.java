package test.stackallofone;

import stackwithallofone.StackAllOfOne;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        StackAllOfOne stack = new StackAllOfOne();

        stack.push(5);
        Thread.sleep(100);
        stack.updateAll(1);
        stack.push(6);
        System.out.println(stack.pop());
        System.out.println(stack.peek());


    }
}
