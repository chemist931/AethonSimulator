package gsaul.AethonSimulator;

import javax.swing.*;
import java.awt.*;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.util.Map;

class CargoStates extends JPanel
{
    private double draw;
    CargoStates()
    {
        setLayout(new GridLayout(10, 2));
        setBackground(Color.DARK_GRAY.darker());
    }

    void updateVars(Map<String, DataExecutor> executorMap)
    {

    }
}
