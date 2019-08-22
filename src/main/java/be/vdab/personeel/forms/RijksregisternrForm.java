package be.vdab.personeel.forms;

import be.vdab.personeel.constraints.RijksregisterNummer;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@RijksregisterNummer
public class RijksregisternrForm
{
    @NotNull
    private Long rijksregisternr;
    @NotNull
    private LocalDate geboorte;

    //CONSTRUCTORS
    public RijksregisternrForm(@NotNull Long rijksregisternr, @NotNull LocalDate geboorte)
    {
        this.rijksregisternr = rijksregisternr;
        this.geboorte = geboorte;
    }

    //GETTERS
    public LocalDate getGeboorte() {
        return geboorte;
    }

    public Long getRijksregisternr() {
        return rijksregisternr;
    }
}
