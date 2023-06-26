package Nyaruko166;

import Nyaruko166.view.MainView;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

//        new MainView().setVisible(true);
        Scanner sc = new Scanner(System.in);
        String srcStr = null;
        String destStr = null;

        srcStr = sc.nextLine();
        destStr = sc.nextLine() + "/Saved";
//        String destFinalStr = destStr;

        File src = new File(srcStr);
        File dest = new File(destStr);

        copyFolder(src.toPath(), dest.toPath());

    }

    public static void copyFolder(Path src, Path dest) {

        String destStr = dest.toString();

        try {
            FileUtils.deleteDirectory(new File(destStr));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        new File(destStr).mkdirs();

        try {
            Files.walk(src).forEach(s -> {
                try {
                    Files.copy(s, dest.resolve(src.relativize(s)), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
