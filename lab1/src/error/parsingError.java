package error;

import javax.management.RuntimeErrorException;

public class parsingError  extends StringIndexOutOfBoundsException {
    public void printErr(){
        System.out.println("Неправильный формат ввода матрицы");
    }
}
