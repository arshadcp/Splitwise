package dev.arshad.Splitwise.Controller;

import dev.arshad.Splitwise.DTO.UserLoginRequestDTO;
import dev.arshad.Splitwise.DTO.UserSignUpRequestDTO;
import dev.arshad.Splitwise.Exception.InvalidRegistrationDataException;
import dev.arshad.Splitwise.Mapper.EntityDTOMapper;
import dev.arshad.Splitwise.Model.User;
import dev.arshad.Splitwise.Service.ServiceInterface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ResponseEntity Userlogin(@RequestBody UserLoginRequestDTO requestDTO){
        User savedUser=userService.login(requestDTO.getEmail(),requestDTO.getPassword());
        return ResponseEntity.ok(EntityDTOMapper.toDTO(savedUser));
    }

    @PostMapping("/signUp")
    public ResponseEntity signUpUser(@RequestBody UserSignUpRequestDTO requestDTO) throws Exception{
        validateUserSignUpDTO(requestDTO);
        User savedUser=userService.signUp(requestDTO.getName(),requestDTO.getEmail(),
                requestDTO.getPassword());
        return ResponseEntity.ok(EntityDTOMapper.toDTO(savedUser));
    }
    private  void validateUserSignUpDTO(UserSignUpRequestDTO requestDTO){
        if(requestDTO.getName()==null || requestDTO.getEmail()==null ||
                requestDTO.getPassword()==null){
            throw new InvalidRegistrationDataException("Invalid Signup data");
        }
    }
    @GetMapping("/hello")
    public ResponseEntity hello(){
      return  ResponseEntity.ok(userService.great());
    }

}
