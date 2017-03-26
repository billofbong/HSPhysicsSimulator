import hs.core.PhysicsSimulator;
import hs.physics.Vector2;
import hs.sceneobject.Polygon;

import javax.swing.JFrame;
import java.awt.*;

/**
 * @author Will Wright
 */
public class Main
{
    public static void main(String[] args) throws Exception
    {
        JFrame frame = new JFrame("HS Physics Simulator by Corbin Naderzad and Will Wright");
        PhysicsSimulator ps = new PhysicsSimulator();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(ps.getRenderer());
        ps.getRenderer().setReset(true);
        //frame.setResizable(false);
        frame.setSize(1280, 1280);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        ps.start();
    }
}
