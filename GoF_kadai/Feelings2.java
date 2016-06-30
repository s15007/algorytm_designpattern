public class Feelings2 {
	public static void main(String[] args) {
		MyFeelings now = new CurrentFeeling();
		now.angry();
		now.happy();
		now.sad();
		now.stupid();
	}
}

abstract class MyFeelings {
	public abstract void angry();
	public abstract void happy();
	public abstract void sad();
	public abstract void stupid();
}

class Me {
	public void beAngry() {
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

// 委譲を使ったAdapterパターン↓↓↓
class CurrentFeeling extends MyFeelings {
	private Me me;
	public CurrentFeeling() {
		this.me = new Me();
	}
	public void angry() {
		me.beAngry();
	}
	public void happy() {
		me.beHappy();
	}
	public void sad() {
		me.beSad();
	}
	public void stupid() {
		me.beStupid();
	}
}