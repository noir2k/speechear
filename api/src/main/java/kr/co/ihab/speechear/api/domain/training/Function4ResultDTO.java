package kr.co.ihab.speechear.api.domain.training;

import kr.co.ihab.speechear.persistence.jooq.tables.pojos.Function4;
import lombok.Data;

import java.util.List;

@Data
public class Function4ResultDTO {
    private List<Function4> results;
}
