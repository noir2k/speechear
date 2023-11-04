package kr.co.ihab.speechear.api.enums;

import kr.co.ihab.speechear.api.interfaces.TrainingChapter;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ChapterPart2 implements TrainingChapter {
    LOCATION("location", "지역", List.of("S")),
    CULTURE("culture", "우리문화", List.of("T", "W")),
    FOOD("food", "음식", List.of("Q")),
    ETC("etc", "기타", List.of("Y")),
    ;

    private final String type;
    private final String title;
    private final List<String> codes;

    ChapterPart2(String type, String title, List<String> codes) {
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

    private static final Map<String, ChapterPart2> TYPE_MAP =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(ChapterPart2::getType, Function.identity())));

    public static ChapterPart2 findByType(String type) {
        if (TYPE_MAP.containsKey(type)) {
            return TYPE_MAP.get(type);
        }
        throw new IllegalArgumentException("Invalid type: " + type);
    }
}