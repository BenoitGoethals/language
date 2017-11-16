package be.dragon.language.model;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;


public class Session {
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

    public int getPrecentage(){
        return getPass().size()/answers.size()*100;
    }

    public int countAnswer(){
        return answers.size();
    }

}
