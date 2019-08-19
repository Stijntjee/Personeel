package be.vdab.personeel.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class RijksregisterNummerValidator  implements ConstraintValidator<RijksregisterNummer, Long>
{
    @Override
    public void initialize(RijksregisterNummer constraintAnnotation) {

    }

    @Override
    public boolean isValid(Long nummer, ConstraintValidatorContext constraintValidatorContext)
    {
        /*
        long jaar = nummer / 1000000000;
        long maand = (nummer / 10000000) % 100;
        long dag = (nummer / 100000) % 10000;

        long controlegetal = nummer % 100;
        long controlgetal2 = (97 - (nummer / 1000000000)) % 97;

        if (jaar >= 1000 && jaar <= LocalDate.now().getYear() && maand <= 12 && maand >= 1 && dag >= 0 && dag <= 31) {
            return (jaar < 2000 && nummer % 100 == (97 - (nummer / 1000000000)) % 97 || jaar >= 2000 && nummer % 100 == (97 - (nummer / 1000000000) + 2000000000000L) % 97);
        }*/
        return true;
    }

}
