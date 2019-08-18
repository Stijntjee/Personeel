package be.vdab.personeel.services;

import be.vdab.personeel.domain.Jobtitel;
import be.vdab.personeel.domain.Werknemer;

import java.util.List;
import java.util.Optional;

public interface WerknemerService
{
    Optional<Werknemer> findBigBoss();
    List<Werknemer> findByJobtitel(Jobtitel jobtitel);
}
