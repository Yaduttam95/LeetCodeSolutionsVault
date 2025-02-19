class Solution {
    int cnt = 0; // Counter to track the number of happy strings generated
    
    /**
     * Recursive function to generate happy strings in lexicographical order.
     * @param ind  Current index in the ans array.
     * @param prev The last added character (to ensure adjacent chars are different).
     * @param ans  The character array storing the current generated string.
     * @param k    The target k-th happy string.
     * @return     True if the k-th happy string is found, otherwise false.
     */
    public boolean func(int ind, char prev, char[] ans, int k) {
        // Base Case: If we have filled the entire string
        if (ind == ans.length) {
            cnt++; // Increment the count of valid happy strings
            return cnt == k; // Return true if this is the k-th happy string
        }

        // Try each character from 'a' to 'c'
        for (char ch = 'a'; ch <= 'c'; ch++) {
            if (ch == prev) continue; // Ensure no adjacent characters are the same
            
            ans[ind] = ch; // Place the character in the string
            
            // Recursively generate the rest of the string
            if (func(ind + 1, ch, ans, k)) return true; // If found, stop recursion
        }
        
        return false; // If no valid happy string was found
    }

    /**
     * Main function to generate the k-th lexicographical happy string of length n.
     * @param n The length of the happy string.
     * @param k The k-th smallest happy string to return.
     * @return  The k-th happy string, or an empty string if k is too large.
     */
    public String getHappyString(int n, int k) {
        char[] ans = new char[n]; // Character array to store the current string
        boolean res = func(0, '#', ans, k); // Start backtracking from index 0
        
        return res ? String.valueOf(ans) : ""; // Return result, or empty string if not found
    }
}