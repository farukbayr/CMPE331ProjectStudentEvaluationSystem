
public class Teacher {
	int grades;
	String status,recommendations;
	public Teacher(int grades,String status,String recommendations){
		this.grades = grades;
		this.recommendations = recommendations;
		this.status = status;
	}
	public int getGrades() {
		return grades;
	}
	public void setGrades(int grades) {
		this.grades = grades;
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
	

}

