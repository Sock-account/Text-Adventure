import javax.swing.*;
import java.awt.*;
public class Window extends JFrame {
    
    //TODO:Figure out how to change the elements in the window dynamically 
    @SuppressWarnings("deprecation")
    // Creates the GUI for the game
    public Window(){
        JPanel window = new JPanel();
        JPanel start = new JPanel();
        JPanel Game = new JPanel();
        
        JLabel Title = new JLabel("The Game of Life");

        start.add(Title);
        window.add(start);
        

        // Sets up the logic for the start screen
        JPanel start_button_space = new JPanel();
        JButton sb = new JButton();
        JLabel l1 = new JLabel("Start");
        sb.add(l1);
        start_button_space.add(sb);
        start.add(start_button_space);
        sb.addActionListener(q ->{
            start.remove(start_button_space);
            start.remove(Title);
            repaint();
            Chara_Creator();
        });





        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(window);
        window.setLayout(new FlowLayout());
        this.setSize(new Dimension(500,500));
        this.setVisible(true);
        this.setTitle("Text Adventure");
    }

    public void Chara_Creator(){
        
    }
}
