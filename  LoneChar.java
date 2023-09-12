import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class LoneChar {
	
	public static char[] loneliest(String s) {
		List<Character> res = new ArrayList<>();
		var mat = Pattern.compile(" +|[a-z]").matcher(s.trim());
		List<String> m = new ArrayList<>();
		while (mat.find()) {
			m.add(mat.group());
		}
		int lon = -1;
		for (int i = 0; i < m.size(); i++) {
			if (m.get(i).charAt(0) == ' ') {
				continue;
			}
			int cnt = 0;
			if (i > 0 && m.get(i - 1).charAt(0) == ' ') {
				cnt += m.get(i - 1).length();
			}
			if (i < m.size() - 1 && m.get(i + 1).charAt(0) == ' ') {
				cnt += m.get(i + 1).length();
			}
			if (cnt > lon) {
				res = new ArrayList<>();
				res.add(m.get(i).charAt(0));
				lon = cnt;
			} else if (cnt == lon) {
				res.add(m.get(i).charAt(0));
			}
		}
	
		char[] ret = new char[res.size()];
		for (int i = 0; i < res.size(); i++) {
			ret[i] = res.get(i);
		}
		return ret;
	}
}
/*
Complete the function which accepts a string and return an array of character(s) that have the most spaces to their right and left.

Notes:

the string can have leading/trailing spaces - you should not count them
the strings contain only unique characters from a to z
the order of characters in the returned array doesn't matter
Examples
"a b  c"                        -->  ["b"]
"a bcs           d k"           -->  ["d"]
"    a b  sc     p     t   k"   -->  ["p"]
"a  b  c  de"                   -->  ["b", "c"]
"     a  b  c de        "       -->  ["b"]
"abc"                           -->  ["a", "b", "c"]
Good luck!
*/