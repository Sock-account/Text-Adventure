import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.function.IntConsumer;
public class Window extends JFrame {

    //The game screen's terminal look. Kept in one place so the story area and the dialogue
    //buttons are styled from the same values and cannot drift apart later
    private static final Font TERMINAL_FONT = new Font("Monospaced", Font.PLAIN, 14);
    private static final Color TERMINAL_BG = Color.BLACK;
    private static final Color TERMINAL_FG = Color.GREEN;

    // Creates the GUI for the game
    public Window(){
        //BorderLayout is what makes the screens scale: whatever sits in CENTER
        //is stretched to fill the frame instead of staying at its preferred size
        JPanel window = new JPanel(new BorderLayout());
        JPanel start = new JPanel(new GridBagLayout());

        JLabel Title = new JLabel("Sand Pit");
        Title.setFont(Title.getFont().deriveFont(Font.BOLD, 28f));

        // Sets up the logic for the start screen
        JButton sb = new JButton("Start");

        //A single GridBag column keeps the title and button centred at any window size
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        start.add(Title, gbc);
        start.add(sb, gbc);

        window.add(start, BorderLayout.CENTER);

        sb.addActionListener(q ->{
            window.remove(start);
            Chara_Creator(window);
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(window);
        this.setTitle("Sand Pit");
        this.setSize(new Dimension(600, 500));
        this.setMinimumSize(new Dimension(380, 340));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void Chara_Creator(JPanel window){
        //This should display the character creation screen
        //The name row and the create button keep their natural height at the top and
        //bottom, while stat_rows takes the space left over and splits it evenly.
        //GridLayout(0, 1) is one column with as many rows as there are stats.
        JPanel chara_creator = new JPanel(new BorderLayout());
        JPanel stat_rows = new JPanel(new GridLayout(0, 1));
        chara_creator.add(stat_rows, BorderLayout.CENTER);

        //This is the panel for the character's name
        JPanel chara_name_panel = new JPanel();
        JTextField chara_name = new JTextField(20);
        JLabel name_label = new JLabel("Name");
        chara_name_panel.add(chara_name);
        chara_name_panel.add(name_label);
        chara_creator.add(chara_name_panel, BorderLayout.NORTH);

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
        stat_rows.add(strength_space);
        
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
        stat_rows.add(int_space);
        
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
        stat_rows.add(charisma_space);

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
        stat_rows.add(coordination_space);
        
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

        //Create character button. Wrapping it in a FlowLayout panel before putting that
        //panel in SOUTH is what keeps the button at its own size - a button added to a
        //BorderLayout region directly gets stretched to fill that whole region.
        JPanel create_space = new JPanel();
        JButton create_char = new JButton("Create Character");
        create_space.add(create_char);
        chara_creator.add(create_space, BorderLayout.SOUTH);
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

            
        window.add(chara_creator, BorderLayout.CENTER);
        window.revalidate();
        window.repaint();
    }
    
    
    
    //This method displays the quirks window and creates and passes the hashmap for quirks to the SetQuirks method in Character
    public void Quirkwin(JPanel window, Character player) {
        JPanel quirkscreen = new JPanel(new BorderLayout());

        //Quirks panel: the heading and submit button keep their natural height at the
        //top and bottom, while the grid of quirk buttons takes all the space left over.
        //GridLayout stretches every child to fill its cell and ignores setPreferredSize,
        //so the buttons are shrunk indirectly: the last two GridLayout arguments are the
        //horizontal and vertical gaps between cells, and the EmptyBorder insets the whole
        //grid from the edges of the CENTER region. Both take space away from the cells.
        JPanel quirk_panel = new JPanel(new GridLayout(0, 2, 20, 20));
        quirk_panel.setBorder(BorderFactory.createEmptyBorder(20, 60, 20, 60));
        JLabel quirk_name = new JLabel("Quirks", SwingConstants.CENTER);
        JButton quirk_b1 = new JButton("Savant");
        JButton quirk_b2 = new JButton("Imbecile");
        JButton quirk_b3 = new JButton("Passivist");
        JButton quirk_b4 = new JButton("Socially inept");
        JButton quirk_b5 = new JButton("Sadist");
        JButton quirk_b6 = new JButton("Weird");
        JPanel submit_space = new JPanel();
        JButton submitButton = new JButton("Submit");
        submit_space.add(submitButton);
        quirk_panel.add(quirk_b1);
        quirk_panel.add(quirk_b2);
        quirk_panel.add(quirk_b3);
        quirk_panel.add(quirk_b4);
        quirk_panel.add(quirk_b5);
        quirk_panel.add(quirk_b6);
        quirkscreen.add(quirk_name, BorderLayout.NORTH);
        quirkscreen.add(quirk_panel, BorderLayout.CENTER);
        quirkscreen.add(submit_space, BorderLayout.SOUTH);

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

            window.remove(quirkscreen);
            Game_start(player, window);
        });
        

        

        window.add(quirkscreen, BorderLayout.CENTER);
        window.revalidate();
        window.repaint();
    }
    
    //This method builds the main game screen and types out the opening text
    public static void Game_start(Character player, JPanel window){
        JPanel gamescreen = new JPanel(new BorderLayout());
        gamescreen.setBackground(TERMINAL_BG);

        JTextArea story = new JTextArea(10, 34);
        story.setEditable(false);
        story.setLineWrap(true);
        story.setWrapStyleWord(true);
        story.setFont(TERMINAL_FONT);
        story.setBackground(TERMINAL_BG);
        story.setForeground(TERMINAL_FG);
        story.setMargin(new Insets(8, 8, 8, 8));

        //A JScrollPane draws its own etched border and its viewport has its own background,
        //neither of which come from the text area inside it - left alone they frame the
        //story in a grey box that breaks the terminal look
        JScrollPane story_scroll = new JScrollPane(story);
        story_scroll.setBorder(BorderFactory.createEmptyBorder());
        story_scroll.getViewport().setBackground(TERMINAL_BG);
        gamescreen.add(story_scroll, BorderLayout.CENTER);

        //The dialogue options sit in SOUTH. A BorderLayout gives SOUTH the full width but
        //only the height its contents ask for, so the story area in CENTER keeps whatever
        //is left - the options never squash it the way a CENTER component would.
        //GridLayout(0, 1) stacks one full-width button per option, however many there are.
        //The panel's own background shows through the gaps between buttons and the border
        //around them, so it has to be black too or the options sit in a grey tray.
        JPanel options_panel = new JPanel(new GridLayout(0, 1, 4, 4));
        options_panel.setBackground(TERMINAL_BG);
        options_panel.setBorder(BorderFactory.createEmptyBorder(6, 8, 8, 8));
        gamescreen.add(options_panel, BorderLayout.SOUTH);

        window.add(gamescreen, BorderLayout.CENTER);
        window.revalidate();
        window.repaint();

        String opening = "You wake to a impregnable darkness. Cloaked in an all encompassing warmth. You want to sleep but I strange groan is heard." +
        "You try to close your eyes but the groaning grows louder.";

        String[] opening_options = {"Open your eyes.", "Stay still and listen.", "Call out."};

        //The options are only shown once the opening has finished typing, so the player
        //isn't offered a choice partway through a sentence.
        typeText(story, opening, 35, () -> setOptions(options_panel, opening_options, choice -> {
            //TODO: each choice should lead to its own scene. For now the pick is echoed
            //back into the story so the wiring is visible end to end.
            setOptions(options_panel, new String[0], null);
            typeText(story, "\n\n> " + opening_options[choice] + "\n", 35);
        }));
    }

    //Fills the dialogue panel with one button per option, replacing whatever was there
    //before. onChoice is handed the index of the button that was pressed, so this method
    //never needs to know anything about the story - the caller decides what happens next.
    //Passing an empty array clears the panel.
    public static void setOptions(JPanel panel, String[] options, IntConsumer onChoice) {
        panel.removeAll();

        for (int i = 0; i < options.length; i++) {
            //The lambda below outlives this loop pass, and Java only lets a lambda capture
            //a variable that never changes, so the counter is copied into a fresh local
            int choice = i;
            JButton option = terminalButton(options[i]);
            option.addActionListener(e -> onChoice.accept(choice));
            panel.add(option);
        }

        //Swing does not re-run the layout for components added after the panel is already
        //on screen until it is told the contents changed. Without revalidate the new
        //buttons are never given a size or position, so they simply do not appear.
        panel.revalidate();
        panel.repaint();
    }

    //Builds a dialogue button styled to match the story area: green monospaced text on
    //black, in a green box.
    public static JButton terminalButton(String text) {
        JButton button = new JButton(text);
        button.setFont(TERMINAL_FONT);
        button.setForeground(TERMINAL_FG);
        button.setBackground(TERMINAL_BG);

        //setBackground alone is not enough here. The look and feel paints its own shaded
        //button face over the whole content area, which hides the colour underneath -
        //that is the same reason the green highlight on the quirk buttons is unreliable.
        //Switching the content area off and marking the button opaque hands the fill back
        //to Swing's plain background painting, which does honour setBackground.
        button.setContentAreaFilled(false);
        button.setOpaque(true);

        //A green outline with room to breathe inside it. A compound border is how two
        //borders are combined: the line goes on the outside, the padding on the inside.
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(TERMINAL_FG),
                BorderFactory.createEmptyBorder(6, 10, 6, 10)));

