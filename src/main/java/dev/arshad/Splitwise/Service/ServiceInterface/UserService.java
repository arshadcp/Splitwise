package dev.arshad.Splitwise.Service.ServiceInterface;

import dev.arshad.Splitwise.Model.User;

public interface UserService {
    User signUp(String name, String email, String password);
    String great();
}
