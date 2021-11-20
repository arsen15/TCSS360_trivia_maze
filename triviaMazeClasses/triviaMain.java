/**
 * 
 * @author Ryan, Arsen, Phuc
 *
 */
public class triviaMain {
  public static void main(String[] args) {   
    mazeContainer mc = new mazeContainer(); 
  //   mc.roomSetup(); 
    System.out.println( mc.getMaze().get(0).get(0).getEast().getQuestion().getQuestionText());
    /*
    TFQuestion q = new TFQuestion(); 
    q.setQuestionText("beans"); 
    System.out.println(q.getQuestionText());  
    q.setAnswer('T');
    q.checkQuestion('T');  
    System.out.println(q.answer());    
    */
  }
}
