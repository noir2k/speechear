package kr.co.ihab.speechear.api.domain.training;

import kr.co.ihab.speechear.api.domain.RequestMappings;
import kr.co.ihab.speechear.api.enums.ChapterPart1;
import kr.co.ihab.speechear.api.enums.ChapterPart2;
import kr.co.ihab.speechear.api.enums.ChapterPart3;
import kr.co.ihab.speechear.api.enums.ChapterPart4;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TrainingController {
    private final TrainingService trainingService;
    @GetMapping(value = "/ok")
    public ResponseEntity<String> ok() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping(value = RequestMappings.LIST_1)
    public ResponseEntity<FunctionListDTO<String, Function1ResultDTO>> List_1(
            @PathVariable("page") int page) {
        return new ResponseEntity<>(trainingService.getList1(page), HttpStatus.OK);
    }

    @GetMapping(value = RequestMappings.CHAPTER_1)
    public ResponseEntity<List<ChapterResultDTO>> Chapter_1() {
        List<ChapterResultDTO> results = trainingService.chapter(List.of(ChapterPart1.values()));
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @GetMapping(value = RequestMappings.LIST_2)
    public ResponseEntity<FunctionListDTO<String, Function2ResultDTO>> List_2(
            @PathVariable("page") int page,
            @PathVariable("chapter") String chapter) {
        return new ResponseEntity<>(trainingService.getList2(page, chapter), HttpStatus.OK);
    }

    @GetMapping(value = RequestMappings.CHAPTER_2)
    public ResponseEntity<List<ChapterResultDTO>> Chapter_2() {
        List<ChapterResultDTO> results = trainingService.chapter(List.of(ChapterPart2.values()));
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @GetMapping(value = RequestMappings.LIST_3)
    public ResponseEntity<FunctionListDTO<String, Function3ResultDTO>> List_3(
            @PathVariable("page") int page,
            @PathVariable("chapter") String chapter) {
        return new ResponseEntity<>(trainingService.getList3(page, chapter), HttpStatus.OK);
    }

    @GetMapping(value = RequestMappings.ITEM_3)
    public ResponseEntity<Function3ItemResultDTO> Item_3(
            @PathVariable("code") String speechCode) {
        return new ResponseEntity<>(trainingService.getItem3(speechCode), HttpStatus.OK);
    }

    @GetMapping(value = RequestMappings.CHAPTER_3)
    public ResponseEntity<List<ChapterResultDTO>> Chapter_3() {
        List<ChapterResultDTO> results = trainingService.chapter(List.of(ChapterPart3.values()));
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @GetMapping(value = RequestMappings.LIST_4)
    public ResponseEntity<FunctionListDTO<String, Function4GroupResultDTO>> List_4(
            @PathVariable("page") int page,
            @PathVariable("chapter") String chapter) {
        return new ResponseEntity<>(trainingService.getList4(page, chapter), HttpStatus.OK);
    }

    @PostMapping(value = RequestMappings.ITEM_4)
    public ResponseEntity<FunctionListDTO<String, Function4ResultDTO>> Item_4(
            @RequestBody Function4GroupResultDTO postData,
            @PathVariable("chapter") String chapter) {
        return new ResponseEntity<>(trainingService.getItem4(postData, chapter), HttpStatus.OK);
    }

    @GetMapping(value = RequestMappings.CHAPTER_4)
    public ResponseEntity<List<ChapterResultDTO>> Chapter_4() {
        List<ChapterResultDTO> results = trainingService.chapter(List.of(ChapterPart4.values()));
        return new ResponseEntity<>(results, HttpStatus.OK);
    }

    @GetMapping(value = RequestMappings.LIST_5)
    public ResponseEntity<FunctionListDTO<String, Function5ResultDTO>> List_5(
            @PathVariable("page") int page) {
        return new ResponseEntity<>(trainingService.getList5(page), HttpStatus.OK);
    }

    @GetMapping(value = RequestMappings.ITEM_5)
    public ResponseEntity<FunctionListDTO<String, Function5HintResultDTO>> Item_5(
            @PathVariable("item") int item) {
        return new ResponseEntity<>(trainingService.getItem5(item), HttpStatus.OK);
    }

//    @Autowired
//    private UserLogComponent userLogComponent;
//
//    @Autowired
//    private UserLogService userLogService;
//
//    @Autowired
//    private AudioInfoService audioInfoService;
//
//    @Autowired
//    private UserService uservice;
//
//    @Autowired
//    private UserActivityService uaservice;
//
//    @PostMapping(value = "/function/Function5/UserActivity")
//    @ResponseBody
//    public void UserActivity(@RequestBody String activity_time)
//    {
//        UserActivityDto dto = new UserActivityDto();
//        dto.setUser_id(userLogComponent.getAccess_Id());
//        dto.setActivity("Function5");
//        dto.setActivity_time(Double.parseDouble(activity_time));
//        uaservice.insertUserActivity(dto);
//    }

//    @RequestMapping(value = "/function/Function5")
//    public String home(Authentication authentication, Model model)
//    {
//        UserLogDto dto = new UserLogDto(
//                                    userLogComponent.getAccess_Id(),
//                                    userLogComponent.getAccess_ip(),
//                                    userLogComponent.getAccess_Time(),
//                                    userLogComponent.getAccess_role(),
//                                    userLogComponent.getAccess_URI());
//        userLogService.insertUserLog(dto);
//        List<String> memberInfo = new ArrayList<String>();
//        memberInfo.add(uservice.getMemberInfo(authentication.getName()).getName());
//        memberInfo.add(uservice.getMemberInfo(authentication.getName()).getCellphone());
//        model.addAttribute("member", memberInfo);
//
//        return "function/Function5.html";
//    }

//    @PostMapping(value = "/function/Function1/getAudioInfo")
//    @ResponseBody
//    public List<Function1Dto> getAudioInfo(Authentication authentication,Function1Dto dto)
//    {
//        return new ArrayList<>();
//        return audioInfoService.getAudioInfo(dto, authentication.getName());
//    }
}
