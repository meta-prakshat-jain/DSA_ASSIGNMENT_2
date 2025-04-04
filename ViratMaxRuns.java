package Assignment_3.Cricket_MinRuns;

import java.util.Scanner;

class PriorityQueueForBowler {
	 //array size
	 private final int SIZE=100;
	 
	 //Array To Store Data
	 private Bowler data[];
	 
	 //Count the elements
	 private int count;
	 
	 public PriorityQueueForBowler() {
		  this.data=new Bowler[SIZE];
		  this.count=0;
		 }
	 
	 /**
	  * Function to add new element into the Priority QUeue
	  * 
	  * Stored into Array as Ascending order  
	  * list of tasks with order of prioritirs:0,1,2,3 ascending order  
	  * COmplexity:  
	  * O(N) or O(1) if array is empty  
	  *  @param task  
	  */
	 
	 public void enque(Bowler bowler) {
		  if(this.isFull()) {
			   grow();
	}
		  //Insertion
		  //Empty priority queue store it on first index
		  int idx=0;
		  
		//SHift elements have more priority towards 1 step right
		  for(idx=count-1;idx>=0&&data[idx].balls()>bowler.balls();idx--) {
		   data[idx+1]=data[idx];
		  }
		  
		  //fill the hole to store new task
		  data[idx+1]=bowler;
		  count++;
		 }
	 
	 /**  
	  * Remove the front element and return it  
	  *    
	  *  We are maintaining ascending order priority  
	  * So we Deque last element from the priority queue    
	  *  O(1) ALways   
	  * @return front element 
	   */
	 
	 public Bowler dequeue() {
		  if(this.isEmpty()) {
		   System.out.println("THis Priority Queue is EMpty");
		   return null;
		  }
		  Bowler bowler=this.data[this.count-1];
		  count--;
		  return bowler;
		 }
	 
	 /**
	  * Function to check the number of elements in Priority Queue
	  * 
	  * @return number of elements
	  */
	 public int size() {
	  return count;
	 }
	 
	 /**
	  * Check if the Priority Queue is Empty
	  * 
	  * @return indicate queue is empty
	  */
	 public boolean isEmpty() {
	  return count==0;
	 }
	 
	 /**
	  * Check that queue is FUll
	  * @return indicate queue is FUll
	  */
	 public boolean isFull() {
	  return count==this.data.length;
	 }
	 
	 /**  * Increase the size of underlying array to accommodate more  
	  	  * elements whenever it is full  
	  	*/
	 
	 public void grow() {
		// new Array with double capacity
		 Bowler tmp[]=new Bowler[count*2];
		//Copy elemnts  
		 for(int i=0;i<count;i++) {
			 tmp[i]=data[i];
		 }
		 data=tmp;
	 }
	 /**
	  * Print the Priority Queue
	  */
	 
	 public void print() {
		  if(this.isEmpty()) {
		   System.out.println("THis Priority Queue is EMpty");
		   return;
		  }
		  System.out.printf("[%s",this.data[0]);
		  
		  for(int i=1;i<count ;i++) {
		   System.out.printf(",%s",data[i].toString());
		  }
		  System.out.println("]");
		 }

		}


public class ViratMaxRuns {
	int ballsPlayedbyKohli;
	PriorityQueueForBowler bowlerquota;
	public ViratMaxRuns(PriorityQueueForBowler bowlerquota,int ballsPlayedbyKohli) {
		// TODO Auto-generated constructor stub
		this.ballsPlayedbyKohli=ballsPlayedbyKohli;
		this.bowlerquota=bowlerquota;
	}
	public void printBallSquence() {
		bowlerquota.print();
		if(bowlerquota.isEmpty()) {
			throw new AssertionError("QUeue is EMpty or the bowlers balls quota is exausted");
		}
		while(ballsPlayedbyKohli>0) {
			
			Bowler a=bowlerquota.dequeue();
			System.out.println("Ball: "+ballsPlayedbyKohli+" -> "+a.name);
			a.balls=a.balls-1;
			bowlerquota.enque(a);
			ballsPlayedbyKohli--;
			
		}
		bowlerquota.print();
	}
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		PriorityQueueForBowler PriorityQueueForBowlerData=new PriorityQueueForBowler();
		System.out.println("Captain COOL Choose Your number of bowler ");
		int numOfBowler=sc.nextInt();
		for(int i=0;i<numOfBowler;i++) {
			if(i==0) sc.nextLine();
			System.out.println("Enter the Name of the bowler");
			String bowlerName2=sc.nextLine();
			System.out.println("Enter the bowls quota of the bowler");
			int bowlerballs=sc.nextInt();
			sc.nextLine();
			Bowler b1=new Bowler(bowlerName2, bowlerballs);
			PriorityQueueForBowlerData.enque(b1);
		}
		PriorityQueueForBowlerData.print();
		
		System.out.println("Enter Number of Bowls virat is goinf to play");
		int ballsPlayed=sc.nextInt();
		ViratMaxRuns viratRuns=new ViratMaxRuns(PriorityQueueForBowlerData,ballsPlayed);
		viratRuns.printBallSquence();
		

//		Bowler b1=new Bowler("Bumrah", 7);
//		Bowler b2=new Bowler("DHoni", 5);
//		
//		
//		PriorityQueueForBowlerData.enque(b1);
//		PriorityQueueForBowlerData.enque(b2);
//		ViratMaxRuns vx=new ViratMaxRuns(PriorityQueueForBowlerData,5);
//		vx.printBallSquence();

		
		

	}

}
