import java.util.*;

class PrioQueue<ContentType>{

  ArrayList<ContentType> sorted = new ArrayList<ContentType>();
  ArrayList<ContentType> queueList = new ArrayList<ContentType>();
      
  public void enqueue(ContentType e){
    queueList.add(e);                           // add a new number in unsorted queue
    sortQueue(queueList);                       // sort that queue and place it in sorted arraylist 
  }     
  
  private void sortQueue(ArrayList<ContentType> list){
    int index = list.size();
    for (int i = 1; i<index; i++){
      if (list.get(index).toString().compareTo(list.get(0).toString()) > 0){
        list.add(index, list.get(0));
        list.remove(0);
      }
    } 
  }
    
  public Integer getSizeQueue(){
    return queueList.size();           // get the size of queue as Integer
  }                                                              
      
  public ContentType getFirstObject(){
    return queueList.get(0);          // get the first object in queue as ContentObject
  }
    
  public ContentType getLastObject(){
    return queueList.get(queueList.size());     //get the last object in queue as ContentObject
  }
    
  public Integer getPlaceInQueue(ContentType e){
    return queueList.indexOf(e);               //search a specific place in queue of an object by getting an int of its position
  }
    
  public void dequeue(){
    queueList.remove(0);  
  }
}