        //Without the look and feel's button face there is no pressed or hover shading left,
        //so the colours are swapped by hand on the way in and out to keep the feedback
        button.setFocusPainted(false);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(TERMINAL_FG);
                button.setForeground(TERMINAL_BG);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(TERMINAL_BG);
                button.setForeground(TERMINAL_FG);
            }
        });

        return button;
    }

    //Reveals text one character at a time so it reads like it is being typed out.
    //Clicking the text area skips ahead to the finished message.
    public static void typeText(JTextArea area, String text, int delayMs) {
        typeText(area, text, delayMs, null);
    }

    //Same, but runs onFinished once the whole message is on screen - whether it typed all
    //the way out or the player clicked to skip it. That is what lets the caller hold the
    //dialogue options back until the text they belong to has actually been read out.
    public static void typeText(JTextArea area, String text, int delayMs, Runnable onFinished) {
        //Held in arrays so the listeners below can update them as they run
        int[] index = {0};
        boolean[] done = {false};
        javax.swing.Timer typer = new javax.swing.Timer(delayMs, null);
        //The skip listener has to be referenced by the code that removes it, and built by
        //code that calls back into it, so it is parked in a one-element array to break the
        //circle - neither half can be written before the other otherwise
        MouseAdapter[] skipper = new MouseAdapter[1];

        //Both finishing paths funnel through here, and the done flag makes it run its body
        //only once, so onFinished can never fire twice for one message
        Runnable finish = () -> {
            if (done[0]) {
                return;
            }
            done[0] = true;
            typer.stop();
            area.append(text.substring(index[0]));
            index[0] = text.length();
            area.removeMouseListener(skipper[0]);
            if (onFinished != null) {
                onFinished.run();
            }
        };

        typer.addActionListener(e -> {
            area.append(String.valueOf(text.charAt(index[0])));
            index[0]++;
            if (index[0] >= text.length()) {
                finish.run();
            }
        });

        skipper[0] = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                finish.run();
            }
        };
        area.addMouseListener(skipper[0]);

        typer.start();
    }
    
    
    
    
    public Character createCharacter(String name, int strength, int intelligence, int charisma, int coordination) {
                Character player = new Character(name, strength, intelligence, charisma, coordination);
        return player;
            }
}
