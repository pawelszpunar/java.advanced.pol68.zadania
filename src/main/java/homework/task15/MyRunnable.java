package homework.task15;

import java.io.File;

public class MyRunnable implements Runnable{
    private final String url;

    public MyRunnable(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        File file = new File(url);
        System.out.println("Process start... [" + file.getName() + "]");
        Task15B.download(url, "c:\\data\\" + file.getName());
        System.out.println("Process end... [" + file.getName() + "]");
    }
}
