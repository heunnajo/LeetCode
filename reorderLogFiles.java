class Solution {
    public String[] reorderLogFiles(String[] logs) {
        //1.identifier 로 구분!
		//2.단어로 이루어진 덩어리를 lexigraphically 정렬!
		Comparator<String> comp = new Comparator<String>() {
			@Override
			public int compare(String s1,String s2) {
				int s1SpaceIndex = s1.indexOf(' ');
				int s2SpaceIndex = s2.indexOf(' ');
				
				char c1 = s1.charAt(s1SpaceIndex+1);
				char c2 = s2.charAt(s2SpaceIndex+1);
				if(c1 <= '9') {
					if(c2 <= '9') {return 0;}//1.digit, digit인 경우
					else {return 1;}//2.digit, letter인 경우 : 자리바꿈!
				}
                //3.letter, digit 인 경우
				if(c2 <= '9') return -1;
                
				//4.letter, letter인 경우
				int res =  s1.substring(s1SpaceIndex+1).compareTo(s2.substring(s2SpaceIndex+1));
				if(res == 0){//단어가 동일한 경우, identifier로 lexicographically 해야하기 때문에 이 부분이 추가됨!
				return s1.substring(0,s1SpaceIndex).compareTo(s2.substring(0,s2SpaceIndex));
				}
                return res;
			}
		};
		Arrays.sort(logs,comp);
        return logs;
    }
}