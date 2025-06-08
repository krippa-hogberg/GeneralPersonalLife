package test;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;

import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.util.mxCellRenderer;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxStylesheet;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws IOException {
        DefaultDirectedGraph<String, DefaultEdge> g =
                new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);

        String r1 = "r1\nHej";
        String q1 = "q1";
        String o1 = "o1";
        String o2 = "o2";
        String o3 = "o3";
        String t1 = "t1";
        String t2 = "t2";

        g.addVertex(r1);
        g.addVertex(q1);
        g.addVertex(o1);
        g.addVertex(o2);
        g.addVertex(o3);
        g.addVertex(t1);
        g.addVertex(t2);

        g.addEdge(r1, q1);
        g.addEdge(q1, o1);
        g.addEdge(q1, o2);
        g.addEdge(q1, o3);
        g.addEdge(o1, t1);
        g.addEdge(o2, t2);

        Object[] groupB = new Object[] { r1, q1 };
        Object[] groupA = new Object[] { o1, o2, o3 };

        JGraphXAdapter<String, DefaultEdge> graphAdapter =
                new JGraphXAdapter<String, DefaultEdge>(g);
        mxIGraphLayout layout = new mxHierarchicalLayout(graphAdapter);
        layout.execute(graphAdapter.getDefaultParent());
        graphAdapter.createGroupCell(groupB);
        graphAdapter.createGroupCell(groupA);
        graphAdapter.setSwimlaneNesting(true);
        ((mxHierarchicalLayout) layout).arrangeGroups(groupB, 2);

        mxStylesheet stylesheet = graphAdapter.getStylesheet();

        Map<String, Object> style = stylesheet.getDefaultEdgeStyle();
        style.put(mxConstants.STYLE_FONTSIZE, 0);


        BufferedImage image =
                mxCellRenderer.createBufferedImage(graphAdapter, null, 2, Color.WHITE, true, null);
        File imgFile = new File("C:/Temp/graph.png");
        ImageIO.write(image, "PNG", imgFile);
    }
}
