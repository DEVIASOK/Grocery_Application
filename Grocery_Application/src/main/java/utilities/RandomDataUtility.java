package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	Faker randomdt=new Faker();
	public String genrateRandomUsername() {
		return randomdt.name().username();//username are present in the  name method
	}
	public String genrateRandomPassword() {
		return randomdt.internet().password();//password are present in the internet method
	}
	public String generateFullName()
	{
		return randomdt.name().fullName();
	}
	
	public String generateEmail()
	{
		return randomdt.internet().emailAddress();
	}
	public String generatePhone()
	{
		return randomdt.phoneNumber().cellPhone();
	}
	
}
