package eu.bankersen.kevin.ql.util.testing.new2;

public class Testting {

    public static void main(String[] args) {
	TypeObject stringA = new StringType();
	
	TypeObject moneyA = new MoneyType();
	TypeObject intA = new IntType();
	
	System.out.println(intA.inferType().getClass());
	
	moneyA.test();
	
	System.out.println(moneyA.inferType().equals(new MoneyType()));
	
	System.out.println(moneyA.isCompatible(moneyA.inferType()));
	
	

    }

}
