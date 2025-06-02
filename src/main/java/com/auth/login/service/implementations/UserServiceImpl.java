package com.auth.login.service.implementations;

import com.auth.login.model.entities.User;
import com.auth.login.model.enums.RoleType;
import com.auth.login.model.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * @return all users created
     */
    public List<User> allUsers() {
        return new ArrayList<>(userRepository.findAll());
    }

    public List<User> getUsersByRole(RoleType role) {
        return userRepository.findByRole(role);
    }

    public List<User> obtenerUsuariosPorAdmin(Integer adminId) {
        return userRepository.findByAdminId(adminId);
    }

    public User getUserById(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public User getUserByNumberID(String numberID) {
        return userRepository.findByNumberID(numberID)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con el número de identificación: " + numberID));
    }

    public boolean existsUserByNumberID(String numberID) {
        return userRepository.findByNumberID(numberID).isPresent();
    }

    public boolean existsUserByEmail(String numberID) {
        return userRepository.findByEmail(numberID).isPresent();
    }

    public List<User> getUsersByNumberIDs(List<String> numberIds) {
        return userRepository.findByNumberIDIn(numberIds);
    }


}
