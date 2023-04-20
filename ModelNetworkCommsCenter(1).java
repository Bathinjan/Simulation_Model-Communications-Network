import java.util.*;
import java.io.*;

class ModelNetworkCommsCenter
{
  public static void main(String[] args) 
  {
    // create scanner to read keyboard input
    Scanner keyboard = new Scanner(System.in);

    // request nccName and seed
    System.out.println("Please enter the name of the Network Comms Center: ");
    String nccName = keyboard.next();

    System.out.println("Please enter the seed as an integer: ");
    int seed = keyboard.nextInt();

    // create new NetworkCommsCenter with 2 vals as params
    NetworkCommsCenter ncc = new NetworkCommsCenter(nccName, seed);

    // read in # of paths as an int
    System.out.println("Please enter the number of paths as an integer: ");
    int numPaths = keyboard.nextInt();

    // initialize ncc w/ number of paths as param
    ncc.initializeNetworkCommsCenter(numPaths);

    // read in # of milliseconds to keep ncc operating for durationForArriving after init
    System.out.println("Please enter the number of milliseconds to keep Network Comms Center operating for new messages: ");
    int durationForArriving = keyboard.nextInt();

    // call operateNetworkCommsCenter for ncc w/ durationForArriving as param
    ncc.operateNetworkCommsCenter(durationForArriving);

    // request output file name
    System.out.println("Please enter the name of the output file for Network Comms Center results: ");
    String outName = keyboard.next();

    // call generateNetworkCommsCenterResults for ncc create w/ output file name as param
    try
    {
      ncc.generateNetworkCommsCenterResults(outName);
    }

    catch(Exception e)
    {
      System.out.println("An error has occured.");
      System.out.println(e);
    }

    keyboard.close();
  }
}