/**
 * @author Ryan, Phuc, Arsen
 * An interface class for Question that will lay out the necessary methods.
 */
public interface Question {
	public void checkQuestion(char a);  	 
	public void setQuestionText(String a); 	
	public boolean answer(); 
	public String getQuestionText();
  public String getMultipleChoiceOptionA();   
  public String getMultipleChoiceOptionB();    
  public String getMultipleChoiceOptionC();   
  public String getMultipleChoiceOptionD();  
}