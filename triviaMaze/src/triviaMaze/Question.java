package triviaMaze;

import java.io.File;

public interface Question {
	
	 
	
	
	 public void checkQuestion(char a);  
	 
	 public void setQuestionText(final String a); 
	 public void setAnswer(char a);
	public boolean answer(); 
	public String getQuestionText();
	
    public String getMultipleChoiceOptionA();  
    
    public String getMultipleChoiceOptionB();    
    
    public String getMultipleChoiceOptionC();   
    
    public String getMultipleChoiceOptionD();  
    
	public File getImage();
	
}
