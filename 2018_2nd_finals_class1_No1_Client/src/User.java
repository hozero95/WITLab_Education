
public class User extends Thread {
	Callback callback;
	
	int id;
	int count;
	
	public User(int id) {
		this.id = id;
		count = 0;
	}
	
	public void setCallback(Callback callback) {
		this.callback = callback;
	}
	
	public void run() {
		while(count < 2) {
			callback.send(id);
			count++;
		}
	}
}
