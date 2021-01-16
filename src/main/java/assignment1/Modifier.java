package assignment1;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Modifier extends Folder implements Runnable{

    public Modifier(ArrayList<File> files, int startPoint, int thread_num) {
        super(files, startPoint, thread_num);
    }

    @Override
    public void run() {
        System.out.println("Runs thread №" + getStartPoint());
        for (int i = getStartPoint(); i < getFiles().size(); i = i + getTHREAD_NUM()){
            try {
                modify(getFiles().get(i));
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void modify(final File fileEntry){
        if (!fileEntry.isDirectory()){
            String fileName = fileEntry.getName();
            if (Pattern.matches("\\bfile_[0-9]*$\\b", fileName.split("\\.")[0])){
                String oldName = fileEntry.getName();
                String fileNum = fileEntry.getName().split("\\.")[0].split("_")[1];
                String fileExtension = fileEntry.getName().split("\\.")[1];
                if (fileEntry.renameTo(new File(fileEntry.getParentFile() + "/" + fileNum + "." + fileExtension))){
                    System.out.println("Runs on Thread " + getStartPoint() + ": File " + oldName + " successfully renamed");
                }
            }
        }
    }
}
