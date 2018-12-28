// Assignment #: 10
//         Name: Derek Pezzella
//    StudentID:	
//  Lab Lecture: TTh 4:30-5:45
//  Description: 

// A linked list is a sequence of nodes with efficient
// element insertion and removal.
// This class contains a subset of the methods of the
// standard java.util.LinkedList class.

import java.util.NoSuchElementException;

public class LinkedList
{
   //nested class to represent a node
   private class Node
   {
          public Object data;
          public Node next;
   }

   //only instance variable that points to the first node.
   private Node first;

   // Constructs an empty linked list.
   public LinkedList()
   {
      first = null;
   }

   // Returns the first element in the linked list.
   public Object getFirst()
   {
      if (first == null)
       {
         NoSuchElementException ex
             = new NoSuchElementException();
         throw ex;
       }
      else
         return first.data;
   }

   // Removes the first element in the linked list.
   public Object removeFirst()
   {
      if (first == null)
       {
         NoSuchElementException ex = new NoSuchElementException();
         throw ex;
       }
      else
       {
         Object element = first.data;
         first = first.next;  //change the reference since it's removed.
         return element;
       }
   }

   // Adds an element to the front of the linked list.
   public void addFirst(Object element)
   {
      //create a new node
      Node newNode = new Node();
      newNode.data = element;
      newNode.next = first;
      //change the first reference to the new node.
      first = newNode;
   }

   // Returns an iterator for iterating through this list.
   public ListIterator listIterator()
   {
      return new LinkedListIterator();
   }


   /*********************************************************
   Add your methods here
   *********************************************************/
   public String toString() {
	   String result = "{ ";
	   ListIterator iter = listIterator();

	   if(!iter.hasNext()) {
		   result = "{ }";
	   } else {
	  	 while(iter.hasNext()) {
		   	result += iter.next() + " "; 
		 }
	   }

	   result += "}";

	   return result;
   }

   public int size() {
	ListIterator iter = listIterator();
	int numElements = 0;

	if(!iter.hasNext()) {
		numElements = 0;
	} else {		
		while(iter.hasNext()) {
			numElements++;
			iter.next(); //it returns stuff or nah?
		}
	}

	return numElements;
   }

   public void addElement(Object element) {
	//initialize iterator to go through elements
	ListIterator iter = listIterator();

	char elemChar = ((String)element).charAt(0);
	byte elemByte = (byte)elemChar;
	byte nextByte = 0;

	Object next = null;
	
	if(!iter.hasNext()) {
		//first element added to the linked list
		iter.add(element);
	} else {
		//not the first element added
		//first, sort through the linked list to find the first characters of each item in the linked list
		//and compare to the element variable. once it hits a next element that has an character with 
		//a larger ASCII code, stop the iterator, rewind it one, then use the add method to insert it.
		while(iter.hasNext()) {
			//potential problem: when I set the iterator to the first character, the goes through the whole list again...
			next = iter.next();
			nextByte = (byte)((String)next).charAt(0);

			if(elemByte > nextByte) {
				//iter.set(next);
				System.out.println("Iterator set to " + next);

				iter.add(element);
			}

			if(iter.hasNext()) {
				//does it have a next item in the list? if so, advance the linked list iterator
				iter.next();
			}
		}

		//now, use the set method to set the iterator 
	}

   }

   public void removeElementsAtOddIndices() {
	   ListIterator iter = listIterator();

	   int i = 0;
	   Object next = null;

	   //going to have to move each element down one after deleting element
	   //make sure to use the set method to uhh maybe?
	   while(!iter.hasNext()) {
		   next = iter.next();

		   if(i%2 != 0) {
			   iter.remove();
		   }

		   iter.next();
		   i++;
	   }


   }

   public void removeAdditionalOccurrences(Object element) {
	   ListIterator iter = listIterator();

	   element = (String)element;

	   Object next = null;

	   while(!iter.hasNext()) {
		   next = iter.next();

		   //downcast the next Object to a String so we can use its methods
		   next = (String)next;

		   if(((String)element).equals(next)) {
			   iter.remove();
		   }

		   iter.next();
	   }

   }

   public Object searchByIndex(int index) {
	   ListIterator iter = listIterator();
	   Object obj = null;


	   return obj;
   }

   public void searchAndIncrease(Object element, int howMany) {
	   ListIterator iter = listIterator();
   }

   //nested class to define its iterator
   private class LinkedListIterator implements ListIterator
   {
      private Node position; //current position
      private Node previous; //it is used for remove() method

      // Constructs an iterator that points to the front
      // of the linked list.

      public LinkedListIterator()
      {
         position = null;
         previous = null;
      }

     // Tests if there is an element after the iterator position.
     public boolean hasNext()
      {
         if (position == null) //not traversed yet
          {
             if (first != null)
                return true;
             else
                return false;
          }
         else
           {
              if (position.next != null)
                 return true;
              else
                 return false;
           }
      }

      // Moves the iterator past the next element, and returns
      // the traversed element's data.
      public Object next()
      {
         if (!hasNext())
          {
           NoSuchElementException ex = new NoSuchElementException();
           throw ex;
          }
         else
          {
            previous = position; // Remember for remove

            if (position == null)
               position = first;
            else
               position = position.next;

            return position.data;
          }
      }

      // Adds an element after the iterator position
      // and moves the iterator past the inserted element.
      public void add(Object element)
      {
         if (position == null) //never traversed yet
         {
            addFirst(element);
            position = first;
         }
         else
         {
            //making a new node to add
            Node newNode = new Node();
            newNode.data = element;
            newNode.next = position.next;
            //change the link to insert the new node
            position.next = newNode;
            //move the position forward to the new node
            position = newNode;
         }
         //this means that we cannot call remove() right after add()
         previous = position;
      }

      // Removes the last traversed element. This method may
      // only be called after a call to the next() method.
      public void remove()
      {
         if (previous == position)  //not after next() is called
          {
            IllegalStateException ex = new IllegalStateException();
            throw ex;
          }
         else
          {
           if (position == first)
            {
              removeFirst();
            }
           else
            {
              previous.next = position.next; //removing
            }
           //stepping back
           //this also means that remove() cannot be called twice in a row.
           position = previous;
      	}
      }

      // Sets the last traversed element to a different value.
      public void set(Object element)
      {
         if (position == null)
          {
            NoSuchElementException ex = new NoSuchElementException();
            throw ex;
          }
         else
          position.data = element;
      }
   } //end of LinkedListIterator class
} //end of LinkedList class
