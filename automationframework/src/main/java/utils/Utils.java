package utils;

import driver.DriverSingleton;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Random;

public class Utils {
    public  static  String decode64(String encodedStr){
        Base64.Decoder decoder =Base64.getDecoder();
        return  new String(decoder.decode(encodedStr.getBytes(StandardCharsets.UTF_8)));
    }

    public static boolean takeScreenShot() {
        File file = ((TakesScreenshot) DriverSingleton.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileCopyUtils.copy(file, new File(Constants.SCREEN_SHOT_FOLDER+generateRandomsString(Constants.SCREENSHOT_NAME_LENGHT)+Constants.SCREENSHOT_EXTINTION));
            return true;
        } catch (IOException e) {
            return false;
        }

    }
    private static String generateRandomsString(int length){
        String seedChars="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb =new StringBuilder();
        int i=0;
        Random  random =new Random();
        while (i<length){
            sb.append(seedChars.charAt(random.nextInt(seedChars.length())));
            i++;
        }
        return sb.toString();
    }
}
