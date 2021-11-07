package triviaMaze;

public class TFQuestion implements Question {
 
	private final String myQuestionText; 
	
	private boolean myQuestionAnswer; 
	TFQuestion(String theQuestion) { 
		myQuestionText = theQuestion; 
	}
	
	public void setQuestionText() { 
		
	} 
	

	 public void checkQuestion(char a) { 
		 if(a=='T') { 
			 myQuestionAnswer =  true;
		 } else if( a == 'F') { 
			 myQuestionAnswer = false; 
		 } 
		
	 }

	@Override
	public boolean answer() {
		// TODO Auto-generated method stub
		return myQuestionAnswer;
	} 
	 

	
}
