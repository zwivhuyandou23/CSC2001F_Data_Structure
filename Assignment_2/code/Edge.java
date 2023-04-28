// Represents an edge in the graph.
class Edge
{
    public Vertex     dest;   // Second vertex in Edge
    public double     cost;   // Edge cost
    public int noOfEdges;
    
    public Edge( Vertex d, double c )
    {
        dest = d;
        cost = c;
        noOfEdges++;
    }
}
