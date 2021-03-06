
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JApplet;

import org.jgraph.JGraph;
import org.jgraph.graph.DefaultEdge;
import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.GraphConstants;
import org.jgrapht.ListenableGraph;
import org.jgrapht.ext.JGraphModelAdapter;
import org.jgrapht.graph.ListenableDirectedGraph;

public class MainAppletGKA extends JApplet {
	private static final Color     DEFAULT_BG_COLOR = Color.decode( "#FAFBFF" );
    private static final Dimension DEFAULT_SIZE = new Dimension( 530, 320 );

	private JGraphModelAdapter m_jgAdapter;
	private JGraph jgraph;
	private ListenableGraph g;
	
	public void init(){
		
		TextField logWindow = new TextField();
		//add(logWindow);
		add(logWindow, -1);
		logWindow.setLocation(getWidth()+50, getHeight()+50);
		logWindow.setText("blahhh");
		
		g = new ListenableDirectedGraph(DefaultEdge.class);
		
		m_jgAdapter=new JGraphModelAdapter(g);
		
		jgraph = new JGraph(m_jgAdapter);
		
		adjustDisplaySettings( jgraph );
        getContentPane(  ).add( jgraph );
        resize( DEFAULT_SIZE );

        
/*        
        // add some sample data (graph manipulated via JGraphT)
        g.addVertex( "v1" );
        g.addVertex( "v2" );
        g.addVertex( "v3" );
        g.addVertex( "v4" );

        g.addEdge( "v1", "v2" );
        g.addEdge( "v2", "v3" );
        g.addEdge( "v3", "v1" );
        g.addEdge( "v4", "v3" );
        
        

        // position vertices nicely within JGraph component
        positionVertexAt( "v1", 130, 40 );
        positionVertexAt( "v2", 60, 200 );
        positionVertexAt( "v3", 310, 230 );
        positionVertexAt( "v4", 380, 70 );*/
        
        
		
	}
	
	private void adjustDisplaySettings( JGraph jg ) {
        jg.setPreferredSize( DEFAULT_SIZE );

        Color  c        = DEFAULT_BG_COLOR;
        String colorStr = null;

        try {
            colorStr = getParameter( "bgcolor" );
        }
         catch( Exception e ) {}

        if( colorStr != null ) {
            c = Color.decode( colorStr );
        }

        jg.setBackground( c );
    }


    private void positionVertexAt( Object vertex, int x, int y ) {
        DefaultGraphCell cell = m_jgAdapter.getVertexCell( vertex );
        Map              attr = cell.getAttributes(  );
        System.out.println(attr);
        Rectangle2D        b    = GraphConstants.getBounds( attr );

        GraphConstants.setBounds( attr, new Rectangle( x, y, (int)b.getWidth(),(int) b.getHeight() ) );

        Map cellAttr = new HashMap(  );
        cellAttr.put( cell, attr );
        m_jgAdapter.edit( cellAttr, null, null, null );
    }
    
    
    /**
     * 
     * @param name
     * @param x
     * @param y
     */
    public void addVertex(String name, int x, int y){
    	g.addVertex(name);
    	positionVertexAt(name, x, y);
    }
    
    /**
     * 
     * @param name
     */
    public void addVertex(String name){
    	//hier die positionierungslogik
    }
    
    /**
     * 
     * @param e1
     * @param e2
     */
    public void addEdge(String e1, String e2){
    	g.addEdge(e1, e2);
    	//System.out.println(m_jgAdapter.getEdgeCell(g.getEdge(e1, e2)).getAttributes());
    	//System.out.println(GraphConstants.getBounds(m_jgAdapter.getEdgeCell(g.getEdge(e1, e2)).getAttributes()));
    	//m_jgAdapter.getEdgeCell(g.getEdge(e1, e2)).getAttributes().
    	
    }
	
	
}