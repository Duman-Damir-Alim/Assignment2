package assignment1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;

public class Folder {
    private ArrayList<File> files;
    private final int startPoint;
    private final int THREAD_NUM;

    public Folder(ArrayList<File> files, int startPoint, int thread_num) {
        this.files = files;
        this.startPoint = startPoint;
        this.THREAD_NUM = thread_num;
    }

    public ArrayList<File> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<File> files) {
        this.files = files;
    }

    public int getStartPoint() {
        return startPoint;
    }

    public int getTHREAD_NUM() {
        return THREAD_NUM;
    }
}
