package assignment1;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Returner extends Folder implements Runnable{

    public Returner(ArrayList<File> files, int startPoint, int thread_num) {
        super(files, startPoint, thread_num);
    }

    @Override
    public void run() {
        System.out.println("Runs thread №" + getStartPoint());
        for (int i = getStartPoint(); i < getFiles().size(); i = i + getTHREAD_NUM()){
            try {
                revert(getFiles().get(i));
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void revert(final File fileEntry) {
        if (!fileEntry.isDirectory()) {
            String fileName = fileEntry.getName();
            if (Pattern.matches("\\b[0-9]*$\\b", fileName.split("\\.")[0])){
                String oldName = fileEntry.getName();
                String fileExtension = fileEntry.getName().split("\\.")[1];
                if (fileEntry.renameTo(new File(fileEntry.getParentFile() + "/file_" + oldName.split("\\.")[0] + "." + fileExtension))){
                    System.out.println("File " + oldName + " successfully renamed");
                }
            }
        }
    }

}
