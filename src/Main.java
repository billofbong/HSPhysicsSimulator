import hs.core.PhysicsSimulator;
import javax.swing.JFrame;

/**
 * @author Will Wright
 */
public class Main
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("HS Physics Simulator by Corbin Naderzad and Will Wright");
        PhysicsSimulator ps = new PhysicsSimulator();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(ps.getRenderer());
        frame.pack();
        frame.setVisible(true);
        ps.start();
    }
}
