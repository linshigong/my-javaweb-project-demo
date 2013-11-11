package test.classtest;

public class test {

    public static void main(String[] args) {
        //反射实例化Class
        instantiate(pojo.class);
        
    }
    
    public static void instantiate(Class<? extends AbstractPojo> apojoClass){
        try {
            System.out.println(apojoClass.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
