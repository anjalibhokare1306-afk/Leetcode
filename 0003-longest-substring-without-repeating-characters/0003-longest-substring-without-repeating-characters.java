import java.util.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            while (seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left));
                left++;
            }
            seen.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    
    public static void main(String[] args) {
        Solution sol = new Solution();

        String s1 = "abcabcbb";
        

        System.out.println("Input: " + s1 + " -> Output: " + sol.lengthOfLongestSubstring(s1)); 
        
    }
}
