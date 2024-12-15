package dev.arshad.Splitwise.DTO;

import dev.arshad.Splitwise.Model.Group;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserSignUpResponseDTO {
    private int id;
    private String name;
    private String email;
    List<UserFriendResponseDTO> friends;
    List<GroupResponseDTO> groups;
}
