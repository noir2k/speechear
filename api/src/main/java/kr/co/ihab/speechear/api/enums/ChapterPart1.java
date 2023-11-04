package kr.co.ihab.speechear.api.enums;

import kr.co.ihab.speechear.api.interfaces.TrainingChapter;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ChapterPart1 implements TrainingChapter {
    SPORT("sport", "스포츠", List.of("A")),
    WEATHER("weather", "날씨", List.of("B")),
    FOOD("food", "음식", List.of("C")),
    HEALTH("health", "건강", List.of("D")),
    PERSON("person", "인물", List.of("E")),
    LOCATION("location", "장소", List.of("F")),
    KOREA("korea", "한국", List.of("G")),
    NATURE("nature", "자연", List.of("H")),
    ETC("etc", "기타", List.of("I")),
    ;

    private final String type;
    private final String title;
    private final List<String> codes;

    ChapterPart1(String type, String title, List<String> codes) {
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

    private static final Map<String, ChapterPart1> TYPE_MAP =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(ChapterPart1::getType, Function.identity())));

    public static ChapterPart1 findByType(String type) {
        if (TYPE_MAP.containsKey(type)) {
            return TYPE_MAP.get(type);
        }
        throw new IllegalArgumentException("Invalid type: " + type);
    }
}