package lab4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class DirectMapping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the N (power of 2): ");
        int N = scanner.nextInt();
        System.out.print("Enter the M (power of 2): ");
        int M = scanner.nextInt();
        System.out.print("Enter the cache block size K (power of 2,K <= "+ N*M/4 +"): ");
        int K = scanner.nextInt();
        ArrayList<String> cacheMemory = new ArrayList<>();
        String[][][] mainMemory = new String[N][M][4];

        /*Creating main memory*/
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                mainMemory[i][j][0]= i+""+j+"c";
                mainMemory[i][j][1]= i+""+j+"m";
                mainMemory[i][j][2]= i+""+j+"k";
                mainMemory[i][j][3]= i+""+j+"y";

            }
        }

        /*for (String[][] row : mainMemory) {
            for (String[] rows : row) {
                System.out.print(Arrays.toString(rows));
            }
            System.out.println();
        }*/

        boolean cacheIsEmpty = true;
        int numberOfAccess = 0;
        int hitNumber = 0;
        int missNumber = 0;
        double hitRatio = 0;
        double missRatio = 0;
        System.out.println("Algoritm 1");
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                for (int k = 0; k < 4; k++) {
                    /*check cache is empty or not*/
                    if (cacheIsEmpty){
                        missNumber++;
                        int row = i;
                        int column = j;
                        int element = 0;
                        /*full cache first time*/
                        for (int l = 0; l < K; l++) {
                            cacheMemory.add(mainMemory[row][column][element]);
                            if(element<3){
                                element++;
                            }else {
                                element = 0;
                                if(column<M-1){
                                    column++;
                                }else {
                                    column = 0;
                                    row++;
                                }
                            }
                        }
                        cacheIsEmpty = false;
                    }else{
                        if(!cacheMemory.contains(mainMemory[i][j][k])){
                            missNumber++;
                            cacheMemory.clear();
                            int row = i;
                            int column = j;
                            int element = 0;
                            for (int l = 0; l < K; l++) {
                                cacheMemory.add(mainMemory[row][column][element]);
                                if(element<3){
                                    element++;
                                }else {
                                    element = 0;
                                    if(column<M-1){
                                        column++;
                                    }else {
                                        column = 0;
                                        row++;
                                    }
                                }
                            }
                        }else {
                            hitNumber++;
                        }
                    }

                    numberOfAccess++;

                }

            }
        }

        System.out.println("Number of accesses: "+numberOfAccess);
        System.out.println("Hit number: "+hitNumber);
        System.out.println("Miss number: "+missNumber);
        hitRatio = (double)hitNumber/numberOfAccess;
        System.out.println("Hit ratio: "+hitRatio+" = "+hitRatio*100+"%");
        missRatio = (double)missNumber/numberOfAccess;
        System.out.println("Miss ratio: "+missRatio+" = "+missRatio*100+"%");

        cacheMemory.clear();
        cacheIsEmpty = true;
        numberOfAccess = 0;
        hitNumber = 0;
        missNumber = 0;

        System.out.println();
        System.out.println("Algoritm 2");
        for(int j = 0; j < M; j++) {
            for(int i = 0; i < N; i++) {
                for (int k = 0; k < 4; k++) {
                    if (cacheIsEmpty){
                        missNumber++;
                        int row = i;
                        int column = j;
                        int element = 0;
                        for (int l = 0; l < K; l++) {
                            cacheMemory.add(mainMemory[row][column][element]);
                            if(element<3){
                                element++;
                            }else {
                                element = 0;
                                if(column<M-1){
                                    column++;
                                }else {
                                    column = 0;
                                    row++;
                                }
                            }
                        }
                        cacheIsEmpty = false;
                    }else{
                        if(!cacheMemory.contains(mainMemory[i][j][k])){
                            missNumber++;
                            cacheMemory.clear();
                            int row = i;
                            int column = j;
                            int element = 0;
                            for (int l = 0; l < K; l++) {
                                cacheMemory.add(mainMemory[row][column][element]);
                                if(element<3){
                                    element++;
                                }else {
                                    element = 0;
                                    if(column<M-1){
                                        column++;
                                    }else {
                                        column = 0;
                                        if(row<N-1) {
                                            row++;
                                        }
                                    }
                                }
                            }
                        }else {
                            hitNumber++;
                        }
                    }


                    numberOfAccess++;


                }

            }
        }

        System.out.println("Number of accesses: "+numberOfAccess);
        System.out.println("Hit number: "+hitNumber);
        System.out.println("Miss number: "+missNumber);
        hitRatio = (double)hitNumber/numberOfAccess;
        System.out.println("Hit ratio: "+hitRatio+" = "+hitRatio*100+"%");
        missRatio = (double)missNumber/numberOfAccess;
        System.out.println("Miss ratio: "+missRatio+" = "+missRatio*100+"%");


        cacheMemory.clear();
        cacheIsEmpty = true;
        numberOfAccess = 0;
        hitNumber = 0;
        missNumber = 0;

        System.out.println();
        System.out.println("Algoritm 3");
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if (cacheIsEmpty) {
                    missNumber++;
                    int row = i;
                    int column = j;
                    int element = 0;
                    for (int l = 0; l < K; l++) {
                        cacheMemory.add(mainMemory[row][column][element]);
                        if (element < 3) {
                            element++;
                        } else {
                            element = 0;
                            if (column < M - 1) {
                                column++;
                            } else {
                                column = 0;
                                row++;
                            }
                        }
                    }
                    cacheIsEmpty = false;
                }else {
                    if (!cacheMemory.contains(mainMemory[i][j][2])) {
                        missNumber++;
                        cacheMemory.clear();
                        int row = i;
                        int column = j;
                        int element = 0;
                        for (int l = 0; l < K; l++) {
                            cacheMemory.add(mainMemory[row][column][element]);
                            if (element < 3) {
                                element++;
                            } else {
                                element = 0;
                                if (column < M - 1) {
                                    column++;
                                } else {
                                    column = 0;
                                    row++;
                                }
                            }
                        }
                    } else {
                        hitNumber++;
                    }
                }
                numberOfAccess++;
            }
        }
        System.out.println("1 part");
        System.out.println("Number of accesses: "+numberOfAccess);
        System.out.println("Hit number: "+hitNumber);
        System.out.println("Miss number: "+missNumber);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                for (int k = 0; k < 3; k++) {
                    if(!cacheMemory.contains(mainMemory[i][j][k])) {
                        missNumber++;
                        cacheMemory.clear();
                        int row = i;
                        int column = j;
                        int element = 0;
                        for (int l = 0; l < K; l++) {
                            cacheMemory.add(mainMemory[row][column][element]);
                            if (element < 3) {
                                element++;
                            } else {
                                element = 0;
                                if (column < M - 1) {
                                    column++;
                                } else {
                                    column = 0;
                                    row++;
                                }
                            }
                        }
                    }else {
                        hitNumber++;
                    }
                    numberOfAccess++;
                }

            }
        }

        System.out.println("Number of accesses: "+numberOfAccess);
        System.out.println("Hit number: "+hitNumber);
        System.out.println("Miss number: "+missNumber);
        hitRatio = (double)hitNumber/numberOfAccess;
        System.out.println("Hit ratio: "+hitRatio+" = "+hitRatio*100+"%");
        missRatio = (double)missNumber/numberOfAccess;
        System.out.println("Miss ratio: "+missRatio+" = "+missRatio*100+"%");

    }
}

