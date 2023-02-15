import java.util.Scanner;
import error.notSameMatrixExc;
import error.parsingError;
import error.notMultiMatrix;
public class Matrix {
    private final int  N;
    private final int M;
    private ComplexNum[][] matrix;


    /**
     * <h3>Конструктор {@link Matrix}</h3>
     * @param N - кол-во строк
     * @param M- кол-во столбцов

     */
    public Matrix(int N,int M){
        this.N = N;
        this.M = M;
        matrix = new ComplexNum[N][M] ;
    }


    /**
     * <h3>Конструктор {@link Matrix}</h3>
     * @param matrix - двумерный массив типа {@link ComplexNum}
     */
    public Matrix(ComplexNum[][] matrix){
        this.N = matrix.length;
        this.M = matrix[0].length;
        this.matrix = matrix;
    }


    /**

     * Возвращает кол-во строк матрицы
     * @return число типа {@link Integer}
     */
    public int getN(){
        return this.N;
    }

    /**

     * Возвращает кол-во столбцов матрицы
     * @return число типа {@link Integer}
     */
    public int getM(){
        return this.M;
    }


    /**
     * <h3>Метод для возращения элемента матрицы</h3>
     * @param N - индекс строки
     * @param M- индекс столбца
     * @return {@link ComplexNum}
     */
    public ComplexNum getEL(int N,int M){
        return matrix[N][M];
    }


    /**
     * <h3>Метод для изменения элемента матрицы</h3>
     * @param N - индекс строки
     * @param M- индекс столбца
     * @param A - вещественная часть
     * @param B- комплексная часть
     */
    public void  setEl(double A,double B,int N,int M){
        matrix[N][M] = new ComplexNum(A,B);
    }


    /**
     * <h3>Метод для возразие элемента по индексу</h3>
     * @param N - индекс строки
     * @param M- индекс столбца
     * @return возращает {@link ComplexNum}
     */
    public ComplexNum getComNum(int N, int M){
        return matrix[N][M];
    }


    /**
     * <h3>Метод для вывода элемента матрицы по индексу</h3>
     * @param N - индекс строки
     * @param M - индекст стоблца
     */
    public void print_el(int N,int M){
        matrix[N][M].print();
    }


    /**
     * <h3>Метод для вывода матрицы в консоль</h3>

     */


