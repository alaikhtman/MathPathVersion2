
public class ParserMath
{
    private String exp;
    private int position = 0;

    public double parse(String exp)
    {
        this.exp = exp;
        position = 0;
        double result = expression(term(factor()));
        return result;
    }

    private double factor()
    {
        char charExp = getChar();

        if (Character.isDigit(charExp))
        {
            return getValue(charExp);
        }
        if (charExp == '(')
        {
            ParserMath p = new ParserMath();
            return p.parse(getExpression());
        }
        return 0;
    }

    private  double term (double left)
    {
        char ch = getChar();
        if (ch != '*' && ch != '/')
        {
            position --;
            return left;
        }
       double right  = factor();
        if (ch == '*')
        {
            return term(left * right);
        }
        if (right == 0)
        {
            System.err.println("Error");
            return 0;
        }
        return term(left / right);
    }

    private double expression (double left)
    {
        char ch = getChar();
        if (ch != '+' && ch != '-')
        {
            position --;
            return left;
        }
        double right  = term (factor());
        if (ch == '+')
        {
            return expression(left+right);
        }

        return expression(left - right);

    }

   //¬озвращает выражение до закрывающейс€ скобки

    private String getExpression()
    {
        String charStringNew = "";
        int opened = 0;
        while (true)
        {
            char charExp = getChar();
            if (charExp == '(')
        {
            opened++;
        }
            if (charExp == ')')
            {
              if (opened !=0)
                  opened--;

              else
                break;
            }
            charStringNew += Character.toString(charExp);
        }

        return charStringNew;

    }

    //возвращаем числа, начинающегос€ с ch
    private double getValue(char charExp)
    {
        String charString;
        charString = Character.toString(charExp);

        while (true)
        {
            charExp = getChar();
            if (Character.isDigit(charExp))
            {
                charString += Character.toString(charExp);
            } else
            {
                break;
            }
        }
        position--;
        return Double.parseDouble(charString);
    }



   //возврат следующего символа
   private char getChar()
    {
        if (position<exp.length()) {

            char charExp = exp.charAt(position);
            position++;
            return charExp;
        }
        return '\0';
    }
}
