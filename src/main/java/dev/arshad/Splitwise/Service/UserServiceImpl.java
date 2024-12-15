package dev.arshad.Splitwise.Service;

import dev.arshad.Splitwise.Exception.UserNotFoundException;
import dev.arshad.Splitwise.Exception.invalidPasswordException;
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
   public User login(String email,String password){
        User user=userRepository.getUserByEmail(email);
        if(user==null){
            throw new UserNotFoundException("Invalid Email");
        }
       BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        if(encoder.matches(password,user.getPassword())){
            return user;
        }
        throw new invalidPasswordException("Wrong password");
   }
}
