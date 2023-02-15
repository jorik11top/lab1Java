import error.notSameMatrixExc;
public class lab1_test_matrix {
    public static void main(String[] args){
//        Matrix matr1 = new Matrix(2,2);
//        matr1.compl_martix();
//        matr1.print_matrix();
//        Matrix matr2 = new Matrix(3,2);
//        matr2.compl_martix();
//        matr2.print_matrix();
//        Matrix matr3 = new Matrix(matr1.multiMatrix(matr2));
//        matr3.print_matrix();
//        Matrix matr1 = new Matrix(2,2);
//        matr1.compl_martix();
//        matr1.print_matrix();
//
//        Matrix matr2 = new Matrix(2,2);
//        matr2.compl_martix();
//        Matrix matr3 = new Matrix(matr1.multiMatrix(matr2));
//        matr3.print_matrix();
//        Matrix matrix = new Matrix(4,4);
//        matrix.compl_martix();
//        matrix.Det(matrix).print();
        Matrix matrix = new Matrix(2,1);
        matrix.compl_martix();
        Matrix matrix1 = new Matrix(2,2);
        matrix1.compl_martix();
        matrix.multiMatrix(matrix1);

    }
}
