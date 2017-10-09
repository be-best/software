package json.miyu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



public class Duxie {
	public static Shurulei du(File file) {
		Shurulei pf;
		GsonBuilder gsb = new GsonBuilder();
		gsb.setPrettyPrinting();
		Gson gs = gsb.serializeNulls().create();
		BufferedReader br;String info = "",str;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
			while((str = br.readLine()) != null){
				info = info + str;
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(info);
		pf = gs.fromJson(info, Shurulei.class);
		return pf;
	}
	
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
