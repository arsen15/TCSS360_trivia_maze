package triviaMaze;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * A class that will help us with Saving and Loading the game. REFERENCE:
 * https://www.youtube.com/watch?v=-xW0pBZqpjU&ab_channel=AlmasBaimagambetov
 * 
 * @author Ryan, Arsen, Phuc
 *
 */
public class GameSaveAndLoad {
  /**
   * Save the game into .ser file to be loaded again.
   * 
   * @param theData
   *          data to be saved
   * @param theFileName
   *          name of the file that was saved
   * @throws IOException
   */
  public static void saveGame(Serializable theData, String theFileName)
      throws IOException {
    try (ObjectOutputStream outputStream = new ObjectOutputStream(
        Files.newOutputStream(Paths.get(theFileName)))) {
      outputStream.writeObject(theData);

    }
  }

  /**
   * Load the game back to its previous state.
   * 
   * @param string
   *          name of the file that was saved
   * @return the object that was saved
   * @throws Exception
   */
  public static mazeContainer loadGame(String string) throws Exception {
    try (ObjectInputStream inputStream = new ObjectInputStream(
        Files.newInputStream(Paths.get(string)))) {
      return (mazeContainer) inputStream.readObject();

    }
  }
}
