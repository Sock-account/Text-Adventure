import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
public class Window extends JFrame {
    
    //TODO:Figure out how to change the elements in the window dynamically 
    @SuppressWarnings("deprecation")
    // Creates the GUI for the game
    public Window(){
        JPanel window = new JPanel();
        JPanel start = new JPanel();
        Frame Game = new JFrame();
        
        JLabel Title = new JLabel("The Game of Life");

        start.add(Title);
        window.add(start);
        Game.add(window);

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
        Game.setLayout(new GridLayout(4, 4));
        Game.pack();
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
        
        //The following will be the panels for the buttons and labels for the attributes

        // Strength panel
        JPanel strength_space = new JPanel();
        JLabel strength_label = new JLabel("Strength");
        JLabel strength_num = new JLabel("0");
        JButton strength_b1 = new JButton("<");
        JButton strength_b2 = new JButton(">");
        strength_space.add(strength_label);
        strength_space.add(strength_b1);
        strength_space.add(strength_num);
        strength_space.add(strength_b2);
        chara_creator.add(strength_space);
        
        // Intelligence panel
        JPanel int_space = new JPanel();
        JLabel int_label = new JLabel("Intelligence");
        JLabel int_num = new JLabel("0");
        JButton int_b1 = new JButton("<");
        JButton int_b2 = new JButton(">");
        int_space.add(int_label);
        int_space.add(int_b1);
        int_space.add(int_num);
        int_space.add(int_b2);
        chara_creator.add(int_space);
        
        //Charisma panel
        JPanel charisma_space = new JPanel();
        JLabel charisma_label = new JLabel("Charisma");
        JLabel charisma_num = new JLabel("0");
        JButton charisma_b1 = new JButton("<");
        JButton charisma_b2 = new JButton(">");
        charisma_space.add(charisma_label);
        charisma_space.add(charisma_b1);
        charisma_space.add(charisma_num);
        charisma_space.add(charisma_b2);
        chara_creator.add(charisma_space);

        //Coordination panel
        JPanel coordination_space = new JPanel();
        JLabel coordination_label = new JLabel("Coordination");
        JLabel coordination_num = new JLabel("0");
        JButton coordination_b1 = new JButton("<");
        JButton coordination_b2 = new JButton(">");
        coordination_space.add(coordination_label);
        coordination_space.add(coordination_b1);
        coordination_space.add(coordination_num);
        coordination_space.add(coordination_b2);
        chara_creator.add(coordination_space);
        
        //Quirks panel
        /*JPanel quirk_panel = new JPanel();
        JLabel quirk_name = new JLabel("Quirks");
        JButton quirk_b1 = new JButton("Savant");
        JButton quirk_b2 = new JButton("Imbecile");
        JButton quirk_b3 = new JButton("Passivist");
        JButton quirk_b4 = new JButton("Socially inept");
        JButton quirk_b5 = new JButton("Sadist");
        JButton quirk_b6 = new JButton("Weird");
        quirk_panel.add(quirk_name);
        quirk_panel.add(quirk_b1);
        quirk_panel.add(quirk_b2);
        quirk_panel.add(quirk_b3);
        quirk_panel.add(quirk_b4);
        quirk_panel.add(quirk_b5);
        quirk_panel.add(quirk_b6);
        chara_creator.add(quirk_panel);*/

        //Create character button
        JButton create_char = new JButton("Create Character");
        chara_creator.add(create_char);
    //TODO: Make the status buttons change the displayed numbers and once the create character button is pushed it creates a new character object

    //These variables will be assigned values and be passed to the character constructor when the create character button is pushed
    // String name;
    // int age = 0; 
    // Integer chara_strength = 0;
    // int intelligence = 0;
    // int charisma = 0;
    // int coordination = 0;
    // HashMap<String,Integer> status = new HashMap<>();
    // String[] quirks = new String[2];
            //Changes values on click

            strength_b1.addActionListener(e -> {
                if(Integer.parseInt(strength_num.getText()) > 0) {
                strength_num.setText(String.valueOf(Integer.parseInt(strength_num.getText()) - 1));
                
                }
            });
            strength_b2.addActionListener(e -> {
                if(Integer.parseInt(strength_num.getText()) < 10) {
                    strength_num.setText(String.valueOf(Integer.parseInt(strength_num.getText()) + 1));
                }
            });
            int_b1.addActionListener(e -> {
                if(Integer.parseInt(int_num.getText()) > 0) {
                    int_num.setText(String.valueOf(Integer.parseInt(int_num.getText()) - 1));
                }
            });
            int_b2.addActionListener(e -> {
                if(Integer.parseInt(int_num.getText()) < 10) {
                    int_num.setText(String.valueOf(Integer.parseInt(int_num.getText()) + 1));
                }
            });
            charisma_b1.addActionListener(e -> {
                if(Integer.parseInt(charisma_num.getText()) > 0) {
                    charisma_num.setText(String.valueOf(Integer.parseInt(charisma_num.getText()) - 1));
                }
            });
            charisma_b2.addActionListener(e -> {
                if(Integer.parseInt(charisma_num.getText()) < 10) {
                    charisma_num.setText(String.valueOf(Integer.parseInt(charisma_num.getText()) + 1));
                }
            });
            coordination_b1.addActionListener(e -> {
                if(Integer.parseInt(coordination_num.getText()) > 0) {
                    coordination_num.setText(String.valueOf(Integer.parseInt(coordination_num.getText()) - 1));
                }
            });
            coordination_b2.addActionListener(e -> {
                if(Integer.parseInt(coordination_num.getText()) < 10) {
                    coordination_num.setText(String.valueOf(Integer.parseInt(coordination_num.getText()) + 1));
                }
            });
            

            //This Button creates the player character object
            create_char.addActionListener( e -> {
            String name = chara_name.getText(); 
                int strength = Integer.parseInt(strength_num.getText()) ;
                int intelligence = Integer.parseInt(int_num.getText());
                int charisma = Integer.parseInt(charisma_num.getText());
                int coordination = Integer.parseInt(coordination_num.getText());
                Character player = createCharacter(name, strength, intelligence, charisma, coordination);
                window.remove(chara_creator);
                Quirkwin(window, player);

    });

            
        window.add(chara_creator);
        window.revalidate();
        window.repaint();

        chara_creator.setLayout(new GridLayout(6, 3));
    }
    
    
    
