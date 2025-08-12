import javax.swing.*;
import java.awt.*;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        // bg settings :p
        UIManager.put("Panel.background", new Color(255, 228, 225));                    // light pink background
        UIManager.put("OptionPane.background", new Color(255, 228, 225));
        UIManager.put("Button.background", new Color(255, 192, 203));                   // pink buttons
        UIManager.put("Button.foreground", Color.BLACK);                                         // button text
        UIManager.put("OptionPane.messageForeground", Color.DARK_GRAY);                          // text color
        UIManager.put("OptionPane.messageFont", new Font("Inter", Font.PLAIN, 16));

        // custom icon
        ImageIcon icon = new ImageIcon("stuff/envelope.png");
        icon.setImage(icon.getImage().getScaledInstance(100, 125, Image.SCALE_SMOOTH));

        // Dialog loop
        String title = "NOTICE";
        String message = "do you like me?";
        Object[] options = {"Yes", "No", "Cancel"};

        int result;
        do {
            result = JOptionPane.showOptionDialog(
                    null,
                    message,
                    title,
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    icon,
                    options,
                    options[2]
            );
        } while (result == JOptionPane.NO_OPTION || result == JOptionPane.CANCEL_OPTION);   // bawal mag no dito boi

        if (result == JOptionPane.YES_OPTION) {
            playMusic("stuff/careless_whisper.wav");    // music LOLL
            JOptionPane.showMessageDialog(
                    null,
                    "i like you too ;)",    // yieeeeee cute naman anyway escucha las palabras de
                                                    // las brujas los secretos escondidos de la noche los
                                                    // antiguos dioses invocamos ahora la obra de la magia
                                                    // oculta está noche
                    title,
                    JOptionPane.INFORMATION_MESSAGE,
                    icon
            );

        }
    }

    public static void playMusic(String musicFile)
    {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(musicFile));
            clip.open(inputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}

