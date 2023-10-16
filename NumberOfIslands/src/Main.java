public class Main {
    public static void main(String[] args) {
        char [][] twoDimArray = {
                {'0','0','1','1'},
                {'0','0','0','0'},
                {'0','1','1','1'},
                {'0','1','1','1'}
        };
        System.out.println(numIslands(twoDimArray));
    }

    public static int numIslands(char [][] matrix){
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix [i][j] == '1'){
                    count += 1;
                    master(matrix, i, j);
                }
            }
        }
        return count;
    }
    public static void master(char[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length || j<0 || j>=matrix[i].length || matrix[i][j] == '0')
            return;
        matrix[i][j] = '0';
        master(matrix, i+1, j);
        master(matrix, i-1, j);
        master(matrix, i, j-1);
        master(matrix, i, j+1);

    }
}