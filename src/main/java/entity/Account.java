package entity;

public class Account {
    private int account_id;
    private int employee_id;
    private String username;
    private String password;
    private String email;

    public Account() {}

    public Account(int account_id, int employee_id, String username, String password, String email) {
        this.account_id = account_id;
        this.employee_id = employee_id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", employee_id=" + employee_id + ", username=" + username
				+ ", password=" + password + ", email=" + email + "]";
	}



    
}

