package be.dragon.language.model;

import org.apache.commons.lang3.RandomUtils;
import org.hamcrest.beans.HasPropertyWithValue;
import org.hamcrest.core.Every;
import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

public class SessionsTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAnswers() throws Exception {

        Set<Quest> quests=new TreeSet<Quest>();
        for (int i = 0; i < 100; i++) {

            Quest quest = new Quest("hallo" + i, "bla" + i, null, Category.adjectief);
            quest.setId(Long.valueOf(i));
            quests.add(quest);
        }

        Session session=new Session(quests);
        session.getAnswers().stream().forEach(x->x.setResponse(RandomUtils.nextBoolean()?x.getQuest().getAnswer():""));
        assertThat(session.getAnswers(),hasSize(100));
        assertThat(session.getAnswers(), (Every.everyItem(HasPropertyWithValue.hasProperty("response", Is.is(notNullValue())))));
    }

    @Test
    public void getBad() throws Exception {
        Set<Quest> quests=new TreeSet<Quest>();
        for (int i = 0; i < 50; i++) {

            Quest quest = new Quest("hallo" + i, "bla" + i, null, Category.adjectief);
            quest.setId(Long.valueOf(i));
            quests.add(quest);
        }

        Session session=new Session(quests);
        session.getAnswers().stream().forEach(x->x.setResponse("false"));
        assertThat(session.getBad(),hasSize(50));
        assertThat(session.getAnswers(), (Every.everyItem(HasPropertyWithValue.hasProperty("response", Is.is("false")))));
    }

    @Test
    public void getPass() throws Exception {
        Set<Quest> quests=new TreeSet<Quest>();
        for (int i = 0; i < 50; i++) {

            Quest quest = new Quest("hallo" + i, "bla" + i, null, Category.adjectief);
            quest.setId(Long.valueOf(i));
            quests.add(quest);
        }

        Session session=new Session(quests);
        session.getAnswers().stream().forEach(x->x.setResponse(x.getQuest().getAnswer()));
        assertThat(session.getPass(),hasSize(50));

    }

}