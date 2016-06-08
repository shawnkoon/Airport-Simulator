public class UtilManager
{
    public char toChar(int col)
    {
        char result = 'k';

        switch(col)
        {
            case 1:
                result = 'a';
                break;

            case 2:
                result = 'b';
                break;

            case 3:
                result = 'c';
                break;

            case 4:
                result = 'd';
                break;

            case 5:
                result = 'e';
                break;

            case 6:
                result = 'f';
                break;

            case 7:
                result = 'g';
                break;

            case 8:
                result = 'h';
                break;

            case 9:
                result = 'i';
                break;

            case 10:
                result = 'j';
                break;
        }

        return result;
    }

    public int toInt(char col)
    {
        int result = -1;

        switch(Character.toLowerCase(col))
        {
            case 'a':
                result = 1;
                break;

            case 'b':
                result = 2;
                break;

            case 'c':
                result = 3;
                break;

            case 'd':
                result = 4;
                break;

            case 'e':
                result = 5;
                break;

            case 'f':
                result = 6;
                break;

            case 'g':
                result = 7;
                break;

            case 'h':
                result = 8;
                break;

            case 'i':
                result = 9;
                break;

            case 'j':
                result = 10;
                break;
        }

        return result;
    }
}
