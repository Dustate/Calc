import java.util.Scanner;
public class CompfTest {
    public static void main(String[] args) throws Exception {
        Scanner read = new Scanner(System.in);
        Compf c = new Compf();
        while (true) {
            System.out.println("¬ведите формулу2 -> ");
            String form = read.nextLine();
            c.compile(form.toCharArray());
        }
    }
}
