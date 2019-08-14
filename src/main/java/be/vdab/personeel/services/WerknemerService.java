package be.vdab.personeel.services;

import be.vdab.personeel.domain.Werknemer;

import java.util.Optional;

public interface WerknemerService
{
    Optional<Werknemer> findBigBoss();
}
