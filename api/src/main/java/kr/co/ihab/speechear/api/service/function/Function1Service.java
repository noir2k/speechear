package kr.co.ihab.speechear.api.service.function;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Function1Service {
//    // private static final String host = "192.168.35.244";
//    private static final String host = "localhost";
//    private static final String userName = "dragonseller_ftp";
//    private static final String password = "DragonSeller*";
//    private static final int port = 39540;
//
//    @Autowired
//    private Function1Dao dao;
//
//    @Autowired
//    private UserSettingDao usdao;
//
//    FTPClient ftpClient = null;
//
//    public String connect() {
//        String result = "connection failed";
//        try{
//            ftpClient = new FTPClient();
//
//            ftpClient.connect(host, port);
//            ftpClient.login(userName, password);
//            ftpClient.enterLocalPassiveMode();
//            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
//            result = "connection success";
//        }
//        catch(IOException e) {
//            e.printStackTrace();
//        }
//
//        return result;
//    }
//
//    // ftp 연결을 해제한다.
//    public void disconnection() {
//        try {
//            if (ftpClient.isConnected()) {
//                ftpClient.logout();
//                ftpClient.disconnect();
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public List<Function1Dto> getAudioInfo(Function1Dto dto, String user_id) {
//        List<Function1Dto> result = dao.getAudioInfo(dto);
//
//        String[] filename = new String[result.size()+1];
//        for(int i = 0; i < result.size(); i++){
//            filename[i] = result.get(i).getFilename();
//        }
//
//        //노이즈 구분
//        String getNoiseName = usdao.getUS(user_id).getNoise_type();
//        String setnoiseName = "";
//        switch(getNoiseName){
//            case "기본" :
//                setnoiseName = "noise1";
//                break;
//            case "길거리" :
//                setnoiseName = "noise2";
//                break;
//            case "식당" :
//                setnoiseName = "noise3";
//                break;
//            case "와글와글" :
//                setnoiseName = "noise4";
//                break;
//        }
//
//        filename[filename.length-1] = setnoiseName;
//        List<String> file = getAudioFile(filename);
//        for(int i = 0; i < file.size()-1; i++){
//            result.get(i).setAudio(file.get(i));
//        }
//
//        Function1Dto noise = new Function1Dto();
//        noise.setFilename("noise");
//        noise.setContext(null);
//        noise.setAudio(file.get(file.size()-1));
//        result.add(noise);
//        return result;
//    }
//
//    // 경로, 파일명, 파일을 받아 해당 경로에 파일을 파일명으로 저장한다.
//    public List<String> getAudioFile(String[] filename) {
//        List<String> result = new ArrayList<String>();
//        String path = "Server/function1";
//        InputStream inputStream = null;
//        try {
//            // 경로를 / 구분
//            String path_arr[] = path.split("/");
//            for (int i = 0; i < path_arr.length; i++) {
//                String directory = path_arr[i];
//                if (directory != null && directory.length() > 0) {
//                    String temp = "/" + directory;
//                    if(ftpClient.changeWorkingDirectory(ftpClient.printWorkingDirectory()+temp)){
//                        System.out.println("current folder: "+ftpClient.printWorkingDirectory());
//                    }
//                }
//            }
//            for(String str : filename) {
//                inputStream = ftpClient.retrieveFileStream(str+".mp3");
//                byte[] fileArray = IOUtils.toByteArray(inputStream);
//                String b64string = new String(Base64.encodeBase64(fileArray));
//                result.add("data:audio/mp3;base64, "+b64string);
//                while(!ftpClient.completePendingCommand());
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        } finally {
//            if (inputStream != null) {
//                try {
//                    inputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            disconnection();
//        }
//        return result;
//    }
}
