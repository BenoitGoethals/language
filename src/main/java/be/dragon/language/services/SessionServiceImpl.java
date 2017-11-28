package be.dragon.language.services;

import be.dragon.language.model.Quest;
import be.dragon.language.model.Session;
import be.dragon.language.unitTests.util.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.TreeSet;

@Service(value = "sessionService")
//@Transactional
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private QuestService questService;

    public SessionServiceImpl(SessionFactory sessionFactory, QuestService questService) {
        this.sessionFactory = sessionFactory;
        this.questService = questService;
    }

    public SessionServiceImpl() {

    }


    @Override
    public Session getSession(int quests) {
        Set<Quest> questsList=new TreeSet<>();


        int i=0;
        while (i<quests){
            Quest retrieveQuest=questService.random();
            if(!questsList.contains(retrieveQuest)){
                questsList.add(retrieveQuest);
                ++i;
            }

        }


        return sessionFactory.createQuestSession(questsList);
    }
}
