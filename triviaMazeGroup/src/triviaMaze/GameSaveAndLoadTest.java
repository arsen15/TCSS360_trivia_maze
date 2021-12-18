package triviaMaze;
import static org.junit.jupiter.api.Assertions.*;

import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

class GameSaveAndLoadTest {

	 /**
	   * Fields that help create a Serializable object to test the Save and Load method.
	   */
	  private Serializable mySaveData = "test";
	  
	  /**
	   * Test if Save method generates a test.ser file in the project folder.
	   * @throws Exception
	   */
	  @Test
	  void testSaveGameExist() throws Exception {
	    GameSaveAndLoad.saveGame(mySaveData, "test.ser");
	    assertTrue(Files.exists(Paths.get("test.ser")));
	  }
	  
	  /**
	   * Test if the Load method loads the game properly.
	   * @throws Exception
	   */
	  @Test
	  void testLoadGame() throws Exception {
		TriviaSQL sqTest = new TriviaSQL();
	    MazeContainer mazeTest = new MazeContainer();
	    mazeTest.fixedArraySetup();
	    mazeTest.setDoors(sqTest.setup());
	    mazeTest.setDoorDirection(1);;
	    GameSaveAndLoad.saveGame(mazeTest, "test.ser");
	    assertEquals("north", GameSaveAndLoad.loadGame("test.ser").getCurrentDoorFaceString());
	  }

}
