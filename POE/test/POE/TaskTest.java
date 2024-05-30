package POE;
import POE.Task;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class TaskTest {
    
    public TaskTest() {
    } 
    
    @Test
    //this will test  to see 
    
    public void testCheckTaskDescription_True() {
    Task newTask = new Task();
    
    String description = "This statement is under 50 characters.";
    
    boolean actual = newTask.checkTaskDescription(description);
    
    assertEquals(true,actual);
    }
    
    @Test
    public void testCheckTaskDescription_False() {
    Task newTask = new Task();
    
    String description = "This statement is above 50 characters and it should return false.";
    
    boolean actual = newTask.checkTaskDescription(description);
    
    assertEquals(false,actual);
    }

    @Test
    public void testCreateTaskID_TestData() {
    //test data from cases one in poe
    Task case1 = new Task("Login Feature","Create login feature to authenticate users.","Robyn Harrison","To do",  8);
   
    String expected = "LO:0:SON";
    
    String actual = case1.createTaskID();
    
    assertEquals(expected,actual);
    
    //test data from cases one in poe
    Task case2 = new Task("Add Task Feature","Create Add Task feature to add task user.","Mike Smith","Doing",  10);
   
    String expected2 = "AD:1:ITH";
    
    String actual2 = case2.createTaskID();
    
    assertEquals(expected2,actual2); 
    }

    @Test
public void totalHours() {
    
    Task testTask1 = new Task("","","","",10);
    Task testTask2 = new Task("","","","",12);
    Task testTask3 = new Task("","","","",55);
    Task testTask4 = new Task("","","","",11);
    Task testTask5 = new Task("","","","",1);

    double expected = 89;
    double actual = testTask1.getTaskDuration()+ testTask2.getTaskDuration()+testTask3.getTaskDuration()+ testTask4.getTaskDuration() +testTask5.getTaskDuration();
    
    assertEquals(expected, actual,0);
    
    Task testTask6 = new Task("","","","",10);
    Task testTask7 = new Task("","","","",8);
    double expected1 = 18;
    double actual1 = testTask6.getTaskDuration() + testTask7.getTaskDuration();
    
    assertEquals(expected1,actual1,0);
}
}
