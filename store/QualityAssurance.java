package store;

public class QualityAssurance extends AbstractStoreEmployee {
    private double winRate;
    private int productHandled;

    public QualityAssurance(double numberOfHoursWorked, double hourlyRate, String storeDetails, double basePay,
            String employeeName, double winRate, int productHandled) {
        super(numberOfHoursWorked, hourlyRate, storeDetails, basePay, employeeName);
        this.winRate = winRate;
        this.productHandled = productHandled;
    }

    public double getWinRate() {
        return winRate;
    }

    public void setWinRate(double winRate) {
        this.winRate = winRate;
    }

    public int getProductHandled() {
        return productHandled;
    }

    public void setProductHandled(int productHandled) {
        this.productHandled = productHandled;
    }

    @Override
    public double calculateOverworkPayment(double hour) {
        return getBasePay() * hour;
    }

    @Override
    public double calculatePay() {
        return super.getBasePay() + calculateCommission() + (super.getNumberOfHoursWorked() * super.getHourlyRate());
    }

    @Override
    public boolean checkPromotionEligibility() {
        if (calculatePay() > 25000 && winRate > 90.0 && productHandled > 20) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Win rate: " + getWinRate() + "%\n" + "Product handled: " + getProductHandled();
    }
}