    public void print_matrix(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                matrix[i][j].print();
            }
            System.out.println();
        }
    }


    /**
     * <h3>Приватный метод для обработки строк</h3>
     * @param N - номер строки
     * @param M - номер столблца
     * @param num - комплексное число введёное пользователем
     * <p>Испольуеться в {@link Matrix#compl_martix()}
     */
    private void parsStr(int N,int M,String num) throws NumberFormatException {
        int pos = 0;
        String numA = new String();
        String numB = new String();
        int havei = 0;
        for (int i = 0;i<num.length();i++){
            if(pos == 0){
                if(num.charAt(i) == '-' | num.charAt(i) == '+'){
                    if(num.charAt(i+1) == 'i') {
                        numB += num.charAt(i);
                    }
                    else{
                        numA += num.charAt(i);
                    }
                }
                else if(num.charAt(i) == 'i'){
                    havei = 1;
                    pos = 1;
                }
                else{
                    numA += num.charAt(i);
                }
            }
            else{
                numB += num.charAt(i);
            }
        }
        matrix[N][M] = new ComplexNum();
        if(numA.isEmpty()){
            matrix[N][M].setA(0);
        }
        else{
            matrix[N][M].setA(Double.parseDouble(numA));
        }
        if( numB.length() == 1 && (numB.charAt(0) == '-' | numB.charAt(0) == '+')) {
            numB += (char) (havei + '0');
            matrix[N][M].setB(Double.parseDouble(numB));
        }
        else if(numB.isEmpty()){
            matrix[N][M].setB(havei);
        }
        else{
            matrix[N][M].setB(Double.parseDouble(numB));
        }
    }


    /**
     * <h3>Метод для ввода матрицы с консоли</h3>
     *Выводит формат, в котором нужно вводить значения матрицы
     */
    public void compl_martix() throws parsingError{
        System.out.println("Формат ввода матрицы");
        System.out.println("3-i3 i3");
        System.out.println("3 3+i");
        Scanner scanner = new Scanner(System.in);
        try {
            for(int i = 0;i < N; i++){
                for (int j = 0; j < M;j++){
                    String str = scanner.next();
                    parsStr(i,j,str);
                }
            }
        }
        catch (StringIndexOutOfBoundsException | NumberFormatException e){
            new parsingError().printErr();
        }
    }



    /**
     * <h3>Метод для сложения матриц</h3>
     * @param matrix - второе слагаемое
     *Измняется {@link Matrix} к которой был применён метод
     */
    public void addMatrix(Matrix matrix) throws notSameMatrixExc{

        if(this.N  == matrix.getN() & this.M == matrix.getM()){
            for(int i = 0;i < N; i++){
                for(int j = 0;j < M; j++){
                    this.matrix[i][j].add(matrix.getComNum(i,j));
                }
            }
        }
        else{
             new notSameMatrixExc().printErr();

        }
    }


    /**
     * <h3>Метод для умножения матриц</h3>
     * @param matrix - 2 множитель
     * @return Возращает результирующий двумерный массив комплексных чисел, для создания обекта класса {@link Matrix}
     * при помощи конструктора {@link  Matrix#Matrix(ComplexNum[][])}
     */
    public ComplexNum[][] multiMatrix(Matrix matrix) throws notMultiMatrix{
            if(this.M != matrix.N) {
                 new notMultiMatrix().printErr();

            }
            ComplexNum[][] timematr = new ComplexNum[this.getN()][matrix.getM()];
            for(int i =0; i < getN();i++){
                for(int j = 0; j < matrix.getM(); j++){
                    timematr[i][j] = new ComplexNum();
                    for(int g = 0;g < this.getM();g++){
                        ComplexNum el = new ComplexNum(this.matrix[i][g]);
                        el.multiply(matrix.getEL(g,j));
                        timematr[i][j].add(el);
                    }
                }
            }
            return timematr;
    }


    /**
     * <h3>Метод для транспонирование матриц</h3>
     *
     * @return Возращает двумерный массив комплексных чисел, для создания обекта класса {@link Matrix}
     * при помощи конструктора {@link  Matrix#Matrix(ComplexNum[][])}
     */
    public ComplexNum[][] transpMatrix(){
        ComplexNum[][] result = new ComplexNum[getM()][getN()];
        for (int i = 0;i<getN();i++){
            for(int j = 0; j < getM(); j++){
                result[j][i] = new ComplexNum();
                result[j][i].setA(matrix[i][j].getA());
                result[j][i].setB(matrix[i][j].getB());
            }
        }
        return result;
    }

    /**
     * <h3>Метод умножающий матрицу на число</h3>
     */
    public void multy_num_matrix(ComplexNum num){
        for(int i = 0;i<this.N;i++){
            for(int j = 0;j < this.M;j++){
                this.matrix[i][j].multiply(num);
            }
        }
    }

    /**
     * <h3>Метод для поиска определителя матрицы</h3>
     * @param minor объект класса {@link Matrix}
     * @return Возращает объект класса {@link ComplexNum} являющийся детроминантом
     */
    public ComplexNum Det(Matrix minor){
        if(minor.getM() == minor.getN()) {
            if (minor.getM() == 1) {
                return minor.getEL(0, 0);
            } else if (minor.getM() == 2) {
                ComplexNum num = new ComplexNum(minor.getEL(0, 0));
                num.multiply(minor.getEL(1, 1));
                ComplexNum num1 = new ComplexNum(minor.getEL(1, 0));
                num1.multiply(minor.getEL(0, 1));
                num.minus(num1);
                return num;
            } else {
                ComplexNum sum = new ComplexNum();
                for (int i = 0; i < minor.getM(); i++) {
                    ComplexNum[][] nullMinor = new ComplexNum[minor.getM() - 1][minor.getM() - 1];
                    for (int j = 1; j < minor.getM(); j++) {
                        int col = 0;
                        for (int k = 0; k < minor.getM(); k++) {
                            if (k == i) {
                                continue;
                            } else {
                                nullMinor[j - 1][col] = new ComplexNum(minor.getEL(j, k));
                                col++;
                            }
                        }
                    }
                    Matrix newMinor = new Matrix(nullMinor);
                    ComplexNum znak = new ComplexNum(minor.getEL(0, i));
                    znak.setA(znak.getA() * Math.pow(-1, i));
                    znak.setB(znak.getB() * Math.pow(-1, i));
                    ComplexNum res = new ComplexNum(Det(newMinor));
                    res.multiply(znak);
                    sum.add(res);
                }
                return sum;
            }
        }
        else{
            System.out.println("Это не квадратная матрица");
            return null;
        }
    }


}
