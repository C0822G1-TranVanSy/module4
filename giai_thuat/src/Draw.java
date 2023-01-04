import java.util.Scanner;

public class Draw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Nhập vào chiều cao của tam giác: ");
        n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == n - 1 || j == 0 || j == i) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
