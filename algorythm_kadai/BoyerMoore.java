import static java.lang.System.out;
import java.util.Scanner;


public class BoyerMoore {
	public static void main(String[] args) {

		String pos;
		out.println("\nベースになる文字列を入力してください\n");
		String s1 = new Scanner(System.in).nextLine();
		out.println("\n検索したい文字列を4文字以上入力してください\n");
		String s2 = new Scanner(System.in).nextLine();
		out.println("\n");
		out.println(judgeS(s1, s2));
	}
		
	static int judgeS(String s1, String s2) {
		int len1, len2, n, i, inc;
		i = 0;
		len1 = s1.length();
		len2 = s2.length();
		n = len1 - len2;
		while (i <= n) {
			if (s2.equals(s1.substring(i, i + len2))) {
				return i;
			} else {
				inc = len2;
				for (int a = 0; a < len2; a++) {
					if (s1.charAt(i + len2 - 1) == s2.charAt(a)) {
						inc = a + 1;
					}
				}
				i += inc;
			}
		}
		return -1;
	}
}
