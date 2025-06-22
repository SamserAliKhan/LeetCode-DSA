import java.util.*;

class Solution {
    public String[] divideString(String s, int k, char fill) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i += k) {
            StringBuilder group = new StringBuilder();

            for (int j = i; j < i + k; j++) {
                if (j < s.length()) {
                    group.append(s.charAt(j));
                } else {
                    group.append(fill);
                }
            }

            result.add(group.toString());
        }

        return result.toArray(new String[0]);
    }
}
