package org.example;

import java.util.Scanner;

public class Celinder {
    public static void main (String [] args){

        System.out.println("달을 입력해주세요 : ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int month = Integer.parseInt(input);

        switch (month){
            case 1 :
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println(month + "월");
                for(int m=1; m <= 30; m++){
                    System.out.print(" " + m);
                    if(m % 7 ==0){
                        System.out.println();
                    }
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println(month + "월");
                for(int o=1; o<=31; o++){
                    System.out.print(" " + o);
                    if(o % 7 ==0){
                        System.out.println();
                    }
                }
                break;
            case 2:
                System.out.println(month + "월");
                for(int p=1; p<=28; p++){
                    System.out.print(" " + p);
                    if (p % 7 == 0){
                        System.out.println();
                    }
                }
                break;
            default:
                System.out.println("1월부터 12월까지 입력해주세요");
        }
    }

}
