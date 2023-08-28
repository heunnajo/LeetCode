class Solution {
    public int reverse(int x) {
        String xs = String.valueOf(x);
        String rs = new StringBuilder().append(xs).reverse().toString();
        int result = 0;
        long tempResult = 0l;
        if(rs.endsWith("-")) {
            tempResult = Long.parseLong(rs.substring(0, rs.length()-1)) * -1;
        } else {
            tempResult = Long.parseLong(rs);
        }

        if(tempResult < Integer.MIN_VALUE || tempResult > Integer.MAX_VALUE) {
            result = 0;
        } else {
            result = (int) tempResult;
        }

        return result;
    }
}