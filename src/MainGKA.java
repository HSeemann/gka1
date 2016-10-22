import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jgraph.JGraph;
import org.jgraph.graph.DefaultEdge;
import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.GraphConstants;
import org.jgrapht.ListenableGraph;
import org.jgrapht.ext.JGraphModelAdapter;
import org.jgrapht.graph.ListenableDirectedGraph;


public class MainGKA extends JFrame{
	/*private static final Color     DEFAULT_BG_COLOR = Color.decode( "#FAFBFF" );
    private static final Dimension DEFAULT_SIZE = new Dimension( 530, 320 );
	
	private static JGraph jgraph;
	private static JGraphModelAdapter m_adapter;
	*/

	public static void main(String[] args) {
		
		//blah
		JFrame frame = new JFrame("GKAv2");
		frame.setSize(600, 600);
		
		//JScrollPane scroller = new JScrollPane(jgraph);
		JSplitPane splitPaneMain = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		MainAppletGKA applet = new MainAppletGKA();
		applet.start();
		applet.init();
		
		JScrollPane scrollApplet = new JScrollPane(applet.getContentPane());
		splitPaneMain.setLeftComponent(scrollApplet);
		//splitPaneMain.setLeftComponent(applet.getContentPane());
		
		JTextArea logWindow = new JTextArea("blah");
		logWindow.setEditable(false);
		JScrollPane logScollPane = new JScrollPane(logWindow);
		
		JSplitPane jSplitDown = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		JTextField eingabeZeile = new JTextField(1);
		jSplitDown.setLeftComponent(logScollPane);
		jSplitDown.setRightComponent(eingabeZeile);
		jSplitDown.setDividerSize(1);
		
		
		splitPaneMain.setRightComponent(jSplitDown);
		
		
		frame.add(splitPaneMain);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//jSplitDown.setMinimumSize(new Dimension(50,50));
		jSplitDown.getRightComponent().setMinimumSize(new Dimension(30,30));
		//jSplitDown.getRightComponent().setMaximumSize(new Dimension(1024,40));
		jSplitDown.setResizeWeight(1.0);
		jSplitDown.setDividerLocation(0.9);
		splitPaneMain.setResizeWeight(1.0);
		splitPaneMain.setDividerLocation(0.7);
		splitPaneMain.setDividerSize(1);
		splitPaneMain.setEnabled(false);
		jSplitDown.setEnabled(false);
		
		
		/*
		ListenableGraph g = new ListenableDirectedGraph<>(DefaultEdge.class);
		m_adapter = new JGraphModelAdapter<>(g);
		jgraph = new JGraph(m_adapter);
		
		frame.getContentPane().add(jgraph);
		
		
		//frame.pack();
		
			
		g.addVertex("hallo1");
		g.addVertex("hallo2");
		g.addEdge("hallo1","hallo2");
		
		//g.addEdge("hallo2", "hallo2");
		positionVertexAt("hallo1",100,100);
		positionVertexAt("hallo2",200,200);
		
		
		jgraph.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				//if(e.getClickCount() == 2){
					int x= e.getX(), y=e.getY();
					Object cell = jgraph.getFirstCellForLocation(x, y);
					
					System.out.println(cell.toString());
				//}
			}
		});
		*/

	}
	
	
	/*
	private static void positionVertexAt( Object vertex, int x, int y ) {
        DefaultGraphCell cell = m_adapter.getVertexCell( vertex );
        System.out.println(m_adapter.getVertexCell(vertex).toString());
        
        Map              attr = cell.getAttributes(  );
        Rectangle2D        b    = GraphConstants.getBounds( attr );
        GraphConstants.setBounds( attr, new Rectangle( x, y, (int)b.getWidth(),(int) b.getHeight() ) );
        Map cellAttr = new HashMap(  );
        cellAttr.put( cell, attr );
        m_adapter.edit( cellAttr, null, null, null );
    }
    */

}