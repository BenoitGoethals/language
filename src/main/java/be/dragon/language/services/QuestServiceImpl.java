package be.dragon.language.services;

import be.dragon.language.model.Quest;
import be.dragon.language.repositorys.QuestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
        return (List<Quest>) questRepository.findAll();
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
}
