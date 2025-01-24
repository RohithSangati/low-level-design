package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Question implements Votable, Commentable {

	private final int id;

	private final String title;

	private final String content;

	private final User author;

	private final Date creationDate;

	private List<Tag> tags;

	private List<Answer> answers;

	private List<Comment> comments;

	private List<Vote> votes;

	Question(String title, String content, User author) {
		this.id = generateId();
		this.title = title;
		this.content = content;
		this.author = author;
		this.creationDate = new Date();
		tags = new ArrayList<>();
		answers = new ArrayList<>();
		comments = new ArrayList<>();
		votes = new ArrayList<>();
		System.out.println("Successfully created question");
	}

	private int generateId() {
		return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
	}

	public void addAnswer(Answer answer) {
		if (this.answers.contains(answer)) {
			System.out.println("Same answer already added for this question");
			return;
		}
		System.out.println("Successfully added answer");
		this.answers.add(answer);
	}

	public void addComment(Comment comment) {
		this.comments.add(comment);
		System.out.println("Comment successfully added to the question");
	}

	@Override
	public List<Comment> getComments() {
		return this.comments;
	}

	@Override
	public void addVote(Vote vote) {
		if (vote.getValue() != -1 && vote.getValue() != 1) {
			throw new IllegalArgumentException("Vote value should be either 1 or -1");
		}
		this.votes.add(vote);
		this.author.setReputationScore((vote.getValue() * 5) + this.author.getReputationScore());
		System.out.println("Successfully added vote and reputation is updated");
	}

	@Override
	public int getVoteCount() {
		int totalCount = 0;
		for (Vote vote : this.votes) {
			totalCount = vote.getValue();
		}
		return totalCount;
	}

	@Override
	public List<Vote> getVotes() {
		return this.votes;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public User getAuthor() {
		return author;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void addTag(Tag tag) {
		this.tags.add(tag);
		System.out.println("Succesfully added tag to the question");
	}

	public List<Tag> getTags() {
		return tags;
	}

	public List<Answer> getAnswers() {
		return answers;
	}
	
}
