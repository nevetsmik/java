public class Main {

    public static void main(String[] args) {
        Temperature myTemp = new Temperature();
        myTemp.insert(99);
        System.out.println(myTemp.getMode());
    }
}
