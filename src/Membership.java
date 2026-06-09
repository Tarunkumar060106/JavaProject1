public class Membership {
    private double discount;
    private double fees;
    private String membershipType;

    public double getDiscount() {
        return this.discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getFees() {
        return this.fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public String getMembershipType() {
        return this.membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }
}
