package sprint.test.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sprint.test.entity.User;
import sprint.test.mapper.UserMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getAll() {
        List<User> userNameList = new ArrayList<>();
        userNameList.addAll(jdbcTemplate.query("select * from user_n", new UserMapper()));
        userNameList.sort((a, b) -> (int) (a.getId() - b.getId()));
        return userNameList;
    }

    @Transactional
    public void addUser(User user) {
        jdbcTemplate.update("insert into user_n (name) values (?)", user.getName());
    }

    public void delUser(String del_user) {
        jdbcTemplate.update("delete from user_n where name = ?", del_user);
    }
}
