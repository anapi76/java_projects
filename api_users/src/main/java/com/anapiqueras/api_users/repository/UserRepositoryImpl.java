package com.anapiqueras.api_users.repository;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;
import com.anapiqueras.api_users.dto.UserDTO;
import com.anapiqueras.api_users.exceptions.UserNotFoundException;
import com.anapiqueras.api_users.mapper.DTOMapperUser;
import com.anapiqueras.api_users.mapper.UserMapperDTO;
import com.anapiqueras.api_users.repository.DAO.iUserDAO;
import com.anapiqueras.api_users.entity.UserEntity;

@Repository
public class UserRepositoryImpl implements iUserRepository {

    public iUserDAO userDao;
    private DTOMapperUser dtoMapperUser;
    private UserMapperDTO userMapperDTO;

    public UserRepositoryImpl(iUserDAO userDao,DTOMapperUser dtoMapperUser, UserMapperDTO userMapperDTO) {
        this.userDao = userDao;
        this.dtoMapperUser=dtoMapperUser;
        this.userMapperDTO=userMapperDTO;
    }

    @Override
    public UserDTO findUserByUsername(String username) throws UserNotFoundException {
        UserEntity userFound=userDao.findOneByUsername(username).orElseThrow(() -> new UserNotFoundException("User not found for username: " + username));
        return userMapperDTO.mapToUserDto(userFound);
    }

    @Override
    public List<UserDTO> findAll() {
        List<UserEntity> users = userDao.findAll();
        return users.stream().map(p->userMapperDTO.mapToUserDto(p)).collect(Collectors.toList());
    }

    @Override
    public UserDTO findUserById(int id) throws UserNotFoundException {
        System.out.println(id);
        UserEntity userFound = userDao.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found for id: " + id));
        return userMapperDTO.mapToUserDto(userFound);
    }

    @Override
    public UserDTO createUser(UserDTO userDto) {
        UserEntity user = dtoMapperUser.mapToUser(userDto);
        user= userDao.save(user);
        UserDTO savedUserDto = userMapperDTO.mapToUserDto(user);
        return savedUserDto;
    }

    @Override
    public UserDTO updateUser(UserDTO userDto) {
        UserEntity user = dtoMapperUser.mapToUser(userDto);
        user= userDao.save(user);
        UserDTO savedUserDto = userMapperDTO.mapToUserDto(user);
        return savedUserDto;
    }

    @Override
    public void deleteUserById(int id) throws UserNotFoundException {
        if(findUserById(id)==null){
            new UserNotFoundException("User not found for id: " + id);
        }
        userDao.deleteById(id);
    }

}
