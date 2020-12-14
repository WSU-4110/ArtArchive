package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionboardTest {

    @BeforeEach
    public void QuestionboardTestWithParameters()
    {
        Questionboard question = new Questionboard("Shahreen Hussain","Material",
                "What is the best material to use");
    }
    @Test
    public void QuestionboardTest()
    {
        Questionboard question = new Questionboard("topic_author", "topic_title",
                "topicquestion");
    }
    @Test
    public void QuestionboardTestWithID()
    {
        Questionboard question = new Questionboard(1,"topic_author","topic_title",
                "topicquestion");
    }

    @Test
    void getTopic_id() {
        Questionboard question = new Questionboard();
        question.setTopic_id(1);
        assertEquals(1,question.getTopic_id());
    }

    @Test
    void getTopic_author() {
        Questionboard question = new Questionboard();
        question.setTopic_author("Shahreen Hussain");
        assertEquals("Shahreen Hussain",question.getTopic_author());
    }
    @Test
    void getTopic_title() {
        Questionboard question = new Questionboard();
        question.setTopic_title("Material");
        assertEquals("Material",question.getTopic_title());
    }
    @Test
    void getTopicquestion() {
        Questionboard question = new Questionboard();
        question.setTopicquestion("What is the best material to use?");
        assertEquals("What is the best material to use?",question.getTopicquestion());
    }

}