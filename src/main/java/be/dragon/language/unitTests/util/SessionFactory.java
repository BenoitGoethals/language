package be.dragon.language.unitTests.util;

import be.dragon.language.model.Quest;
import be.dragon.language.model.Session;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class SessionFactory {

    public SessionFactory() {
    }

    public Session createQuestSession(Set<Quest> quests){

        Session session=new Session(quests);
        return session;
    }




}
