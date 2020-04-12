package com.company;

import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Извлечь корень из числа: ");
        int num = sc.nextInt();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(new SquareRoot(num));
        int result = future.get();
        System.out.println("Квадратный корень числа √" + num + " = " + result);
        executorService.shutdown();
    }
}

class SquareRoot implements Callable<Integer> {
    private int num;


    public SquareRoot(int num) {
        this.num = num;
    }

    @Override
    public Integer call() {
        int deduction = 1;
        double root = 0;
        while (num >= 1) {
            num -= deduction;
            deduction += 2;
            root++;
        }
        return (int) root;
    }
}

