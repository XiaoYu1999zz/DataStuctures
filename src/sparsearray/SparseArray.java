package sparsearray;

/**
 * @author ：XiaoYu
 * @date ：2022/9/5 4:43
 * @version: :1.0
 * :
 */
//稀疏数组
public class SparseArray {
    public static void main(String[] args) {
        // 创建一个原始的二维数组 11*11
        //0： 表示没有旗子  1：表示黑子  2：表示白子
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[3][4] = 2;

        // 打印棋盘 原始的二维数组
        int sum = 0; //非0的数据
        for (int[] row : chessArr) {
            for (int data : row) {
                if (data != 0) {
                    sum++;
                }
                System.out.print("\t" + data);
            }
            System.out.println();
        }


        System.out.println("==========================================================");

        //    创建稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        //稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //遍历二维数据  将非0数据放入稀疏数组
        int cont = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0) {
                    cont++;
                    sparseArr[cont][0] = i;
                    sparseArr[cont][1] = j;
                    sparseArr[cont][2] = chessArr[i][j];
                }
            }
        }
        System.out.println("输出稀疏数组");
        for (int[] row : sparseArr) {
            for (int data : row) {
                System.out.print("\t\t\t" + data);
            }
            System.out.println();
        }

        //将稀疏数组转换成二维数组
        int[][] chessArrT = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
           chessArrT[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }


        System.out.println("输出稀疏数组转换二维数据");
        for (int[] row : chessArrT) {
            for (int data : row) {
                System.out.print("\t" + data);
            }
            System.out.println();
        }

    }
}
