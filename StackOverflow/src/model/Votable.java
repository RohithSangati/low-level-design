package model;

import java.util.List;

public interface Votable {

	void addVote(Vote vote);

	int getVoteCount();

	List<Vote> getVotes();

}
