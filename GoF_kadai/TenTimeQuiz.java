import java.util.Scanner;

public class TenTimeQuiz {
	public static void main(String[] args) {
		AbstractFlow q1 = new Question1("みりん", "鼻の長〜い動物は？（ひらがなで）",  "ぞう");
		AbstractFlow q2 = new Question1("シャンデリア", "毒りんごを食べちゃったのは？（ひらがなで）",  "しらゆきひめ");
		q1.quiz();
		q2.quiz();
	}
}

abstract class AbstractFlow {
	public abstract void theme();
	public abstract void sayTen();
	public abstract void question();
	public abstract void sayAnswer();
	public abstract void answer();
	public final void quiz() {
		theme();
		for (int i = 0; i < 10; i++) {
			sayTen();
		}
		question();
		sayAnswer();
		answer();
	}
}

class Question1 extends AbstractFlow {
	private String key1;
	private String key2;
	private String question;
	String userAnswer;
	public Question1(String key1, String question, String key2) {
		this.key1 = key1;
		this.key2 = key2;
		this.question = question;
	}

	public void theme() {
		System.out.println(key1 + "って10回言って");
	}
	public void sayTen() {
		System.out.println(key1);
	}
	public void question() {
		System.out.println(question);
	}
	public void sayAnswer() {
		userAnswer = new Scanner(System.in).nextLine();
	}

	public void answer() {
		if (userAnswer.equals(key2)) {
			System.out.println("おめでとう！！正解だよヽ(´▽｀)");
		} else {
		System.out.println("「" + key2 + "」でした〜ヽ(´▽｀)/へへっ");
		}
	}
}
