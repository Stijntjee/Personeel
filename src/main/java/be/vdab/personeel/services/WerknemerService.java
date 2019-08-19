package be.vdab.personeel.services;

import be.vdab.personeel.domain.Jobtitel;
import be.vdab.personeel.domain.Werknemer;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface WerknemerService
{
    Optional<Werknemer> findBigBoss();
    Optional<Werknemer> findById(Long id);
    List<Werknemer> findByJobtitel(Jobtitel jobtitel);
    void update(Werknemer werknemer);
    void opslag(Long id, BigDecimal opslag);
    void wijzigRijksregisternr(long id, long rijksregisternr);
}
