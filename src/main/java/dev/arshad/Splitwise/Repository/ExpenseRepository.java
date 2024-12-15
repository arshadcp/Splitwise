package dev.arshad.Splitwise.Repository;

import dev.arshad.Splitwise.Model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Integer> {
}
