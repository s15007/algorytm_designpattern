public class Feelings {
	public static void main(String[] args) {
		MyFeelings now = new CurrentFeeling();
		now.angry();
		now.happy();
		now.sad();
		now.stupid();
	}
}

interface MyFeelings {
	public abstract void angry();
	public abstract void happy();
	public abstract void sad();
	public abstract void stupid();
}

class Me {
	public void beAngy() {
		System.out.println("\n(∴｀┏ω┓´)/ｺﾗｧｰ!!");
	}
	public void beHappy() {
		System.out.println("\nヽ(´▽｀)/へへっ");
	}
	public void beSad() {
		System.out.println("\n(ＴｍＴ)ｳｩｩ･･･");
	}
	public void beStupid() {
		System.out.println("\n└(ﾟ∀ﾟ└)ﾊｯｽﾙ!ﾊｯｽﾙ!!(┘ﾟ∀ﾟ)┘ ﾊｯｽﾙ!ﾊｯｽﾙ!!\n");
	}
}
// 継承を使ったAdapterパターン↓↓↓
class CurrentFeeling extends Me implements MyFeelings {
	public void angry() {
		beAngy();
	}
	public void happy() {
		beHappy();
	}
	public void sad() {
		beSad();
	}
	public void stupid() {
		beStupid();
	}
}