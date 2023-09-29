import java.util.Optional;

/**
 *싱클통 패턴 : 객채의 인스턴스 오직 1개만 생성되는 패턴
 */
public class SingletonPatternSample {

    private static SingletonPatternSample singletonPatternSample = new SingletonPatternSample();
    private String nulltest;
    private SingletonPatternSample() {

    }
    public static SingletonPatternSample getSingletonPatternSample(){
        return singletonPatternSample;
    }

    public void singletonPatternSampleTest(){
        System.out.println("SingletonPatternSample.class test");
    }

}
