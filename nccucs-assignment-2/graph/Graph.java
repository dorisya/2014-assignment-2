package ps3.graph;

import java.util.*;

public class Graph<E>
{
	//A directed graph consists of a set of nodes, some of which may be connected by edges, and the edges have direction.
	//There cannot be more than one edge from a given node to another given node, but there can be an edge from A to B and an edge from B to A.
    
	//Initiated as an empty graph.
	public Graph()
    {
    	graphMap = new HashMap<E, Set<E>>();
    }
    
	//Add a node to the graph.
    public boolean addNode(E newNode)
    {
    	if(newNode == null){
			throw new IllegalArgumentException("newNode is null");
		}
		if(graphMap.containsKey(newNode)){  
			return false; //if the node is already in the graph, return false.
		}
		graphMap.put(newNode, new HashSet<E>());
		return true;
    }
    
    //In the graph, add an edge from parentnode to childnode.
    public boolean addEdge(E parentNode, E childNode)
    {
    	if(parentNode == null || childNode == null){
			throw new IllegalArgumentException("node is null");
		}
		if(graphMap.get(parentNode).contains(childNode)){
			return false; //if the edge is already in the graph, return false.
		}
		if(!graphMap.containsKey(parentNode) || !graphMap.containsKey(childNode)){
			throw new IllegalArgumentException("node is not in the graph");
		}
		
		//add an edge from parentnode to childnode.
		Set<E> specified = graphMap.get(parentNode);
		specified.add(childNode);
		graphMap.put(parentNode, specified);
		
		return true;
    }
    
    //Check if the node is in the graph or not.
    public boolean containsNode(E node){
    	if(node == null){
			throw new IllegalArgumentException("node is null");
		}
		return graphMap.containsKey(node);
	}
    
    //Check if the edge from parentnode to childnode is in the graph or not.
    public boolean containsEdge(E parentNode, E childNode){
    	if(parentNode == null || childNode == null){
			throw new IllegalArgumentException("node is null");
		}
		if(!graphMap.containsKey(parentNode) || !graphMap.containsKey(childNode)){
			throw new IllegalArgumentException("node is not in the graph");
		}
		return graphMap.get(parentNode).contains(childNode);
	}
    
    //List all nodes in the graph.
    public Set<E> listNodes()
    {
    	return Collections.unmodifiableSet(graphMap.keySet());
    }
    
    //List the set of children for the parentnode.
    public Set<E> listChildren(E parentNode)
    {
    	return Collections.unmodifiableSet(graphMap.get(parentNode));
    }
    
    //Check the graph is empty or not.
    public boolean isEmpty(){
		return graphMap.isEmpty();
	}

	private Map<E, Set<E>> graphMap;
}