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
		
		System.out.print("��α� ��ǥ���� �Է��ϼ��� : ");
		donationCenter.goal = scan.nextInt();
		
		while(true) {
			System.out.print(count + "ȸ�� ��α��� �Է��ϼ��� : ");
			won = scan.nextInt();
			if(donator.donate(won)) {
				donationCenter.donation += won;
				if(donationCenter.donation >= donationCenter.goal) {
					System.out.println("��ǥ���� �޼��Ǿ����ϴ�! �Ѿ� : " + donationCenter.donation + "����");
					System.out.println("�� " + count + "ȸ ����ϼ̽��ϴ�.");
					break;
				}
				recipient.receipt(donationCenter.donation);
				System.out.println("�Ŀ��� �Ѿ� : " + donationCenter.donation);
				count++;
			}
			else {
				System.out.println("��α��� 1ȸ 20���� ���ϸ� �����մϴ�.");
			}
		}
	}
}
