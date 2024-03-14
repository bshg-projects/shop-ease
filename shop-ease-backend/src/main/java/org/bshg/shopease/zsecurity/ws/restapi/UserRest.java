package org.bshg.shopease.zsecurity.ws.restapi;

import org.bshg.shopease.zsecurity.entity.AppUser;
import org.bshg.shopease.zsecurity.service.facade.UserService;
import org.bshg.shopease.zsecurity.ws.converter.UserConverter;
import org.bshg.shopease.zsecurity.ws.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/admin/users")
@RestController
public class UserRest {
    private final UserService userService;
    private final UserConverter userConverter;

    public UserRest(UserService userService, UserConverter userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }

    @GetMapping()
    public List<UserDto> findAll() {
        List<AppUser> all = this.userService.findAll();
        return userConverter.toDto(all);
    }

    public AppUser findByUsername(String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("/id/{id}")
    public UserDto findById(@PathVariable Long id) {
        AppUser byId = userService.findById(id);
        return userConverter.toDto(byId);
    }

    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @PostMapping("/save")
    public UserDto save(@RequestBody UserDto userDto) {
        AppUser user = userConverter.toItem(userDto);
        AppUser saved = userService.save(user);
        return userConverter.toDto(saved);
    }

    @PutMapping()
    public UserDto update(@RequestBody UserDto userDto) {
        AppUser user = userConverter.toItem(userDto);
        AppUser saved = userService.update(user);
        return userConverter.toDto(saved);
    }

    @DeleteMapping()
    public int delete(@RequestBody UserDto userDto) {
        AppUser user = userConverter.toItem(userDto);
        return userService.delete(user);
    }

    @GetMapping("/username/{username}")
    public UserDto findByUsernameWithRoles(@PathVariable String username) {
        return userConverter.toDto(userService.findByUsernameWithRoles(username));
    }

    @DeleteMapping("/username/{username}")
    public int deleteByUsername(@PathVariable String username) {
        return userService.deleteByUsername(username);
    }
}

