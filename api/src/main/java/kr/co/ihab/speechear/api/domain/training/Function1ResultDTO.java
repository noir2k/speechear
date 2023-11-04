package kr.co.ihab.speechear.api.domain.training;

import kr.co.ihab.speechear.persistence.jooq.tables.pojos.Function1;
import lombok.Data;

import java.util.List;

@Data
public class Function1ResultDTO {
    private List<Function1> results;
}
