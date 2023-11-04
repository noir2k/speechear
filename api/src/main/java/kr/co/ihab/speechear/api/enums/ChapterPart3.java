package kr.co.ihab.speechear.api.enums;

import kr.co.ihab.speechear.api.interfaces.TrainingChapter;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ChapterPart3 implements TrainingChapter {
    COOK("cook", "요리", List.of("J")),
    ORIENT_CULTURE("orient_culture", "전통문화", List.of("K")),
    SPORT("sport", "스포츠", List.of("L")),
    PARTY("party", "세계의 잔치", List.of("M")),
    PROVERB("proverb", "속담", List.of("N")),
    LOCATION("location", "지역", List.of("O")),
    HERITAGE("heritage", "세계유산", List.of("P")),
    NATION("nation", "나라", List.of("Q")),
    HEALTH("health", "건강", List.of("R")),
    PERSON("person", "인물", List.of("S")),
    ETC("etc", "기타", List.of("T")),
    ;

    private final String type;
    private final String title;
    private final List<String> codes;

    ChapterPart3(String type, String title, List<String> codes) {
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

    private static final Map<String, ChapterPart3> TYPE_MAP =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(ChapterPart3::getType, Function.identity())));

    public static ChapterPart3 findByType(String type) {
        if (TYPE_MAP.containsKey(type)) {
            return TYPE_MAP.get(type);
        }
        throw new IllegalArgumentException("Invalid type: " + type);
    }
}