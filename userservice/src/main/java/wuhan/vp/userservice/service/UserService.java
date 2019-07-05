package wuhan.vp.userservice.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import wuhan.vp.common.model.User;

public interface UserService {

    User getUserByUsername(String username);

    User userLogin(@RequestBody User user);


    User getUserByUserId(int userId);
}
