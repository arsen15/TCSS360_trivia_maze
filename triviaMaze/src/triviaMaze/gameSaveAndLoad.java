package triviaMaze;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * gameSave class that will take in the mazeContainer object and its data then
 * the save method will save those into .SER file to be loaded back.
 * 
 * @author Ryan, Arsen, Phuc
 *
 */
public class gameSaveAndLoad {
  public static void saveGame(Serializable theData, String theFileName)
      throws IOException {
    try (ObjectOutputStream outputStream = new ObjectOutputStream(
        Files.newOutputStream(Paths.get(theFileName)))) {
      outputStream.writeObject(theData);
    }
  }

  public static Object loadGame(String theFileName) throws Exception {
    try (ObjectInputStream inputStream = new ObjectInputStream(
        Files.newInputStream(Paths.get(theFileName)))) {
      return inputStream.readObject();
    }
  }
//  public static public static void main(String[] args) {
//    triviaSQL sq1 = new triviaSQL();
//    mazeContainer mC1 = new mazeContainer();
//    mC1.fixedArraySetup();
//    mC1.setDoors(sq1.setup());
//    try {
//      FileOutputStream fileOut = new FileOutputStream("currentMazeVer.ser");
//      ObjectOutputStream out = new ObjectOutputStream(fileOut);
//      out.writeObject(mC1);
//      out.close();
//      fileOut.close();
//      System.out.printf("Serialized data is saved in currentMazeVer.ser");
//    } catch (IOException i) {
//      i.printStackTrace();
//    }
//  }
}
