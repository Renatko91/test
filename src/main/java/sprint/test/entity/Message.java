package sprint.test.entity;

import org.springframework.data.annotation.Id;

public class Message {
    @Id
    private long id;
    private String text;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
