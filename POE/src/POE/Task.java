package POE;
import javax.swing.JOptionPane;
public class Task {
private int numberOfTasks;
    private static int taskNumber = -1;
    private static double totalDuration = 0;
    private double taskDuration;
    private String taskName;
    private String taskDescription;
    private String developerDetails;
    private String taskID;
    private String taskStatus;
    
    
    //setters
    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public void setNumberOfTasks(int numberOfTasks) {
        this.numberOfTasks = numberOfTasks;
    }

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setDeveloperDetails(String developerDetails) {
        this.developerDetails = developerDetails;
    }

    public void setTaskDuration(double taskDuration) {
        this.taskDuration = taskDuration;
        totalDuration += taskDuration;
    }

    public void setTotalDuration(double totalDuration) {
        this.totalDuration = totalDuration;
    }
    
    //getters
    public String getTaskStatus() {
        return taskStatus;
    }

    public String getTaskID() {
        return taskID;
    }

    public int getNumberOfTasks() {
        return numberOfTasks;
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getDeveloperDetails() {
        return developerDetails;
    }

    public double getTaskDuration() {
        return taskDuration;
    }
    
     public double getTotalDuration() {
        return totalDuration;
    }
    
    //constructor with no parameters.
    public Task(){}
    
    //constructor with parameters.
    public Task(String taskName, String taskDescription, String developerDetails, String taskStatus, double taskDuration) 
    {
    this.numberOfTasks = numberOfTasks;
    this.taskName = taskName;
    this.taskDescription = taskDescription;
    this.developerDetails = developerDetails;
    this.taskStatus = taskStatus;
    this.taskDuration = taskDuration;
    this.taskNumber = taskNumber;
    taskNumber++;
    }
  

    /*
    This method will check to see if the description that the user enters is more than 50 characters.
    If it is morethan 50 then the method will return false else it will be true.
    */
    public boolean checkTaskDescription(String taskDescription){
    if (taskDescription.length() <= 50) {
        return true;
    }else{
        return false;
    }
    }
    
    //this method will calaculate the total hours of ALL tasks entered.
    public double totalHours(){
        totalDuration += taskDuration;
    return totalDuration; 
    }
    
    /*
    This method will generate a unique id for each task entered.
    variable named 'details' that will hold the lst three letters of the developers details
    taskID will hold the entire taskID > taskName:taskNumber:details
    */
    
    /*
    CODE ATTRIBUTION:
    used 'Tutorials Point' to get the last 3 characters in a string.
    website:  https://www.tutorialspoint.com/How-to-extract-the-last-n-characters-from-a-string-using-Java
    */
    public String createTaskID(){
    String details = developerDetails.substring(developerDetails.length() - 3); 
    details = details.toUpperCase();
    taskName = taskName.toUpperCase();
    taskID = taskName.substring(0, 2) + ":" + this.taskNumber + ":" + details;
    return taskID;
    }
    
    //this method will output the details to the user in the correct order.
    public String printTaskDetails(){
    String displayDetails = "Task Status: " + taskStatus;
    displayDetails += "\nDeveloper Details: " + developerDetails;
    displayDetails += "\nTask Number: " + taskNumber;
    displayDetails += "\nTask Name: " + taskName;
    displayDetails += "\nTask Description: " + taskDescription;
    displayDetails += "\nTask ID: " + createTaskID() ;
    displayDetails += "\nDuration of the task: " + taskDuration;
    return  displayDetails;       
    }

    public static double taskDetails(int numTasks){
    double total = 0;

    //using a for loop to ask the user for information about each task.
    for(int i = 0; i < numTasks; i++){
        Task task = new Task();
        boolean inputValid = false;

    // each question is contained in a loop so if the user enters invalid data the question will be repeated until the user has entered valid data

        String taskName; 
        do {
        taskName = JOptionPane.showInputDialog(null, "Please enter a name for task " + (i+1));
        if (taskName.isBlank() || taskName.isEmpty() || taskName.length() < 3){
            JOptionPane.showMessageDialog(null, "Please enter valid data to procced!", "Enter Data!",JOptionPane.ERROR_MESSAGE);
        }else {
            inputValid = true;
        }
        }while (!inputValid);
        
        
        String description;
        do {
            inputValid = false; // Reset inputValid to false at the beginning of each iteration
            description = JOptionPane.showInputDialog(null, "Please enter a description for task " + (i+1) + "\nThe task should not exceed 50 characters.");
            task.checkTaskDescription(description);
            if ( description.isBlank() || description.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter valid data.", "Invalid Data!",JOptionPane.ERROR_MESSAGE);
            }else if(description.length() > 50){
                JOptionPane.showMessageDialog(null, "Enter a task description of less than 50 characters. Please try again.", "Invalid Data!",JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Task successfully captured.", "Captured Data.",JOptionPane.INFORMATION_MESSAGE);            
                inputValid = true;
            }
        } while (!inputValid);

        
        String developerDetails;
        do{
        inputValid = false;
        developerDetails = JOptionPane.showInputDialog(null, "Please enter the details of developer " + (i+1));
        if (developerDetails.isBlank() || developerDetails.isEmpty() || developerDetails.matches(".*[~`!@#$%^&*()_+-=;',./<>?:{}|].*") || developerDetails.length() <= 2){
            JOptionPane.showMessageDialog(null, "Please enter valid data to procced!", "Enter Data!",JOptionPane.ERROR_MESSAGE);
        }else {
            inputValid = true;
        }
        }while(!inputValid);
        
        
        String duration;
        double taskDuration = 0;
        do{
        inputValid = false;    
        duration = JOptionPane.showInputDialog(null, "Please enter the duration in hours for task " + (i+1));
        if (duration.isBlank() || duration.isEmpty()|| duration.matches(".*[a-z].*") || duration.matches(".*[A-Z].*") || duration.matches(".*[~!@#$%^&*()_+`=;'/:<>].*")){
            JOptionPane.showMessageDialog(null, "Please enter valid data to procced!", "Enter Data!",JOptionPane.ERROR_MESSAGE);
        }else {
            taskDuration = Double.parseDouble(duration);
            inputValid = true;
        }
        }while(!inputValid);
        
        
        String[] options = {"NOT COMPLETE","IN PROGRESS", "COMPLETED"}; // the user will select which level of completion they are on
        int status = JOptionPane.showOptionDialog(null, "Please select an option:", "Status", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        String taskStatus = options[status];
        
       Task details = new Task(taskName,  description,  developerDetails,  taskStatus,  taskDuration);
       // This calls the method that displays the information. The information will be displayed after all the questions for the task is filled.
       String output = details.printTaskDetails();
       //The total duration will only be displayed once, after all tasks have been filled completely.
       JOptionPane.showMessageDialog(null, output);
       total = details.totalHours();
     
    }//end of for loop
    return total;
    }
    
    public void quit(){
        //this will ask the user if they are sure they want to quit, if they select yes the project will exit,
        //if they select no the program will take them back to the menu.
    String[] options = {"YES", "NO"}; 
                int action = JOptionPane.showOptionDialog(null, "Are you sure you want to Quit?", "Exit",
                         JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (action == JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(null, "Thank you for using Kanban Boards! Good Bye!", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
    }
    
}
