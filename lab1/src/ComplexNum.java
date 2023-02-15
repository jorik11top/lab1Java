/**

 * Класс комплексных чисел позволяющий:
 * <p>-создавать комлпексные числа</p>
 * <p>-выводить их</p>
 * <p>-складывать их</p>
 * <p>-умножать их</p>
 * <p>-выводить в тригонометрической форме </p>
 */
public class ComplexNum {
    private double a = 0, b = 0;

    public ComplexNum(){
        this.a = 0;
        this.b = 0;
    }

    public ComplexNum(double a,double b){
        this.a = a;
        this.b = b;
    }
    /**

     * Создаёт копию на основе другого комплексного числа
     */
    public ComplexNum(ComplexNum num){
        this.a = num.getA();
        this.b = num.getB();
    }/**

     * Возвращает целую часть A
     */
    public double getA(){
        return this.a;
    }
    /**

     * Изменяет вещественную часть
     */
    public void setA(double num){
        this.a = num;
    }
    /**

     * Возвращает мнимую часть B
     */
    public double getB(){

        return this.b;
    }
    /**

     * Изменяет мнимую часть
     */
    public void setB(double num){
        this.b = num;
    }
    /**

     * Складывает 2 комплексных числа.
     * <p>-результат записывается в число к которому применён метод
     */
    public void add(ComplexNum num){
        this.a += num.getA();
        this.b += num.getB();
    }
    /**

     * Даёт разность 2 комплексных числа.
     * <p>-результат записывается в число к которому применён метод
     */
    public void minus(ComplexNum num){
        this.a -= num.getA();
        this.b -= num.getB();
    }
    /**
     * Умножает 2 комплексных числа.
     * <p>-результат записывается в число к которому применён метод
     *
     * @return
     */
    public void multiply(ComplexNum num){
        double A = num.getA()*this.a - num.getB()*this.b;
        double B = this.b*num.getA() + this.a* num.getB();
        this.a = A;
        this.b = B;
    }
    /**

     * Выводит число в тригонометрической форме в консоль
     */
    public void printTrigonometricForm(){
        double z = Math.sqrt(Math.pow(this.a,2)+Math.pow(this.b,2));
        double a1 = this.a/z;
        double b1 = this.b/z;
        if (b1 > 0) {
            System.out.format("%.3f(%.3f + %.3f)%n", z, a1, b1);
        }
        else {
            System.out.format("%.3f(%.3f - %.3f)%n", z, a1, (-b1));
        }
    }
    /**

     * Выводит число в консоль
     */
    public void print(){
        if (getB() == 0){
            System.out.print(getA()+" ");
        }
        else if (getA() == 0){
            System.out.print(getB()+"i ");
        }
        else{
            if(getB() < 0){
                System.out.print(getA());
                System.out.print(getB()+"i ");
            }
            else {
                System.out.print(getA() +"+"+ getB()+"i ");
            }

        }

    }

}
