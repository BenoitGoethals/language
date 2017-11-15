package be.dragon.language.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Questions")
public class Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "question",unique = true,nullable = false)
    @NotNull
    private String question;
    @Column(name = "answer",nullable = false)
    @NotNull
    private String answer;
    @Column(name = "image")
    @Lob
    private byte[] image;
    @NotNull
    @Column(name = "category",nullable = false)
    @Enumerated(value = EnumType.ORDINAL)
    private Category category;

    public Quest() {
    }

    public Quest(String question, String answer, byte[] image, Category category) {
        this.question = question;
        this.answer = answer;
        this.image = image;
        this.category = category;
    }

    public Long  getId() {
        return id;
    }

    public void setId(Long  id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quest quest = (Quest) o;

        return id != null ? id.equals(quest.id) : quest.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }



    @Override
    public String toString() {
        return "Quest{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", category=" + category +
                '}';
    }
}
