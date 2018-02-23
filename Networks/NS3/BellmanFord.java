import java.util.Scanner;
 
public class BellmanFord
{
    private int distances[];
    private int n;
    public static final int MAX_VALUE = 999;
 
    public BellmanFord(int n)
    {
        this.n = n;
        distances = new int[n + 1];
    }
 
    public void BellmanFordEvaluation(int source, int adjacencymatrix[][])
    {
        for (int i = 1; i <= n; i++)
        {
            distances[i] = MAX_VALUE;
        }
 
        distances[source] = 0;
        for (int i = 1; i <= n - 1; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                for (int k = 1; k <= n; k++)
                {
                    if (adjacencymatrix[j][k] != MAX_VALUE)
                    {
                        if (distances[k] > distances[j] + adjacencymatrix[j][k])
                            distances[k] = distances[j]+ adjacencymatrix[j][k];
                    }
                }
            }
        }
 
        for (int j = 1; j <= n; j++)
        {
            for (int k = 1; k <= n; k++)
            {
                if (adjacencymatrix[j][k] != MAX_VALUE)
                {
                    if (distances[k] > distances[j]+ adjacencymatrix[j][k])
                        System.out.println("The Graph contains negative egde cycle");
                }
            }
        }
 
        for (int vertex = 1; vertex <= n; vertex++)
        {
            System.out.println("distance of source  " + source + " to "
                      + vertex + " is " + distances[vertex]);
        }
    }
 
    public static void main(String[] arg)
    {
        int n = 0;
        int source;
        Scanner scanner = new Scanner(System.in);
 
        System.out.println("Enter the number of vertices");
        n = scanner.nextInt();
 
        int adjacencymatrix[][] = new int[n + 1][n + 1];
        System.out.println("Enter the adjacency matrix");
        for (int j = 1; j <= n; j++)
        {
            for (int k = 1; k <= n; k++)
            {
                adjacencymatrix[j][k] = scanner.nextInt();
 	              if (j == k)
                {
                    adjacencymatrix[j][k] = 0;
                    continue;
                }
                if (adjacencymatrix[j][k] == 0)
                {
                    adjacencymatrix[j][k] = MAX_VALUE;
                }
            }
        }
 
        System.out.println("Enter the source vertex");
        source = scanner.nextInt();
 
        BellmanFord bellmanford = new BellmanFord(n);
        bellmanford.BellmanFordEvaluation(source, adjacencymatrix);
        scanner.close();	
    }
}
