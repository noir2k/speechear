package kr.co.ihab.speechear.api.domain.training;

import kr.co.ihab.speechear.persistence.jooq.tables.pojos.Function2;
import lombok.Data;

import java.util.List;

@Data
public class Function2ResultDTO {
    private List<Function2> results;
}
