package be.dragon.language.integrationTests.services;

import be.dragon.language.model.Quest;

import java.util.List;

public interface QuestService {

    Quest addQuest(Quest quest);

    void deleteQuest(Quest quest);

    List<Quest> allQuests();

    void updateQuest(Quest quest);

    void deleteAll();

    Quest getQuest(Long i);

    List<Quest> quests();

    Long countQuest();

    Quest random();
}
