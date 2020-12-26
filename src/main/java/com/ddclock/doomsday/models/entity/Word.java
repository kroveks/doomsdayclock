package com.ddclock.doomsday.models.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "word")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @Column
    private String value;

    @Column
    private String translationValue;

    @Column
    private String exampleSentence;

    @CreationTimestamp
    @Column(name = "persist_date", updatable = false)
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    private LocalDateTime persistDateTime;

    @ManyToMany(mappedBy = "words", fetch = FetchType.LAZY)
    private List<Dictionary> dictionaries;

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", translationValue='" + translationValue + '\'' +
                ", exampleSentence='" + exampleSentence + '\'' +
                ", persistDateTime=" + persistDateTime +
                '}';
    }
}
