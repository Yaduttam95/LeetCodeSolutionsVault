class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {

              int row=mat.length;
	        int col=mat[0].length;

	        HashMap<Integer,int[]> hm=new HashMap<>();//SC:O(arr_length)


	        int[] row_array=new int[row];//SC : O(m)
	        int[] col_array=new int[col];//SC : O(n)

	        for(int i=0;i<row;i++){
	            for(int j=0;j<col;j++){

	                hm.put(mat[i][j],new int[] {i,j});

	            }
	        } //TC : O(m*n)


	        
	        for(int i=0;i<arr.length;i++) {//TC : O(arr.length)
	        	
	        	int[] curr= hm.get(arr[i]);
	        	
	        	row_array[curr[0]]++;
	        	col_array[curr[1]]++;
	        	
	        	if(col_array[curr[1]]==row|| row_array[curr[0]]==col) {
	        		return i;		
	        	}
	        }
	        
	        return 0; 
        
    }
}