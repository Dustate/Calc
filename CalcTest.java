import java.util.Scanner;

public class CalcTest {
    public static void main(String[] args) throws Exception {
        Calc c = new Calc();
        Scanner read = new Scanner(System.in);
        while (true){
            System.out.println("¬ведите формулу1 -> ");
            String form = read.nextLine();
            c.compile(form.toCharArray());
        }
    }
}

