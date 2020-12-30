package com.test.task;

public class Main {

    private static int count = 0;
    private static final int TEMP = 2;

    static int[][] ships = {
            { 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, },
            { 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, },
            { 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, },
            { 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, },
            { 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
            { 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
            { 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, },
            { 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, }
    };

    public static void main(String[] args) {


        for (int i = 0; i < ships.length; i++) {
            for (int j = 0; j < ships[i].length; j++) {
                if (ships[i][j] == 1) {

                    if (checkSquare(ships, i, j)) {
                        processSquare(ships, i, j);
                    } else {
                        if (checkVertical(ships, i, j)) {
                            processVertical(ships, i, j);
                        } else {
                            if (checkHorizontal(ships, i, j)) {
                                processHorizontal(ships, i, j);
                            } else {
                                ships[i][j] = TEMP;
                                count++;
                            }
                        }
                    }
                }
            }
        }

        System.out.println("Ships on the field - " + count);

        for (int i = 0; i < ships.length; i++) {
            for (int j = 0; j < ships[i].length; j++) {
                System.out.print(ships[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean checkSquare(int[][] array, int i, int j) {
        return (i + 1 < array.length && j + 1 < array[i].length && (array[i][j + 1] == 1 && array[i + 1][j] == 1));
    }

    private static boolean checkHorizontal(int[][] array, int i, int j) {
        return (j + 1 < array[i].length && array[i][j + 1] == 1 && !checkSquare(array, i, j));
    }

    private static boolean checkVertical(int[][] array, int i, int j) {
        return (i + 1 < array.length && array[i + 1][j] == 1 && array[i][j + 1] != 1);
    }

    private static void processSquare(int[][] array, int i, int j) {
        array[i][j] = TEMP;
        array[i][j + 1] = TEMP;
        array[i + 1][j] = TEMP;
        array[i + 1][j + 1] = TEMP;
        count++;
    }

    private static void processHorizontal(int[][] array, int i, int j) {
        for (int k = j; k < array[i].length; k++) {
            if (array[i][k] == 1) {
                array[i][k] = TEMP;
            } else {
                break;
            }
        }
        count++;
    }

    private static void processVertical(int[][] array, int i, int j) {
        for (int k = i; k < array.length; k++) {
            if (array[k][j] == 1) {
                array[k][j] = TEMP;
            } else {
                break;
            }
        }
        count++;
    }

}