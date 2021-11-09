package triviaMaze;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.sqlite.SQLiteDataSource;



public class triviaSQL {  
	 public void setup( ArrayList<ArrayList<Room>> theMaze) { 
	 // public static void main(String[] args) {
	        SQLiteDataSource ds = null;

	        //establish connection (creates db file if it does not exist :-)
	        try {
	            ds = new SQLiteDataSource();
	            ds.setUrl("jdbc:sqlite:questions.db");
	        } catch ( Exception e ) {
	            e.printStackTrace();
	            System.exit(0);
	        }

	        System.out.println( "Opened database successfully" );
	        
	        
	        //now create a table
	        String query = "CREATE TABLE IF NOT EXISTS questions ( " +
	        		"QUESTION TEXT NOT NULL, " +
	                "ANSWER TEXT NOT NULL, " + "ANSWERTWO TEXT NOT NULL )";
	        try ( Connection conn = ds.getConnection();
	                Statement stmt = conn.createStatement(); ) {
	              int rv = stmt.executeUpdate( query );
	              System.out.println( "executeUpdate() returned " + rv );
	          } catch ( SQLException e ) {
	              e.printStackTrace();
	              System.exit( 0 );
	          }
	          System.out.println( "Created questions table successfully" );
	        
	        //next insert two rows of data
	        System.out.println( "Attempting to insert 2 rows into questions table" );

	        String query1 = "INSERT INTO questions ( QUESTION, ANSWER, ANSWERTWO ) VALUES ( 'Last name of Java creator?', 'Gosling', 'testing' )";
	        String query2 = "INSERT INTO questions ( QUESTION, ANSWER, ANSWERTWO ) VALUES ( 'This statement is false', 'paradox', 'Testing' )";
            String query3 = "INSERT INTO questions ( QUESTION, ANSWER, ANSWERTWO ) VALUES ( 'what does gael want?', 'dark soul', '' )";
	        try ( Connection conn = ds.getConnection();
	              Statement stmt = conn.createStatement(); ) {
	            int rv = stmt.executeUpdate( query1 );
	            System.out.println( "1st executeUpdate() returned " + rv );

	            rv = stmt.executeUpdate( query2 );
	            System.out.println( "2nd executeUpdate() returned " + rv ); 
	            rv = stmt.executeUpdate(query3);
	        } catch ( SQLException e ) {
	            e.printStackTrace();
	            System.exit( 0 );
	        }
	        
	        
	        //now query the database table for all its contents and display the results
	        System.out.println( "Selecting all rows from test table" );
	        query = "SELECT * FROM questions";

	        try ( Connection conn = ds.getConnection();
	              Statement stmt = conn.createStatement(); ) {
	            
	            ResultSet rs = stmt.executeQuery(query);
	            
	            //walk through each 'row' of results, grab data by column/field name
	            // and print it
	            while ( rs.next()) {
	                String question = rs.getString( "QUESTION" );
	                String answer = rs.getString( "ANSWER" ); 
	                String answer2 = rs.getString("ANSWERTWO"); 
	                MultipleChoiceQuestion q = new MultipleChoiceQuestion(); 
	                q.setQuestionText(question); 
	                q.setMultipleChoiceOptionA(answer);
	                Door door = new Door(); 
	                

	                System.out.println( "Result: Question = " + question +
	                    ", Answer = " + answer + "answer 2"+answer2);
	            }
	        } catch ( SQLException e ) {
	            e.printStackTrace();
	            System.exit( 0 );
	        }
	    }
}
