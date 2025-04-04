package Assignment_3.Cricket_MinRuns;

public class Bowler{
	String name;
	int balls;
	Bowler(String name,int balls){
		this.name=name;
		this.balls=balls;
	}
	 public String getBowlerName() {
		  return this.name;
		 }
			
		 public void SetTaskName(String s) {
		  this.name=name;
		 }
			
		 public int balls() {
		  return this.balls;
		 }
			
		 public void setballs(int balls) {
		  this.balls=balls;
		 }
			
		 public String toString() {
		  return String.format("(Bowler %s,Balls:%d)", name,balls);
		 }
}
