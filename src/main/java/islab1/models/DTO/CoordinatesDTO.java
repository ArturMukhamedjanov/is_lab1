package islab1.models.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoordinatesDTO {
    private Long id;
    private Integer creatorId;
    private Double x;
    private Long y;
}