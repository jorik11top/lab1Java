import java.util.Scanner;
public class lab1_test_complexnum {
 public static void main(String[] args){
    double a,b;
    Scanner in = new Scanner(System.in);
    System.out.print("Введите вещественную часть: ");
    a = in.nextDouble();
    System.out.print("Введите мнимую часть: ");
    b = in.nextDouble();
    ComplexNum num1 = new ComplexNum(a,b);
    System.out.print("Вывод числа: ");
    num1.print();
    ComplexNum num2 = new ComplexNum(num1);
    System.out.print("2 число: ");
    num2.print();
    num1.add(num2);
    System.out.print("1 число + 2 число: ");
    num1.print();
    num1.multiply(num2);
    System.out.print("Произведение 1 числа на  2 число: ");
    num1.print();
    System.out.print("Вывод числа в тригонометрической форме: ");
    num1.printTrigonometricForm();

 }
}
