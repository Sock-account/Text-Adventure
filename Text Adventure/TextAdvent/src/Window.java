import javax.swing.*;
import java.awt.*;
public class Window extends JFrame {
    
    //TODO:Figure out how to change the elements in the window dynamically 
    @SuppressWarnings("deprecation")
    // Creates the game window for the game
    public Window(){
        JPanel window = new JPanel();
        JPanel Start = new JPanel();
        JPanel Game = new JPanel();

        JLabel Title = new JLabel("The Game of Life");

        Start.add(Title);
        window.add(Start);

        JPanel start_button_space = new JPanel();



        JButton sb = new JButton();



        JLabel l1 = new JLabel("Start");

        start_button_space.add(sb);
        Start.add(start_button_space);
        window.add(Start);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(window);
        window.setLayout(new FlowLayout());
        this.setSize(new Dimension(500,500));
        this.setVisible(true);
        this.setTitle("Text Adventure");
    }
}
