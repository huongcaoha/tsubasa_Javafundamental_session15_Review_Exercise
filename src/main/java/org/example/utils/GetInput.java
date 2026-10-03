package org.example.utils;

import java.util.Scanner;

public class GetInput {

    public static String getString(Scanner scanner ,String suggestion){
        do {
            System.out.println(suggestion);
            String input = scanner.nextLine();
            if(input.isEmpty()){
                System.out.println("Vui lòng không để trống");
            }else {
                return input;
            }
        }while(true);

    }

    public static int getInt(Scanner scanner ,String suggestion ,int min , int max){
        do {
            try {
                System.out.println(suggestion);
                int number = Integer.parseInt(scanner.nextLine());
                if(number<min || number>max){
                    System.out.println("Vùi lòng nhập trong khoảng " + min + " đến " + max);
                }else {
                    return number;
                }
            }catch (Exception e){
                System.out.println("Vui lòng nhập vào số nguyên trong khoảng "+ min + " đến " + max);
            }
        }while(true);
    }

    public static long getLong(Scanner scanner ,String suggestion ,long min , long max){
        do {
            try {
                System.out.println(suggestion);
                long number = Integer.parseInt(scanner.nextLine());
                if(number<min || number>max){
                    System.out.println("Vùi lòng nhập trong khoảng " + min + " đến " + max);
                }else {
                    return number;
                }
            }catch (Exception e){
                System.out.println("Vui lòng nhập vào số nguyên trong khoảng "+ min + " đến " + max);
            }
        }while(true);
    }

    public static float getFloat(Scanner scanner ,String suggestion ,float min , float max){
        do {
            try {
                System.out.println(suggestion);
                float number = Float.parseFloat(scanner.nextLine());
                if(number<min || number>max){
                    System.out.println("Vùi lòng nhập trong khoảng " + min + " đến " + max);
                }else {
                    return number;
                }
            }catch (Exception e){
                System.out.println("Vui lòng nhập vào số thực trong khoảng "+ min + " đến " + max);
            }
        }while(true);
    }

    public static boolean getBoolean(Scanner scanner , String suggestion){

            System.out.println(suggestion);
            int input = getInt(scanner,suggestion,0,1);
            return input == 1 ;

    }
}
