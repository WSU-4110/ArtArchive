package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    User user = new User("usernameTest", "emailTest", "United States", "passwordTest", "firstName", "lastName", "description", "red", "sampleFile");
    @BeforeEach
    public void testNewUser(){
        User user = new User(0,"usernameTest", "emailTest", "United States", "passwordTest", "firstName", "lastName", "description", "red", "sampleFile");
    }
    @Test
    public void testNewUser1(){
        User user1 = new User();
    }
    @Test //Tests to see if username returns correctly
    public void testGetID(){
        user.setId(0);
        assertEquals(0, user.getId());
    }
    @Test //Tests to see if username returns correctly
    public void testGetUsername(){
        user.setName("notusernameTest");
        assertEquals("notusernameTest", user.getName());
    }
    @Test //Tests to see if email returns correctly
    public void testGetEmail(){
        user.setEmail("emailTester");
        assertEquals("emailTester", user.getEmail());
    }
    @Test //Tests to see if country returns correctly
    public void testGetCountry(){
        user.setCountry("Turkey");
        assertEquals("Turkey", user.getCountry());
    }
    @Test //Tests to see if password returns correctly
    public void testGetPassword(){
        user.setPassword("newPasswordTest");
        assertEquals("newPasswordTest", user.getPassword());
    }
    @Test //Tests to see if firstName returns correctly
    public void testGetFName(){
        user.setFirstName("firstLastName");
        assertEquals("firstLastName", user.getFirstName());
    }
    @Test //Tests to see if lastName returns correctly
    public void testGetLName(){
        user.setLastName("myLastName");
        assertEquals("myLastName", user.getLastName());
    }
    @Test //Tests to see if lastName returns correctly
    public void testGetDescription(){
        user.setDescription("mydescription");
        assertEquals("mydescription", user.getDescription());
    }
    @Test //Tests to see if lastName returns correctly
    public void testGetFavoriteColor(){
        user.setFavoriteColor("purple");
        assertEquals("purple", user.getFavoriteColor());
    }
    @Test //Tests to see if lastName returns correctly
    public void testGetFile(){
        user.setFile("testerFile");
        assertEquals("testerFile", user.getFile());
    }

}

