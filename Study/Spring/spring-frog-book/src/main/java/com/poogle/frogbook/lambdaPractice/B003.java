package com.poogle.frogbook.lambdaPractice;

public class B003 {
    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println("Hello Lambda 3");
        };
        r.run();
    }
}
