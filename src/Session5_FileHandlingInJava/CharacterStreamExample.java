/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session5_FileHandlingInJava;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author June
 */
public class CharacterStreamExample {

    public static void main(String[] args) throws IOException {
        FileReader input = null;
        FileWriter output = null;

        try {
            input = new FileReader("d:/session05/characterstreaminput.txt");
            output = new FileWriter("d:/session05/characterstreamoutput.txt");

            int c;
            while ((c = input.read()) != -1) {
                output.write(c);
                System.out.println(Integer.toString(c));
            }
        } finally {
            if (input != null) {
                input.close();
            }
            if (output != null) {
                output.close();
            }
        }
    }
}

/*
Byte Stream trong Java được sử dụng để thực hiện input và output của các byte (8 bit), 
trong khi đó, Character Stream trong Java được sử dụng để thực hiện input và output cho Unicode 16 bit. 
Mặc dù có nhiều lớp liên quan tới character stream nhưng các lớp thường dùng nhất là FileReader và FileWriter… 
Mặc dù trong nội tại, FileReader sử dụng FileInputStream và FileWriter sử dụng FileOutputStream, 
nhưng có một điểm khác biệt lớn ở đây là FileReader đọc hai byte cùng một thời điểm và FileWriter ghi 2 byte cùng một lúc.
*/