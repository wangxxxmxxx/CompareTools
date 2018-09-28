package com.dcits.compare.tar.commonflow;

import java.io.File;

import com.dcits.compare.tar.constants.TarConstants;
import com.dcits.compare.tar.utils.FileUtils;
import com.dcits.compare.tar.utils.TarFileUtils;
import com.dcits.core.IValveContext;
import com.dcits.core.impl.ValveBase;
import com.dcits.utils.PrintUtils;

public class ExtractTarValve extends ValveBase{

	@Override
	public String getInfo() {
		return "解压tar文件";
	}

	@Override
	public void invokeHook(String orig, String dest, IValveContext context) {
		PrintUtils.print(getInfo());
		PrintUtils.printLine();
		
		//删除old解压的临时文件
	    String oldDir = System.getProperty("user.dir") + File.separator + ".tmp";
	    FileUtils.delAllFile(oldDir);
		String extractOrigDir = System.getProperty("user.dir") + File.separator + ".tmp" + File.separator + "orig" + File.separator;
		String extractDestDir = System.getProperty("user.dir") + File.separator + ".tmp" + File.separator + "dest" + File.separator;
		TarFileUtils.deCompressTARFile(orig, extractOrigDir);
		TarFileUtils.deCompressTARFile(dest, extractDestDir);
		
		PrintUtils.printLine();
		
		//存放结果传递给下一个valve
	    context.setTemp(TarConstants.ORIG_EXTRACT, extractOrigDir);
	    context.setTemp(TarConstants.DEST_EXTRACT, extractDestDir);
	    context.setTemp(TarConstants.IS_EXTRACT, true);
	}

}
