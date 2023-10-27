package kr.co.ihab.speechear.service.function;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Function5Service {
//    // private static final String host = "192.168.35.244";
//    private static final String host = "localhost";
//    private static final String userName = "dragonseller_ftp";
//    private static final String password = "DragonSeller*";
//    private static final int port = 39540;
//
//    @Autowired
//    private Function5Dao dao;
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
//    public Function5Dto loadFile(Function5Dto dto) {
//        Function5Dto result = dao.loadFile(dto);
//
//        Map<String,String> temp = new HashMap<>();
//        List<String> audioName = dao.getAudioList(dto);
//        List<String> audioFile = getAudioFile(dao.getAudioList(dto));
//        for(int i = 0; i < audioName.size(); i++) {
//            temp.put(audioName.get(i), audioFile.get(i));
//        }
//        result.setAudio(temp);
//        result.setCnt(audioName.size() / 4);
//
//        return result;
//    }
//
//    public List<String> getAudioFile(List<String> filename) {
//        List<String> result = new ArrayList<String>();
//        String path = "Server/function5";
//        InputStream inputStream = null;
//        try {
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
