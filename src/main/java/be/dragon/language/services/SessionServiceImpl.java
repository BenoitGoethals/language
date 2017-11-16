package be.dragon.language.services;

import be.dragon.language.model.Quest;
import be.dragon.language.model.Session;

import be.dragon.language.util.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private QuestService questService;

    @Override
    public Session getSession(int quests) {
        Set<Quest> questsList=new TreeSet<>();


        int i=0;
        while (i<=quests){
            Quest retrieveQuest=questService.random();
            if(!questsList.contains(retrieveQuest)){
                questsList.add(retrieveQuest);
                ++i;
            }

        }


        return sessionFactory.createQuestSession(questsList);
    }
}
