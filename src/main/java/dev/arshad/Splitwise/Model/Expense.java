package dev.arshad.Splitwise.Model;

import dev.arshad.Splitwise.Model.Enum.CurrencyType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Expense extends BaseModel{
    private int amount;
    private String description;
    private LocalDateTime expenseTime;
    private CurrencyType currency;
    @ManyToOne
    private User addedBy;
    @OneToMany
    List<UserExpense> userExpenses;
}
