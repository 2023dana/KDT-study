package MyPage;

import java.util.Random;
import java.util.Scanner;

class random {
	
	Random random1 = new Random();
	int first = random1.nextInt(10);
	Random random2 = new Random();
	int second = random2.nextInt(10);
	Random random3 = new Random();
	int third = random3.nextInt(10);

			
			
	String answer = first+""+second+""+third;
}

class input {
	
}

public class BaseballGame {
		
	public static void main(String[] args) {
		
		
			
		random r = new random();
		Scanner answer1 = new Scanner(System.in);
		System.out.println("세 자리 숫자를 입력하세요");
		if(answer1==first) {
			System.out.println(Strike);
		}
			
		
		System.out.println("정답은 "+r.answer);

	}

}
