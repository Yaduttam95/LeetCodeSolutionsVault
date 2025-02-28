class Solution {
    public String shortestCommonSupersequence(String a, String b) {
        int[][]dp=new int[a.length()][b.length()];
        for(int[]k:dp)Arrays.fill(k,-1);
        a(a,b,0,0,dp);
        StringBuilder sb=new StringBuilder();
        int i=0,j=0;
        while(i<a.length() && j<b.length()){
            if(a.charAt(i)==b.charAt(j)){
                sb.append(a.charAt(i));
                i++;j++;
            }
            else if(i<a.length()-1 && dp[i+1][j]==dp[i][j]){
                sb.append(a.charAt(i));
                i++;
            }
            else{
                sb.append(b.charAt(j));
                j++;
            }
        }
        while(i<a.length()){
            sb.append(a.charAt(i++));
        }
        while(j<b.length()){
            sb.append(b.charAt(j++));
        }
        return sb.toString();
    }
    public int a(String a,String b,int i,int j,int[][]dp){
        if(i==a.length() || j==b.length())return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(a.charAt(i)==b.charAt(j)){
            return dp[i][j]=1+a(a,b,i+1,j+1,dp);
        }
        else{
            return dp[i][j]=Math.max(a(a,b,i+1,j,dp),a(a,b,i,j+1,dp));
        }
    }
}
// class Solution {
//     public String shortestCommonSupersequence(String a, String b) {
//         int[][]dp=new int[a.length()+1][b.length()+1];
//         for(int i=1;i<=a.length();i++){
//             for(int j=1;j<=b.length();j++){
//                 if(a.charAt(i-1)==b.charAt(j-1)){
//                     dp[i][j]=1+dp[i-1][j-1];
//                 }
//                 else{
//                     dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
//                 }
//             }
//         }
//         StringBuilder sb=new StringBuilder();
//         int i=0,j=0;
    //     while(i<a.length() && j<b.length()){
    //         if(a.charAt(i)==b.charAt(j)){
    //             sb.append(a.charAt(i));
    //             i++;j++;
    //         }
    //         else if(i<a.length()-1 && dp[i][j]==dp[i+1][j]){
    //             sb.append(a.charAt(i));
    //             i++;
    //         }
    //         else{
    //             sb.append(b.charAt(j));
    //             j++;
    //         }
    //     }
    //     while(i<a.length()){
    //         sb.append(a.charAt(i++));
    //     }
    //     while(j<b.length()){
    //         sb.append(b.charAt(j++));
    //     }
    //     return sb.toString();
    // }
// }