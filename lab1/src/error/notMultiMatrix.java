package error;

public class notMultiMatrix extends RuntimeException{
    public void printErr(){
        System.out.println("Эти матрицы нельзя умножить");
    }
}
