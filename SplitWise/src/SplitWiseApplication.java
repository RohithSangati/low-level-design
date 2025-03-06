import model.Group;
import model.SplitType;
import model.SplitWiseService;
import model.User;

public class SplitWiseApplication {

	public static void main(String[] args) {

		SplitWiseService splitWiseServive = SplitWiseService.getInstance();

		User rohith = splitWiseServive.addUser("Rohith", "rohit.s@darwinbox.io");
		User moulika = splitWiseServive.addUser("Moulika", "moulika.s@coforge.io");
		User doraBabu = splitWiseServive.addUser("Dora Babu", "dorababu.k@cognizant.io");

		Group group1 = splitWiseServive.addGroup("Marraige Party");

		group1.addMember(rohith);
		group1.addMember(moulika);
		group1.addMember(doraBabu);

		splitWiseServive.printBalanceSheet(rohith);

		splitWiseServive.addExpenseToGroup(group1, 1003, SplitType.PERCENTAGE, rohith);

		splitWiseServive.printBalanceSheet(rohith);

		Group group2 = splitWiseServive.addGroup("Marraige Part2");

		group2.addMember(rohith);
		group2.addMember(moulika);
		group2.addMember(doraBabu);
		

		splitWiseServive.addExpenseToGroup(group1, 1003, SplitType.EQUAL, rohith);
		
		splitWiseServive.printBalanceSheet(rohith);
		
		Group group3 = splitWiseServive.addGroup("Marraige Part3");

		group2.addMember(rohith);
		group2.addMember(moulika);
		group2.addMember(doraBabu);
		

		splitWiseServive.addExpenseToGroup(group1, 1003, SplitType.AMOUNT, rohith);
		
		splitWiseServive.printBalanceSheet(rohith);
		
		splitWiseServive.settleAmount(doraBabu,rohith);
		
		splitWiseServive.printBalanceSheet(rohith);

	}
}