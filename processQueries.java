//#1409.Queries on a Permutation With Keys
class Solution {
    public int[] processQueries(int[] queries, int m) {
        int[] m_arr = new int[m];
        
        int index = 0;
        for(int i=1; i<=m; i++){
            m_arr[index] = i;
            index++;
        }
        
        int[] ans = new int[queries.length];
        
        for(int i=0; i<queries.length; i++){
            
            /*find index*/
            index = 0;
            for(int j=0; j<m_arr.length; j++){
                if(m_arr[j] == queries[i]){
                    index = j;
                    break;
                }
            }
            
            /*add in final array*/
            ans[i] = index;
            
            /*Right Shifting m_arr*/
            int k, temp=0;
            temp = m_arr[index];
            for(k=index; k>0; k--)
                m_arr[k] = m_arr[k-1];
            
            m_arr[k] = temp;
        }
        return ans;
    }
}