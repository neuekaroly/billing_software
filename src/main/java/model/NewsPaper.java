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
public class NewsPaper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Setter(AccessLevel.NONE)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "workinghour")
    private double workingHour;

    public NewsPaper(String name, double workingHour) {
        this.name = name;
        this.workingHour = workingHour;
    }

    @Override
    public String toString() {
        return "Name of the newspaper: " + name + " working hours: " + workingHour;
    }
}

