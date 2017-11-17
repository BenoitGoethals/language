package be.dragon.language.model;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;


public class Session {
    public Session() {
    }

    private Set<Answer> answers=new TreeSet<>();
    public Session(Set<Quest> quests) {
        quests.stream().forEach(x -> answers.add(new Answer(x)));

    }

    public Set<Answer> getAnswers() {
        return answers;
    }

    public List<Answer> getBad(){
        return answers.stream().filter(x->!x.pass()).collect(Collectors.toList());
    }

    public List<Answer> getPass(){
        return answers.stream().filter(x->x.pass()).collect(Collectors.toList());
    }

    public double getPrecentage(){
        return ((double)getPass().size()/(double)answers.size())*100.0;
    }

    public int countAnswer(){
        return answers.size();
    }

}
