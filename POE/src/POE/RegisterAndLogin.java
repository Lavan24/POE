package POE;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.*;

public class RegisterAndLogin {

    public static void main(String[] args) {
       
    //created an object called 'user'
    Login user = new Login();
    
    //calls a method from Login to display the registering image
    user.registering();
     
    //variables for name & surnaame:
    String inputName, inputSurname;

    /*
    loop for entering your name. if your name is null, empty, blank, conatins numbers,special charecters or is greater than 14 then it will
    return an error message and will prompt you to enter a valid name.
    */
    do {
        inputName = JOptionPane.showInputDialog("Please enter your name:");
            if (inputName == null || inputName.isEmpty() || inputName.isBlank() 
           || inputName.matches(".*[0-9].*") || inputName.matches(".*[`~|/!@#$%^&*()_={}<>?:].*") || inputName.length() >= 14) {
                JOptionPane.showMessageDialog( null, "Please enter a name to proceed with the application."
                                              , "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Your name has been saved successfully!");
                user.setName(inputName);
                break;
            }     
    } while (true);
    /*
    loop for entering your surname. if your surname is null, empty, blank, conatins numbers,special charecters or is greater than 14 then it will
    return an error message and will prompt you to enter a valid surname.
    */  
    do {
        inputSurname = JOptionPane.showInputDialog("Please enter your surname:");
            if (inputSurname == null || inputSurname.isEmpty() || inputSurname.matches(".*[0-9].*")
                || inputSurname.matches(".*[`~.!@#$%^&*()-+?|_=,<>/].*") || inputSurname.isBlank()  || inputSurname.length() >= 14) {
                JOptionPane.showMessageDialog( null, "Please enter a surname to proceed with the application."
                                              , "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,"Your surname has been saved successfully!" );
                user.setSurname(inputSurname);
                break;
            }     
    } while (true);
    
    //variables for username & password
    String inputUserName, inputPassword = " ";
    boolean isUserNameValid, isPasswordValid , isLoginSuccessfull;
    
    /*
    loop for entering your username. When you enter an incorrect username the loop will repeat until your username meetes the set requirments.
    if you enter a username that has all requirements then it will 'set' the username using the 'set' method.
    */
      do {
            inputUserName = JOptionPane.showInputDialog(null, "Please enter a username:\n" +
             "Your username must contain:\n~ An underscore\n~ Must be 5 characters or less.");
            isUserNameValid = user.checkUserName(inputUserName);
            user.registerUser(inputUserName, inputPassword);
            user.setUserName(inputUserName);
                if (!isUserNameValid) {}    
        } while (!isUserNameValid);//while false.
      
     /*
    loop for entering your password. When you enter an incorrect password the loop will repeat until your password meetes the set requirments.
    if you enter a password that has all requirements then it will 'set' the password using the 'set' method.
    */
      do {
            inputPassword = JOptionPane.showInputDialog(null, "Please enter a password.\n" +
                                                                   "Your password must contain:\n" +
                            "~ A capital letter\n~ A special charceter\n~ A number\n~ Must be 8 characters or more.");
            isPasswordValid = user.checkPasswordComplxity(inputPassword);
            user.registerUser(inputPassword);
            user.setPassword(inputPassword);
                if (!isPasswordValid) {
                }
        } while (!isPasswordValid); //while false
     
      JOptionPane.showMessageDialog(null, "The registration process is now complete!");
      
     /*
     prompt the user to make a choice: login or cancel. 
     if they press Cancel all their progress will be lost and they will have to reset their name, surname, username and password
     */
     
     /*
     CODE ATTRIBUTION
     Line 149 - 151 was taken from Stack Overflow
     https://stackoverflow.com/questions/13479731/joptionpane-showoptiondialog
     author: gadeynebram
     https://stackoverflow.com/users/1053785/gadeynebram
     */
    String[] options = {"LOGIN", "CANCEL"}; 
    int action = JOptionPane.showOptionDialog(null, "Please select an action you want to complete.", "Options",
                             JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

    if (action == JOptionPane.YES_OPTION)
    {
       user.login();
    /*
       CODE ATTRIBUTION
       code for adding a count variable was taken from Stack Overflow
       https://stackoverflow.com/questions/33344858/java-addition-while-loop-and-joptionpane
       author: Bob
       https://stackoverflow.com/users/5488976/bob
    */
    int count = 0;
    while (count < 3) {
        String username = JOptionPane.showInputDialog(null, "Please enter the username that you have set:");

            if (username.isBlank() || username.isEmpty()) {
                JOptionPane.showMessageDialog( null, "Please enter a valid username to proceed with the application."
                                              , "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                String password = JOptionPane.showInputDialog(null, "Please enter the password that you have set:");

            if (password.isBlank() || password.isEmpty()) {
                JOptionPane.showMessageDialog( null, "Please enter a valid password to continue!"
                                              , "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
            if (username.equals(inputUserName) && password.equals(inputPassword)) {
                isLoginSuccessfull = true;
                final JDialog dialog = new JDialog((Frame) null, "", true);
                dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                dialog.setSize(325, 400);
                dialog.setLocationRelativeTo(null);

                JLabel label = new JLabel();
                label.setIcon(new ImageIcon("Heading.gif")); 

                /*
                CODE ATTRIBUTION
                Code for changing the font colour
                https://stackoverflow.com/questions/26913923/how-do-you-change-the-size-and-font-of-a-joptionpane
                author: Sergiy Medvynskyy
                https://stackoverflow.com/users/1989769/sergiy-medvynskyy
                */
                
                //this will add the users name and surname to the logo display gif.  
                JLabel textLabel = new JLabel("Welcome " + inputName + " " + inputSurname + "! \n" + "It is great to see you again!");
                textLabel.setHorizontalAlignment(JLabel.CENTER); 
                textLabel.setForeground(Color.darkGray);

                JPanel panel = new JPanel();
                panel.setLayout(new BorderLayout());
                panel.add(label, BorderLayout.NORTH); 
                panel.add(textLabel, BorderLayout.CENTER);

                dialog.add(panel);
                    
                Timer timer = new Timer(5000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dialog.dispose();
                }
                });
                timer.setRepeats(false);
                timer.start();
                dialog.setVisible(true);

                break;
            } else {
                JOptionPane.showMessageDialog(null, "Your username or password is incorrect!");
                count++;
                      }
                }
            }
        }
         if (count == 3) {
            JOptionPane.showMessageDialog(null, """
                                                You have entered the incorrect Password & Username 3 times.
                                                You are now locked out of your account.
                                                """);
        }
    }else if(action == JOptionPane.NO_OPTION){
    JOptionPane.showMessageDialog(null, "You have chosen to exit the program. Goodbye!", "EXIT",JOptionPane.ERROR_MESSAGE );
    }
//****************************************************************************END OF PART ONE***********************************************************************************************************************
    //created an object called myTask to access the task class
    Task myTask = new Task();
    boolean numOfTasksValid = false; // sets numOfTasksValid to false
    do {
    int choice = 0; // sets choice to 0
    String menu = "1. Add Tasks \n" + "2. Show Report \n" + "3. Quit"; //the options the user is presented with.
    String input = JOptionPane.showInputDialog(null, "Please choose an option from the below menu: \n" + menu, "Options", JOptionPane.INFORMATION_MESSAGE);
    
    //if the user enters invalid data the following error message will be displayed.
    if(input.isEmpty() || input.isBlank() || input.matches(".*[a-z].*") || input.matches(".*[A-Z].*") || input.matches(".*[~!@#$%^&*()_+`=;',./:<>].*")){
        JOptionPane.showMessageDialog(null,  "Please select a number from the above menu.", "Selection", JOptionPane.ERROR_MESSAGE);
    }else{
        //if the user enters data that is valid the folllwoing will occur
        choice = Integer.parseInt(input); 

        switch(choice){
            case 1:
                do {
                    String tasks = JOptionPane.showInputDialog(null, "How many tasks would you like to add?");
// if the the user enters letters or leaves it blank or filled with white space an error message will be displayed and it will promt the user to enter valid dats.       
                    if (tasks.isBlank() || tasks.isEmpty() || tasks.matches(".*[A-Z].*") ||tasks.matches(".*[a-z].*") ){
                        JOptionPane.showMessageDialog(null,  "Please enter a number to proceed with the application.", "Number Of Tasks.", JOptionPane.ERROR_MESSAGE);
                    }else{
//if the user enters the correct data it will the 'parse' and then call the taskDetails(numTasks) method
                        int numTasks = Integer.parseInt(tasks);
                        double totalNumOfTasks = myTask.taskDetails(numTasks);
                        JOptionPane.showMessageDialog(null,"Total amount of hours accross all development tasks is: "+ totalNumOfTasks + " hours.");
                    }
                }while(numOfTasksValid);
            break;
            case 2:
                // displays the "coming soon" message 
                JOptionPane.showMessageDialog(null, "Coming Soon!", "Future Expansion", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 3:    
                // if the user enter 3 the program will quit.
                myTask.quit();
                break;
            default:
                // this is the deafult. If the user enter any number that is greater than 3 it will display an error message.
                JOptionPane.showMessageDialog(null, "Please select an option from the menu box.", "Selection", JOptionPane.ERROR_MESSAGE);
        }//switch
    }
    } while (isLoginSuccessfull = true);
//********************************************************** END OF PART TWO **************************************************************************************************************   
   
    
    }// end of main
} // end of class