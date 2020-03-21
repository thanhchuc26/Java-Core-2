/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session8_MultithreadingAndConcurrency;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author June
 */
class myFile {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String fileName) throws FileNotFoundException, IOException {
        File file = new File(fileName);
        try (FileReader fr = new FileReader(file)) {
            char[] a = new char[50];
            fr.read(a); // doc noi dung toi mang
            this.content = "";
            for (char c : a) {
                this.content += c;
            }
        }
    }
}

class ReadFile implements Runnable {

    myFile myfile;

    public ReadFile(myFile myfile) {
        this.myfile = myfile;
    }

    @Override
    public void run() {
        System.out.println("Reading content");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        synchronized (myfile) {

            try {
                myfile.setContent("d:/session05/FileWriter.txt");
                myfile.notifyAll();
            } catch (IOException ex) {
                Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}

class displayContent implements Runnable {

    myFile myfile;

    public displayContent(myFile myfile) {
        this.myfile = myfile;
    }

    @Override
    public void run() {
        synchronized (myfile) {
            System.out.println("Waitting for read content");
            try {
                myfile.wait();
                System.out.println(myfile.getContent());
            } catch (InterruptedException ex) {
                Logger.getLogger(displayContent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

public class wait_notify_Example {

    public static void main(String[] args) throws IOException {
        myFile myfile = new myFile();//("d:/session05/FileWriter.txt");
        Thread t1 = new Thread(new ReadFile(myfile));
        Thread t2 = new Thread(new displayContent(myfile));
        t1.start();
        t2.start();
    }
}

/*
wait(): Phương thức này sẽ làm cho luồng đang sở hữu monitor của đối tượng 
(hay luồng đang khóa đối tượng và nắm giữ đối tượng này) tạm thời ngưng hoạt động 
và trả monitor của đối tượng cho luồng khác. 
Sau khi trả monitor luồng 1 sẽ về trạng thái đợi, trạng thái này java định nghĩa là Thread.State.WAITING

notify() và notifyall(): 
Sau khi luồng 2 nắm giữ monitor của đối tượng và xử lý xong những gì luồng 1 cần, 
thì luồng 2 sẽ gọi phươg thức notify() hoặc notifyall() trên đối tượng 
để đánh thức các luồng đang chờ monitor của đối tượng và ngay sau đó luồng 2 sẽ trả lại monitor của đối tượng. 

Điểm khác nhau giữa notify() và notifyall() là:
notify() sẽ gửi thông điệp đánh thức cho 1 luồng ngẫu nhiên trong các luồng đang chờ, 
còn notifyall() sẽ gửi cho tất cả các luồng đang chờ b. 
Tuy nhiên, thông điệp gửi bởi notify() như đã nói,nó sẽ đánh thức 1 luồng bất kỳ 
chứ không chắc chắn là luồng 1 nên SUN khuyến cáo nên dùng notifyall().
 */
