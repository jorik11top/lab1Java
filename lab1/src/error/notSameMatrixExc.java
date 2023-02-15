package error;

/**
 * Матрицы разных размеров
 */
public class notSameMatrixExc extends RuntimeException{
    public void printErr(){
        System.out.println("Матрицы должны быть одного размера");
    }
}

