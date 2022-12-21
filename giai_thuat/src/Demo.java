public class Demo {

    static boolean solution(int[] arg1) {
        int a = 0;
        for(int i = 1;i<arg1.length-1;i++ ){
            a = 0;
            for(int j = 0;j<i;j++){
                a += arg1[j];
            }
            if(arg1[i] == a && arg1.length-1 != i){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        if(solution(a)){
            System.out.println(1);
        }else {
            System.out.println(2);
        }
    }
}
