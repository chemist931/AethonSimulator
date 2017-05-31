package gsaul.AethonSimulator.Panels;

import gsaul.AethonSimulator.DataExecutor;

import javax.swing.*;
import java.awt.*;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.util.Map;

public class CargoStates extends JPanel
{
    private double draw;
    public CargoStates()
    {
        setLayout(new GridLayout(10, 2));
        setBackground(Color.DARK_GRAY.darker());
    }

    public void updateVars(Map<String, DataExecutor> executorMap)
    {

    }
}
