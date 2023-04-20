class SmallMessage extends Message
{
  // --- Instance variables --- 
  private String messageLength;

  // --- Constructors ---
  public SmallMessage(int arrivalTime)
  {
    // calls super() with arrivalTime
    super(arrivalTime);

    // calls setMessageLength with no params
    setMessageLength();
  }

  // --- Getters ---
  @Override
  public String getMessageLength()
  {
    // returns messageLength()
    return messageLength;
  }

  // --- Setters ---
  public void setMessageLength()
  {
    // sets messageLength to "small"
    messageLength = "Small";
  }

  // --- Other Methods ---
  // didn't end up using this
  public String toString()
  {
    // format:
    // The Small length message with priority 9 with ID Message 53 waited 6 milliseconds to be transmitted
    return "";
  }
}