    //This method displays the quirks window and creates and passes the hashmap for quirks to the SetQuirks method in Character
    public void Quirkwin(JPanel window, Character player) {
        JPanel quirkscreen = new JPanel();

        //Quirks panel
        JPanel quirk_panel = new JPanel();
        JLabel quirk_name = new JLabel("Quirks");
        JButton quirk_b1 = new JButton("Savant");
        JButton quirk_b2 = new JButton("Imbecile");
        JButton quirk_b3 = new JButton("Passivist");
        JButton quirk_b4 = new JButton("Socially inept");
        JButton quirk_b5 = new JButton("Sadist");
        JButton quirk_b6 = new JButton("Weird");
        JPanel submit_space = new JPanel();
        JButton submitButton = new JButton("Submit");
        submit_space.add(submitButton);
        quirk_panel.add(quirk_name);
        quirk_panel.add(quirk_b1);
        quirk_panel.add(quirk_b2);
        quirk_panel.add(quirk_b3);
        quirk_panel.add(quirk_b4);
        quirk_panel.add(quirk_b5);
        quirk_panel.add(quirk_b6);
        quirk_panel.add(submitButton);
        quirk_panel.add(submit_space);
        quirkscreen.add(quirk_panel);

        quirk_b1.addActionListener(e -> {
            if(!quirk_b1.getBackground().equals(Color.GREEN)) {
            quirk_b1.setBackground(Color.GREEN);
            }else if(quirk_b1.getBackground().equals(Color.GREEN)) {
            quirk_b1.setBackground(Color.LIGHT_GRAY);
            }
        });
        quirk_b2.addActionListener(e -> {
            if(!quirk_b2.getBackground().equals(Color.GREEN)) {
            quirk_b2.setBackground(Color.GREEN);
            }else if(quirk_b2.getBackground().equals(Color.GREEN)) {
            quirk_b2.setBackground(Color.LIGHT_GRAY);
            }
        });
        quirk_b3.addActionListener(e -> {
            if(!quirk_b3.getBackground().equals(Color.GREEN)) {
            quirk_b3.setBackground(Color.GREEN);
            }else if(quirk_b3.getBackground().equals(Color.GREEN)) {
            quirk_b3.setBackground(Color.LIGHT_GRAY);
            }
        });
        quirk_b4.addActionListener(e -> {
            if(!quirk_b4.getBackground().equals(Color.GREEN)) {
            quirk_b4.setBackground(Color.GREEN);
            }else if(quirk_b4.getBackground().equals(Color.GREEN)) {
            quirk_b4.setBackground(Color.LIGHT_GRAY);
            }
        });
        quirk_b5.addActionListener(e -> {
            if(!quirk_b5.getBackground().equals(Color.GREEN)) {
            quirk_b5.setBackground(Color.GREEN);
            }else if(quirk_b5.getBackground().equals(Color.GREEN)) {
            quirk_b5.setBackground(Color.LIGHT_GRAY);
            }
        });
        quirk_b6.addActionListener(e -> {
            if(!quirk_b6.getBackground().equals(Color.GREEN)) {
            quirk_b6.setBackground(Color.GREEN);
            }else if(quirk_b6.getBackground().equals(Color.GREEN)) {
            quirk_b6.setBackground(Color.LIGHT_GRAY);
            }
        });

        HashMap<Integer,Integer> quirks = new HashMap<>();
        
        submitButton.addActionListener(e -> {
            if (quirk_b1.getBackground().equals(Color.GREEN)) {
                int q1 = quirk_b1.getText().hashCode();
                quirks.put(q1, 1);
            }
            else {
                int q1 = quirk_b1.getText().hashCode();
                quirks.put(q1, 0);
            }
            if (quirk_b2.getBackground().equals(Color.GREEN)) {
                int q2 = quirk_b2.getText().hashCode();
                quirks.put(q2, 1);
            }
            else {
                int q2 = quirk_b2.getText().hashCode();
                quirks.put(q2, 0);
            }
            if (quirk_b3.getBackground().equals(Color.GREEN)) {
                int q3 = quirk_b3.getText().hashCode();
                quirks.put(q3, 1);
            }
            else {
                int q3 = quirk_b3.getText().hashCode();
                quirks.put(q3, 0);
            }
            if (quirk_b4.getBackground().equals(Color.GREEN)) {
                int q4 = quirk_b4.getText().hashCode();
                quirks.put(q4, 1);
            }
            else {
                int q4 = quirk_b4.getText().hashCode();
                quirks.put(q4, 0);
            }
            if (quirk_b5.getBackground().equals(Color.GREEN)) {
                int q5 = quirk_b5.getText().hashCode();
                quirks.put(q5, 1);
            }
            else {
                int q5 = quirk_b5.getText().hashCode();
                quirks.put(q5, 0);
            }
            if (quirk_b6.getBackground().equals(Color.GREEN)) {
                int q6 = quirk_b6.getText().hashCode();
                quirks.put(q6, 1);
            }
            else {
                int q6 = quirk_b6.getText().hashCode();
                quirks.put(q6, 0);
            }
            player.setQuirks(quirks);
        });
        

        

        quirkscreen.setLayout(new GridLayout(3, 3));
        window.add(quirkscreen);
        window.revalidate();
        window.repaint();
    }
    
    
    
    
    
    
    public Character createCharacter(String name, int strength, int intelligence, int charisma, int coordination) {
                Character player = new Character(name, strength, intelligence, charisma, coordination);
        return player;
            }
}
