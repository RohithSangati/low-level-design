package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StackOverflow {

	private Map<Integer, User> users;
	private Map<Integer, Question> questions;
	private Map<Integer, Answer> answers;
	private Map<Integer, Tag> tags;
	private static StackOverflow stackOverflowInstance;

	private StackOverflow() {
		this.users = new HashMap<>();
		this.questions = new HashMap<>();
		this.answers = new HashMap<>();
		this.tags = new HashMap<>();
	}
	
	public static StackOverflow getInstance() {
		if(stackOverflowInstance == null) {
			synchronized (StackOverflow.class) {
				stackOverflowInstance = new StackOverflow();
			}
		}
		return stackOverflowInstance;
	}

	public User createUser(String name) {
		User user = new User(name);
		this.users.put(user.getId(), user);
		return user;
	}

	public Question askQuestion(String title, String content, User user) {
		Question question = user.askQuestion(title, content);
		this.questions.put(question.getId(), question);
		return question;
	}

	public Answer answerQuestion(String content, Question question, User user) {
		Answer answer = user.answerQuestion(content, question);
		this.answers.put(answer.getId(), answer);
		return answer;
	}

	public Map<Integer, User> getUsers() {
		return users;
	}

	public Map<Integer, Question> getQuestions() {
		return questions;
	}

	public Map<Integer, Answer> getAnswers() {
		return answers;
	}

	public Map<Integer, Tag> getTags() {
		return tags;
	}

	public Comment makeComment(Commentable commentable, String content, User user) {
		return user.makeComment(commentable, content);
	}

	public void addVote(Votable votable, int value, User user) {
		Vote vote = new Vote(user, value);
		votable.addVote(vote);
	}

	public List<Question> searchQuestion(String term) {
		List<Question> matchedQuestions = new ArrayList<>();
		for (Question question : questions.values()) {
			boolean isMatched = false;
			List<Tag> tags = question.getTags();
			for (Tag tag : tags) {
				if (tag.getName().contains(term)) {
					isMatched = true;
					break;
				}
			}
			if (!isMatched && (question.getTitle().toLowerCase().contains(term)
					|| question.getContent().toLowerCase().contains(term))) {
				isMatched = true;
			}
			if (isMatched) {
				matchedQuestions.add(question);
			}
		}
		return matchedQuestions;
	}

}
