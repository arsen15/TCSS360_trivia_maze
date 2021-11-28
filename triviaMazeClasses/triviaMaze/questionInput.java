package triviaMaze;

/**
 * 
 * @author Ryan. Arsen, Phuc
 *
 */
public class questionInput {

  public void testing() {

    Room temp = new Room();

    TFQuestion darkSoul = new TFQuestion();
    darkSoul.setQuestionText("Does gael seek the dark soul?");
    darkSoul.setAnswer('T');

    temp.getNorth().setQuestion(darkSoul);

  }

}