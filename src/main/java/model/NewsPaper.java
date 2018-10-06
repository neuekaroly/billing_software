package model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "newspapers")
public class NewsPaper {
    public NewsPaper(String name, int workingHour) {
        this.name = name;
        this.workingHour = workingHour;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Setter(AccessLevel.NONE)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "workinghour")
    private int workingHour;
}
