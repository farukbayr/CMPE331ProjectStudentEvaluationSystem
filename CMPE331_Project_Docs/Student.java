
public class Student {
	String fullName,status,recommendations;
	int value1,value2,value3;
	

	public Student(String fullName, String status, String recommendations, int value1,int value2,int value3) {
		super();
		this.fullName = fullName;
		this.status = status;
		this.recommendations = recommendations;
		this.value1 = value1;
		this.value2 = value2;
		this.value3 = value3;
		double average = (double)(value1 + value2 + value3)/(double)3;
		if(35>average && average>=0){
			this.status = "F";
		}
		else if(45>average && average>=35){
			this.status  = "D";
		}
		else if(60>average && average>=45){
			this.status  = "C";
		}
		else if(85>average && average>=60){
			this.status  = "B";
		}
		else{
			this.status = "A";
		}
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRecommendations() {
		return recommendations;
	}

	public void setRecommendations(String recommendations) {
		this.recommendations = recommendations;
	}

	public int getValue1() {
		return value1;
	}

	public void setValue1(int value1) {
		this.value1 = value1;
	}

	public int getValue2() {
		return value2;
	}

	public void setValue2(int value2) {
		this.value2 = value2;
	}

	public int getValue3() {
		return value3;
	}

	public void setValue3(int value3) {
		this.value3 = value3;
	}

	@Override
	public String toString() {
		return fullName + " \nStatus: " + status + "\nRecommendation:" + recommendations
				+ "\nGrade1=" + value1 + ", Grade2=" + value2 + ", Grades3=" + value3;
	}


}
