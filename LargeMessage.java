class LargeMessage extends Message
{
  // --- Instance variables --- 
  private String messageLength;

  // --- Constructors ---
  public LargeMessage(int arrivalTime)
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
    // sets messageLength to "Medium"
    messageLength = "Large";
  }

  // --- Other Methods ---
  // didn't end up using this
  public String toString()
  {
    // format:
    // The Average length message with priority 11 with ID Message 33 waited 6 milliseconds to be transmitted
    return "";
  }
}