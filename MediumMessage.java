class MediumMessage extends Message
{
  // --- Instance variables --- 
  private String messageLength;

  // --- Constructors ---
  public MediumMessage(int arrivalTime)
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
    messageLength = "Medium";
  }

  // --- Other Methods ---
  // didn't end up using this
  public String toString()
  {
    // format:
    // The Medium length message with priority 11 with ID Message 33 waited 6 milliseconds to be transmitted
    return "";
  }
}