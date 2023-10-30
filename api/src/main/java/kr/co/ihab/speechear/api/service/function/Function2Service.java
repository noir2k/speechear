package kr.co.ihab.speechear.api.service.function;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Function2Service {
//    // private static final String host = "192.168.35.244";
//    private static final String host = "localhost";
//    private static final String userName = "dragonseller_ftp";
//    private static final String password = "DragonSeller*";
//    private static final int port = 39540;
//
//    @Autowired
//    private Function2Dao dao;
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
//    public List<Function2Dto> getAudioInfo(Function2Dto dto) {
//        List<Function2Dto> result = dao.getAudioInfo(dto);
//        result = getAudioFile(result);
//
//        return result;
//    }
//
//    // 경로, 파일명, 파일을 받아 해당 경로에 파일을 파일명으로 저장한다.
//
//    public List<Function2Dto> getAudioFile(List<Function2Dto> dto) {
//        String audio = "";
//        String path = "Server/function2";
//        InputStream inputStream = null;
//        InputStream inputStream2 = null;
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
//
//            for(int i = 0; i < dto.size(); i++) {
//                inputStream = ftpClient.retrieveFileStream(dto.get(i).getSpeechcode()+".mp3");
//                byte[] fileArray = IOUtils.toByteArray(inputStream);
//                String b64string = new String(Base64.encodeBase64(fileArray));
//                audio = "data:audio/mp3;base64, "+b64string;
//                dto.get(i).setSaudio(audio);
//
//                while(!ftpClient.completePendingCommand());
//            }
//            for(int i = 0; i < dto.size(); i++) {
//                inputStream2 = ftpClient.retrieveFileStream(dto.get(i).getQuestioncode()+".mp3");
//                byte[] fileArray = IOUtils.toByteArray(inputStream2);
//                String b64string = new String(Base64.encodeBase64(fileArray));
//                audio = "data:audio/mp3;base64, "+b64string;
//                dto.get(i).setQaudio(audio);
//
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
//
//        return dto;
//    }
}
