package com.qa.mystore.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	public static final String LOGIN_PAGE_TITLE = "Login - My Store";
	public static final String ACCOUNTS_PAGE_TITLE = "Login - My Store";
	public static final String ACCOUNTS_PAGE_HEADER = "My account - My Store";
	public static final String HOME_PAGE_TITLE="My Store";
	public static final String SEARCH_RESULTS_PRODUCTSLIST_TITLE="Search - My Store";

	public static final String LOGIN_PAGE_URL_FRACTION = "route=account/login";
	
	public static final int DEFAULT_TIME_OUT = 5;
	public static final int IMAC_IMAGE_COUNT = 3;
	public static final int MACBOOKPRO_IMAGE_COUNT = 4;
	public static final int MACBOOKAIR_IMAGE_COUNT = 4;

	public static final String LOGIN_ERROR_MESSG = "No match for E-Mail Address and/or Password";
	public static final String REGISTER_SUCCESS_MESSG = "Your Account Has Been Created!";
	
	public static List<String> getExpectedAccSecList() {
		List<String> expSecList = new ArrayList<String>();
		expSecList.add("My Account");
		expSecList.add("My Orders");
		expSecList.add("My Affiliate Account");
		expSecList.add("Newsletter");
		return expSecList;
	}
}