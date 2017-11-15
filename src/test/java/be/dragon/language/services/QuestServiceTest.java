package be.dragon.language.services;

import be.dragon.language.config.JpaConfiguration;
import be.dragon.language.model.Category;
import be.dragon.language.model.Quest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)

@SpringBootTest
public class QuestServiceTest {

    @Autowired
    private QuestService questService;

    @Before
    public void setUp() throws Exception {
        questService.deleteAll();
    }

    @After
    public void tearDown() throws Exception {
        questService.deleteAll();
    }

    @Test
    public void addQuest() throws Exception {

        Quest quest=new Quest("hallo","bla",null, Category.sentende);
       Quest quest1= questService.addQuest(quest);
        assertThat(quest1.getId(),is(notNullValue()));

    }

    @Test
    public void deleteQuest() throws Exception {
        Quest quest=new Quest("hallo","bla",null, Category.sentende);
        Quest quest1= questService.addQuest(quest);
        assertThat(quest1,is(notNullValue()));
        questService.deleteQuest(quest1);
        assertThat(questService.getQuest(Long.valueOf(1)),is(nullValue()));

    }

    @Test
    public void allQuests() throws Exception {
        List<Quest> questList=new ArrayList<>();
        Quest quest=null;
        for (int i = 0; i < 100; i++) {
             quest=new Quest("hallo"+i,"bla"+i,null, Category.sentende);

            Quest quest1= questService.addQuest(quest);
            questList.add(quest1);
            assertThat(quest1.getId(),is(notNullValue()));
        }
        assertThat(questService.allQuests(),hasSize(100));
    }

    @Test
    public void updateQuest() throws Exception {

        Quest quest=new Quest("hallo","bla",null, Category.sentende);
        Quest quest1= questService.addQuest(quest);
        assertThat(quest1.getId(),is(notNullValue()));
        quest1.setAnswer("ok");
        Quest quest2= questService.addQuest(quest);
        assertThat(quest2.getAnswer(),is("ok"));
    }

}