import Format.*;

import java.io.IOException;

public class MyMain {
    public static void main(String[] args) throws IOException{
        Format f = new Format();
        f.loadText("C:\\Users\\Kate\\IdeaProjects\\program5\\src\\Format\\myText.txt");
        f.format("C:\\Users\\Kate\\IdeaProjects\\program5\\src\\Format\\myFormatText.txt");
    }
}
