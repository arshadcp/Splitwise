package dev.arshad.Splitwise.DTO;

import dev.arshad.Splitwise.Model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAmount {
    private User user;
    private Double amount;
    public UserAmount(){

    }

    public UserAmount(User user, Double amount) {
        this.user = user;
        this.amount = amount;

    }
}
