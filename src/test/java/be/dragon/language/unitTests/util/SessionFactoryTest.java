package be.dragon.language.unitTests.util;

import be.dragon.language.model.Category;
import be.dragon.language.model.Quest;
import be.dragon.language.model.Session;
import org.apache.commons.lang3.RandomUtils;
import org.hamcrest.beans.HasPropertyWithValue;
import org.hamcrest.core.Every;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class SessionFactoryTest {
    SessionFactory sessionFactory = new SessionFactory();

    @Test
    public void testCreateQuestSession() throws Exception {
        Set<Quest> quests=new TreeSet<Quest>();
        for (int i = 0; i < 100; i++) {

            Quest quest = new Quest("hallo" + i, "bla" + i, null, Category.adjectief);
            quest.setId(Long.valueOf(i));
            quests.add(quest);
        }

        Session session = sessionFactory.createQuestSession(quests);

        session.getAnswers().stream().forEach(x->x.setResponse(RandomUtils.nextBoolean()?x.getQuest().getAnswer():""));
        assertThat(session.getAnswers(),hasSize(100));
        assertThat(session.getAnswers(), (Every.everyItem(HasPropertyWithValue.hasProperty("response", Is.is(notNullValue())))));
    }
}

