import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Test {

	// 生成随机数字和字母,
	public static String getStringRandom(int length) {

		String val = "";
		Random random = new Random();

		// 参数length，表示生成几位随机数
		for (int i = 0; i < length; i++) {

			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			// 输出字母还是数字
			if ("char".equalsIgnoreCase(charOrNum)) {
				// 输出是大写字母还是小写字母
				int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val += (char) (random.nextInt(26) + temp);
			} else if ("num".equalsIgnoreCase(charOrNum)) {
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}

	public static void main(String[] args) {
		Set couponSet = new HashSet();
		int couponCount = 10000000;
		for (int i = 0; i < couponCount; i++) {
			couponSet.add(getStringRandom(8));
		}
		System.out.println(couponSet.size());
	}
}
