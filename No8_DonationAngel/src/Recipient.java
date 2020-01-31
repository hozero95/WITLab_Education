
public class Recipient {
	
	DonationCenter donationcenter;
	
	public Recipient(DonationCenter donationCenter) {
		this.donationcenter = donationCenter;
	}
	
	void receipt(int donation) {
		donationcenter.donation -= 8;
	}
}
