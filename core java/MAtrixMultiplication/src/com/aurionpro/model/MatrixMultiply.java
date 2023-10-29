package com.aurionpro.model;

public class MatrixMultiply {
	public static void main(String[] args) {
		int count=0;
		int[][] matrix1 = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		int[][] matrix2 = {
				{9,8,7},
				{6,5,4},
				{3,2,1}
		};
		
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int sum = 0;
                for (int k = 0; k < 3; k++) {
                    sum += matrix1[i][k] * matrix2[k][j];

                }
                if(count==3) {
                	System.out.println("\n");
                	count=0;
            }
                count++;
                System.out.print(" "+sum);

			}
		}
		
		
	}

}
