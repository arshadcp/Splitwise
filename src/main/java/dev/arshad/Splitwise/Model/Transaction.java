package dev.arshad.Splitwise.Model;

import dev.arshad.Splitwise.Model.Enum.CurrencyType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Transaction extends BaseModel {
    @ManyToOne
    private User borrower;
    @ManyToOne
    private User lender;
    private Double amount;
    private CurrencyType currencyType;

}
