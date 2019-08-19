package be.vdab.personeel.forms;

import be.vdab.personeel.constraints.RijksregisterNummer;

import javax.validation.constraints.NotNull;

public class RijksregisternrForm
{
    @RijksregisterNummer
    private final Long rijksregisternr;

    //CONSTRUCTORS
    public RijksregisternrForm(@NotNull Long rijksregisternr)
    {
        this.rijksregisternr = rijksregisternr;
    }

    //GETTERS
    public Long getRijksregisternr() {
        return rijksregisternr;
    }
}
