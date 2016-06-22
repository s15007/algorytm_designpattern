import static java.lang.System.out;
import java.util.Scanner;

public class Greedy{
    public static void main(String[] args) {
        getChange g = new getChange();       
        out.println("お釣りの金額は？");
        int num  = new java.util.Scanner(System.in).nextInt();
        g.change(num);  
    }
}
class getChange {
    public void change(int a) {
        int val[] = { 500, 100, 50, 10, 5, 1 };
        int sum, n, i;

        sum = 0;
        for (i = 0; i < 6; i++) {
            n = a / val[i];
            out.println(val[i] + "円硬貨 = " + n + "枚");
            sum += n;
            a %= val[i];
        }
        out.println("硬貨の合計枚数 =" + sum + "枚");
    }
}