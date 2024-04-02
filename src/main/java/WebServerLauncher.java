import org.apache.catalina.startup.Tomcat;


import java.io.File;
import java.util.logging.Logger;

public class WebServerLauncher {
    private static final Logger logger = Logger.getLogger(WebServerLauncher.class.getName());

    public static void main(String[] args) throws Exception {
        String webappDirLocation = "./webapp/";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();

        /**
         * 웹 애플리케이션의 컨텍스트 경로를 지정 -> 웹 애플리케이션에 대한 URL에 사용
         * 예를 들어, "/myapp"으로 설정하면 웹 애플리케이션은 http://localhost:8080/myapp에 배치
         * 루트 컨텍스트로 배치하려면 빈 문자열("")을 사용
         */
        tomcat.addWebapp("", new File(webappDirLocation).getAbsolutePath());
        logger.info("configuring app with basedir: " + new File(webappDirLocation).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();
    }
}
