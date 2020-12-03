package model;

<<<<<<< HEAD
import java.util.Date;

public class Questionboard {
    protected int topic_id;
    protected String topic_author;
    protected String topic_title;
    protected String topicquestion;
    Date topic_create_time = new Date();
    java.sql.Date sqlDate;
    Date utilDate;

    public Questionboard() {
        this.sqlDate = new java.sql.Date(this.topic_create_time.getTime());
        this.utilDate = new Date(this.sqlDate.getTime());
    }

    public Questionboard(String topic_author, String topic_title, String topicquestion) {
        this.sqlDate = new java.sql.Date(this.topic_create_time.getTime());
        this.utilDate = new Date(this.sqlDate.getTime());
        this.topic_author = topic_author;
        this.topic_title = topic_title;
        this.topicquestion = topicquestion;
    }

    public Questionboard(int topic_id, String topic_author, String topic_title, String topicquestion) {
        this.sqlDate = new java.sql.Date(this.topic_create_time.getTime());
        this.utilDate = new Date(this.sqlDate.getTime());
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

    public java.sql.Date getSqlDate() {
        return this.sqlDate;
    }

    public Date getTopic_create_time() {
        return this.topic_create_time;
    }

    public Date getUtilDate() {
        return this.utilDate;
    }

    public void setSqlDate(java.sql.Date sqlDate) {
        this.sqlDate = sqlDate;
    }

    public void setTopic_create_time(Date topic_create_time) {
        this.topic_create_time = topic_create_time;
    }

    public void setUtilDate(Date utilDate) {
        this.utilDate = utilDate;
=======
public class Questionboard {
    public Questionboard(int topic_id, String topic_author, String topic_title, String topicquestion) {
    }

    public String getTopic_author() {
    }

    public String getTopic_title() {
    }

    public String getTopicquestion() {
    }

    public int getTopic_id() {
>>>>>>> 54e00a4fe02ce23b900cd3297d82e0f38ac9305e
    }
}
