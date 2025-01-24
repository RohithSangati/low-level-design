package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Answer implements Votable, Commentable {

	private final int id;
	private final String content;
	private final User authour;
	private final Date creationDate;
	private final Question question;
	private List<Vote> votes;
	private List<Comment> comments;
	private boolean isAccepted;

	Answer(String content, User user, Question question) {
		this.id = generateId();
		this.content = content;
		this.authour = user;
		this.creationDate = new Date();
		this.question = question;
		votes = new ArrayList<>();
		comments = new ArrayList<>();
		this.isAccepted = false;
		System.out.println("Successfully created answer");
		question.addAnswer(this);
	}

	public int getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public User getAuthour() {
		return authour;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public Question getQuestion() {
		return question;
	}

	public boolean isAccepted() {
		return isAccepted;
	}

	private int generateId() {
		return (int) (System.currentTimeMillis() & Integer.MAX_VALUE);
	}

	@Override
	public void addComment(Comment comment) {
		this.comments.add(comment);
		System.out.println("Comment successfully added to the answer");
	}

	@Override
	public List<Comment> getComments() {
		return this.comments;
	}

	@Override
	public void addVote(Vote vote) {
		if (vote.getValue() != -1 && vote.getValue() != 1) {
			throw new IllegalArgumentException("Vote must be either either 1 or -1");
		}
		this.votes.add(vote);
		this.authour.setReputationScore((vote.getValue() * 5) + this.authour.getReputationScore());
		System.out.println("Successfully added vote and reputation score is updated");
	}

	public void markAsAccepted() {
		if (!this.isAccepted) {
			this.isAccepted = true;
			this.authour.setReputationScore(10 + this.authour.getReputationScore());
			System.out.println("Successfully marked answer as accepted");
			return;
		}
		System.out.println("Successfully marked question as accepted");
	}

	@Override
	public int getVoteCount() {
		int totalCount = 0;
		for (Vote vote : this.votes) {
			totalCount += vote.getValue();
		}
		return totalCount;
	}

	@Override
	public List<Vote> getVotes() {
		return this.votes;
	}

}
