package model;

import java.util.ArrayList;
import java.util.List;

public class User {

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", reputationScore=" + reputationScore + ", questions="
				+ questions + ", answers=" + answers + ", comments=" + comments + "]";
	}

	private final int id;
	private final String userName;
	private int reputationScore;
	private List<Question> questions;
	private List<Answer> answers;
	private List<Comment> comments;

	User(String userName) {
		this.id = this.generateId();
		this.userName = userName;
		this.reputationScore = 0;
		this.questions = new ArrayList<>();
		this.answers = new ArrayList<>();
		this.comments = new ArrayList<>();
	}

	public Question askQuestion(String title, String content) {
		Question question = new Question(title, content, this);
		this.addQuestion(question);
		this.setReputationScore(this.getReputationScore() + 5);
		return question;
	}

	public Answer answerQuestion(String content, Question question) {
		Answer answer = new Answer(content, this, question);
		this.addAnswer(answer);
		this.setReputationScore(this.getReputationScore() + 10);
		return answer;
	}

	public Comment makeComment(Commentable commentable, String content) {
		Comment comment = new Comment(content, this);
		commentable.addComment(comment);
		this.addComment(comment);
		this.setReputationScore(this.getReputationScore() + 5);
		return comment;
	}

	private void addComment(Comment comment) {
		this.comments.add(comment);
	}

	public void setReputationScore(int reputationScore) {
		this.reputationScore = reputationScore;
	}

	public int getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public int getReputationScore() {
		return reputationScore;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void addQuestion(Question question) {
		this.questions.add(question);
	}

	public void addAnswer(Answer answer) {
		this.answers.add(answer);
	}

	private int generateId() {
		return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
	}

}
