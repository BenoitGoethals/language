package be.dragon.language.services;

import be.dragon.language.model.Quest;

import java.util.List;

public interface QuestService {

    public Quest addQuest(Quest quest);
    public void deleteQuest(Quest quest);
    public List<Quest> allQuests();
    public void updateQuest(Quest quest);

    void deleteAll();

    Quest getQuest(Long i);
}
