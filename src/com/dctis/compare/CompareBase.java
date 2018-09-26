package com.dctis.compare;

import com.dctis.core.ICompare;
import com.dctis.core.IPipeline;
import com.dctis.core.IValve;

public class CompareBase implements ICompare, IPipeline{
	private SimplePipeline pipeline = new SimplePipeline();
	
	@Override
	public synchronized void addValve(IValve valve) {
	    pipeline.addValve(valve);
	 }

	@Override
	public IValve[] getValves() {
		return pipeline.getValves();
	}

	@Override
	public void invoke(String orig, String dest) {
		pipeline.invoke(orig, dest);
	}

	@Override
	public void removeValve(IValve valve) {
		pipeline.removeValve(valve);
	}

	@Override
	public void compare(String orig, String dest) {
		invoke(orig, dest);
	}

}
