import model.ATM;
import model.Account;
import model.BankingService;
import model.Card;

class AtmApplication {

	public static void main(String[] args) {

		BankingService bankingService = BankingService.getBankingServiceInstance();
		ATM atm = ATM.getAtmInstance();

		long cardNumber = bankingService.createAccount("Rohith", 1000);

		Card card = bankingService.atmCardByCardNumber(cardNumber);
		card.setOrResetPin(123456);

		atm.AddAmountToDispenser(1000);

		atm.startProcessing();

		System.out.println(atm.getAmountInDispenser());

		Account account = bankingService.getAccountByCardNumber(cardNumber);
		System.out.println(account.getAmount());

	}

}