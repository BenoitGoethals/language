package be.dragon.language.integrationTests.model;

import be.dragon.language.model.Category;
import be.dragon.language.model.Quest;
import be.dragon.language.model.Session;
import be.dragon.language.services.QuestService;
import be.dragon.language.services.SessionService;
import be.dragon.language.services.SessionServiceImpl;
import be.dragon.language.unitTests.util.SessionFactory;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SessionTest {


    private SessionService sessionService;

    @Mock
    private QuestService questService;

    @Mock
    private SessionFactory sessionFactory;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        sessionService = new SessionServiceImpl(sessionFactory, questService);
    }


    //@Test()
    public void getSession() throws Exception {


        Set<Quest> quests = new HashSet<>();
        for (int i = 0; i < 100; i++) {

            Quest quest = new Quest("hallo" + i, "bla" + i, null, Category.adjectief);
            quest.setId(Long.valueOf(i));
            quests.add(quest);
        }
        Random r = new Random();

        Object[] object = quests.toArray();
        Quest q = mock(Quest.class);
        q.setId(r.nextLong() * 100);

        when(questService.random()).thenReturn((Quest) object[1], (Quest) object[2], (Quest) object[0], (Quest) object[3]);
        when(sessionFactory.createQuestSession(quests)).thenReturn(new Session(quests));
        final Session session = sessionService.getSession(4);
        assertThat(session.getAnswers(), hasSize(4));

    }



}
