package be.dragon.language.util;

import be.dragon.language.model.Category;
import be.dragon.language.model.Quest;
import be.dragon.language.model.Session;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class SessionFactoryTest {
    SessionFactory sessionFactory = new SessionFactory();

    @Test
    public void testCreateQuestSession() throws Exception {
        Session result = sessionFactory.createQuestSession(new HashSet<Quest>(Arrays.asList(new Quest("question", "answer", new byte[]{(byte) 0}, Category.functionWord))));
        Assert.assertEquals(new Session(new HashSet<Quest>(Arrays.asList(new Quest("question", "answer", new byte[]{(byte) 0}, Category.functionWord)))), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme