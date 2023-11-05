package kr.co.ihab.speechear.api.domain;

public class RequestMappings {
    public static final String API = "/api";
    public static final String AUTH = API + "/auth";
    public static final String SIGNIN = AUTH + "/signin";
    public static final String SIGNUP = AUTH + "/signup";
    public static final String USER = API + "/user";
    public static final String TRAINING = API + "/training";
    public static final String PART_1 = TRAINING + "/part1";
    public static final String CHAPTER_1 = PART_1 + "/chapter";
    public static final String LIST_1 = PART_1 + "/page/{page}";
    public static final String PART_2 = TRAINING + "/part2";
    public static final String CHAPTER_2 = PART_2 + "/chapter";
    public static final String LIST_2 = CHAPTER_2 + "/{chapter}/page/{page}";
    public static final String PART_3 = TRAINING + "/part3";
    public static final String CHAPTER_3 = PART_3 + "/chapter";
    public static final String LIST_3 = CHAPTER_3 + "/{chapter}/page/{page}";
    public static final String ITEM_3 = PART_3 + "/code/{code}";
    public static final String PART_4 = TRAINING + "/part4";
    public static final String CHAPTER_4 = PART_4 + "/chapter";
    public static final String LIST_4 = CHAPTER_4 + "/{chapter}/page/{page}";
    public static final String ITEM_4 = CHAPTER_4 + "/{chapter}/item";
    public static final String PART_5 = TRAINING + "/part5";
    public static final String LIST_5 = PART_5 + "/page/{page}";
    public static final String ITEM_5 = PART_5 + "/item/{item}";
}
