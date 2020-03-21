/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session01_ExceptionsAndAssertions;

/**
 *
 * @author June
 */
public class throw_and_throws {
//    int a;
    public void phepChia()throws ArithmeticException{
        int a=0;
        try{
            a=1/0;
        }
        catch(ArithmeticException error){
            throw new ArithmeticException();
        }
        finally{
            System.out.println("Ket qua: "+a);
        }
    }
    public static void main(String[] args) {
        throw_and_throws test=new throw_and_throws();
        try{
            test.phepChia();
        }
        catch(ArithmeticException error){
            System.out.println("Phep chia khong the chia cho 0");
        }
    }
}
//throw: ném ra bên ngoài 1 exception để bộ phận khác xử lý exception
//throws: được sử dụng trên dòng khai báo 1 phương thức mà trong phương thức đó có sử dụng throw
//trong ví dụ trên, khi gọi phương thức phepChia():
//- nếu mẫu số = 0 thì phương thức phepChia() sẽ ném ra 1 exception
//để phương thức main() xử lý (vì phương thức main() là phương thức gọi phepChia().
//- nếu mẫu số không = 0 thì khối finally sẽ được thực hiện