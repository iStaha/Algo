package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestPalindrome {

	static boolean isPalindrome(String str) {

		// Pointers pointing to the beginning
		// and the end of the string
		int i = 0, j = str.length() - 1;

		// While there are characters toc compare
		while (i < j) {

			// If there is a mismatch
			if (str.charAt(i) != str.charAt(j))
				return false;

			// Increment first pointer and
			// decrement the other
			i++;
			j--;
		}

		// Given string is a palindrome
		return true;
	}

	public static char[] copyOf(char[] original, int from, int to) {
		int newLength = Math.max(from, to) - Math.min(from, to);
		if (newLength < 0)
			throw new IllegalArgumentException(from + " > " + to);
		char[] copy = new char[newLength];
		System.arraycopy(original, from, copy, 0, Math.min(original.length - from, newLength));
		return copy;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String text = "rgczcpratwyqxaszbuwwcadruayhasynuxnakpmsyhxzlnxmdtsqqlmwnbxvmgvllafrpmlfuqpbhjddmhmbcgmlyeypkfpreddyencsdmgxysctpubvgeedhurvizgqxclhpfrvxggrowaynrtuwvvvwnqlowdihtrdzjffrgoeqivnprdnpvfjuhycpfydjcpfcnkpyujljiesmuxhtizzvwhvpqylvcirwqsmpptyhcqybstsfgjadicwzycswwmpluvzqdvnhkcofptqrzgjqtbvbdxylrylinspncrkxclykccbwridpqckstxdjawvziucrswpsfmisqiozworibeycuarcidbljslwbalcemgymnsxfziattdylrulwrybzztoxhevsdnvvljfzzrgcmagshucoalfiuapgzpqgjjgqsmcvtdsvehewrvtkeqwgmatqdpwlayjcxcavjmgpdyklrjcqvxjqbjucfubgmgpkfdxznkhcejscymuildfnuxwmuklntnyycdcscioimenaeohgpbcpogyifcsatfxeslstkjclauqmywacizyapxlgtcchlxkvygzeucwalhvhbwkvbceqajstxzzppcxoanhyfkgwaelsfdeeviqogjpresnoacegfeejyychabkhszcokdxpaqrprwfdahjqkfptwpeykgumyemgkccynxuvbdpjlrbgqtcqulxodurugofuwzudnhgxdrbbxtrvdnlodyhsifvyspejenpdckevzqrexplpcqtwtxlimfrsjumiygqeemhihcxyngsemcolrnlyhqlbqbcestadoxtrdvcgucntjnfavylip";

		char charText[] = text.toCharArray();

		int subs[] = { 0, 0 };

		int k, max = 0;

		List<String> lis = new ArrayList<String>();

		for (int i = 0; i < charText.length; i++) {

			for (k = 0; k < charText.length; k++) {

				/*
				 * if (charText[i] == charText[k] ) { break; }
				 */

				// lis.add(new String(Arrays.copyOfRange(charText, i, (k+1))));

				// System.out.println(new String(copyOf(charText, i, (k+1))));

				// System.out.println(i + " " + k);
				
				if (max < (new String(copyOf(charText, i, (k + 1)))).length() && isPalindrome(new String(copyOf(charText, i, (k + 1))))) {
					
			//		System.out.println(new String(copyOf(charText, i, (k+1))));
					
					max= ((k+1)-i);
					
					subs[0] = Math.min(i, (k+1)); 
					subs[1] = Math.max(i, (k+1));
					
					/*
					 * max = Math.max(i, k) - Math.min(i, k); subs[0] = Math.min(i, k); subs[1] =
					 * Math.max(i, k);
					 */
				}


			}

			
		//	System.out.println(i + "  " + k);

		}

		
		  char[] newArray = Arrays.copyOfRange(charText, subs[0], (subs[1]));
		  
		  
		  String str = new String(newArray);
		  
		  
		  
		  
		  System.out.println(str);
		 

//		System.out.print(x + "  " + y);

		// while(x< charText.length && y )

	//	System.out.println(lis);
	}

}
