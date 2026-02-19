package com.self.Java26;

public class CommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp =  new int[m][n];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n ; j++) {
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }

    public int longestPalindromeSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[][] dp =  new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n ; j++) {
                if(s.charAt(i-1) == rev.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[n][n];
    }

    public String longestPalindrome(String s) {

        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int maxLen = Math.max(checkLengthOfPalindrome(s, i, i), checkLengthOfPalindrome(s, i, i+1));
            if(maxLen >  end-start){
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int checkLengthOfPalindrome(String s, int i, int j){
        int left = i;
        int right = j;
        int length = 0;
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right -left -1;
    }

    public int longestPalindromeSubseq1(String s) {
        int len = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        int[][] dp = new int[len+1][len+1];

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) {
                if (s.charAt(i) == rev.charAt(j)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] =  Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[len][len];
    }


}
