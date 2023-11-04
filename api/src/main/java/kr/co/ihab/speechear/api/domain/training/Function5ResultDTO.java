package kr.co.ihab.speechear.api.domain.training;

import kr.co.ihab.speechear.persistence.jooq.tables.pojos.Function5_1;
import lombok.Data;

import java.util.List;

@Data
public class Function5ResultDTO {
    private List<Function5_1> results;
}
