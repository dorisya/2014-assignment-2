package ps3.graph;

public class DijkstraSpecializer<N> implements PathFinderSpecializer<N> {

    private Graph graph;

    /**
     * Creates a new DijkstraSpeciaizer on the specified graph.
     *
     * @param graph the graph that the algorithm works on
     * @effects creates a DijkstraSpecializer on the specified graph
     */
    public DijkstraSpecializer(Graph graph) {
        this.graph = graph;
    }
    
    public Iterable<N> childrenIterator(N node) {
        return graph.listChildren(node);
    }
    
    public int compare(Path<N> o1, Path<N> o2) {
        if (o1.cost() > o2.cost())
            return 1;
        if (o1.cost() < o2.cost())
            return -1;
        return 0;
    }
    
	public Iterable<N> expandNode(N node) {
		return graph.listChildren(node);
	}

}