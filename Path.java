class Path
{
  // --- Instance variables --- 
  private static int pathIDCounter = 0;
  private int pathIDNumber;
  private int totalMessagesProcessedByPath;
  private int timeRemainingForCurrentTransmission;
  private Message assignedMessage;

  // --- Constructors ---
  public Path()
  {
    // calls setPathIDNumber with no params
    setPathIDNumber();
  }

  // --- Getters ---
  public int getPathIDCounter()
  {
    return pathIDCounter;
  }

  public int getPathIDNumber()
  {
    return pathIDNumber;
  }

  public int getTotalMessagesProcessedByPath()
  {
    return totalMessagesProcessedByPath;
  }

  public int getTimeRemainingForCurrentTransmission()
  {
    return timeRemainingForCurrentTransmission;
  }

  public Message getAssignedMessage()
  {
    return assignedMessage;
  }

  // --- Setters ---
  public void setPathIDCounter(int pathIDCounter)
  {
    this.pathIDCounter = pathIDCounter;
  } 

  public void setPathIDNumber()
  {
    // increments pathIDCounter by one
    pathIDCounter ++;
    // sets pathIDNumber = pathIDNumberCounter
    pathIDNumber = pathIDCounter;
  }

  public void setTotalMessagesProcessedByPath(int totalMessagesProcessedByPath)
  {
    this.totalMessagesProcessedByPath = totalMessagesProcessedByPath;
  }

  public void setTimeRemainingForCurrentTransmission(int timeRemainingForCurrentTransmission)
  {
    // set to value of  param
    this.timeRemainingForCurrentTransmission = timeRemainingForCurrentTransmission;
  }

  public void setAssignedMessage(Message message)
  {
    assignedMessage = message;
  }

  // --- Other Methods ---
  
  public Message removeAssignedMessage()
  {
    // create temporary message ref = assignedMessage ref
    Message tempMessage = assignedMessage;
    // set assignedMessage to null
    assignedMessage = null;
    // increment totalMessagesProcessedByPath by 1 // might need setter here
    totalMessagesProcessedByPath++;
    // return value of tempMessage ref
    return tempMessage;
  }

  public void decrementTimeRemainingForCurrentTransmission()
  {
    // decrement by 1
    timeRemainingForCurrentTransmission--;
  }

  // didn't end up using this
  public String toString()
  {
    // format:
    // Path 7 processed 12 messages
    return "";
  }
  
}