package com.vti.backend.presentationlayer;

import java.sql.SQLException;

public interface Iview {
	public void getLoginAdmin() throws ClassNotFoundException, SQLException;

	public void getLoginUser() throws ClassNotFoundException, SQLException;
}
