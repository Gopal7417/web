package com.potix.task1;

public interface RegisterDAO {
	public int registerUser(UserModel um);
	public int validateCredentials(LoginModel lm);
}
