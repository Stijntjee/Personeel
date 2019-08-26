package be.vdab.personeel.constraints;

import be.vdab.personeel.forms.RijksregisternrForm;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class RijksregisterNummerValidator implements ConstraintValidator<RijksregisterNummer, RijksregisternrForm>
{
    @Override
    public void initialize(RijksregisterNummer constraintAnnotation) {

    }

    @Override
    public boolean isValid(RijksregisternrForm rijksregisternrForm, ConstraintValidatorContext constraintValidatorContext) {
        Long nummer = rijksregisternrForm.getRijksregisternr();
        LocalDate geboorte = rijksregisternrForm.getGeboorte();

        if (nummer != null && geboorte != null)
        {
            long controlegetal = nummer / 100;
            boolean jaar = (geboorte.getYear() % 100) == (nummer / 1000000000);
            boolean maand =(geboorte.getMonthValue()) == (nummer / 10000000 % 100);
            boolean dag = (geboorte.getDayOfMonth()) == (nummer / 100000 % 100);

            if (jaar && maand && dag)
            {
                return (nummer % 100 == (97 - controlegetal % 97));
            }
        }
        return false;
    }
}
