package com.priceshoes.rest.applications;

/**
 * 
 * @author ederquinones
 *
 */
public class APIConstants {
	
	/* ResultSet is "data" */
	public static final String RESTFUL_DATA = "data";
	
	/* Hateoas - links */
	public static final String HATEOAS_LINKS = "_links";
	
	/* Inventory RESTful Service Path */
	public static final String INVENTORY_PATH = "/inventory";
	/* Inventory Online RESTful Service Path */
	public static final String ONLINE_INVENTORY_PATH = "/online";
	/* Inventory Retail RESTful Service Path */
	public static final String RETAIL_INVENTORY_PATH = "/retail";
	
	/* Inventory Online */
	public static final int ONLINE_INVENTORY_TYPE = 0;
	/* Inventory Retail */
	public static final int RETAIL_INVENTORY_TYPE = 1;
	
	/* eCommerce Inventory */
	public static final String ONLINE_INVENTORY = "online";
	/* Retail Inventory */
	public static final String RETAIL_INVENTORY = "retail";
	
	/* Member RESTful Service Path */
	public static final String MEMBER_PATH = "/member";
	
	/* Member - Hello Controller RESTful Service Path */
	public static final String MEMBER_CONTROLLER_HELLO = "/hello";
	/* Member - Count Controller RESTful Service Path */
	public static final String MEMBER_CONTROLLER_COUNT = "/count";
	
	
	/* Member RESTful Service Path */
	public static final String COUPON_PATH = "/coupon";
	
	/* Member - Hello Controller RESTful Service Path */
	public static final String COUPON_CONTROLLER_HELLO = "/hello";
	/* Member - Count Controller RESTful Service Path */
	public static final String COUPON_CONTROLLER_COUNT = "/count";
	
	public static final String ORDER_PATH = "/order";
	
	public static final String PRODUCT_PATH = "/product";
	
	/* Catalog Info  RESTful Service Path */
	public static final String CATALOG_INFO_PATH = "/catalog";
	/* Retail Inventory */
	public static final String CATALOG_INFO = "info";
}
