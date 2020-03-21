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
class classGenerics1<T> {

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

}
class classGenerics2<K,V>{
    private K k;
    private V v;

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }
    
}
public class generics_class {

    public static void main(String[] args) {
        classGenerics1<Integer> classInteger = new classGenerics1<>();
        classInteger.setT(10);
//        System.out.println(classInteger.getT()+"");
        System.out.printf("Gia tri cua classInteger la: %d\n", classInteger.getT());
        classGenerics1<String> classString=new classGenerics1<>();
        classString.setT("Softech");
        System.out.printf("Gia tri cua classString la: %s\n", classString.getT());
        classGenerics2<String,Integer> classGenericsIS=new classGenerics2<>();
        classGenericsIS.setK("Batch");
        classGenericsIS.setV(129);
        System.out.printf("Gia tri key cua classGenericsIS la: %s\n",classGenericsIS.getK());
        System.out.printf("Gia tri value cua classGenericsIS la %d\n",classGenericsIS.getV());
    }
}
