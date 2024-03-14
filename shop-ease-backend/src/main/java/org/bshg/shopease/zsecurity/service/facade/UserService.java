package org.bshg.shopease.zsecurity.service.facade;

import org.bshg.shopease.zsecurity.entity.AppUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    String cryptPassword(String value);

    boolean changePassword(String username, String newPassword);

    List<AppUser> findAll();

    AppUser findByUsername(String username);

    AppUser findById(Long id);

    void deleteById(Long id);

    AppUser save(AppUser user);

    AppUser update(AppUser user);

    int delete(AppUser user);

    AppUser findByUsernameWithRoles(String username);

    int deleteByUsername(String username);

    UserDetails loadUserByUsername(String username);
}
