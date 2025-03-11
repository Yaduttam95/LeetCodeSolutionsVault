class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        HashMap<Character, Integer> mp = new HashMap<>();
        int ans = 0;
        int l = 0, r = 0;
        
        while (r < n) {
            mp.put(s.charAt(r), mp.getOrDefault(s.charAt(r), 0) + 1);
            
            while (mp.size() == 3) {
                ans += (n - r);
                mp.put(s.charAt(l), mp.get(s.charAt(l)) - 1);
                if (mp.get(s.charAt(l)) == 0) mp.remove(s.charAt(l));
                l++;
            }
            r++;
        }
        return ans;
    }
}