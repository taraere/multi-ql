form taxOfficeExample { 
  	"Did you sell a house in 2010?"
   		hasSoldHouse: boolean
  	"Did you buy a house in 2010?"
    	hasBoughtHouse: boolean
  	"Did you enter a loan?"
    	hasMaintLoan: int = 2 + 2 * 4
   	"Did you enter a loan in 2012?"
    	hasMaintLoan2012: int
     
    // It isn't a boolean
  	if(hasMaintLoan){
    	"Did you buy a house in 2012?"
   	  		hasBoughtHouse2012: string
  
  	} else if (true == false) {
    	"Did you buy a house in 2013?"
   	  		hasBoughtHouse2013: int = hasMaintLoan2012 + 2 * (hasMaintLoan2012 - 3)
  	} else if (hasSoldHouse != false) {
  
  	} else if (hasBoughtHouse) {
  
  	} else {
  
  	}
}