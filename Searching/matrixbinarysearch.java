package Searching;
public class matrixbinarysearch {
        public boolean searchMatrix(int[][] matrix, int target) {
            int k = 0;

            while (k <= matrix.length - 1) {

                int start = 0;
                int end = matrix[k].length - 1;
                while (start <= end) {
                    int mid = (start + end ) / 2;
                    if (matrix[k][mid] > target) {
                        end = mid - 1;
                    } else if (matrix[k][mid] < target) {
                        start = mid + 1;
                    } else {
                        return true;

                    }
                }
                k++;
            }


            return false;
        }
    }


