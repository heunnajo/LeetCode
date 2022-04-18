import java.util.Scanner;
import java.util.Stack;

public class LongestPalindromicSubstring_Idea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean res = true;//자바에는 flag대신 boolean이 있다.
		Scanner sc = new Scanner(System.in);
		Stack stk = new Stack();//스택생성
		char[] cArr;//입력 받은 문자열을 문자배열로 바꿈.그래야 인덱스 처리가 쉽다.
		String n; int len;
		n = sc.nextLine();
		len = n.length();
		
		cArr = n.toCharArray();
		int end, start;//문자열을 반으로 쪼갰을때 각각 배열의 끝과 처음.
		if(len%2 == 0){//문자열의 길이가 짝수일때
			end = len/2 - 1;
			start = len/2;
		}
		else{//문자열 길이가 홀수일때
			end = len/2 - 1;
			start = len/2+1;
		}
		
		for(int i = 0; i <= end; i++)//스택에 절반의 첫번째 배열을 넣어주자.
			stk.push(cArr[i]);
		
		char temp;//스택에서 pop한 원소
		for(int i = start; i < len; i++){
			if(!stk.isEmpty()){
				temp = (char)stk.pop();
				if(temp != cArr[i]){//만약 비교했을때 같지 않다면 회문이 불가능한 숫자.
					res = false;
					break;//더이상 비교할 필요가 없음.
				}
			}
		}
		
		if(res == true) System.out.println("yes");
		else System.out.println("no");
		}
		
		

}