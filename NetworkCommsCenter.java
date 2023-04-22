import java.util.*;
import java.io.*;

class NetworkCommsCenter
{
  // --- Instance Variables ---
  private Random randyX = new Random();
  
  private PriorityQueue<Message> msgWaitingQ;
  private ArrayList<Path> pathAvailableList = new ArrayList<>();
  private ArrayList<Path> pathBusyList = new ArrayList<>();
  private ArrayList<Message> processedMessages = new ArrayList<>();

  private String commCenterName;
  private int currentTime = 0;

  // --- Constructors ---
  public NetworkCommsCenter(String name, int seed)
  {
    // set commCenterName to name
    commCenterName = name;
    // create msgWaitingQ using instance of MessagePriority as param
    // also initialize with size 1 as param (current compiler complains if not)
    msgWaitingQ = new PriorityQueue<Message>(1, new MessagePriority());
    // create randyX object based on seed
    randyX = new Random(seed);
  }

  // --- Methods ---
  public void initializeNetworkCommsCenter(int numPaths)
  {
    // For each path in numPaths
    for(int i = 0; i < numPaths; i++)
    {
      // create a new Path and add the path to the pathAvailableList ArrayList
      pathAvailableList.add(new Path());
    }

    // 15 times
    for(int j = 0; j < 15; j++)
    {
      // generate random int 1-10
      int randGen = randyX.nextInt(1, 11);

      // 20% of the time
      if (randGen == 1 || randGen == 2)
      {
        // add a new SmallMessage to msgWaitingQ w/ currentTime as param
        msgWaitingQ.add(new SmallMessage(currentTime));
      }

      // 30% of the time
      if (randGen == 3 || randGen == 4 || randGen == 5)
      {
        //  add new MediumMessage to msgWaitingQ w/ currentTime as param
        msgWaitingQ.add(new MediumMessage(currentTime));
      }

      // 50% of the time
      if (randGen == 6 || randGen == 7 || randGen == 8 || randGen == 9 || randGen == 10)
      {
        // add new LargeMessage to msgWaitingQ w/ currentTime as param
        msgWaitingQ.add(new LargeMessage(currentTime));
      }
    }

    // set currentTime to 1
    currentTime = 1;
  }

  public void operateNetworkCommsCenter(int durationForArrivingMessages)
  {
    // create int endArrivalsTime; set equal to sum of currentTime and durationForArrivingMessages
    int endArrivalsTime = currentTime + durationForArrivingMessages;

    // create other temp variables
    Message tempMessage;
    Path tempPath;

    // create int variable transmissionDuration
    int transmissionDuration;

    // while size of processedMessages =! Message.messageIDCounter
    // OR
    // currentTime < endArrivalsTime
    while (processedMessages.size() != Message.messageIDCounter || currentTime < endArrivalsTime)
    {
      // if currentTime < endArrivalsTime
      if (currentTime < endArrivalsTime)
      {
        // do 3 times
        for(int i = 0; i < 3; i++)
        {
          // Generate random 1-10
          int randGen = randyX.nextInt(1,11);

          // 20% of the time
          if (randGen == 1 || randGen == 2)
          {
            // add new smallMessage to msgWaitingQ w/ currentTime
            msgWaitingQ.add(new SmallMessage(currentTime));
          }

          // 30% of the time
          if (randGen == 3 || randGen == 4 || randGen == 5)
          {
            // add new mediumMessage to msgWaitingQ w/ currentTime
            msgWaitingQ.add(new MediumMessage(currentTime));
          }

          // 50% of the time
          if (randGen == 6 || randGen == 7 || randGen == 8  || randGen == 9 || randGen == 10)
          {
            // add new LargeMessage to msgWaitingQ w/ currentTime
            msgWaitingQ.add(new LargeMessage(currentTime));
          }
        }// end current loop
      }// end if

      // Check on busy Paths
      // for each Path from i = 0 to  i <  pathBusyList.size()
      for (int i = 0; i < pathBusyList.size(); i++)
      {
        // Set tempPath to the Path in pathBusyList
        tempPath = pathBusyList.get(i);

        // call decrementTimeRemainingForCurrentTransmission() for tempPath
        tempPath.decrementTimeRemainingForCurrentTransmission();

        // if tempPath.timeRemainingForCurrentTransmission() equals 0
        if (tempPath.getTimeRemainingForCurrentTransmission() == 0)
        {
          // retrieve ref to Message currently being processed by tempPath; set to tempMessage
          tempMessage = tempPath.getAssignedMessage();

          // add tempMessage to processedMessages aLIst
          processedMessages.add(tempMessage);

          // call setTotalTime for tempMessage with currentTime as param
          tempMessage.setTotalTime(currentTime);

          // call removedAssignedMessage() for tempPath
          tempPath.removeAssignedMessage();

          // remove the ith element from pathBusyList
          pathBusyList.remove(i);

          // add tempPath to the pathAvailableList
          pathAvailableList.add(tempPath);

          // decrement i by 1
          i--;
        }// end if
      }// end loop

      // Assign Messages to idle Paths
      // while pathAvailableList is NOT empty && msgWaitingQ also NOT empty
      while(pathAvailableList.size() > 0 && msgWaitingQ.size() > 0)
      {
        // remove a message from msgWaitingQ; set tempMessage
        tempMessage = msgWaitingQ.remove(); /// ***** COMPILES, BUT I SMALL DANGER

        // call setStartTransmitTime for tempMessage w/ currentTime
        tempMessage.setStartTransmitTime(currentTime);

        // remove first path (index 0) in pathAvailableList and set tempPath to it
        tempPath = pathAvailableList.remove(0);

        // add tempPath to pathBusyList
        pathBusyList.add(tempPath);

        // call setAssignedMessage for tempPath w/ tempMessage as param
        tempPath.setAssignedMessage(tempMessage);

        // call setMessagePath for tempMessage with tempPath as param
        tempMessage.setMessagePath(tempPath);

        // generate random value as follows
        if (tempMessage instanceof SmallMessage)
        {
          // set transmissionDuration to int b/w 1 and 3
          transmissionDuration = randyX.nextInt(1,4);
        }

        else if (tempMessage instanceof MediumMessage)
        {
          // set transmissionDuration to int b/w 3 and 7
          transmissionDuration = randyX.nextInt(3, 8);
        }

        else
        {
          // set transmissionDuration to int b/w 7 and 11
          transmissionDuration = randyX.nextInt(7, 12);
        }

        // call setTransmissionDuration for tempMessage w/ transmissionDuration as param
        tempMessage.setTransmissionDuration(transmissionDuration);

        // call setTimeRemainingForCurrentTransmission for tempPath w/ transmissionDuration as param
        tempPath.setTimeRemainingForCurrentTransmission(transmissionDuration);
      } // end while loop

      // increment currentTime by 1
      currentTime++;
    } // end larger while loop
  }

