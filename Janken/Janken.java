import java.util.*;
import java.util.Random;

public class Janken {
	public static void main(String[] args) {
		int LOOP_COUNT = 10000000;
		int GU = 1;
		int CHOKI = 2;
		int PA = 3;
		int USER[];
		int COMPUTER[];
		int JUDGE = 3;
		int DRAW = 0;
		int WIN = 2;
		int LOSE = 1;

		USER = new int[3];
		USER[0] = GU;
		USER[1] = CHOKI;
		USER[2] = PA;
		COMPUTER = new int[3];
		COMPUTER[0] = GU;
		COMPUTER[1] = CHOKI;
		COMPUTER[2] = PA;

		Janken001 test1 = new Janken001();
		test1.janken(LOOP_COUNT,USER,COMPUTER,JUDGE,GU,CHOKI,PA,DRAW,WIN,LOSE);

		Janken002  test2 =	 new Janken002();
		test2.janken(LOOP_COUNT,USER,COMPUTER,JUDGE,GU,CHOKI,PA,DRAW,WIN,LOSE);

		Janken003 test3 = new Janken003();
		test3.janken(LOOP_COUNT,USER,COMPUTER,JUDGE,DRAW,WIN,LOSE);
		
		Janken004 test4 = new Janken004();
		test4.janken(LOOP_COUNT,USER,COMPUTER,JUDGE,GU,CHOKI,PA,DRAW,WIN,LOSE);
	}
}

class Janken001 {
	public void janken(int i,int user[],int computer[],int judge,int gu,int choki,int pa,int draw,int win,int lose) {

		int x = 0;
		judge = 0;
		Random a = new Random();
		int DIVISOR = 1000000;


		long start = System.nanoTime();

		while (x < i ) {

			int num1 = a.nextInt(3);
			int num2 = a.nextInt(3);
			
			if (user[num1] == gu && computer[num2] == gu){
				judge = draw;
			} else if (user[num1] == gu && computer[num2] == choki) {
				judge = win;
			} else if (user[num1] == gu && computer[num2] == pa) {
				judge = lose;
			} else if (user[num1] == choki && computer[num2] == gu) {
				judge = lose;
			} else if (user[num1] == choki && computer[num2] == choki) {
				judge = draw;
			} else if (user[num1] == choki && computer[num2] == pa) {
				judge = win;
			} else if (user[num1] == pa && computer[num2] == gu) {
				judge = win;
			} else if (user[num1] == pa && computer[num2] == choki) {
				judge = lose;
			} else if (user[num1] == pa && computer[num2] == pa) {
				judge = draw;
			}
			// if (judge == draw) {
			// 	System.out.println("あいこ");
			// } else if (judge == win) {
			//  	System.out.println("ユーザの勝ち");
			// } else if (judge == lose) {
			//  	System.out.println("ユーザーの負け");
			// }
			x++;
		}
		long end = System.nanoTime();
		System.out.println("    ");
		System.out.println("9通りの条件分岐は：" + (end - start) / DIVISOR + "ミリ秒");
	}
}


class Janken002 {
	public void janken(int i,int user[],int computer[],int judge,int gu,int choki,int pa,int draw,int win,int lose) {
				int x = 0;
		judge = 0;
		Random a = new Random();
		int DIVISOR = 1000000;


		long start = System.nanoTime();

		while (x < i ) {

			int num1 = a.nextInt(3);
			int num2 = a.nextInt(3);
			
			if (user[num1] == computer[num2]) {
				judge = draw;
			} else if (user[num1] == gu && computer[num2] == choki ||
						user[num1] == choki && computer[num2] == pa ||
						user[num1] == pa && computer[num2] == gu){
				
				judge = win;

			} else {
				judge = lose;
			}
			// if (judge == draw) {
			// 	System.out.println("あいこ");
			// } else if (judge == win) {
			//  	System.out.println("ユーザの勝ち");
			// } else if (judge == lose) {
			//  	System.out.println("ユーザーの負け");
			// }
			x++;
		}
		long end = System.nanoTime();
		System.out.println("    ");
		System.out.println("3通りの条件分岐は：" + (end - start) / DIVISOR + "ミリ秒");
		System.out.println("    ");
	}
}




class Janken003 {
	public void janken(int i,int user[],int computer[],int judge,int draw,int win,int lose) {

		int x = 0;

		Random a = new Random();
		int DIVISOR = 1000000;

		long start = System.nanoTime();

		while (x < i) {
			
			int num1 = a.nextInt(3);
			int num2 = a.nextInt(3);
			judge = (user[num1] - computer[num2] + 3) % 3;

			// if (judge == draw) {
			// 	System.out.println("あいこ");
			// } else if (judge == win) {
			//  	System.out.println("ユーザの勝ち");
			// } else if (judge == lose) {
			//  	System.out.println("ユーザーの負け");
			// }
			x++;
			
		}
		long end = System.nanoTime();
		System.out.println("計算式では：" + (end - start) / DIVISOR + "ミリ秒");
		System.out.println("    ");
		}
}

class Janken004 {
	public void janken(int i,int user[],int computer[],int judge,int gu,int choki,int pa,int draw,int win,int lose) {
		int x = 0;

		Random a = new Random();
		int DIVISOR = 1000000;

		int newjudge[][] = new int[3][3];
		
		newjudge[0][0] = draw;
		newjudge[0][1] = win;
		newjudge[0][2] = lose; 

		newjudge[1][0] = lose;
		newjudge[1][1] = draw;
		newjudge[1][2] = win;

		newjudge[2][0] = win;
		newjudge[2][1] = lose;
		newjudge[2][2] = draw;

		long start = System.nanoTime();

		while (x < i) {
			
			int num1 = a.nextInt(3);
			int num2 = a.nextInt(3);
			if (newjudge[user[num1] - 1][computer[num2] - 1] == draw) {
				judge = draw;
			} else if (newjudge[user[num1] - 1][computer[num2] - 1] == win){
			 	judge = win;
			} else if (newjudge[user[num1] - 1][computer[num2] - 1] == lose) {
			 	judge = lose;
			}

			// if (judge == draw) {
			// 	System.out.println("あいこ");
			// } else if (judge == win) {
			//  	System.out.println("ユーザの勝ち");
			// } else if (judge == lose) {
			//  	System.out.println("ユーザーの負け");
			// }
			x++;
			
		}
		long end = System.nanoTime();
		System.out.println("構造体では：" + (end - start) / DIVISOR + "ミリ秒");
		System.out.println("    ");
	}
}

