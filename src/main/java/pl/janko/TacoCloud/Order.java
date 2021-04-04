package pl.janko.TacoCloud;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class Order {
    @NotBlank(message="pole obowiazkowe !")
    private String name;
    @NotBlank(message = "pole obowiazkowe !")
    private String street;
    @NotBlank(message = "pole obowiazkowe !")
    private String city;
    @NotBlank(message = "pole obowiazkowe !")
    private String state;
    @NotBlank(message = "pole obowiazkowe !")
    private String zip;
    @CreditCardNumber(message = "bledny numer karty")
    private String ccNumber;
    //@Pattern(regexp = "^(0[1-9]1[0-2])([\\/])([1-9][0-9])$", message = "musi byc format MM/RR")
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0, message = "bledny kod CVV")
    private String ccCVV;
}
