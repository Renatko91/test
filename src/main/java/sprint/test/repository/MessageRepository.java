package sprint.test.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sprint.test.entity.Message;
import sprint.test.entity.User;
import sprint.test.mapper.MessageMapper;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Message> getAll() {
        List<Message> messageTextList = new ArrayList<>();
        messageTextList.addAll(jdbcTemplate.query("select * from messages", new MessageMapper()));
        messageTextList.sort((a, b) -> (int) (a.getId() - b.getId()));
        return messageTextList;
    }

    @Transactional
    public void addMessage(Message message) {
        jdbcTemplate.update("insert into messages (text) values (?)", message.getText());
    }

    public void delMessage(String text) {
        jdbcTemplate.update("delete from messages where text = ?", text);
    }
}
