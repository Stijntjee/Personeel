package be.vdab.personeel.forms;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class OpslagForm
{
    @NotNull
    @Range(min = 1)
    private final BigDecimal opslag;

    //CONSTRUCTORS
    public OpslagForm(@NotNull @Range(min = 1) BigDecimal opslag) {
        this.opslag = opslag;
    }

    //GETTERS
    public BigDecimal getOpslag() {
        return opslag;
    }
}
