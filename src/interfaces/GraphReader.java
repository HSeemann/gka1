package interfaces;


import java.net.URI;
import java.util.Set;

import org.jgraph.JGraph;
import org.jgrapht.Graph;

import adt.Edge;

public interface GraphReader {
	
	/**
	 * 
	 * @param path
	 */
	public void setPath(String path);
	
	
	
	/**
	 * 
	 * @return
	 */
	public boolean isUndirected();
	
	/**
	 * starts to read and parse the file line by line
	 */
	public void parsefile();
	
	/**
	 * 
	 * @return
	 */
	public Set<String> getNodes();
	
	/**
	 * 
	 * @return
	 */
	public Set<Edge> getEdges();
	
	

}
