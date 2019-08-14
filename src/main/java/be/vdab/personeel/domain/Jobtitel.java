package be.vdab.personeel.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "jobtitels")
public class Jobtitel implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String naam;
    @Version
    private long versie;

    @OneToMany(mappedBy = "jobtitel")
    private Set<Werknemer> werknemers;

    //CONSTRUCTORS

    //GETTERS
    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public long getVersie() {
        return versie;
    }

    public Set<Werknemer> getWerknemers() {
        return werknemers;
    }
}
