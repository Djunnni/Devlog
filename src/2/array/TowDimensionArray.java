package chapter7.array;

public class TowDimensionArray {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3}, {4,5,6}};

        // 행의 길이
        System.out.println(arr.length);
        // 열의 길이
        System.out.println(arr[0].length);
        // 순회
        for(int i=0; i< arr.length; i++) {
            for(int j=0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);
            }
        }

        char[][] arr2 = new char[13][2];
        char ch= 'A';

        for(int i=0; i < arr2.length; i++) {
            for(int j=0; j < arr2[i].length; j++, ch++) {
                arr2[i][j] = ch;
            }
        }
        for(int i=0; i < arr2.length; i++) {
            for(int j=0; j < arr2[i].length; j++) {
               System.out.println(arr2[i][j]);
            }
        }

    }
}
