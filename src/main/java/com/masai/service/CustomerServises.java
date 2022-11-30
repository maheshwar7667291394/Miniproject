package com.masai.service;

import com.masai.exception.CustomerException;
import com.masai.model.User;

public interface CustomerServises {
	
	public User CreateCustomer(User customer)throws CustomerException;
	public User UpdateCustomer(User customer,String key)throws CustomerException;

}
