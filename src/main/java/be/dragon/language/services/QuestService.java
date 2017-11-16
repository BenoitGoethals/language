package be.dragon.language.services;

import be.dragon.language.model.Quest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface QuestService {

    public Quest addQuest(Quest quest);
    public void deleteQuest(Quest quest);
    public List<Quest> allQuests();
    public void updateQuest(Quest quest);

    public void deleteAll();

    public Quest getQuest(Long i);

    public List<Quest> quests();

    public Long countQuest();

    public Quest random();
}
