package com.wuwenhuan.leetcode;

import java.util.Arrays;

public class Solution498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return null;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[] result = new int[row * col];
        int pos = 0;
        for (int i = 0; i < row + col - 1; i++) {
            if (i % 2 == 0) {
                int x = i < row ? i : row - 1;
                int y = i < row ? 0 : i - row + 1;
                while (x >= 0 && y < col) {
                    result[pos] = matrix[x][y];
                    x--;
                    y++;
                    pos++;
                }
            } else {
                int x = i < col ? 0 : i - col + 1;
                int y = i < col ? i : col - 1;
                while (x < row && y >= 0) {
                    result[pos] = matrix[x][y];
                    x++;
                    y--;
                    pos++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Solution498 solution498 = new Solution498();
        System.out.println(Arrays.toString(solution498.findDiagonalOrder(m)));


    }


}

