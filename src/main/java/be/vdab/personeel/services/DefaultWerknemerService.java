package be.vdab.personeel.services;

import be.vdab.personeel.domain.Werknemer;
import be.vdab.personeel.repositories.WerknemerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
public class DefaultWerknemerService implements WerknemerService
{
    private final WerknemerRepository werknemerRepository;

    //CONSTRUCTORS
    DefaultWerknemerService(WerknemerRepository werknemerRepository)
    {
        this.werknemerRepository = werknemerRepository;
    }
    //METHODS
    @Override
    public Optional<Werknemer> findBigBoss() {
        return werknemerRepository.findByChefIsNull();
    }
}
