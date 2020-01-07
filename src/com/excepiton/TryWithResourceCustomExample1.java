package com.excepiton;

public class TryWithResourceCustomExample1 {
    public static void main(String[] args) {
        try (CloseMe closeMe = new CloseMe()) {
            System.out.println("hello world");
            String test = null;
            test.toString();
            if(true) {
                return;
            }
        } catch (Exception e) {
            System.out.println("i am in catch");
            e.getMessage();
        } finally {
            System.out.println("i am in catch finally");
        }
    }
}
class CloseMe implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("I am inside closed method");
    }
}
