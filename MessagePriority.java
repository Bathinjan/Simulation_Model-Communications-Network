import java.util.*;

class MessagePriority implements Comparator<Message>
{
  public int compare(Message a, Message b)
  {
    // if the messages have the same class
    if (a instanceof SmallMessage && b instanceof SmallMessage)
    {
      // compare priorities 
      if (a.getPriority() == b.getPriority())
      {
        // return difference of messageCreationTime
        return (a.getMessageCreationTime() - b.getMessageCreationTime());
      }

      else
      {
        // return diff of priorities
        return (a.getPriority() - b.getPriority());
      }
    }

    else if (a instanceof MediumMessage && b instanceof MediumMessage)
    {
      // compare priorities 
      if (a.getPriority() == b.getPriority())
      {
        // return difference of messageCreationTime
        return (a.getMessageCreationTime() - b.getMessageCreationTime());
      }

      else
      {
        // return diff of priorities
        return (a.getPriority() - b.getPriority());
      }
    }

    else if (a instanceof LargeMessage && b instanceof LargeMessage)
    {
      // compare priorities 
      if (a.getPriority() == b.getPriority())
      {
        // return difference of messageCreationTime
        return (a.getMessageCreationTime() - b.getMessageCreationTime());
      }

      else
      {
        // return diff of priorities
        return (a.getPriority() - b.getPriority());
      }
    }

    else
    {
      // return negative value of compareTo for a and b's message
      return ( a.getMessageLength().compareTo(b.getMessageLength()) * -1);
    }
  }
}