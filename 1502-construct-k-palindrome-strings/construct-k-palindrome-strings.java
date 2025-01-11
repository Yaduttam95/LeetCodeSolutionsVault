class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        if(n==k){
            return true;
        }else if(k>n){
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        int ct = 0;
        for(Map.Entry<Character, Integer> ele: map.entrySet()){
            if(ele.getValue()%2!=0){
                ct++;
            }
        }
        if(ct>k){
            return false;
        }
        return true;
    }
}