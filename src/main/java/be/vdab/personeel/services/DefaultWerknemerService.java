package be.vdab.personeel.services;

import be.vdab.personeel.domain.Jobtitel;
import be.vdab.personeel.domain.Werknemer;
import be.vdab.personeel.repositories.WerknemerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
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

    @Override
    public List<Werknemer> findByJobtitel(Jobtitel jobtitel) {
        return werknemerRepository.findByJobtitel(jobtitel);
    }

    @Override
    public void update(Werknemer werknemer) {
        werknemerRepository.save(werknemer);
    }

    @Override
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
    public void opslag(Long id, BigDecimal opslag) {
        werknemerRepository.findById(id).ifPresent(werknemer -> werknemer.opslag(opslag));
    }

    @Override
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
    public void wijzigRijksregisternr(long id, long rijksregisternr) {
        werknemerRepository.findById(id).ifPresent(werknemer -> werknemer.setRijksregisternr(rijksregisternr));
    }

    @Override
    public Optional<Werknemer> findById(Long id) {
        return werknemerRepository.findById(id);
    }

}
