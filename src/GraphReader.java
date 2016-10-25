import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jgrapht.Graph;

import adt.Edge;

public class GraphReader implements interfaces.GraphReader{

	Set<String> nodes = new HashSet<>();
	Set<Edge> edges= new HashSet<>();;
	
	boolean undirected = true;
	boolean weighted= false;
	
	String path;
	
	Pattern directionPattern = Pattern.compile("[a-zA-Z0-9]*[--].|[a-zA-Z]*[->]");
	Pattern nodePattern = Pattern.compile("([a-zA-Z0-9]([^ -.*]||[^-.*]))");
	
	
	public GraphReader(String path) {
		setPath(path);
	}
	
	@Override
	public void setPath(String path) {
		if(path.equals("")){
			raiseException("Empty strings are not allowed");
		}else{
		
			this.path=path;
		}
		
	}

		
	@Override
	public boolean isUndirected() {

		return undirected;
	}
	
	public boolean isDirected(){
		return !undirected;
	}
	public boolean isWeighted(){
		return weighted;
	}
	public boolean isUnWeighted(){
		return !weighted;
	}

	@Override
	public void parsefile() {
		
		String[] temp;
		String[] splitSemikolon;
		String node1;
		String node2;
		String direction;
		Integer weight;
		String name;
		
		try {
			BufferedReader bf = new BufferedReader(new FileReader(new File(path)));
			for(String line; (line= bf.readLine())!=null;){
				
				
				splitSemikolon=line.split(";");
				
				if(splitSemikolon[0].contains("->")){
					undirected=false;
				}
				if(splitSemikolon[0].contains(":")){
					weighted=true;
				}
				temp=splitSemikolon[0].split(" ");
				
				
				node1 = getFirstNode(splitSemikolon[0]);
				node2 = getSecondNode(splitSemikolon[0]);
				direction = getDirection(splitSemikolon[0]);
				weight = getWeight(splitSemikolon[0]);
				name = getName(splitSemikolon[0]);
				
				System.out.println(node1+" "+direction+" "+node2);
				//System.out.println(direction);
				
				/*
				if(node1!=null){
					nodes.add(node1);
				}
				if(node2 != null){
					nodes.add(node2);
				}
				if(isWeighted() && node1!=null && node2!=null){
					edges.add(new Edge(node1,node2, weight));
				}else if(node1!=null && node2!= null){
					edges.add(new Edge(node1, node2));
				}
				*/
				
				
				
			}
			System.out.println(nodes.toString());
			System.out.println(edges.toString());
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public Set<String> getNodes() {
		return nodes;
	}


	@Override
	public Set<Edge> getEdges() {
		
		return edges;
	}
	private void raiseException(String message){
		
	}
	
	private String getFirstNode(String string){
		List<String> results = new ArrayList<String>();
		String temp="";
		Matcher matcher = nodePattern.matcher(string);
		
		while(matcher.find()){
			results.add(matcher.group());
			//System.out.println(matcher.group());
			//temp=matcher.group();
		}
		//System.out.println(results.get(0));
		
		return results.get(0);
	}
	private String getSecondNode(String string){
		List<String> results = new ArrayList<String>();
		String temp="";
		Matcher matcher = nodePattern.matcher(string);
		
		while(matcher.find()){
			results.add(matcher.group());
			//System.out.println(matcher.group());
			//temp=matcher.group();
		}
		//System.out.println(results.get(0));
		
		return results.get(1);
	}
	private String getDirection(String string){
		String temp="";
		Matcher matcher = directionPattern.matcher(string);
		
		while(matcher.find()){
			//System.out.println(matcher.group());
			temp=matcher.group();
		}
		
		return temp;
	}
	private Integer getWeight(String string){
		return null;
	}
	private String getName(String string){
		return null;
	}
	
	
	

}
