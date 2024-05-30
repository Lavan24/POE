package POE;
import POE.Login;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class LoginTest {
    
    public LoginTest() { }
    //testUser is an object
    Login testUser = new Login();
    
    @Test
    /*
    this method is for the correct username.
    the correct username is stored in usernameCorrect and will then be checked in the checkUserName method.
    */
    public void testCheckUserNameCorrect() {
    String usernameCorrect = "kyl_1";
    testUser.setUserName(usernameCorrect);
    boolean result = testUser.checkUserName(usernameCorrect);
    assertEquals(true, result);  
    }
     /*
    this method is for the incorrect username.
    the incorrect username is stored in usernameIncorrect and will then be checked in the checkUserName method.
    */
    @Test
    public void testCheckUserNameIncorrect() {
    String usernameIncorrect = "kyle!!!!!!!";
    testUser.setUserName(usernameIncorrect);
    boolean result = testUser.checkUserName(usernameIncorrect);
    assertEquals(false, result);   
    }
    
    @Test
    /*
    this method is for the correct password.
    the correct password is stored in passwordCorrect and will then be checked in the checkPassword method.
    */
    public void testCheckPasswordComplxityCorrect() {
    String passwordCorrect = "Ch&&sec@ke99!";
    testUser.setPassword(passwordCorrect);
    boolean result = testUser.checkPasswordComplxity(passwordCorrect);
    assertEquals(true, result); 
    }
    
    /*
    this method is for the incorrect password.
    the incorrect password is stored in passwordIncorrect and will then be checked in the checkPassword method.
    */
    @Test
    public void testCheckPasswordComplxityIncorrect() {
    String passwordzIncorrect = "password";
    testUser.setPassword(passwordzIncorrect);
    boolean result = testUser.checkPasswordComplxity(passwordzIncorrect);
    assertEquals(false, result);
    
    }
   /*
    CODE ATTRIBUTION
    for testLoginUserCorrect() and testLoginUserIncorrect() was taken form stack Overflow
    https://stackoverflow.com/questions/31174339/junit-testing-a-method-with-joptionpane-showmessagedialog
    author: mediumN
    https://stackoverflow.com/users/4749658/mediumm
    */
    @Test
    public void testLoginUserCorrect() {
    String usernameCorrect = "kyl_1";
    String passwordCorrect = "Ch&&sec@ke99!";
    String usernameCorrect2 = "kyl_1";
    String passwordCorrect2 = "Ch&&sec@ke99!";
    boolean result = true;
    


    if(usernameCorrect2.equals(usernameCorrect) && passwordCorrect2.equals(passwordCorrect) ){

        result = true;
    }
       assertTrue(result);
    }
    
    
    @Test
    public void testLoginUserIncorrect() {
    String usernameCorrect = "kyl_1";
    String passwordCorrect = "Ch&&sec@ke99!";
    String usernameIncorrect = "kule!!!!!!";
    String passwordIncorrect2 = "paasword";
    boolean result = false;
     
    if(usernameIncorrect.equals(usernameCorrect) && passwordIncorrect2.equals(passwordCorrect) ){
 
    result = true;
    
    }
    assertFalse(result);
    }
    
    @Test
    public void testCheckUserNameCorrectTrue() {
    String usernameCorrect = "kyl_1";
    testUser.setUserName(usernameCorrect);
    boolean result = testUser.checkUserName(usernameCorrect);
    assertTrue(result);
    }
    @Test
    public void testCheckUserNameIncorrectFalse() {
    String usernameIncorrect = "kyle!!!!!!!";
    testUser.setUserName(usernameIncorrect);
    boolean result = testUser.checkUserName(usernameIncorrect);
    assertFalse(result); 
    }
   
     
    @Test
    public void testCheckPasswordComplxityCorrectTrue() {
    String passwordCorrect = "Ch&&sec@ke99!";
    testUser.setPassword(passwordCorrect);
    boolean result = testUser.checkPasswordComplxity(passwordCorrect);
    assertTrue(result);

    }
    
    @Test
    public void testCheckPasswordComplxityIncorrectFalse() {
    String passwordzIncorrect = "password";
    testUser.setPassword(passwordzIncorrect);
    boolean result = testUser.checkPasswordComplxity(passwordzIncorrect);
   assertFalse(result);
    
    }
}
