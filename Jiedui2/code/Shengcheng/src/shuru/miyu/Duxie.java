package shuru.miyu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



public class Duxie {
	public static void xie(Shuchulei out, File file) {
		GsonBuilder gsb = new GsonBuilder();
		gsb.setPrettyPrinting();
		Gson gs = gsb.create();
		//System.out.println(gs.toJson(p));
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file),"UTF-8"));
			
			bw.append(gs.toJson(out));
			bw.newLine();
			bw.flush();
			bw.close();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
