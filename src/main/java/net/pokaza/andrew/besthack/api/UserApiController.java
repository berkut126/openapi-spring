package net.pokaza.andrew.besthack.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.pokaza.andrew.besthack.model.*;
import net.pokaza.andrew.besthack.repo.RoleRepository;
import net.pokaza.andrew.besthack.repo.UserRepository;
import net.pokaza.andrew.besthack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toSet;

@Controller
@RequestMapping("${openapi.bESTHACK2020Web.base-path:}")
public class UserApiController implements UserApi {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    private final NativeWebRequest request;

    @Autowired
    public UserApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<List<String>> userGet() {
        for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                ObjectMapper mapper = new ObjectMapper();
                try {
                    String res = mapper.writeValueAsString(userRepository.findAll());
                    ApiUtil.setExampleResponse(request, "application/json", res);
                }
                catch (IOException e){
                    e.printStackTrace();
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
                break;
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> userLoginDelete(String login) {
        if(userRepository.findByUsername(login) != null){
            userRepository.deleteByUsername(login);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<InlineResponse200> userLoginGet(String login) {
        User user = userRepository.findByUsername(login);
        if(user == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        InlineResponse200 response = new InlineResponse200();
        response.blocked(user.isBlocked());
        response.setRights(user.getRoles().stream().map(Role::getName).collect(joining(" ")));
        ObjectMapper mapper = new ObjectMapper();
        try {
            ApiUtil.setExampleResponse(request, "application/json", mapper.writeValueAsString(response));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (IOException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseEntity<Void> userLoginPut(String login, @Valid InlineObject2 inlineObject2) {
        User user = userRepository.findByUsername(login);
        if(user == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        user.setBlocked(inlineObject2.getBlocked());
        user.setRoles(Arrays.stream(inlineObject2.getRights().split(",")).map(it -> {
            Role role = roleRepository.findByName(it);
            if(role == null){
                role = new Role();
                role.setName(it);
                role.setUsers(Set.of(user));
                roleRepository.save(role);
            }
            return role;
        }).collect(toSet()));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<String>> userLoginRolesGet(String login) {
        User user = userRepository.findByUsername(login);
        if(user == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        ObjectMapper mapper = new ObjectMapper();
        try {
            ApiUtil.setExampleResponse(request, "application/json", mapper.writeValueAsString(
                    user.getRoles().stream().map(Role::getName).collect(joining(" ")))
            );
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (IOException e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Void> userLoginRolesPut(String login, @Valid InlineObject3 inlineObject3) {
        User user = userRepository.findByUsername(login);
        if(user == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Role role = roleRepository.findByName(inlineObject3.getRole());
        if(role == null){
            role = new Role();
            role.setName(inlineObject3.getRole());
            role.setUsers(Set.of(user));
            roleRepository.save(role);
        }
        user.setRoles(Set.of(role));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<InlineResponse2001> userLoginStatusGet(String login) {
        for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                User a = userRepository.findByUsername(login);
                if(a == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                ObjectMapper mapper = new ObjectMapper();
                try {
                    String res = mapper.writeValueAsString(a.isBlocked());
                    ApiUtil.setExampleResponse(request, "application/json", res);
                }
                catch (IOException e){
                    e.printStackTrace();
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
                break;
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> userPost(String login, String password) {
        User user = new User();
        user.setUsername(login);
        user.setPassword(password);
        user.setBlocked(false);
        if(userService.saveUser(user)) return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
