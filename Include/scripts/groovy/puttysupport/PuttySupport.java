package puttysupport;
import internal.GlobalVariable;
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint;
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase;
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData;
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject;
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject;

import com.kms.katalon.core.annotation.Keyword;
import com.kms.katalon.core.checkpoint.Checkpoint;
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords;
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords;
import com.kms.katalon.core.model.FailureHandling;
import com.kms.katalon.core.testcase.TestCase;
import com.kms.katalon.core.testdata.TestData;
import com.kms.katalon.core.testobject.TestObject;
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords;
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords;
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import com.jcraft.jsch.*;

public class PuttySupport {
	private static final String REMOTE_HOST = "QTSUATGMCMS1";
	private static final String USERNAME = "test01";
	private static final String PASSWORD = "testuser1234";
	private static final int REMOTE_PORT = 22;
	private static final int SESSION_TIMEOUT = 50000;
	private static final int CHANNEL_TIMEOUT = 10000;
	 public void puttyTest() throws IOException {

    Session jschSession = null;

    try {

        JSch jsch = new JSch();
       
        jsch.setKnownHosts("C:\\Users\\pkumar\\.ssh\\known_hosts");
        //jsch.setConfig("StrictHostKeyChecking", "Yes");
        jschSession = jsch.getSession(USERNAME, REMOTE_HOST, REMOTE_PORT);
        jschSession.setPassword(PASSWORD);  

        // not recommend, uses jsch.setKnownHosts
        //jschSession.setConfig("StrictHostKeyChecking", "no");

        // authenticate using private key
        //jsch.addIdentity("b1:4c:a0:f5:61:f3:e1:75:43:84:3f:b3:96:0d:67:35");
        //jsch.a
        // 10 seconds timeout session
        jschSession.connect(SESSION_TIMEOUT);

        ChannelExec channelExec = (ChannelExec) jschSession.openChannel("exec");

        // Run a command
        channelExec.setCommand("cd /data/scripts");

        // display errors to System.err
        channelExec.setErrStream(System.err);

        InputStream in = channelExec.getInputStream();

        // 5 seconds timeout channel
        channelExec.connect(CHANNEL_TIMEOUT);
        
        channelExec.setCommand("sh process_econtracts");

        // display errors to System.err
        channelExec.setErrStream(System.err);

        in = channelExec.getInputStream();

        // 5 seconds timeout channel
        channelExec.connect(CHANNEL_TIMEOUT);

        // read the result from remote server
        byte[] tmp = new byte[1024];
        while (true) {
            while (in.available() > 0) {
                int i = in.read(tmp, 0, 1024);
                if (i < 0) break;
                System.out.print(new String(tmp, 0, i));
            }
            if (channelExec.isClosed()) {
                if (in.available() > 0) continue;
                System.out.println("exit-status: "
                    + channelExec.getExitStatus());
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (Exception ee) {
            }
        }

        channelExec.disconnect();

    } catch (JSchException | IOException e) {

        e.printStackTrace();

    } finally {
        if (jschSession != null) {
            jschSession.disconnect();
        }
    }

}
	}