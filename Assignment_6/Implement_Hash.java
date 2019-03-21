import java.util.*;
import java.lang.*;

class HashTable
{
    private int Rows = 0;
    private int tableSize = 31;
    int collisions = 0;
    private String[] hashTable = new String[tableSize];
    List<Integer> rows_visited = new ArrayList<>();

    public void insertInTable(String s)
    {
        if(Rows <= tableSize/2)
        {
            int sum = getSum(s);
            int original_val = (17*sum/5 + s.charAt(0)/7 + s.charAt(1)/11)%tableSize ;
            int i = 1;
            int val = original_val;

            while(rows_visited.contains(val))
            {
                val = (original_val + i * i) % tableSize;
                i++;
                collisions++;
            }
            hashTable[val] = s;
            Rows++;
            rows_visited.add(val);
        }
        else
        {
            System.out.println();
            setHashTable(tableSize);
            insertInTable(s);
        }
    }

    private int getSum(String s)
    {
        int sum = 0;
        for(int i = 0; i < s.length(); i++)
            sum = sum + s.charAt(i);
        return sum;
    }

    private int getPrimeNumber(int previous)
    {
        int i = previous+1, j = 2,factors = 0;
        for(i = previous+1; i < Integer.MAX_VALUE; i++)
        {
            factors = 0;
            for(j = 2; j*j <=i; j++)
            {
                if(i%j == 0)
                {
                    factors++;
                    break;
                }
            }
            if(factors == 0)
                return i;
        }
        return i;
    }

    private void setHashTable(int previousSize)
    {
        tableSize = getPrimeNumber(2*previousSize);
        System.out.println("Create a new HashTable of size : "+tableSize);
        String[] old = hashTable;
        hashTable = new String[tableSize];
        Rows = 0;
        List<String> temp = new ArrayList<>();
        for(int i = 0; i < rows_visited.size();i++)
            temp.add(old[rows_visited.get(i)]);
        rows_visited.clear();;
        System.out.println("Rehashing all the previous table values ......");
        for(int i = 0; i < temp.size(); i++)
            insertInTable(temp.get(i));
        System.out.println("Rehashing complete.");
        System.out.println();
    }
}

class Implement_Hash
{
    public static void main(String[] args) throws Exception
    {
        HashTable h = new HashTable();
        String[] input = {"asfjaf44","dfefn 11","248hn","adnfdhf",
                "as in ii","nf112nn","12244nn","odfnens1",
                "djhfsd","sfmdd ","133s s33","fnfanss"," sdam 432","124134w",
                "os311mm ","lasdm jm","zdsd33 ","saf nm ","keep sd","fdfd23"};

        for(int i = 0; i < input.length; i++)
            h.insertInTable(input[i]);
        System.out.println("Total number of collisions encountered were : " +h.collisions);

    }
}
