/*
 * TCSS 360 Trivia Maze Project
 * Fall 2021
 */

package triviaMaze;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import org.sqlite.SQLiteDataSource;

/**
 * This class opens and sets up the database.
 *   
 * @author Ryan Montoya, Phuc Luu, Arsen Shintemirov
 * @version 12/17/2021
 */
public class TriviaSQL {

	/**
	 * Used to get a random question.
	 */
  Random myRandomQuestion = new Random();

  /**
   * Method that sets up the database for the maze.
   * @return
   */
  public ArrayList<Question> setup() {
    SQLiteDataSource ds = null;
    ArrayList<Question> questionList = new ArrayList<Question>();
    // establish connection (creates db file if it does not exist :-)
    try {
      ds = new SQLiteDataSource();
      ds.setUrl("jdbc:sqlite:questions.db");
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(0);
    }

    System.out.println("Opened database successfully");

    String query = "CREATE TABLE IF NOT EXISTS questions ( "
        + "QUESTION TEXT NOT NULL, " + "TYPE TEXT NOT NULL, "
        + "ANSWERA TEXT NOT NULL, " + "ANSWERB TEXT NOT NULL, "
        + "ANSWERC TEXT NOT NULL, " + "ANSWERD TEXT NOT NULL, "
        + " IMAGE TEXT NOT NULL )";

    try (Connection conn = ds.getConnection();
        Statement stmt = conn.createStatement();) {
      int rv = stmt.executeUpdate(query);
      System.out.println("executeUpdate() returned " + rv);
    } catch (SQLException e) {
      e.printStackTrace();
      System.exit(0);
    }
    System.out.println("Created questions table successfully");

    // next insert two rows of data
    System.out.println("Attempting to insert 2 rows into questions table");
    try (Connection conn = ds.getConnection();
        Statement stmt = conn.createStatement();) {
      // int rv = stmt.executeUpdate( query1 );
      // System.out.println( "1st executeUpdate() returned " + rv );

    } catch (SQLException e) {
      e.printStackTrace();
      System.exit(0);
    }

    // now query the database table for all its contents and display the results
    System.out.println("Selecting all rows from test table");
    query = "SELECT * FROM questions";

    try (Connection conn = ds.getConnection();
        Statement stmt = conn.createStatement();) {

      ResultSet rs = stmt.executeQuery(query);

      // walk through each 'row' of results, grab data by column/field name
      // and print it
      // create an array of questions to randomly select from when creating
      // doors after the while loop

      while (rs.next()) {
        String question = rs.getString("QUESTION");
        String type = rs.getString("TYPE");
        String answerA = rs.getString("ANSWERA");
        String answerB = rs.getString("ANSWERB");
        String answerC = rs.getString("ANSWERC");
        String answerD = rs.getString("ANSWERD");
        String image = rs.getString("IMAGE");
        if (type.equals("MC")) {
          // answerA is always correct in the database so shuffle the placement
          // and store the int value to establish the char correct answer

          MultipleChoiceQuestion q = new MultipleChoiceQuestion();
          q.setQuestionText(question);
          final int MCRoll = 4;
          // roll for stuff here
          int a = myRandomQuestion.nextInt(MCRoll);

          if (a == 0) {
            q.setAnswer('A');
            q.setMultipleChoiceOptionA(answerA);
            q.setMultipleChoiceOptionB(answerC);
            q.setMultipleChoiceOptionC(answerB);
            q.setMultipleChoiceOptionD(answerD);
          } else if (a == 1) {
            q.setAnswer('B');
            q.setMultipleChoiceOptionB(answerA);
            q.setMultipleChoiceOptionA(answerC);
            q.setMultipleChoiceOptionC(answerB);
            q.setMultipleChoiceOptionD(answerD);
          } else if (a == 2) {
            q.setAnswer('C');
            q.setMultipleChoiceOptionC(answerA);
            q.setMultipleChoiceOptionA(answerC);
            q.setMultipleChoiceOptionB(answerB);
            q.setMultipleChoiceOptionD(answerD);
          } else if (a == 3) {
            q.setAnswer('D');
            q.setMultipleChoiceOptionD(answerA);
            q.setMultipleChoiceOptionA(answerC);
            q.setMultipleChoiceOptionC(answerB);
            q.setMultipleChoiceOptionB(answerD);
          }
          File f = new File("./" + image);
          q.setImage(f);
          questionList.add(q);

        } else {
          TFQuestion TF = new TFQuestion();
          TF.setQuestionText(question);

          char[] a = answerA.toCharArray();
          System.out.println(a[0]);
          TF.setAnswer(a[0]);
          File f = new File("./" + image);
          TF.setImage(f);
          questionList.add(TF);
        }

        System.out.println("Result: Question = " + question + ", Type = " + type
            + " option A " + answerA + " option B " + answerB + " option C "
            + answerC + " option D " + answerD);
      }
      return questionList;

    } catch (SQLException e) {
      e.printStackTrace();
      System.exit(0);
    }
    return questionList;
  }
}
