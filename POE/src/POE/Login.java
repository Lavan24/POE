package POE;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.WindowConstants;
public class Login {
 
 //private fields: name & surname
  private String name;
  private String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
 
  // private fields username & password
  private String userName;
  private String password;
  
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
  
  
  //empty constructor
  public Login(){}

  //method that checks the username. If username meets the requirements it will return true if it does not then it will return false.     
  public boolean checkUserName(String inputUserName){
    this.userName = inputUserName;
        if (userName.length() <= 5 && userName.contains("_")){  
            return true;
        }
    return false;
  }
  
  //method that checks the password. If password meets the requirements it will return true if it does not then it will return false.     
  public boolean checkPasswordComplxity(String inputPassword){
      this.password = inputPassword;
    if (password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[0-9].*") &&
                password.matches(".*[`~!@#$%^&*()-_+=:;'<>?/,.+-]*.")) {
            return true;
        } else {
            return false;
        }
  }
 
  //method that returns the proper messages back to the user. -> for the username
  //method overloading is being used.
  public String registerUser(String inputUserName, String inputPassword){
    if (!checkUserName(inputUserName)) {   
       JOptionPane.showMessageDialog( null, """
                                            Username is not correctly formatted!
                                            Please ensure that it has an underscore and 5 characters or less!
                                            """ , "ERROR", JOptionPane.ERROR_MESSAGE);
    } else {
                JOptionPane.showMessageDialog(null, "Username successfully captured!");
    }
    return "Username saved successfully.";
  }
  
  //method that returns the proper messages back to the user. -> for the password
  //method overloading is being used.
  public String registerUser( String inputPassword){
   if (!checkPasswordComplxity(inputPassword)) {
        
         JOptionPane.showMessageDialog( null, """
                                            Password is not correctly formatted!
                                            Please ensure your password contains the following:
                                            1. A capital letter.
                                            2. A special character.
                                            3. A number.
                                            4. Must be more than 8 characters long.
                                            """ , "ERROR", JOptionPane.ERROR_MESSAGE);                                 
    } else { 
         JOptionPane.showMessageDialog(null, "Password captured successfully!");
    }
  return "password saved successfully!";
  }
  
  //method for login user.
  public boolean loginUser(){
      
    String inputUserName;
    String inputPassword;
    boolean isUserNameValid;
    boolean isPasswordValis;    
    
    //loop for entering your username after registering.
     do {
        inputUserName = JOptionPane.showInputDialog(null, "Please enter your username:");
        isUserNameValid = checkUserName(inputUserName);
    } while (!isUserNameValid);
     
    // loop for entering your password after registering.
    do {
        inputPassword = JOptionPane.showInputDialog(null, "Enter your password:");
        isPasswordValis = checkPasswordComplxity(inputPassword);
    } while (!isPasswordValis);
    
    /*
    if the username AND password match what is set, then it will return true
    else
    it will display username & password is incorrect and it will return false
    */
          
   if (inputUserName.equals(userName) && inputPassword.equals(password)) {
        return true;
    } else {
      JOptionPane.showMessageDialog( null, "Your username or Password is incorrect."
                                              , "ERROR", JOptionPane.ERROR_MESSAGE);
        return false;
    }   
}
  
  /*
  method for returning login status.
  if the user enters the correct details only then only will the program display a welcome statement, 
  making use of the name and surname set at the beggining of the program
  if the user enters the incorrect details it will display an error message
  */
  public String returnLoginStatus(){
  if (loginUser()) {
            return "Welcome" + name + " " + surname + "\n " + "Its great to see you again!";
                  
        } else {
            return "Username or password is incorrect! Please try again.";
        }
  }
  
    /*
    CODE ATTRIBUTION
    Code for displaying the images was taken from Stack Overflow.
    https://stackoverflow.com/questions/30251877/autoclose-joptionpane-showconfirmdialog-with-a-timer
    author : StanislavL
    https://stackoverflow.com/users/301607/stanislavl
    */
  
  public void registering(){
    final JDialog dialog = new JDialog((Frame) null, "", true);
    dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    dialog.setSize(325, 350);
    dialog.setLocationRelativeTo(null);

    JLabel label = new JLabel();
    label.setIcon(new ImageIcon("Registration.gif"));
    dialog.add(label);

    Timer timer = new Timer(6000, new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
    });
    timer.setRepeats(false);
    timer.start();
    dialog.setVisible(true);  
  }
  
  public void login(){
  
    final JDialog dialog2 = new JDialog((Frame) null, "", true);
    dialog2.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    dialog2.setSize(325, 350);
    dialog2.setLocationRelativeTo(null);

    JLabel label = new JLabel();
    label.setIcon(new ImageIcon("Login.gif")); 
    dialog2.add(label);
    
    Timer timer = new Timer(5000, new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                dialog2.dispose();
            }
        });
        timer.setRepeats(false);
        timer.start();
        dialog2.setVisible(true);

  }
  
}

