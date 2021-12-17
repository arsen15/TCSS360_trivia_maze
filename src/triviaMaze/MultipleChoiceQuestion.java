package triviaMaze;

import java.io.File;
import java.io.Serializable;

public class MultipleChoiceQuestion implements Question, Serializable {

  private static final long serialVersionUID = 9129880869446421445L;
// set to public for testing the getters
  private boolean myQuestionAnswer;
  public String myQuestionText;

  private String myOptionA;
  private String myOptionB;
  private String myOptionC;
  private String myOptionD;
  private char myCharacterAnswer;
  public File myImageFile;
  // maybe just have setters instead of things in constructor, to be seen
  public MultipleChoiceQuestion() {
    // myQuestionText = theQuestionText;
    // myCharacterAnswer = theAnswer;
  }

  public void setAnswer(char theAnswer) {
    myCharacterAnswer = theAnswer;
  }

  @Override
  public void checkQuestion(char theInput) {

    if (myCharacterAnswer == theInput) {
      myQuestionAnswer = true;
    } else {

      myQuestionAnswer = false;
    }

  }

  @Override
  public void setQuestionText(final String theQuestionText) {

    myQuestionText = theQuestionText;
  }

  public String getQuestionText() {
    return myQuestionText;
  }

  public String getMultipleChoiceOptionA() {
    return myOptionA;
  }
  public String getMultipleChoiceOptionB() {
    return myOptionB;
  }
  public String getMultipleChoiceOptionC() {
    return myOptionC;
  }
  public String getMultipleChoiceOptionD() {
    return myOptionD;
  }
  public void setMultipleChoiceOptionA(final String theA) {
    myOptionA = theA;
    // return myOptionA;
  }
  public void setMultipleChoiceOptionB(final String theB) {
    myOptionB = theB;
    // return myOptionB;
  }
  public void setMultipleChoiceOptionC(final String theC) {
    myOptionC = theC;

  }
  public void setMultipleChoiceOptionD(final String theD) {
    myOptionD = theD;
    // return myOptionD;
  }
  public void setImage(final File theFile) {
    myImageFile = theFile;
  }
  public File getImage() {
    return myImageFile;
  }

  // block of setters and getters ,maybe make a class for the multiple choices
  // to seperate this

  @Override
  public boolean answer() {

    return myQuestionAnswer;

  }

}
