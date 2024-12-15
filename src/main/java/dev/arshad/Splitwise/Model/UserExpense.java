package dev.arshad.Splitwise.Model;

import dev.arshad.Splitwise.Model.Enum.ExpenseType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class UserExpense extends BaseModel{
    @ManyToOne
    private User user;
    private Double amount;
    @Enumerated(EnumType.STRING)
   private ExpenseType expenseType;
}
