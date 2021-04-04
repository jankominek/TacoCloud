package pl.janko.TacoCloud;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
@Data
public class Taco {

    private Long id;
    private Date createdAt;

    @NotNull
    @Size(min = 5, message = "minimum 5 znakow")
    private String name;
    @Size(min = 1, message = "minimum 1 skladnik")
    private List<String> ingredients;
}
