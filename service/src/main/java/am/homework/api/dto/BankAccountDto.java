package am.homework.api.dto;

public class BankAccountDto {
    private Long id;
    private double amount;

    public BankAccountDto(Long id, double amount) {
        this.id = id;
        this.amount = amount;
    }
    public BankAccountDto(){

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
