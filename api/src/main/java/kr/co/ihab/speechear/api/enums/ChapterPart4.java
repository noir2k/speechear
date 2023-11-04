package kr.co.ihab.speechear.api.enums;

import kr.co.ihab.speechear.api.interfaces.TrainingChapter;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ChapterPart4 implements TrainingChapter {
    WORD3("word3", "3문장 세트", List.of("3")),
    WORD4("word4", "4문장 세트", List.of("4")),
    WORD5("word5", "5문장 세트", List.of("5")),
    ;

    private final String type;
    private final String title;
    private final List<String> codes;

    ChapterPart4(String type, String title, List<String> codes) {
        this.type = type;
        this.title = title;
        this.codes = codes;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<String> getCodes() {
        return codes;
    }

    private static final Map<String, ChapterPart4> TYPE_MAP =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(ChapterPart4::getType, Function.identity())));

    public static ChapterPart4 findByType(String type) {
        if (TYPE_MAP.containsKey(type)) {
            return TYPE_MAP.get(type);
        }
        throw new IllegalArgumentException("Invalid type: " + type);
    }
}