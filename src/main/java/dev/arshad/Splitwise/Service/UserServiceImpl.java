package dev.arshad.Splitwise.Service;

import dev.arshad.Splitwise.Model.User;
import dev.arshad.Splitwise.Repository.UserRepository;
import dev.arshad.Splitwise.Service.ServiceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    public User signUp(String name, String email, String password){
        User user=new User();
        user.setName(name);
        user.setEmail(email);
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(password));
       return userRepository.save(user);

    }
    public String great(){
        return "hello";
    }
}
