package com.talentyco.shopping.service.impl;

import com.talentyco.shopping.domain.User;
import com.talentyco.shopping.domain.security.Role;
import com.talentyco.shopping.domain.security.UserRole;
import com.talentyco.shopping.utility.SecurityUtility;
import com.talentyco.shopping.repository.RoleRepository;
import com.talentyco.shopping.repository.UserRepository;
import com.talentyco.shopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public User createUser(String username, String email, String password, List<String> roles) {
        User user = findByUsername(username);
        if (user != null) {
            return user;
        } else {
            user = new User();
            user.setUsername(username);
            user.setPassword(SecurityUtility.passwordEncoder().encode(password));
            user.setEmail(email);
            Set<UserRole> userRoles = new HashSet<>();
            for (String rolename : roles) {
                Role role = roleRepository.findByName(rolename);
                if (role == null) {
                    role = new Role();
                    role.setName(rolename);
                    roleRepository.save(role);
                }
                userRoles.add(new UserRole(user, role));
            }
            user.setUserRoles(userRoles);
            return userRepository.save(user);
        }
    }
}
