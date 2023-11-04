package kr.co.ihab.speechear.api.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Random;
@Slf4j
@Service
@RequiredArgsConstructor
public class AudioInfoService {
    private final DSLContext dslContext;

    @Value("${speechear.static-url}")
    private String staticUrl;
    static final String FUNC1 = "function1";
    static final String FUNC4 = "function4";
    static final String FUNC4_2 = "function4_2";
    static final String FUNC5 = "function5";

//    private final UserSettingDao usdao;
//
//    private final Function1Dao func1Dao;
//
//    private final Function2Dao func2Dao;
//
//    private final Function3Dao func3Dao;
//
//    private final Function4Dao func4Dao;
//
//    private final Function5Dao func5Dao;

    public static String getRandomNumber() {
        Random random = new Random();
        int randomNum = random.nextInt(10) + 1;
        return randomNum < 10 ? "0" + randomNum : Integer.toString(randomNum);
    }

    // for func1
//    public List<Function1Dto> getAudioInfo(Function1Dto dto, String user_id) {
//        return new ArrayList<>();
//        List<Function1Dto> result = func1Dao.getAudioInfo(dto);
//        return new ArrayList<>();
//
//        for (Function1Dto r : result) {
//            r.setAudio(getAudioFileUrl(r.getFilename(), FUNC1));
//        }
//
//        String getNoiseName = usdao.getUS(user_id).getNoise_type();
//        switch(getNoiseName){
//            case "기본" :
//                result.add(getNoise("noise1"));
//                break;
//            case "길거리" :
//                for(int i = 1; i <= 10; i++) {
//                    String fileNum = i < 10 ? "0" + i : Integer.toString(i);
//                    result.add(getNoise("noise2-" + fileNum));
//                }
//                break;
//            case "식당" :
//                for(int i = 1; i <= 10; i++) {
//                    String fileNum = i < 10 ? "0" + i : Integer.toString(i);
//                    result.add(getNoise("noise3-" + fileNum));
//                }
//                break;
//            case "와글와글" :
//                result.add(getNoise("noise4"));
//                break;
//        }
//
//        return result;
//    }

//    private Function1Dto getNoise(String noiseFileName) {
//        return new Function1Dto();
//        Function1Dto noise = new Function1Dto();
//        noise.setFilename(noiseFileName);
//        noise.setContext(null);
//        noise.setAudio(getAudioFileUrl(noiseFileName, FUNC1));
//        return noise;
//    }

    // for func2
//    public List<Function2Dto> getAudioInfo(Function2Dto dto) {
//        return new ArrayList<>();
//        List<Function2Dto> result = func2Dao.getAudioInfo(dto);
//        for (Function2Dto function2Dto : result) {
//            try {
//                String sCode = staticUrl + "function2/" + function2Dto.getSpeechcode() + ".mp3";
//                String qCode = staticUrl + "function2/" + function2Dto.getQuestioncode() + ".mp3";
//                function2Dto.setSaudio(getAudioStr(sCode));
//                function2Dto.setQaudio(getAudioStr(qCode));
//            } catch (Exception e) {
//                e.printStackTrace();
//                throw new RuntimeException(e);
//            }
//        }
//
//        return result;
//    }

    // for func3
//    public List<Function3Dto> getAudioInfo(Function3Dto dto) {
//        return new ArrayList<>();
//        List<Function3Dto> result = func3Dao.getAudioInfo(dto);
//        for (Function3Dto function3Dto : result) {
//            try {
//                String code = staticUrl + "function3/" + function3Dto.getSpeechcode() + ".mp3";
//                String audio = getAudioStr(code);
//                function3Dto.setAudio(audio);
//            } catch (Exception e) {
//                e.printStackTrace();
//                throw new RuntimeException(e);
//            }
//        }
//
//        return result;
//    }

    // for func4
//    public List<Function4Dto> getAudioInfo(String index) {
//        return new ArrayList<>();
//        List<Function4Dto> data = func4Dao.getAudioInfo(index);
//
//        List<String> fileNames = new ArrayList<String>();
//        List<String> files = new ArrayList<String>();
//        try {
//            for(Function4Dto dto : data) {
//                String fName = dto.getFilename();
//                String code = staticUrl + FUNC4_2 + "/" + fName + ".mp3";
//                String audio = getAudioStr(code);
//                fileNames.add(fName);
//                files.add(audio);
//                dto.setFile(audio);
//            }
//
//            List<Function4Dto> result = new ArrayList<Function4Dto>();
//            Function4Dto dto = new Function4Dto();
//            dto.setIndex(index);
//            dto.setContext("merged");
//            String code = staticUrl + FUNC4 + "/" + index + ".mp3";
//            dto.setFile(getAudioStr(code));
//            dto.setFilename(index);
//            result.add(dto);
//
//            result.addAll(data);
//
//            return result;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

//    public List<Function4Dto> getFirstInfo(Function4Dto dto) {
//        return new ArrayList<>();
//        return func4Dao.getFirstInfo(dto);
//    }

//    public Function5Dto getAudioInfo(Function5Dto dto) {
//        return new Function5Dto();
//        Function5Dto result = func5Dao.loadFile(dto);
//
//        Map<String,String> temp = new HashMap<>();
//        List<String> audioName = func5Dao.getAudioList(dto);
//        List<String> audioFile = getAudioFileUrls(audioName.toArray(new String[0]), FUNC5);
//        for(int i = 0; i < audioName.size(); i++) {
//            temp.put(audioName.get(i), audioFile.get(i));
//        }
//        result.setAudio(temp);
//        result.setCnt(audioName.size() / 4);
//
//        return result;
//    }

    private String getAudioFileUrl(String filename, String filePath) {
        try {
            String file = staticUrl + filePath + "/" + filename + ".mp3";
            return getAudioStr(file);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    private List<String> getAudioFileUrls(String[] filename, String filePath) {
        List<String> result = new ArrayList<>();
        for(String str : filename) {
            result.add(getAudioFileUrl(str, filePath));
        }
        return result;
    }

    private String getAudioStr(String code) throws IOException {
        InputStream inputStream = new URL(code).openStream();
        byte[] fileArray = IOUtils.toByteArray(inputStream);
        String b64string = new String(Base64.getEncoder().encode(fileArray));
        return "data:audio/mp3;base64, " + b64string;
    }
}
