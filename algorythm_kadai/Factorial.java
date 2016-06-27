import static java.lang.System.out;
import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		out.printf("数字を入力してください.....");

		Factorial_test f = new Factorial_test();
		int NUM = new Scanner(System.in).nextInt();
		out.printf("\nfor文を使った処理.......   " + NUM + "の階乗は");
		f.test1(NUM);

		out.printf("\n再帰を使った処理.......   " + NUM + "の階乗は");
		out.println(saiki(NUM));

		long start = System.nanoTime();
		out.println("\n再帰を使ってフィボナッチを求める処理.......   ");
		out.println(NUM + "番目のフィボナッチ数は " + fibonacci(NUM));
		long end = System.nanoTime();
		out.println("処理時間" + (end - start) / 1000000 + "ミリ秒");

		start = System.nanoTime();
		out.println("\n動的計画法を使ってフィボナッチを求める処理.......   ");
		out.println(NUM + "番目のフィボナッチ数は " + fibonacci2(NUM));
		end = System.nanoTime();
		out.println("処理時間" + (end - start) / 1000000 + "ミリ秒");

		start = System.nanoTime();
		out.println("\n再帰と動的計画法を使ってフィボナッチを求める処理.......   ");
		initFibonacciNumbers();
		out.println(NUM + "番目のフィボナッチ数は " + fibonacci3(NUM));
		end = System.nanoTime();
		out.println("処理時間" + (end - start) / 1000000 + "ミリ秒");
		

		out.println("\n");
	}
	// 再帰を使った処理
	static int saiki(int a) {
		if(a == 0) {
			return 1;
		} else {
			return a * saiki(a - 1);
		}

	}
	// フィボナッチ数を求める処理
	static int fibonacci(int b) {
		if(b == 0) {
			return 0;
		} else if(b == 1) {
			return 1;
		} else {
			return fibonacci(b - 1) + fibonacci(b - 2);
		}
	}
	// 動的計画法を使ったフィボナッチ数を求める関数
	static int fibonacciNumbers[] = new int[100];
	
	static int fibonacci2(int n) {
		int i;
		for (i = 0; i <= n; i++) {
			if (i == 0) {
				fibonacciNumbers[0] = 0;
			} else if (i == 1) {
				fibonacciNumbers[1] = 1;
			} else {
				fibonacciNumbers[i] = fibonacciNumbers[i - 1] + fibonacciNumbers[i -2];
			}
		}
		return fibonacciNumbers[n];
	}


	// 再帰と動的計画法を組み合わせてフィボナッチを求める処理

	static void initFibonacciNumbers() {
		int i;
		for(i = 0; i < 100; i++) {
			fibonacciNumbers[i] = -1;
		}
	}

	static int fibonacci3(int n) {
		if (fibonacciNumbers[n] == -1) {
			if (n == 0) {
				fibonacciNumbers[n] = 0;
			} else if (n == 1) {
				fibonacciNumbers[n] = 1;
			} else {
				fibonacciNumbers[n] = fibonacci3(n - 1) + fibonacci3(n - 2);
			}
		}
		return fibonacciNumbers[n];
	}
}

// for文を使った処理
class Factorial_test {
	public void test1(int num) {
		int n,i;
		n = 1;
		for(i = num; i >= 1; i--) {
			n *= i;
		}
		out.println(n);
	}
}