package BattleCity;

public class Score {
	
	public String name;
	public int score;

	public Score(String name, int score) {
		this.score = score;
		this.name = name;
	}


	@Override
	public String toString() {
		if (name == null)
			return super.toString();
		else
			return String.format("%s \t \t \t \t \t \t \t \t \t \t \t \t \t \t \t %d", this.name, this.score);
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	
}