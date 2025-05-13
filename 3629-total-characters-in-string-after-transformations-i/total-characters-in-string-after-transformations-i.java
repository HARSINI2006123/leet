class Solution {
    public int lengthAfterTransformations(String s, int t) {
        
        final int MOD = 1_000_000_007;

        // Count array where count[i] = number of characters with i transformations left
        long[] count = new long[26];  // Only 26 possible characters

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (int step = 0; step < t; step++) {
            long[] next = new long[26];

            for (int i = 0; i < 26; i++) {
                if (i == 25) { // 'z'
                    next[0] = (next[0] + count[25]) % MOD; // 'a'
                    next[1] = (next[1] + count[25]) % MOD; // 'b'
                } else {
                    next[i + 1] = (next[i + 1] + count[i]) % MOD;
                }
            }

            count = next;
        }

        // Sum all counts to get the total length
        long total = 0;
        for (long c : count) {
            total = (total + c) % MOD;
        }

        return (int) total;
    }
}

    