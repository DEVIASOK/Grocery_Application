package constant;

public class Constant {
	
	public static final String CONFIG_FILE=  System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties";
	public static final String TEST_DATA=  System.getProperty("user.dir")+"\\src\\test\\resources\\Test_Data1.xlsx";
	//get local path- System.getProperty("user.dir")
	//"C:\Users\devia\eclipse-workspace\Grocery_Application\src\main\resources\config.properties"
	//"C:\\Users\\devia\\eclipse-workspace\\Grocery_Application\\src\\test\\resources\\Test_Data1.xlsx"
	//login error message
	public static final String VALID_CREDENTIAL_ERROR="user is not able to login with valid credentials";
	public static final String INVALID_CREDENTIAL_ERROR="User is able to login with invalid credentials";
	public static final String INVALID_USERNAME_ERROR="User is able to login with invalid USERNAME";
	public static final String INVALID_PASSWORD_ERROR="User is able to login with invalid PASSWORD";
	 // Logout error message
    public static final String LOGOUT_ERROR = "User is unable to logout";

    // Admin Users error messages
    public static final String USER_CREATION_ERROR = "User creation failed:User already exists";

    public static final String USER_SEARCH_ERROR = "USER NOT FOUND";

    // Manage Delivery Boy error messages
    public static final String DELIVERY_BOY_CREATION_ERROR = "New Delivery boy not created";

    public static final String DELIVERY_BOY_SEARCH_ERROR = "delivery boy name not found in existing list";
    // Manage Pages error messages
    public static final String MANAGE_PAGE_CREATION_ERROR = "Unexpected error";

    public static final String MANAGE_PAGE_SEARCH_ERROR = " Searched page_title does not exist ";



}


