package kr.co.ihab.speechear.api.domain.training;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ChapterResultDTO {
    private List<String> chapterCodes;
    private String chapterType;
    private String chapterTitle;
}
