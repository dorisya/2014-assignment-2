package ps3.graph;

/**
 * DijkstraSpecializer implements the PathFinderSpecializer interface in order
 * to encapsulate the behavior of Dijkstra's shortest path algorithm on graphs
 * that implement the AbstractGraph interface.
 *
 * @param <N>
 *            the type of nodes in the graph passed as an argument
 */
public class DijkstraSpecializer implements PathFinderSpecializer<WeightedNode> {
  
	private Graph<WeightedNode> graph;
  
	/**
	 * Creates a new DijkstraSpeciaizer on the specified graph.
	 *
	 * @param graph
	 *            the graph that the algorithm works on
	 * @effects creates a DijkstraSpecializer on the specified graph
	 */
	public DijkstraSpecializer(Graph<WeightedNode> graph) {
		this.graph = graph;
	}
  
	// Specified in Comparator interface
	public int compare(Path<WeightedNode> o1, Path<WeightedNode> o2) {
		if (o1.cost() > o2.cost())
			return 1;
		if (o1.cost() < o2.cost())
			return -1;
		return 0;
	}
  
	// Specified in PathFinderSpecializer interface
	public Iterable<WeightedNode> expandNode(WeightedNode node) {
		return graph.listChildren(node);
	}
  
}