package com.company;
import com.company.Model.Answer;
import com.company.Model.MyThread;
import com.company.Model.WrongAnswer;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        boolean printTime = needTheTime(args);

        if (args.length == 2 || printTime) {

            // time
            long t = System.nanoTime();
            // path file 1
            String pathF1 = args[0];
            // path file 2
            String pathF2 = args[1];

            MyThread X = new MyThread(pathF1);
            MyThread Y = new MyThread(pathF2);

            X.start();
            Y.start();

            X.join();
            Y.join();
            // error
            if (X.list == null) {
                System.out.println(new WrongAnswer(502, "не найден файл 1."));
                return;
            }
            // error
            if (Y.list == null) {
                System.out.println(new WrongAnswer(502, "не найден файл 2."));
                return;
            }
            // error
            if (X.list.size() != Y.list.size()) {
                System.out.println(new WrongAnswer(500, "ошибка"));
                return;
            }
            // get solution r(x,y)
            double result = getResult(X, Y);
            System.out.println(new Answer(result));
            if (printTime) {
                System.out.println("Time program = " + (System.nanoTime() - t));
            }
        } else {
            System.out.println(new WrongAnswer(501, "неверное количество аргументов"));
        }
    }

    private static boolean needTheTime(String[] args) {
        return args.length == 3 && args[2].trim().equals("-t") ;
    }

    private static double getResult(MyThread x, MyThread y) {
        double u = (x.sumOfClose * y.sumOfClose);
        double d = (x.b_x * y.b_x);
        return u / d ;
    }
}
