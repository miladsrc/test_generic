package base.model;
import lombok.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BaseEntity <ID extends Serializable> {
    //serializable is just a marker interface

    private ID id;

}
