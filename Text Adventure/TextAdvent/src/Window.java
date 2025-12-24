import javax.swing.*;
import java.awt.*;
public class Window extends JFrame {
    
    @SuppressWarnings("derprecation")
    public Window(){
        JPanel window = new JPanel();
        JPanel Start = new JPanel();
        JPanel Game = new JPanel();

        JLabel Title = new JLabel("Text Adventure");

        Start.add(Title);
        window.add(Start);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(window);
        window.setLayout(new FlowLayout());
        this.setSize(new Dimension(500,500));
        this.setVisible(true);
        this.setTitle("Text Adventure");
    }
}
