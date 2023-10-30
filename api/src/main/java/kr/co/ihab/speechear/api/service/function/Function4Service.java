package kr.co.ihab.speechear.api.service.function;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Function4Service {
//    // private static final String host = "192.168.35.244";
//    private static final String host = "localhost";
//    private static final String userName = "dragonseller_ftp";
//    private static final String password = "DragonSeller*";
//    private static final int port = 39540;
//
//    @Autowired
//    private Function4Dao dao;
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
//    public List<Function4Dto> getFirstInfo(Function4Dto dto) {
//        List<Function4Dto> result = dao.getFirstInfo(dto);
//        return result;
//    }
//
//    public List<Function4Dto> getAudioInfo(String index) {
//        List<Function4Dto> data = dao.getAudioInfo(index);
//        List<String> fileNames = new ArrayList<String>();
//        List<String> files = new ArrayList<String>();
//        for(Function4Dto dto : data) {
//            fileNames.add(dto.getFilename());
//        }
//        files = getSentenceAudioFile(fileNames);
//        for(int i = 0; i < data.size(); i++) {
//            data.get(i).setFile(files.get(i));
//        }
//
//        List<Function4Dto> result = new ArrayList<Function4Dto>();
//        Function4Dto dto = new Function4Dto();
//        dto.setIndex(index);
//        dto.setContext("merged");
//        dto.setFile(getAudioFile(index));
//        dto.setFilename(index);
//        result.add(dto);
//        for(int i = 0; i < data.size(); i++) {
//            result.add(data.get(i));
//        }
//
//        return result;
//    }
//
//    // 경로, 파일명, 파일을 받아 해당 경로에 파일을 파일명으로 저장한다.
//
//    public String getAudioFile(String index) {
//        connect();
//        String audio = "";
//        String path = "Server/function4";
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
//            inputStream = ftpClient.retrieveFileStream(index+".mp3");
//            byte[] fileArray = IOUtils.toByteArray(inputStream);
//            String b64string = new String(Base64.encodeBase64(fileArray));
//            audio = "data:audio/mp3;base64, "+b64string;
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
//        return audio;
//    }
//
//    public List<String> getSentenceAudioFile(List<String> filename) {
//        connect();
//        List<String> result = new ArrayList<String>();
//        String path = "Server/function4_2";
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
