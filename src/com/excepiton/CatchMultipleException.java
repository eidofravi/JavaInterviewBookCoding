package com.excepiton;

public class CatchMultipleException {
    public static void main(String[] args) {
        try {

        } catch(NullPointerException | IllegalArgumentException  e) {

        } catch(RuntimeException e) {

        }
    }
}
