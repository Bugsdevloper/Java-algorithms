public class KMPAlgorithm {

    private int[] computePrefixArray(String pattern) {
        int m = pattern.length();
        int[] prefixArray = new int[m];
        int j = 0;

        for (int i = 1; i < m; i++) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
                prefixArray[i] = j;
            } else {
                if (j > 0) {
                    j = prefixArray[j - 1];
                    i--; // Recheck the current character
                } else {
                    prefixArray[i] = 0;
                }
            }
        }

        return prefixArray;
    }

    public int searchSubstring(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[] prefixArray = computePrefixArray(pattern);

        int i = 0; // Index for text
        int j = 0; // Index for pattern

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                // Pattern found, return the starting index
                return i - j;
            } else if (i < n && text.charAt(i) != pattern.charAt(j)) {
                if (j > 0) {
                    j = prefixArray[j - 1];
                } else {
                    i++;
                }
            }
        }

        // Pattern not found
        return -1;
    }

    public static void main(String[] args) {
        String text = "ABCABCDABABCDABCDABDE";
        String pattern = "ABCDABD";
        KMPAlgorithm kmp = new KMPAlgorithm();
        int index = kmp.searchSubstring(text, pattern);

        if (index != -1) {
            System.out.println("Pattern found at index: " + index);
        } else {
            System.out.println("Pattern not found in the text.");
        }
    }
}
