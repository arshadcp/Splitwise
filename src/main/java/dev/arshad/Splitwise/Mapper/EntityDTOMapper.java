package dev.arshad.Splitwise.Mapper;

import dev.arshad.Splitwise.DTO.GroupResponseDTO;
import dev.arshad.Splitwise.DTO.UserFriendResponseDTO;
import dev.arshad.Splitwise.DTO.UserSignUpResponseDTO;
import dev.arshad.Splitwise.Model.Group;
import dev.arshad.Splitwise.Model.User;

import java.util.ArrayList;
import java.util.List;

public class EntityDTOMapper {
    public static UserSignUpResponseDTO toDTO(User user){
        UserSignUpResponseDTO responseDTO=new UserSignUpResponseDTO();
        responseDTO.setId(user.getId());
        responseDTO.setName(user.getName());
        responseDTO.setEmail(user.getEmail());
 //       List<UserFriendResponseDTO> friendList=new ArrayList<>();
//        for(User friend:user.getFriends()){
//            UserFriendResponseDTO f =FriendtoDTO(friend);
//            friendList.add(f);
//        }
  //      responseDTO.setFriends(friendList);
//        List<GroupResponseDTO> groups=new ArrayList<>();
//        for(Group group:user.getGroups()){
//           GroupResponseDTO g= GrouptoDTO(group);
//        }
//        responseDTO.setGroups(groups);
        return responseDTO;
    }
//    public static UserFriendResponseDTO FriendtoDTO(User user){
//        UserFriendResponseDTO responseDTO=new UserFriendResponseDTO();
//        responseDTO.setName(user.getName());
//        responseDTO.setId(user.getId());
//        return responseDTO;
//
//    }
//    public static GroupResponseDTO GrouptoDTO(Group group){
//        GroupResponseDTO responseDTO=new GroupResponseDTO();
//        responseDTO.setName(group.getName());
//        responseDTO.setTotalAmountSpent(group.getTotalAmountSpent());
//        return responseDTO;
//    }
}
