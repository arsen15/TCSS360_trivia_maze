package triviaMaze;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class gameSave {
  public static void main(String[] args) {
    triviaSQL sq1 = new triviaSQL();
    mazeContainer mC1 = new mazeContainer();
    mC1.fixedArraySetup();
    mC1.setDoors(sq1.setup());
    try {
      FileOutputStream fileOut = new FileOutputStream("currentMazeVer.ser");
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(mC1);
      out.close();
      fileOut.close();
      System.out.printf("Serialized data is saved in currentMazeVer.ser");
    } catch (IOException i) {
      i.printStackTrace();
    }
  }
}
