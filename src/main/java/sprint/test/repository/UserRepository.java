package sprint.test.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import sprint.test.entity.User;
import sprint.test.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getAll() {
        List<User> userNameList = new ArrayList<>();
        userNameList.addAll(jdbcTemplate.query("select * from user_n;", new UserMapper()));
        return userNameList;
    }
}
