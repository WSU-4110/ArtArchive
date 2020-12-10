package model;

import java.util.Date;

public class Questionboard {
    protected int topic_id;
    protected String topic_author;
    protected String topic_title;
    protected String topicquestion;

    public Questionboard() {
    }

    public Questionboard(String topic_author, String topic_title, String topicquestion) {
        super();
        this.topic_author = topic_author;
        this.topic_title = topic_title;
        this.topicquestion = topicquestion;
    }

    public Questionboard(int topic_id, String topic_author, String topic_title, String topicquestion) {
        super();
        this.topic_id = topic_id;
        this.topic_author = topic_author;
        this.topic_title = topic_title;
        this.topicquestion = topicquestion;
    }

    public int getTopic_id() {
        return this.topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }

    public String getTopic_author() {
        return this.topic_author;
    }

    public void setTopic_author(String topic_author) {
        this.topic_author = topic_author;
    }

    public String getTopic_title() {
        return this.topic_title;
    }

    public void setTopic_title(String topic_title) {
        this.topic_title = topic_title;
    }

    public String getTopicquestion() {
        return this.topicquestion;
    }

    public void setTopicquestion(String topicquestion) {
        this.topicquestion = topicquestion;
    }

}
