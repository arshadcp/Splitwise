package dev.arshad.Splitwise.Model;

import dev.arshad.Splitwise.Model.Enum.CurrencyType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class SettlementTransaction extends BaseModel {
    @ManyToOne
    private User borrower;
    @ManyToOne
    private User lender;
    private Double amount;
    private CurrencyType currencyType;

    public SettlementTransaction(User borrower, User lender, Double amount) {
        this.borrower = borrower;
        this.lender = lender;
        this.amount = amount;
    }
    public SettlementTransaction(){

    }
}
