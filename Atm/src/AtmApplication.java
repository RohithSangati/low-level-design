import model.ATM;
import model.BankingService;
import model.Card;
import model.CashDispenser;

class AtmApplication {

	public static void main(String[] args) {

		BankingService bankingService = BankingService.getBankingServiceInstance();
		ATM atm = ATM.getAtmInstance();

		long cardNumber = bankingService.createAccount("Rohith", 1000);

		Card card = bankingService.atmCardByCardNumber(cardNumber);
		card.setOrResetPin(123456);
		
		atm.AddAmountToDispenser(1000);
		
		atm.startProcessing();
		
		
	}

}