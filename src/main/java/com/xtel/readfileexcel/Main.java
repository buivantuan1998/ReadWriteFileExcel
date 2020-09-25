/**
 * 
 */
package com.xtel.readfileexcel;

import java.io.IOException;

/**
 * @author admin
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		WriteFileExcel w = new WriteFileExcel();
		ReadFileExcel r = new ReadFileExcel();
		w.writeFileExcel();
		r.readFileExcel();
	}

}
