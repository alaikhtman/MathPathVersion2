

public class Main
{
    public static void main(String[] args)
    {
        ParserMath p = new ParserMath();
        System.out.println(p.parse("1*2*((7-10)*(2+4)+3)"));
    }
}


//    public static long factorial(int n)
//    {
//            if (n == 0 || n == 1)
//                return 1;
//            long result = 1;
//            for (int i =2; 1<=n; i++)
//            {
//                result *=i;
//            }
////            return result;
//
//        if (n==0|| n==1)
//        {
//            return 1;
//        }
//        return n*factorial(n-1);
//    }
//}



