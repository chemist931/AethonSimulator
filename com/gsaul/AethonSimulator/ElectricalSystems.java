package gsaul.AethonSimulator;

import javax.swing.*;
import java.awt.*;
import java.nio.file.FileSystem;
import java.nio.file.Path;

public class ElectricalSystems extends JPanel
{
    public ElectricalSystems()
    {
        setLayout(new FlowLayout());
        JLabel test = new JLabel("JLabel es");
        add(test);
    }

    public double getSOC()
    {
        return 555.555;
    }
}
