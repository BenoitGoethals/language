package be.dragon.language.util;

import be.dragon.language.model.Quest;
import be.dragon.language.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

@Component
public class SessionFactory {



    public Session createQuestSession(Set<Quest> quests){

        Session session=new Session(quests);
        return session;
    }




}
