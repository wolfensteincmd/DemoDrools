/**
 * 
 */
package com.demodrools.pojo;

/**
 * @author erick
 *
 */
public class Operations {
	
	public static final int NOT_PROC = 0;
	
	public static final int PROC = 1;
	
	public static final String A = "A";
	
	public static final String B = "B";
	
	public static final String C = "C";
	
	public static final boolean TRUE = true;
	
	public static final boolean FALSE = false;
	
	private String origin;
	
	private String destination;
	
	private double amount;
	
	private double balance;
	
	private double balance2;
	
	private String message;
	
	private int status;
	
	public Operations(){
		this.status = NOT_PROC;
	}

	/**
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	public double getBalance2() {
		return balance2;
	}

	public void setBalance2(double balance2) {
		this.balance2 = balance2;
	}
	
}
