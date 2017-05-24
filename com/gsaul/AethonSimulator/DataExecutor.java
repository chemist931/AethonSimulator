package gsaul.AethonSimulator;

import java.util.Map;

public interface DataExecutor
{
	void updateVars(Map<String, DataExecutor> map);

	Object getVal();

	String getName();
}
