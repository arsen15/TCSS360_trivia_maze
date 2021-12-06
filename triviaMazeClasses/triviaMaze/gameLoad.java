package triviaMaze;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class gameLoad {
  public static void main(String[] args) {
    mazeContainer mC1 = null;
    try {
      FileInputStream fileIn = new FileInputStream("currentMazeVer.ser");
      ObjectInputStream in = new ObjectInputStream(fileIn);
      mC1 = (mazeContainer) in.readObject();
      in.close();
      fileIn.close();
    } catch (IOException i) {
      System.out.println("You haven't saved the game yet!");
      i.printStackTrace();

      return;
    } catch (ClassNotFoundException c) {
      System.out.println(
          "Cannot find the save file! Make sure that you have saved the game");
      c.printStackTrace();
      return;
    }

    System.out.println("Deserialized maze...");
    System.out.println("Current facing: " + mC1.getCurrentDoorFaceString());
    System.out.println("I'm currently at X Coordinate: " + mC1.getCurrentX());
    System.out.println("I'm currently at Y Coordinate: " + mC1.getCurrentY());
    System.out.println("Current Maze: " + mC1.getMaze());
  }
}
