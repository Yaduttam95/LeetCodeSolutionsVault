class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length()!=t.length()){
            return false;
        }

        HashMap<Character, Integer> hm1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> hm2 = new HashMap<Character, Integer>();
        
        for (int i =0; i<s.length();i++){
            int k = hm1.getOrDefault(s.charAt(i), 0);
            hm1.put(s.charAt(i), k+1);

            int l = hm2.getOrDefault(t.charAt(i), 0);
            hm2.put(t.charAt(i), l+1);
        }

        return hm1.equals(hm2);
         
    }
}