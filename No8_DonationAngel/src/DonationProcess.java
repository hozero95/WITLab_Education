import java.util.Scanner;

public class DonationProcess {
	Scanner scan = new Scanner(System.in);
	DonationCenter donationCenter;
	Donator donator;
	Recipient recipient;
	
	void initialize() {
		donationCenter = new DonationCenter();
		donator = new Donator();
		recipient = new Recipient(donationCenter);
	}
	
	void process() {
		int count = 1;
		int won = 0;
		initialize();
		
		System.out.print("기부금 목표액을 입력하세요 : ");
		donationCenter.goal = scan.nextInt();
		
		while(true) {
			System.out.print(count + "회차 기부금을 입력하세요 : ");
			won = scan.nextInt();
			if(donator.donate(won)) {
				donationCenter.donation += won;
				if(donationCenter.donation >= donationCenter.goal) {
					System.out.println("목표액이 달성되었습니다! 총액 : " + donationCenter.donation + "만원");
					System.out.println("총 " + count + "회 기부하셨습니다.");
					break;
				}
				recipient.receipt(donationCenter.donation);
				System.out.println("후원금 총액 : " + donationCenter.donation);
				count++;
			}
			else {
				System.out.println("기부금은 1회 20만원 이하만 가능합니다.");
			}
		}
	}
}
