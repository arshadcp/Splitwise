package dev.arshad.Splitwise.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity(name = "Splitwise_Group")
public class Group extends BaseModel{
    private String name;
    private LocalDateTime creationDate;
    private Double totalAmountSpent;
    @ManyToOne
    private User createdBy;
    @ManyToMany(mappedBy = "groups")
   private List<User> members;
   @OneToMany
    private List<Expense> expenses;
   @OneToMany
   private List<SettlementTransaction> settlementSettlementTransactions;

}
