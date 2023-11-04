package kr.co.ihab.speechear.api.domain.training;

import jakarta.transaction.Transactional;
import kr.co.ihab.speechear.api.enums.ChapterPart2;
import kr.co.ihab.speechear.api.enums.ChapterPart3;
import kr.co.ihab.speechear.api.enums.ChapterPart4;
import kr.co.ihab.speechear.api.interfaces.TrainingChapter;
import kr.co.ihab.speechear.persistence.jooq.tables.pojos.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Table;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static kr.co.ihab.speechear.persistence.jooq.tables.Function1.FUNCTION1;
import static kr.co.ihab.speechear.persistence.jooq.tables.Function2.FUNCTION2;
import static kr.co.ihab.speechear.persistence.jooq.tables.Function3_1.FUNCTION3_1;
import static kr.co.ihab.speechear.persistence.jooq.tables.Function3_2.FUNCTION3_2;
import static kr.co.ihab.speechear.persistence.jooq.tables.Function4.FUNCTION4;
import static kr.co.ihab.speechear.persistence.jooq.tables.Function5_1.FUNCTION5_1;
import static kr.co.ihab.speechear.persistence.jooq.tables.Function5_2.FUNCTION5_2;
import static org.jooq.impl.DSL.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class TrainingService {
    private final DSLContext dslContext;

    public int getTableCount(Table<?> table, Condition cond) {
        Long totalCount = dslContext.selectCount()
                .from(table)
                .where(cond)
                .fetchOneInto(Long.class);
        totalCount = Optional.ofNullable(totalCount).orElse(0L);
        return totalCount.intValue();
    }

    public int adjustOffset(int page, int limit, int totalCount, int lastOffset) {
        int offset = (page - 1) * limit;
        if (offset >= totalCount) {
            return lastOffset;
        }

        return offset;
    }

    @Transactional
    public FunctionListDTO<String, Function1ResultDTO> getList1(int page) {
        page = Math.max(page, 1);

        int itemCount = 10;
        int pageCount = 10;

        int totalCount = getTableCount(FUNCTION1, noCondition());
        int lastOffset = totalCount - (totalCount % itemCount);
//        int totalPage = (totalCount / pageCount) + (totalCount % pageCount > 0 ? 1 : 0);

        int limit = itemCount * pageCount;
        int offset = (page - 1) * limit;
        int rowNumStart = (page - 1) * pageCount + 1;
        int totalPage = lastOffset / limit;
        if (lastOffset % limit > 0) {
            totalPage++;
        }

        FunctionListDTO<String, Function1ResultDTO> dto = new FunctionListDTO<>();
        dto.setTotalPage(totalPage);
        dto.setCurrentPage(page);

        List<Function1> funclist = new ArrayList<>();
        AtomicInteger rowNum = new AtomicInteger(rowNumStart);
        Map<String, Function1ResultDTO> map = new HashMap<>();

        dslContext
                .select(FUNCTION1.fields())
                .from(FUNCTION1)
                .offset(offset)
                .limit(limit)
                .fetchStream()
                .forEach((record) -> {
                    funclist.add(record.into(FUNCTION1).into(Function1.class));
                    if (funclist.size() == itemCount) {
                        Function1ResultDTO fDto = new Function1ResultDTO();
                        fDto.setResults(funclist.stream().toList());
                        map.put(String.valueOf(rowNum), fDto);
                        rowNum.getAndIncrement();
                        funclist.clear();
                    }
                });

        dto.setRows(map);

        return dto;
    }

    @Transactional
    public FunctionListDTO<String, Function2ResultDTO> getList2(int page, String type) {
        page = Math.max(page, 1);

        int itemCount = 5;
        int pageCount = 10;

        Condition cond = noCondition();
        ChapterPart2 _type = ChapterPart2.findByType(type.toLowerCase());

        if (_type != null) {
            for (String code : _type.getCodes()) {
                cond = cond.or(FUNCTION2.SPEECHCODE.like(code + "%"));
            }
        }

        int totalCount = getTableCount(FUNCTION2, cond);
        int lastOffset = totalCount - (totalCount % itemCount);
//        int totalPage = (totalCount / pageCount) + (totalCount % pageCount > 0 ? 1 : 0);

        int limit = itemCount * pageCount;
        int offset = (page - 1) * limit;
        int rowNumStart = (page - 1) * pageCount + 1;
        int totalPage = lastOffset / limit;
        if (lastOffset % limit > 0) {
            totalPage++;
        }

        FunctionListDTO<String, Function2ResultDTO> dto = new FunctionListDTO<>();
        dto.setTotalPage(totalPage);
        dto.setCurrentPage(page);

        List<Function2> funclist = new ArrayList<>();
        AtomicInteger rowNum = new AtomicInteger(rowNumStart);
        Map<String, Function2ResultDTO> map = new HashMap<>();

        dslContext
                .select(FUNCTION2.fields())
                .from(FUNCTION2)
                .where(cond)
                .offset(offset)
                .limit(limit)
                .fetchStream()
                .forEach((record) -> {
                    funclist.add(record.into(FUNCTION2).into(Function2.class));
                    if (funclist.size() == itemCount) {
                        Function2ResultDTO fDto = new Function2ResultDTO();
                        fDto.setResults(funclist.stream().toList());
                        map.put(String.valueOf(rowNum), fDto);
                        rowNum.getAndIncrement();
                        funclist.clear();
                    }
                });

        dto.setRows(map);

        return dto;
    }

    @Transactional
    public FunctionListDTO<String, Function3ResultDTO> getList3(int page, String type) {
        page = Math.max(page, 1);

        int itemCount = 10;
        int pageCount = 10;

        Condition cond = noCondition();
        ChapterPart3 _type = ChapterPart3.findByType(type.toLowerCase());

        if (_type != null) {
            for (String code : _type.getCodes()) {
                cond = cond.or(FUNCTION3_2.SPEECHCODE.like(code + "%"));
            }
        }

        int totalCount = getTableCount(FUNCTION3_2, cond);
        int lastOffset = totalCount - (totalCount % itemCount);
//        int totalPage = (totalCount / pageCount) + (totalCount % pageCount > 0 ? 1 : 0);

        int limit = itemCount * pageCount;
        int offset = (page - 1) * limit;
        int rowNumStart = (page - 1) * pageCount + 1;
        int totalPage = lastOffset / limit;
        if (lastOffset % limit > 0) {
            totalPage++;
        }

        FunctionListDTO<String, Function3ResultDTO> dto = new FunctionListDTO<>();
        dto.setTotalPage(totalPage);
        dto.setCurrentPage(page);

        List<Function3_2> funclist = new ArrayList<>();
        AtomicInteger rowNum = new AtomicInteger(rowNumStart);
        Map<String, Function3ResultDTO> map = new HashMap<>();

        dslContext
                .select(FUNCTION3_2.fields())
                .from(FUNCTION3_2)
                .where(cond)
                .offset(offset)
                .limit(limit)
                .fetchStream()
                .forEach(record -> {
                    funclist.add(record.into(FUNCTION3_2).into(Function3_2.class));
                    // single results
                    Function3ResultDTO fDto = new Function3ResultDTO();
                    fDto.setResults(funclist.stream().toList());
                    map.put(String.valueOf(rowNum), fDto);
                    rowNum.getAndIncrement();
                    funclist.clear();
                });

        dto.setRows(map);

        return dto;
    }

    @Transactional
    public Function3ItemResultDTO getItem3(String speechCode) {
        Condition cond = FUNCTION3_2.SPEECHCODE.eq(speechCode);

        Function3ItemResultDTO qDto = new Function3ItemResultDTO();
        qDto.setQaModels(new ArrayList<>());

        dslContext
                .select(FUNCTION3_2.fields())
                .select(FUNCTION3_1.fields())
                .from(FUNCTION3_2)
                .leftJoin(FUNCTION3_1)
                .on(FUNCTION3_1.SPEECHCODE.eq(FUNCTION3_2.SPEECHCODE))
                .where(cond)
                .fetchStream()
                .forEach(record -> {
                    Function3_2 func32 = record.into(FUNCTION3_2).into(Function3_2.class);
                    Function3_1 func31 = record.into(FUNCTION3_1).into(Function3_1.class);

                    if (qDto.getSpeechModel() == null) {
                        qDto.setSpeechModel(func32);
                    }

                    if (func31 != null ) {
                        qDto.getQaModels().add(func31);
                    }
                });

        return qDto;
    }

    @Transactional
    public FunctionListDTO<String, Function4GroupResultDTO> getList4(int page, String type) {
        page = Math.max(page, 1);

        int itemCount = 5;
        int pageCount = 10;

        String code = "";
        Condition cond = noCondition();
        ChapterPart4 _type = ChapterPart4.findByType(type.toLowerCase());

        if (_type != null) {
            code = _type.getCodes().get(0);
            cond = cond.or(FUNCTION4.FILENAME.like("%" + code));
        }

        Integer totalCount = dslContext
                .selectCount()
                .from(
                    dslContext.select(FUNCTION4.INDEX)
                            .from(FUNCTION4)
                            .where(cond)
                            .groupBy(FUNCTION4.INDEX)
                            .having(count(FUNCTION4.FILENAME).eq(Integer.parseInt(code)))
                )
                .fetchOneInto(Integer.class);
        totalCount = Optional.ofNullable(totalCount).orElse(0);

        int lastOffset = totalCount - (totalCount % itemCount);
//        int totalPage = (totalCount / pageCount) + (totalCount % pageCount > 0 ? 1 : 0);

        int limit = itemCount * pageCount;
        int offset = (page - 1) * limit;
        int rowNumStart = (page - 1) * pageCount + 1;
        int totalPage = lastOffset / limit;
        if (lastOffset % limit > 0) {
            totalPage++;
        }

        FunctionListDTO<String, Function4GroupResultDTO> dto = new FunctionListDTO<>();
        dto.setTotalPage(totalPage);
        dto.setCurrentPage(page);

        List<String> funclist = new ArrayList<>();
        AtomicInteger rowNum = new AtomicInteger(rowNumStart);
        Map<String, Function4GroupResultDTO> map = new HashMap<>();

        dslContext
                .select(FUNCTION4.INDEX)
                .from(FUNCTION4)
                .where(cond)
                .groupBy(FUNCTION4.INDEX)
                .having(count(FUNCTION4.FILENAME).eq(Integer.parseInt(code)))
                .orderBy(FUNCTION4.INDEX.asc())
                .offset(offset)
                .limit(limit)
                .fetchStream()
                .forEach((record) -> {
                    funclist.add(record.into(FUNCTION4.INDEX).into(String.class));
                    if (funclist.size() == itemCount) {
                        Function4GroupResultDTO fDto = new Function4GroupResultDTO();
                        fDto.setResults(funclist.stream().toList());
                        map.put(String.valueOf(rowNum), fDto);
                        rowNum.getAndIncrement();
                        funclist.clear();
                    }
                });

        dto.setRows(map);

        return dto;
    }

    @Transactional
    public FunctionListDTO<String, Function4ResultDTO> getItem4(Function4GroupResultDTO item, String type) {
        int page = 1;

        String code = "";
        ChapterPart4 _type = ChapterPart4.findByType(type.toLowerCase());

        if (_type != null) {
            code = _type.getCodes().get(0);
        }

        int itemCount = Integer.parseInt(code);
        int pageCount = 10;
        Condition cond = noCondition();
        if (item.getResults() != null && item.getResults().size() > 0) {
            for (String r : item.getResults()) {
                cond = cond.or(FUNCTION4.INDEX.eq(r));
            }
        }

        int totalCount = getTableCount(FUNCTION4, cond);
        int lastOffset = totalCount - (totalCount % itemCount);
//        int totalPage = (totalCount / pageCount) + (totalCount % pageCount > 0 ? 1 : 0);

        int limit = itemCount * pageCount;
        int offset = (page - 1) * limit;
        int rowNumStart = (page - 1) * pageCount + 1;
        int totalPage = lastOffset / limit;
        if (lastOffset % limit > 0) {
            totalPage++;
        };

        FunctionListDTO<String, Function4ResultDTO> dto = new FunctionListDTO<>();
        dto.setTotalPage(totalPage);
        dto.setCurrentPage(page);

        List<Function4> funclist = new ArrayList<>();
        AtomicInteger rowNum = new AtomicInteger(rowNumStart);
        Map<String, Function4ResultDTO> map = new HashMap<>();

        dslContext
                .select(FUNCTION4.fields())
                .from(FUNCTION4)
                .where(cond)
                .offset(offset)
                .limit(limit)
                .fetchStream()
                .forEach(record -> {
                    funclist.add(record.into(FUNCTION4).into(Function4.class));
                    if (funclist.size() == itemCount) {
                        Function4ResultDTO fDto = new Function4ResultDTO();
                        fDto.setResults(funclist.stream().toList());
                        map.put(String.valueOf(rowNum), fDto);
                        rowNum.getAndIncrement();
                        funclist.clear();
                    }
                });

        dto.setRows(map);

        return dto;
    }

    @Transactional
    public FunctionListDTO<String, Function5ResultDTO> getList5(int page) {
        page = Math.max(page, 1);

        int itemCount = 1;
        int pageCount = 50;

        int totalCount = getTableCount(FUNCTION5_1, noCondition());
        int lastOffset = totalCount - (totalCount % itemCount);
//        int totalPage = (totalCount / pageCount) + (totalCount % pageCount > 0 ? 1 : 0);

        int limit = itemCount * pageCount;
        int offset = (page - 1) * limit;
        int rowNumStart = (page - 1) * pageCount + 1;
        int totalPage = lastOffset / limit;
        if (lastOffset % limit > 0) {
            totalPage++;
        }

        FunctionListDTO<String, Function5ResultDTO> dto = new FunctionListDTO<>();
        dto.setTotalPage(totalPage);
        dto.setCurrentPage(page);

        List<Function5_1> funclist = new ArrayList<>();
        AtomicInteger rowNum = new AtomicInteger(rowNumStart);
        Map<String, Function5ResultDTO> map = new HashMap<>();

        dslContext
                .select(FUNCTION5_1.fields())
                .from(FUNCTION5_1)
                .offset(offset)
                .limit(limit)
                .fetchStream()
                .forEach((record) -> {
                    funclist.add(record.into(FUNCTION5_1).into(Function5_1.class));
                    // single results
                    Function5ResultDTO fDto = new Function5ResultDTO();
                    fDto.setResults(funclist.stream().toList());
                    map.put(String.valueOf(rowNum), fDto);
                    rowNum.getAndIncrement();
                    funclist.clear();
                });

        dto.setRows(map);

        return dto;
    }

    @Transactional
    public FunctionListDTO<String, Function5HintResultDTO> getItem5(int hintIndex) {
        Condition cond = FUNCTION5_2.FILENAME.like(hintIndex + "-%");

        FunctionListDTO<String, Function5HintResultDTO> dto = new FunctionListDTO<>();
        dto.setTotalPage(0);
        dto.setCurrentPage(0);

        List<Function5_2> funclist = new ArrayList<>();
        Map<String, Function5HintResultDTO> map = new HashMap<>();

        dslContext
                .select(FUNCTION5_2.fields())
                .from(FUNCTION5_2)
                .where(cond)
                .fetchStream()
                .forEach((record) -> funclist.add(record.into(FUNCTION5_2).into(Function5_2.class)));

        Function5HintResultDTO fDto = new Function5HintResultDTO();
        fDto.setResults(funclist.stream().toList());
        map.put(String.valueOf(0), fDto);

        dto.setRows(map);

        return dto;
    }

    public List<ChapterResultDTO> chapter(List<TrainingChapter> list) {
        return list.stream().map(r -> new ChapterResultDTO(r.getCodes(), r.getType(), r.getTitle())).toList();
    }
}
