class Solution {
    int n;
    int[] parent;
    int find(int x){
        if(x == parent[x]){
            return x;
        } else{
            return parent[x] = find(parent[x]);
        }
    }
    void union(int x,int y){
        x = find(x);
        y = find(y);
        
        if(x<y){
            parent[y] = x;   
        } else{//x>=y
            parent[x] = y;
        }
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int len = s1.length();
        parent = new int[26];
        
        for(int i=0;i<26;i++){
            parent[i] = i;
        }
        
        for(int i=0;i<len;i++){
            int x = s1.charAt(i)-'a';
            int y = s2.charAt(i)-'a';
            union(x,y);
        }
        
        // for(int i=0;i<26;i++){
        //     char c = (char)(parent[i]+'a');
        //     System.out.print(c+" ");
        // }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<baseStr.length();i++){
            //char cur = (char)(parent[baseStr.charAt(i)-'a'] + 'a');
            
            char cur = (char)(find(baseStr.charAt(i)-'a') + 'a');
            System.out.println(cur+",");
            sb.append(cur);
        }
        
        return sb.toString();
        
    }
}