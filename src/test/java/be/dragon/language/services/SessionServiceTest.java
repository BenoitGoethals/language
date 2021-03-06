package be.dragon.language.services;

import be.dragon.language.model.Answer;
import be.dragon.language.model.Category;
import be.dragon.language.model.Quest;
import be.dragon.language.model.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)

@SpringBootTest
@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
public class SessionServiceTest {

    @Autowired
    private SessionService sessionService;

    @Autowired
    private QuestService questService;


    @Before
    public void setUp() throws Exception {

        Quest quest=null;
        for (int i = 0; i < 100; i++) {
            quest=new Quest("hallo"+i,"bla"+i,null, Category.adjectief);

            Quest quest1= questService.addQuest(quest);

        }

    }

    @After
    public void tearDown() throws Exception {
        questService.deleteAll();
    }

    @Test
    @Rollback(true)
    public void getSession() throws Exception {
        final Session session = sessionService.getSession(100);
        assertThat(session.getAnswers(),hasSize(100));
        assertThat(session.getPrecentage(),is(0.0));
    }

    @Test
    @Rollback(true)
    public void getSessionDoTest() throws Exception {
        final Session session = sessionService.getSession(60);
        assertThat(session.getAnswers(),hasSize(60));
      //  session.getAnswers().stream().filter(x -> x.getQuest().getId() < 20).forEach(x->x.setResponse(x.getQuest().getAnswer()));
        Iterator<Answer> iterator= session.getAnswers().iterator();
        for (int i = 0; i <20 ; i++) {
            Answer next = iterator.next();
            next.setResponse(next.getQuest().getAnswer());

        }

        double res=session.getPrecentage();
       assertThat(res,is(33.33333333333333));
       assertThat(session.getBad().size(),is(40));
        assertThat(session.getPass().size(),is(20));
    }
}