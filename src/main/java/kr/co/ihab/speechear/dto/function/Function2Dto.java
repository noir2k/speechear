package kr.co.ihab.speechear.dto.function;

import lombok.Data;

@Data
public class Function2Dto {
    private String speechcode;
    private String speechcontext;
    private String questioncode;
    private String questioncontext;
    private String answer;
    private String saudio;
    private String qaudio;
    private int chapter;
    private String category;
}
