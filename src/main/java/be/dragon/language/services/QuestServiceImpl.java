package be.dragon.language.services;

import be.dragon.language.model.Quest;
import be.dragon.language.repositorys.QuestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("questService")
@Transactional
public class QuestServiceImpl implements QuestService {

    public static final Logger logger = LoggerFactory.getLogger(QuestServiceImpl.class);


    @Autowired
    private QuestRepository questRepository;

    public QuestServiceImpl(QuestRepository questRepository) {
        this.questRepository=questRepository;
    }


    @Override
    public Quest addQuest(Quest quest) {
       logger.info("add "+quest);
       return questRepository.save(quest);
    }

    @Override
    public void deleteQuest(Quest quest) {
        logger.info("delete "+quest);
        questRepository.delete(quest);
    }

    @Override
    public List<Quest> allQuests() {
        return questRepository.findAll();
    }

    @Override
    public void updateQuest(Quest quest) {
        logger.info("add "+quest);
         questRepository.save(quest);
    }

    @Override
    public void deleteAll() {
        questRepository.deleteAll();
    }

    @Override
    public Quest getQuest(Long i) {
        return questRepository.findOne(i);
    }


    @Override
    public List<Quest> quests(){
        return questRepository.findAll();
    }

    @Override
    public Long countQuest() {
        return questRepository.count();
    }

    @Override
    public Quest random() {
        Long qty=questRepository.count();

        int idx = (int)(Math.random() * qty);
        Page<Quest> questionPage = questRepository.findAll(new PageRequest(idx, 1));
        Quest q = null;
        if (questionPage.hasContent()) {
            q = questionPage.getContent().get(0);
        }
        return q;
    }
}
