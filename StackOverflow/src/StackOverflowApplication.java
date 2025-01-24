import java.util.List;

import model.Answer;
import model.Question;
import model.StackOverflow;
import model.Tag;
import model.User;

class StackOverflowApplication {

	public static void main(String[] args) {

		StackOverflow stackOverflow = StackOverflow.getInstance();

		User rohith = stackOverflow.createUser("Rohith");
		User moulika = stackOverflow.createUser("Moulika");
		User bava = stackOverflow.createUser("Dora Babu");

		Question question1 = stackOverflow.askQuestion("What is java?", "I need to know about Java", rohith);
		question1.addTag(new Tag("programming"));
		question1.addTag(new Tag("coding"));
		Answer answer1 = stackOverflow.answerQuestion("Java is famous programming language", question1, moulika);
		stackOverflow.addVote(answer1, 1, rohith);
		stackOverflow.makeComment(answer1, "Thank you somuch for your answer", rohith);
		stackOverflow.makeComment(answer1, "Thank you somuch for your answer", rohith);

		System.out.println(rohith.getReputationScore());
		System.out.println(moulika.getReputationScore());
		System.out.println(bava.getReputationScore());

		Answer answer2 = stackOverflow.answerQuestion("Java provides numerours feature to develop web applications",
				question1, bava);
		stackOverflow.addVote(answer1, 1, bava);

		System.out.println(rohith.getReputationScore());
		System.out.println(moulika.getReputationScore());
		System.out.println(bava.getReputationScore());

		System.out.println(moulika.toString());
		System.out.println(rohith.toString());
		System.out.println(bava.toString());

		Question question2 = stackOverflow.askQuestion("What is LLD?", "I need to know about LLD", rohith);
		question2.addTag(new Tag("design"));
		question2.addTag(new Tag("oops"));

		List<Question> questions = stackOverflow.searchQuestion("coding");
		System.out.println(questions);
		questions = stackOverflow.searchQuestion("oops");
		System.out.println(questions);
		questions = stackOverflow.searchQuestion("oijoij");
		System.out.println(questions);
		questions = stackOverflow.searchQuestion("need");
		System.out.println(questions);
		questions = stackOverflow.searchQuestion("what");
		System.out.println(questions);
		
		
		System.out.println(question1.getAnswers());
		System.out.println(question1.getComments());
		System.out.println(question1.getVotes());
		
		System.out.println(answer1.getComments());
		System.out.println(answer1.getVotes());

	}

}