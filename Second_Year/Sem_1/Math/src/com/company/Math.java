package com.company;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Math {
    private static String[] P;
    private static Map<Integer,BigDecimal> resultMap;

    public static void main(String[] args) {
        resultMap = new HashMap<>();

        // Xi
        char[] x = new char[]{'0', '1', '2', '3'};
        // Pi
        P = new String[]{"0.1", "0.2", "0.3", "0.4"};
        // выстрелы
        int n = 2;


        // get result and save in Map
        getSolution(x, n, "");

        // print result
        for (int i = 0; i < resultMap.size(); i++) {
            System.out.println("P(x = "+i+") = "+ resultMap.get(i));
        }

        // сумма
        BigDecimal sum = getSum();
        // сумма все p
        System.out.println("сумма = "+ sum);


        BigDecimal math = getMath();
        // математическое ожидание
        System.out.println("математическое ожидание  = "+math);

        // дисперсию числа
        BigDecimal dispersion = getDispersion(math);

        System.out.println("дисперсию числа = "+dispersion);


    }

    private static BigDecimal getDispersion(BigDecimal math) {
        BigDecimal e = new BigDecimal("0");
        for (int i = 0; i < resultMap.size(); i++) {
            e = e.add(resultMap.get(i).multiply(new BigDecimal((i*i))));
        }
        return e.subtract(math.multiply(math));
    }
    private static BigDecimal getMath() {
        BigDecimal r = new BigDecimal("0");
        for (int i = 0; i < resultMap.size(); i++) {
            r = r.add(resultMap.get(i).multiply(new BigDecimal(i)));
        }
        return r;
    }

    private static BigDecimal getSum() {
        BigDecimal sum = new BigDecimal("0");
        for (int i = 0; i < resultMap.size(); i++) {
            sum = sum.add(resultMap.get(i));
        }
        return sum;
    }





    public static void getSolution(char[] c, int n, String start){
        if(start.length() >= n){
           // System.out.println(start);
            setResult(start);
        }else{
            for(char x: c){
                getSolution(c, n, start+x);
            }
        }
    }








    private static void setResult(String start) {
        int sum = 0 ;
        BigDecimal mul = new BigDecimal("1");
        for (int i = 0; i <start.length(); i++) {
            int index = Integer.parseInt(String.valueOf(start.charAt(i)));
            sum += index;
            mul = mul.multiply(new BigDecimal(P[index]));
        }
        if (resultMap.containsKey(sum)){
            resultMap.replace(sum,resultMap.get(sum).add(mul));
        }else {
            resultMap.put(sum,mul);
        }
    }
}
