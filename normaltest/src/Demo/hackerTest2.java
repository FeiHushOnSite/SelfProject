package Demo;

public class hackerTest2 {
    public static void main(String[] args) {
        try {
            int demotest = demotest(1);
            System.out.println(demotest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int demotest(int num) throws Exception {
        if(num == 1){
            throw new demoException().demo111();
        }
        return 1;
    }

    static class demoException extends Exception{
        public Exception demo111() throws Exception {
            throw new Exception("这是个测试异常");
        }
    }
}
