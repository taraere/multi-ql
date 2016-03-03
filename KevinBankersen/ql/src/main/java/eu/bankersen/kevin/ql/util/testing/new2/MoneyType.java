package eu.bankersen.kevin.ql.util.testing.new2;

public class MoneyType extends TypeObject<MoneyType> {
    
    @Override
    public boolean isCompatible(MoneyType object) {
	return true;
    }
    
    @Override
    public boolean isCompatible(IntType object) {
	return true;
    }

    @Override
    public MoneyType inferType() {
	return this;
    }
    
    @Override
    public void test() {
	System.out.println("Overridden");
    }

}
