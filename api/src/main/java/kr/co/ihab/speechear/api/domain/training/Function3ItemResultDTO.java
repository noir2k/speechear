package kr.co.ihab.speechear.api.domain.training;

import kr.co.ihab.speechear.persistence.jooq.tables.pojos.Function3_1;
import kr.co.ihab.speechear.persistence.jooq.tables.pojos.Function3_2;
import lombok.Data;

import java.util.List;

@Data
public class Function3ItemResultDTO {
    private Function3_2 speechModel;
    private List<Function3_1> qaModels;
}
