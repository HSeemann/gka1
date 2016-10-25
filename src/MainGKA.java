import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.swing.JApplet;
import javax.swing.JButton;
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

	private static JTextArea logWindow;
	private static MainAppletGKA applet;
	
	public static void main(String[] args) {
		
		//blah
		JFrame frame = new JFrame("GKAv2");
		frame.setSize(600, 600);
		
		//JScrollPane scroller = new JScrollPane(jgraph);
		JSplitPane splitPaneMain = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		applet = new MainAppletGKA();
		applet.start();
		applet.init();
		
		
		splitPaneMain.setLeftComponent(applet.getContentPane());
		//splitPaneMain.setLeftComponent(applet.getContentPane());
		
		logWindow = new JTextArea();
		logWindow.setEditable(false);
		JScrollPane logScollPane = new JScrollPane(logWindow);
		
		JSplitPane jSplitDown = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		JTextField eingabeZeile = new JTextField(1);
		jSplitDown.setLeftComponent(logScollPane);
		
		JButton sendTextField = new JButton("send");
		
		JSplitPane textAndButton = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,eingabeZeile,sendTextField);
		
		jSplitDown.setRightComponent(textAndButton);
		
		jSplitDown.setDividerSize(1);
		
		
		
		splitPaneMain.setRightComponent(jSplitDown);
		
		
		sendTextField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//logWindow.append("\n"+eingabeZeile.getText());
				scanInput(eingabeZeile.getText());
				eingabeZeile.setText("");
				
			}
		});
		
		
		eingabeZeile.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar()==KeyEvent.VK_ENTER){
					scanInput(eingabeZeile.getText());
					eingabeZeile.setText("");
					
				}
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
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
		textAndButton.setDividerLocation(0.8);
		textAndButton.setResizeWeight(1.0);
		textAndButton.setEnabled(false);
		textAndButton.setDividerSize(0);
		
		
		
		
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

	public static void log(String zeile){
		logWindow.append(zeile+"\n");
	}
	public static void scanInput(String order){
		
		
		String temp[] = order.split(" ");
		if(Pattern.matches("addVertex.*", order)||Pattern.matches("addKante.*", order)){
			
			
			if(temp.length>=4){
				log("addVertex-->Name: \""+temp[1]+"\" at x="+temp[2]+" y="+temp[3]);
				applet.addVertex(temp[1], Integer.parseInt(temp[2]), Integer.parseInt(temp[3]));
			}else{
				log("---ERROR--->addVertex benötigt mindestens 3 Parameter!");
			}
			//log(temp[0]+"<- 1 "+temp[1]+"<-2 "+temp[2]+"<-3 "+temp[3]+"<-4 ");
			
		}else if(Pattern.matches("addEdge.*", order)||Pattern.matches("addKnoten", order)){
			if(temp.length>=3){
				log("addEdge--->Edge zwischen: \""+temp[1]+"\" und "+temp[2]);
				applet.addEdge(temp[1], temp[2]);
				
			}else{
				log("---ERROR--->addEdge benoetigt mindestens 2 Parameter!");
			}
			
		}
		
	}
	
}