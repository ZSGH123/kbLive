package com.kblive.usersystem.common.utils.datetools;

import java.util.Date;


public class AutoDefineDate extends Date {

	private static final long serialVersionUID = 1L;

	private long date;
	
	public AutoDefineDate() {
		super();
	}

	public AutoDefineDate(long date) {
		super(date);
		this.date=date;
	}
	public String toString() {
       Date d=new Date(date);
       return DateTools.dateToStrWithTime(d);
    }
	public static void main(String[] args) {
		 System.out.println(new AutoDefineDate(new Date().getTime()));
		 System.out.println(new Date());
	}
	
}
