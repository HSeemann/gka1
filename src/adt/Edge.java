package adt;

public class Edge implements Comparable{
	String node1;
	String node2;
	Integer gewicht=0;
	String name="";
	
	/**
	 * Creates an edge with only a startnode and a endnode 
	 * (in directed graphs). 
	 * Creates an edge between two vertexes 
	 * (in undirected graphs)
	 *  
	 * @param start startnode (in directed graphs)
	 * @param end endnode (in directed graphs)
	 */
	public Edge(String start, String end) {
		if(start.equals("") || end.equals("")){
			raiseException();
		}else{
			node1 = start;
			node2 = end;
		}
	}
	
	public Edge(String start, String end, int weight){
		gewicht=weight;
		if(start.equals("") || end.equals("")){
			raiseException();
		}else{
			node1 = start;
			node2 = end;
		}
		
	}
	
	
	
	private void raiseException(){
		
	}



	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	public String toString(){
		return node1+" -> "+node2;}
	
	public int getWeight(){
		return gewicht;
	}
	public void setWeight(int w){
		gewicht=w;
	}

}
