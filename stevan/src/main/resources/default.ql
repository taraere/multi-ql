form taxOfficeExample { 

	"What is your age?"
		age: integer
	"What is your date of Birth?"
		birthDate: date
	"Did you sell a house in 2010?"
		hasSoldHouse: money
	"Did you buy a house in 2010?"
		hasBoughtHouse: boolean
	"Did you enter a loan?"
		hasMaintLoan: boolean
	
	if (!hasSoldHouse) {
		"What was the selling price?"
			sellingPrice: money
		"Private debts for the sold house:"
			privateDebt: money
		"Parents gift money:"
			giftMoneys: money
		"Parents gift money:"
			giftMoney: money
		"Value residue:"
			valueResidue: money = 
				(sellingPrice - privateDebt) + giftMoney
	}
	
	if (age + 5) {
		"Do you see yourself as being old?"
			old: boolean
	}
	
	"Did you steal in 2010?"
		hasStolen: boolean
		
	if (hasStolen + true) {
		"How much did you steal?"
			stealingAmount: money
		"Did you hurt anyone in the process?"
			hurtAnyone: boolean
		"Did you get caught?"
			gotCaught: boolean
		"Did you get caught?"
			gotCaught: boolean
	}

}