  public void generateNetworkCommsCenterResults(String fileName) throws Exception
  {
    try
    {
      File file = new File(fileName);
      file.createNewFile();
  
      PrintWriter writer = new PrintWriter(file);
  
      writer.printf("Data for Network Comms Center: " + fileName + "\n\n");
      writer.printf("Summary Data By Path\n");
  
      // number of messages processed by each path
      for(Path p : pathAvailableList)
      {
        // Path 5 processed 30 messages
        writer.printf("Path %d processed %d messages\n", p.getPathIDNumber(), p.getTotalMessagesProcessedByPath());
      }

      writer.println(); // line break
  
      int smallMessageTotal = 0;
      int mediumMessageTotal = 0;
      int largeMessageTotal = 0;
      int totalMessages = 0;
  
      double smallTotalTime = 0;
      double mediumTotalTime = 0;
      double largeTotalTime = 0;
  
      double smallAverage = 0;
      double mediumAverage = 0;
      double largeAverage = 0;
      double totalAverage = 0;
  
  
      // I'm separating out these foreach loops because my brain is a coke slushie from Burger King left in the car for 15 days
      for (Message m : processedMessages)
      {
        if (m instanceof SmallMessage)
        {
          // increment smallMessageTotal
          smallMessageTotal++;
          // add SM time to total SM time
          smallTotalTime += m.getTotalTime();
          // increment total messages
        }
  
        else if(m instanceof MediumMessage)
        {
          // increment mediumMessageTotal
          mediumMessageTotal++;
          // add MD time to total SM time
          mediumTotalTime += m.getTotalTime();
        }
  
        else if(m instanceof LargeMessage)
        {
          // increment largeMessageTotal
          largeMessageTotal++;
          // add LG time to total SM time
          largeTotalTime += m.getTotalTime();
        }
  
        else{}
        totalMessages++;
      }
  
      // calculate averages
      smallAverage = (smallTotalTime / smallMessageTotal);
      mediumAverage = (mediumTotalTime / mediumMessageTotal);
      largeAverage = (largeTotalTime / largeMessageTotal);
      totalAverage = ( (smallTotalTime + mediumTotalTime + largeTotalTime)/totalMessages );
      
  
      writer.printf("The average total time for %d Small Messages is %.2f milliseconds\n", smallMessageTotal, smallAverage);
      writer.printf("The average total time for %d Medium Messages is %.2f milliseconds\n", mediumMessageTotal, mediumAverage);
      writer.printf("The average total time for %d Large Messages is %.2f milliseconds\n", largeMessageTotal, largeAverage);
      writer.printf("The average total time for %d Total Messages is %.2f milliseconds\n\n", totalMessages, totalAverage);
  
      // create an iterator on processedMessages arrayList
      Iterator<Message> iterator = processedMessages.iterator();
  
      writer.println("MESSAGE ID / PRIORITY / PATH ID / LENGTH / CREATION TIME / WAIT TIME / START TRANSMIT TIME / TRANS DURATION / TOTAL TIME");
  
      // iterate thru array
      // Formatting is pretty bad but I tried
      while(iterator.hasNext())
      {
        // MESSAGE ID / PRIORITY / PATH ID / LENGTH / CREATION TIME / WAIT TIME / START TRANSMIT TIME / TRANS DURATION / TOTAL TIME
        // M_STRING   / M_INT    / M_P_INT / M_STR  / M_INT         / M_INT     / M_INT               / M_INT          / M_INT 
        // s / d / d / s / d / d / d / d / d
        // I Tried Part 2 Electric Boogaloo
        Message m = iterator.next();
        writer.printf("%7s%7d%12d%12s%12d%12d%15d%18d%20d\n", 
        m.getMessageID(), m.getPriority(), m.getMessagePath().getPathIDNumber(), m.getMessageLength(), m.getMessageCreationTime(), m.getWaitTime(), m.getStartTransmitTime(), m.getTransmissionDuration(), m.getTotalTime());
      }
  
      writer.close();
    }
      
    catch (Exception e)
    {
      System.out.println("An I/O exception has occured.");
      System.out.println(e);
    }
  }
}
