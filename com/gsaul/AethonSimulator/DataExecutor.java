package gsaul.AethonSimulator;

import java.util.HashMap;

public interface DataExecutor
{
	void updateVars(HashMap<String, DataExecutor> map);

	Object getVal();

	String getName();
}
