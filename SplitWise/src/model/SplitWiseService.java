package model;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SplitWiseService {

	private static SplitWiseService splitWiseService;
	private HashMap<String, User> usersMap;
	private HashMap<String, Group> groupsMap;
	private HashMap<String, Transaction> transactionsMap;
	private Scanner sc;

	private SplitWiseService() {
		usersMap = new HashMap<>();
		groupsMap = new HashMap<>();
		transactionsMap = new HashMap<>();
		sc = new Scanner(System.in);
	}

	public static SplitWiseService getInstance() {
		if (splitWiseService == null) {
			synchronized (SplitWiseService.class) {
				splitWiseService = new SplitWiseService();
			}
		}
		return splitWiseService;
	}

	private boolean isUserExists(String email) {
		for (User user : this.usersMap.values()) {
			if (user.getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}

	public User addUser(String name, String email) {
		if (isUserExists(email)) {
			System.out.println("User with same email already exists");
			return null;
		}
		User user = new User(name, email);
		this.usersMap.put(user.getUserId(), user);
		System.out.println("Successfully added user " + user.getName());
		return user;
	}

	public Group addGroup(String name) {
		Group group = new Group(name);
		this.groupsMap.put(group.getGroupId(), group);
		System.out.println("Successuflly added group " + group.getName());
		return group;
	}

	public void addMemberToGroup(Group group, User user) {
		group.addMember(user);
	}

	private Expense createExpense(double amount, SplitType splitType, User paidBy) {
		Expense expense = new Expense(amount, splitType, paidBy);
		System.out.println("Expense successfully created");
		return expense;
	}

	private String getBalanceKey(User user1, User user2) {
		return user1.getUserId() + ":" + user2.getUserId();
	}

	private void updateUserBalance(String balanceKey, double amount, User user) {
		user.setAmountSheet(balanceKey, user.getAmountSheet().getOrDefault(balanceKey, 0.0) + amount);
	}

	private HashMap<String, Split> makeSplits(Expense expense, HashMap<User, Double> userAmounts) {
		HashMap<String, Split> splits = new HashMap<>();
		for (User user : userAmounts.keySet()) {
			Split split;
			if (expense.getSplitType() == SplitType.PERCENTAGE) {
				split = new PercentageSplit(expense.getAmount(), userAmounts.get(user), user);
			} else {
				if (expense.getSplitType() == SplitType.EQUAL) {
					split = new EqualSplit(userAmounts.get(user), user);
				} else {
					split = new AmountSplit(userAmounts.get(user), user);
				}
			}
			splits.put(split.getSplitId(), split);
			String balanceKey1 = this.getBalanceKey(expense.getPaidBy(), user);
			updateUserBalance(balanceKey1, split.getAmount(), expense.getPaidBy());
			String balanceKey2 = this.getBalanceKey(user, expense.getPaidBy());
			updateUserBalance(balanceKey2, -split.getAmount(), user);
		}
		return splits;
	}

	private HashMap<String, Split> getSplits(Expense expense, List<User> users) {
		HashMap<User, Double> userAmounts = new HashMap<>();
		if (expense.getSplitType() == SplitType.EQUAL) {
			double amount = expense.getAmount() / users.size();
			for (User user : users) {
				if (user.equals(expense.getPaidBy()))
					continue;
				userAmounts.put(user, amount);
			}
		} else {
			while (true) {
				double total = 0;
				for (User user : users) {
					if (user.equals(expense.getPaidBy()))
						continue;
					System.out.println(
							"Enter " + (expense.getSplitType() == SplitType.PERCENTAGE ? "Percentage " : " Amount ")
									+ " for the user " + user.getName());
					double amountOrPercentage = sc.nextDouble();
					userAmounts.put(user, amountOrPercentage);
					total += amountOrPercentage;
				}
				if (expense.getSplitType() == SplitType.AMOUNT) {
					if (total > expense.getAmount()) {
						System.out.println("Total amount should be less than or equal to " + expense.getAmount());
					} else {
						break;
					}
				} else {
					if (total > 100) {
						System.out.println("Total amount should not be greater than 100");
					} else {
						break;
					}
				}
			}
		}
		HashMap<String, Split> splits = makeSplits(expense, userAmounts);
		return splits;
	}

	public void addExpenseToGroup(Group group, double amount, SplitType splitType, User paidBy) {
		Expense expense = this.createExpense(amount, splitType, paidBy);
		HashMap<String, Split> splits = this.getSplits(expense, group.getMembers());
		expense.setSplits(splits);
		group.addExpense(expense);
	}

	private void createTransaction(User user1, User user2, double amount) {
		Transaction transaction = new Transaction(user1, user2, amount);
		System.out.println("Transaction successfully created with transaction id - " + transaction.getTransactionId());
		this.transactionsMap.put(transaction.getTransactionId(), transaction);
		System.out.println("Transaction Successfully processed");

	}

	public void settleAmount(User user1, User user2) {
		String balanceKey1 = this.getBalanceKey(user1, user2);
		String balanceKey2 = this.getBalanceKey(user2, user1);
		double amountUser2HasToBePaid = user1.getAmountSheet().getOrDefault(balanceKey1, 0.0);
		double amountUser1HasToBePaid = user2.getAmountSheet().getOrDefault(balanceKey2, 0.0);
		if (amountUser1HasToBePaid < 0) {
			user1.setAmountSheet(balanceKey1, 0.0);
			user2.setAmountSheet(balanceKey2, 0.0);
			System.out.println(
					user1.getName() + " has to pay " + Math.abs(amountUser1HasToBePaid) + " to " + user2.getName());
			createTransaction(user1, user2, Math.abs(amountUser1HasToBePaid));
		} else {
			user2.setAmountSheet(balanceKey2, 0.0);
			user1.setAmountSheet(balanceKey1, 0.0);
			System.out.println(
					user2.getName() + " has to pay " + Math.abs(amountUser2HasToBePaid) + " to " + user2.getName());
			createTransaction(user1, user2, Math.abs(amountUser2HasToBePaid));
		}
	}

	public void printBalanceSheet(User user) {
		HashMap<String, Double> amountSheet = user.getAmountSheet();
		for (String balanceKey : amountSheet.keySet()) {
			String user2Id = balanceKey.split(":")[1];
			User user2 = this.usersMap.get(user2Id);
			System.out.println(user2.getName() + "---------->" + amountSheet.get(balanceKey));
		}
	}

}
