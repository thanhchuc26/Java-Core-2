/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session4_Generics;

/**
 *
 * @author June
 */
class KeyValue<K, V> {

    private K key;
    private V value;

    public KeyValue(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

class ThongTinLienHe extends KeyValue<Integer, String> {
// Class này mở rộng từ class KeyValue<K,V>
// Và chỉ định rõ K,V
// K = Integer  (Số điện thoại).
// V = String   (Tên người dùng).

    public ThongTinLienHe(Integer key, String value) {
        super(key, value);
    }
}

class DiaChiLienHe<V> extends KeyValue<Integer, V> {
// Class này mở rộng class KeyValue<K,V>
// Xác định rõ kiểu tham số K là Integer.
// Vẫn giữ kiểu tham số generic V.

    public DiaChiLienHe(Integer key, V value) {
        super(key, value);
    }
}

class SoDienThoaiVaDiaChi<K, V, I> extends KeyValue<K, V> {
// Class này mở rộng class KeyValue<K,V>
// Bổ sung thêm tham số I là Integer.
// Vẫn giữ kiểu tham số generic K, V.
    private I i;

    public SoDienThoaiVaDiaChi(K key, V value,I i) {
        super(key, value);
        this.i = i;
    }

    public I getI() {
        return i;
    }

    public void setI(I i) {
        this.i = i;
    }

}

public class inheritance_class_generic {

    public static void main(String[] args) {
        ThongTinLienHe thongTinLienHe = new ThongTinLienHe(12345, "Softech");
        Integer soDienThoai = thongTinLienHe.getKey();
        String hoten = thongTinLienHe.getValue();
        System.out.println("So dien thoai: " + soDienThoai + ". Ho ten: " + hoten);
        DiaChiLienHe<String> diaChiLienHe = new DiaChiLienHe<>(38, "Yen Bai");
        Integer sonha = diaChiLienHe.getKey();
        String tenduong = diaChiLienHe.getValue();
        System.out.println("So nha: " + sonha + ". Ten duong: " + tenduong);
        SoDienThoaiVaDiaChi<Integer,String,String> soDienThoaiVaDiaChi=new SoDienThoaiVaDiaChi<>( 123, "Softech","38 Yen Bai");
        System.out.println("So dien thoai: "+soDienThoaiVaDiaChi.getKey()+". "
                + "Ho ten: "+soDienThoaiVaDiaChi.getValue()+". "
                        + "Dia chi: "+soDienThoaiVaDiaChi.getI());
    }
}

//Một class mở rộng từ một class generics, nó có thể chỉ định rõ kiểu cho tham số generics, 
//giữ nguyên các tham số generics hoặc thêm các tham số generics.
