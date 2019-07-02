package wuhan.vp.userservice.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import wuhan.vp.userservice.model.User;

@Mapper
public interface UserDao {

    @Select("select * from user where userName=#{username}")
    User getUserByUsername(String username);

    @Select("select * from user where userName=#{userName} and password=#{password}")
    User userLogin(@RequestBody User user);
}
