package be.dragon.language.model;

import be.dragon.language.services.QuestService;
import be.dragon.language.services.SessionService;
import be.dragon.language.services.SessionServiceImpl;
import be.dragon.language.util.SessionFactory;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Iterator;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
        final Session session = sessionService.getSession(100);
        assertThat(session.getAnswers(), hasSize(100));
        assertThat(session.getPrecentage(), is(0.0));
    }

    //@Test()
    public void getSessionDoTest() throws Exception {
        final Session session = sessionService.getSession(60);
        //  given(questService.)
        assertThat(session.getAnswers(), hasSize(60));
        //  session.getAnswers().stream().filter(x -> x.getQuest().getId() < 20).forEach(x->x.setResponse(x.getQuest().getAnswer()));
        Iterator<Answer> iterator = session.getAnswers().iterator();
        for (int i = 0; i < 20; i++) {
            Answer next = iterator.next();
            next.setResponse(next.getQuest().getAnswer());

        }

        double res = session.getPrecentage();
        assertThat(res, is(33.33333333333333));
        assertThat(session.getBad().size(), is(40));
        assertThat(session.getPass().size(), is(20));
    }


}
