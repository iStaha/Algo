package pattern;

public class Pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String pattern = "abcdefgahbfggfgfdgfdaaaaaaaaaaaaaaaaaaaaaa";

	//	combinations("", pattern);

	//	System.out.println(combination(pattern));

///		subset("", "gffg");
	//	subset("", "123");
		
		System.out.println(1 & (1 << 0));

	}

	private static void subset(String p, String up) {
		// TODO Auto-generated method stub

		if (up.isEmpty()) {
			System.out.println(p);
			return;
		}

		char c = up.charAt(0);

		subset(p + c, up.substring(1));
		
		subset(p, up.substring(1));

	}

	private static String combination(String up) {
		// TODO Auto-generated method stub

		if (up.isEmpty()) {
			return "";
		}

		char c = up.charAt(0);

		if (c == 'a') {
			return combination(up.substring(1));
		} else {
			return c + combination(up.substring(1));
		}

	}

	private static void combinations(String p, String up) {
		// TODO Auto-generated method stub

		if (up.isEmpty()) {
			System.out.println(p + "  ");
			return;
		}

		char c = up.charAt(0);

		if (c == 'a') {
			combinations(p, up.substring(1));
		} else {
			combinations(p + c, up.substring(1));
		}

	}

}
