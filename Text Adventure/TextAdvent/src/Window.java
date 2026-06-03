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
            Chara_Creator(window);
        });





        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(window);
        window.setLayout(new FlowLayout());
        this.setSize(new Dimension(500,500));
        this.setVisible(true);
        this.setTitle("Text Adventure");
    }

    public void Chara_Creator(JPanel window){
        //This should display the character creation screen
        JPanel chara_creator = new JPanel();
        
        //This is the panel for the character's name
        JPanel chara_name_panel = new JPanel();
        JTextField chara_name = new JTextField(20);
        JLabel name_label = new JLabel("Name");
        chara_name_panel.add(chara_name);
        chara_name_panel.add(name_label);
        chara_creator.add(chara_name_panel);
        
        //This is the panel for the character's age
        JPanel age_space = new JPanel();
        JTextField age_box = new JTextField(2);
        JLabel age_label = new JLabel("Age");
        age_space.add(age_box);
        age_space.add(age_label);
        chara_creator.add(age_space);

        
        //The following will be the panels for the buttons 
        // and labels for the attributes

        // Strength panel
        JPanel strength_spacel = new JPanel();
        JLabel strength_label = new JLabel("Strength");
        JLabel strength_num = new JLabel("0");
        JButton strength_b1 = new JButton("<-");
        JButton strength_b2 = new JButton("->");
        window.add(chara_creator);
        window.revalidate();
        window.repaint();

        chara_creator.setLayout(new GridLayout());
    }
}
