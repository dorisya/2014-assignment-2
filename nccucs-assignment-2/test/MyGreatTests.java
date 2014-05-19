package ps3.test;

import java.util.Set;

import ps3.graph.Graph;
import junit.framework.*;

public final class MyGreatTests extends TestCase {
	/**
	 * tests that two identical nodes cannot be added to a graph
	 */
	public void testAddNodeRepInv() {
		Graph<String> g = new Graph<String>();
		String s = "Legolas";
    
		g.addNode(s);
		Set<String> nodes = g.listNodes();
    
		g.addNode(s);
		assertTrue(
               "Adding a node that is already in the graph should not change the graph.",
               nodes.equals(g.listNodes()));
	}
  
	/**
	 * tests that two identical edges cannot be added to the graph
	 */
	public void testAddEdgeRepInv() {
		Graph<String> g = new Graph<String>();
		String sp = "Legolas";
		String sc = "Legolas";
    
		g.addNode(sp);
		g.addNode(sc);
		g.addEdge(sp, sc);
		Set<String> nodes = g.listChildren(sp);
    
		g.addEdge(sp, sc);
		assertTrue(
               "Adding a edge that is already in the graph should not change the graph.",
               nodes.equals(g.listChildren(sp)));
	}
  
	public void testisEmpty() {
		Graph<String> g = new Graph<String>();
		g.isEmpty();
	}
  
	public void testaddNode() {
		Graph<String> g = new Graph<String>();
		String s = null;
		g.addNode(s);
	}
  
	public void testaddEdge1() {
		Graph<String> g = new Graph<String>();
		String sp = null;
		String sc = "sc";
		g.addEdge(sp, sc);
	}
  
	public void testaddEdge2() {
		Graph<String> g = new Graph<String>();
		String sp = "sp";
		String sc = null;
		g.addEdge(sp, sc);
	}
  
	public void testcontainsNode() {
		Graph<String> g = new Graph<String>();
		String s = null;
		g.containsNode(s);
	}
  
	public void testcontainsEdge1() {
		Graph<String> g = new Graph<String>();
		String sp = null;
		String sc = "sc";
		g.containsEdge(sp, sc);
	}
  
	public void testcontainsEdge2() {
		Graph<String> g = new Graph<String>();
		String sp = "sp";
		String sc = null;
		g.containsEdge(sp, sc);
	}
}