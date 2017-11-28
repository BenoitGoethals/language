package be.dragon.language.repositorys;

import be.dragon.language.model.Category;
import be.dragon.language.model.Quest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public interface QuestRepository extends JpaRepository<Quest,Long> {

    /**
     * @param category
     * @return
     */
    List<Quest> findByCategory(Category category);

}
