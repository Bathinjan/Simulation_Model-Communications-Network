import java.util.*;

abstract class Message
{
  // --- Instance variables --- 
  static int messageIDCounter = 0; // doesn't make sense to make this private based on specifications
  private int priority;
  private int messageCreationTime;
  private int startTransmitTime;
  private int transmissionDuration;
  private int waitTime;
  private int totalTime;

  private String messageID;
  private Path messagePath;
  private static Random randy = new Random(5);

  // --- Constructors ---
  public Message(int messageCreationTime)
  {
    setPriority();
    setMessageIDCounter();
    setMessageCreationTime(messageCreationTime);
  }

  // --- Getters ---
  public int getMessageIDCounter()
  {
    return messageIDCounter;
  }

  public int getPriority()
  {
    return priority;
  }

  public int getMessageCreationTime()
  {
    return messageCreationTime;
  }

  public int getStartTransmitTime()
  {
    return startTransmitTime;
  }

  public int getTransmissionDuration()
  {
    return transmissionDuration;
  }

  public int getWaitTime()
  {
    return waitTime;
  }

  public int getTotalTime()
  {
    return totalTime;
  }

  public String getMessageID()
  {
    return messageID;
  }

  public int getPathIDNumber()
  {
    // return PathIDNumber for the Path that this message is assigned to, as int
    return messagePath.getPathIDNumber();
  }

  public Path getMessagePath()
  {
    return messagePath;
  }
  
  // --- Setters ---
  
  public void setMessageIDCounter()
  {
    // increments messageIDCounter by 1
    messageIDCounter++;
    // sets messageID to concatenation of "message" and messageIDCounter
    messageID = "Message " + messageIDCounter;
  }

  public void setPriority() // no params, void return
  {
    // sets priority to random number b/w 1-50 (incl)
    this.priority = randy.nextInt(1,51);
  }

  public void setMessageCreationTime(int messageCreationTime)
  {
    // uses into parameter to set messageCreationTime
    this.messageCreationTime = messageCreationTime;
  }

  public void setStartTransmitTime(int time)
  {
    // uses param to set startTransmitTime
    startTransmitTime = time;
    // sets waitTime as difference b/w startTransmitTime and messageCreationTime
    waitTime = getStartTransmitTime() - getMessageCreationTime();
  }

  public void setTransmissionDuration(int transmissionDuration)
  {
    // sets transmissionDuration to param's value
    this.transmissionDuration = transmissionDuration;
  }

  public void setTotalTime(int endTransmissionTime)
  {
    // sets totalTime to diff b/w endTransmissionTime and messageCreationTime
    totalTime = endTransmissionTime - getMessageCreationTime();
  }

  public void setMessagePath(Path path)
  {
    // sets messagePath to the reference in parameter
    messagePath = path;
  }

  // --- Abstract Methods ---

  // no params, void return
  abstract void setMessageLength();
  // no params, returns string
  abstract String getMessageLength();
}