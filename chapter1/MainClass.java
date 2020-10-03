public class MainClass {


    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        Circle circle = new Circle();
        System.out.println("Enter radius of circle");
        int radius=sc.nextInt();
        circle.printArea(radius);

        Rectangle rectangle = new Rectangle();
        System.out.println("Enter length and breadth of rectangle");
        int length=sc.nextInt();
        int breadth=sc.nextInt();
        rectangle.printArea(length, breadth);
    }
}

