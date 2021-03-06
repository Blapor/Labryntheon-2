package maze.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import maze.Button;
import maze.Main;
import maze.Character;
import static maze.Main.height;
import static maze.Main.width;
import maze.Player;

/**
 *
 * @author Alex and Ryan
 */
public class StartMenuState extends State{
    
    private Button newGameButton;
    private Button loadGameButton;
    private Button settingsButton;
    private Button instructionButton;
    private Button creditsButton;
    private Button endButton;
    private Player player;
    private Character pc;
    
    public StartMenuState(Main main){
        super(main);
        player = main.getPlayer();
        pc = main.getCharacter();
        newGameButton = new Button(Color.darkGray, Color.green,width/2 - 128, height/7, 256,64, "Start New Game");
        loadGameButton = new Button(Color.darkGray, Color.green,width/2 - 128, height*2/7, 256,64, "Load Previous Save");
        settingsButton = new Button(Color.darkGray, Color.green,width/2 - 128, height*3/7, 256,64, "Options");
        instructionButton = new Button(Color.darkGray, Color.green,width/2 - 128, height*4/7, 256,64, "How To Play");
        creditsButton = new Button(Color.darkGray, Color.green,width/2 - 128, height*5/7, 256,64, "Credits");
        endButton = new Button(Color.darkGray, Color.green,width/2 - 128, height*6/7, 256,64, "Exit Game");
    }
    
    @Override
    public void update() {
        newGameButton.update((int)player.getMouseX(), (int)player.getMouseY());
        loadGameButton.update((int)player.getMouseX(), (int)player.getMouseY());
        settingsButton.update((int)player.getMouseX(), (int)player.getMouseY());
        instructionButton.update((int)player.getMouseX(), (int)player.getMouseY());
        creditsButton.update((int)player.getMouseX(), (int)player.getMouseY());
        endButton.update((int)player.getMouseX(), (int)player.getMouseY());
        
        if(newGameButton.click(player.getLeftPressed())){
            pc.newGame();
        	State.setState(main.getDiffMenuState());
        }
        if(loadGameButton.click(player.getLeftPressed())){
        	State.setState(main.getSaveLoaderState());
        }
        if(settingsButton.click(player.getLeftPressed())){
        	State.setState(main.getSettingsMenuState());
        }
        if(instructionButton.click(player.getLeftPressed())){
            State.setState(main.getHowToMenuState());
        }
        if(creditsButton.click(player.getLeftPressed())){
            State.setState(main.getCreditsState());
        }
        if(endButton.click(player.getLeftPressed())){
            System.exit(0);
        }
    }

    @Override
    public void render(Graphics g) {
        newGameButton.render(g);
        endButton.render(g);
        
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
        g.setColor(Color.yellow);
        g.drawString("Chasey Atom", (width/2) - (g.getFontMetrics().stringWidth("Chasey Atom") / 2), (height/4) - 32);
        
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        g.setColor(Color.white);
        g.drawString(startButton.getText(), (width/2) - (g.getFontMetrics().stringWidth(startButton.getText()) / 2), (height/3 + 32));
        g.drawString(endButton.getText(), (width/2) - (g.getFontMetrics().stringWidth(endButton.getText()) / 2), (height/2 + 32));
        
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        g.setColor(Color.white);
        g.drawString(Main.VERSION, 0,12);
    }

    @Override
    public void reloadState() {
    }
    
    
}
