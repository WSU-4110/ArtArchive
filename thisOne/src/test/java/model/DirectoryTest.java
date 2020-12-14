package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectoryTest {
    Directory directory = new Directory("title", "description", "user", "link");
    @BeforeEach
    public void testNewDirectoryWithParams(){
        Directory directory = new Directory("title", "description", "user", "link");
    }

    @Test
    public void testNewDirectoryConstruct(){
        Directory directory = new Directory();
    }

    @Test
    public void testNewDirectoryConstruct2(){
        Directory directory = new Directory(1,"title", "description", "user", "link");
    }

    @Test
    public void testGetDirectoryTitle(){
        directory.setTitle("Test");
        assertEquals("Test", directory.getTitle());
    }

    @Test
    public void testGetDirectoryDescription(){
        directory.setDescription("Test description");
        assertEquals("Test description", directory.getDescription());
    }

    @Test
    public void testGetDirectoryUser(){
        directory.setUser("TestUser");
        assertEquals("TestUser", directory.getUser());
    }

    @Test
    public void testGetDirectoryID(){
        directory.setId(1);
        assertEquals(1, directory.getId());
    }

    @Test
    public void testGetDirectoryLink(){
        directory.setLink("TestLink");
        assertEquals("TestLink", directory.getLink());
    }
}
