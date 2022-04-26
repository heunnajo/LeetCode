class Solution {
     public String largestNumber(int[] nums) {
        int[] sorted = Arrays.stream(nums)
            .boxed()
            .sorted(this::compare)
            .mapToInt(i -> i).toArray();

        StringBuilder sb = new StringBuilder();
        for(int num : sorted) {
            sb.append(num);
        }

        String res = sb.toString();
        return res.charAt(0) == '0' ? "0" : res;
    }
    private int compare(Integer a, Integer b) {
         String str1 = String.format("%d%d", a, b);
         String str2 = String.format("%d%d", b, a);
         return str2.compareTo(str1);
    }
}