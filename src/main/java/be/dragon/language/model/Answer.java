package be.dragon.language.model;

public class Answer implements Comparable<Answer> {
    public Answer() {
    }

    public Answer(Quest quest) {
        this.quest = quest;
    }

    private Quest quest;
    private String response;

    public String getResponse() {
        return response;
    }

    public Quest getQuest() {
        return quest;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public boolean pass(){
        return quest.getAnswer().equalsIgnoreCase(response);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Answer)) return false;

        Answer answer = (Answer) o;

        return quest != null ? quest.equals(answer.quest) : answer.quest == null;
    }

    @Override
    public int hashCode() {
        return quest != null ? quest.hashCode() : 0;
    }

    @Override
    public int compareTo(Answer o) {
        if(this.quest.getId()==o.quest.getId()){
            return 0;
        }
        else if(this.quest.getId() < o.quest.getId()){
            return 1;
        }
        else{
            return -1;
        }
    }
}
