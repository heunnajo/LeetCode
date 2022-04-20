class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();
        char[][] arr = new char[numRows][len/2];
        
        int i=0,j=0;
        for(int idx=0;idx<len;idx++){
            for(int k=0;k<numRows;k++){
                arr[i++][j] = s.charAt(idx);
            }
            for(int k=0;k<numRows-1;k++){
                if(j>=len/2) break;;
                arr[i--][j++] = s.charAt(idx);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int row=0;row<arr.length;row++){
            for(int col=0;col<arr[0].length;col++){
                sb.append(arr[row][col]);
            }
        }
        return sb.toString();
    }
}