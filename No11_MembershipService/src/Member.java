
public class Member {
	private long id;
	private String name;
	private int mileage;
	
	public Member(long id, String name, int mileage) {
		this.id = id;
		this.name = name;
		this.mileage = mileage;
	}
	public Member(long id, String name) {
		this.id = id;
		this.name = name;
		this.mileage = 0;
	}
	public Member(long id, int mileage) {
		this.id = id;
		this.name = "none";
		this.mileage = mileage;
	}
	public Member(long id) {
		this.id = id;
		this.name = "none";
		this.mileage = 0;
	}
	
	public long getID() {
		return id;
	}
	public void set(long id) {
		this.id = id;
	}
	public void set(String name) {
		this.name = name;
	}
	public void set(int mileage) {
		this.mileage = mileage;
	}
	public String toString() {
		return id + "\t\t" + name + "\t\t" + mileage;
	}
}
