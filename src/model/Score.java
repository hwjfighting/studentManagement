package model;

public class Score {
	private int id;
	private int student_id;
	private String student_name;
	private int course_id;
	private String course_name;
	private int score;
	private int highestScore;
	private int lowestScore;
	private double avgScore;
	private int num;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getHighestScore() {
		return highestScore;
	}
	public void setHighestScore(int highestScore) {
		this.highestScore = highestScore;
	}
	public int getLowestScore() {
		return lowestScore;
	}
	public void setLowestScore(int lowestScore) {
		this.lowestScore = lowestScore;
	}
	public double getAvgScore() {
		return avgScore;
	}
	public void setAvgScore(double avgScore) {
		this.avgScore = avgScore;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

}
