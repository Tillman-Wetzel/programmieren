package Java_homework;

public class MainStaticMain {
    
    public static void main(String[] args) {
        System.out.println(MainStatic.myMethod(5, 3));
        System.out.println(5 + 3);
        MainStatic.intArrayMethod();

        ObjektOrient1 myObjekt = new ObjektOrient1();
        
        System.out.println(myObjekt.x);
        System.out.println(myObjekt.y);
        System.out.println(myObjekt.Z);
        System.out.println(ObjektOrient1.w);

        myObjekt.test();
        
        ObjektOrient1.staticTest();
    
    }
    
}
