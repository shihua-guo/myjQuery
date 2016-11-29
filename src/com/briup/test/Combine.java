package com.briup.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 此类用于实现映射
 * 
 * @author alan
 * @date Nov 26, 2016 10:43:10 AM
 */
public class Combine {
	public static void main(String[] args) {
		Combine combine = new Combine();
		combine.combine();
	}

	/**
	 * 用于映射
	 */
	public void combine() {
		String path1 = "src/com/briup/test/ica";
		String path2 = "src/com/briup/test/dpi";
		List<Object> icaList = saveIntList(path1);
		List<Object> dpiList = saveIntList(path2);

		System.out.println("原始的icaList长度：" + icaList.size());
		System.out.println("原始的dpiList长度：" + dpiList.size());
		int countAllMatch = 0;
		int countMatch = 0;

		// 存放完全匹配的
		List<Object> allMatchIcaList = new ArrayList<>();
		List<Object> allMatchDpiList = new ArrayList<>();

		// 存放失败的
		List<Object> matchIcaList = new ArrayList<>();
		List<Object> matchDpiList = new ArrayList<>();
		// 写入文件
		PrintWriter pw = null;
		try {
			FileWriter fw = new FileWriter(new File("src/com/briup/test/combine"), true);
			pw = new PrintWriter(fw);

			// flag：dpi中是否含有ica
			boolean ifDpiContainsIca = false;
			// 遍历ica
			for (int i = 0; i < icaList.size(); i++) {
				ifDpiContainsIca = false;
				Object ica = icaList.get(i);
				String nameSmallClassICA = ((ICA) ica).getNameSmallClass();
				// 判断是否完全一样。
				for (int k = 0; k < dpiList.size(); k++) {
					Object dpi = dpiList.get(k);
					String subClassNameDPI = ((DPI) dpi).getSubClassName();
					if (subClassNameDPI.equals(nameSmallClassICA)) {
						// 拼接
						String combine = ((DPI) dpi).toString() + ((ICA) ica).toString();
						// 写入文件
						pw.println(combine);
						pw.flush();
						// 把ica添加到完全匹配数组中
						allMatchIcaList.add(ica);
						// 把dpi添加都完全匹配数组中
						allMatchDpiList.add(dpi);
						countAllMatch++;
					}
				}
			}
			// 移除完全匹配的dpi
			dpiList.removeAll(allMatchDpiList);
			icaList.removeAll(allMatchIcaList);
			System.out.println("删除完全匹配后的dpiList长度：" + dpiList.size());
			System.out.println("完全匹配有：" + countAllMatch);
			
			//过滤完全匹配还能部分匹配的
			
			
			
			for (int i = 0; i < icaList.size(); i++) {
				ifDpiContainsIca = false;
				Object ica = icaList.get(i);
				String nameSmallClassICA = ((ICA) ica).getNameSmallClass();
				// 判断是否包含
				for (int j = 0; j < dpiList.size(); j++) {
					Object dpi = dpiList.get(j);
					String subClassNameDPI = ((DPI) dpi).getSubClassName();
					// 判断dpi中是否包含ica
					if (subClassNameDPI.indexOf(nameSmallClassICA) != -1) {
						// 拼接
						String combine = ((DPI) dpi).toString() + ((ICA) ica).toString();
						// 写入文件
						pw.println(combine);
						pw.flush();
						// 把匹配成功的元素添加到成功list
						matchDpiList.add(dpi);
						ifDpiContainsIca = true;

						// 计数
						countMatch++;
					}
				}
				if (ifDpiContainsIca) {
					matchIcaList.add(ica);
				}
			}

			// 移除失败的
			icaList.removeAll(matchIcaList);
			dpiList.removeAll(matchDpiList);
			System.out.println("删除后的部分匹配的icaList长度：" + icaList.size());
			System.out.println("删除后的部分匹配的dpiList长度：" + dpiList.size());
			System.out.println("部分匹配有：" + countMatch);

			System.out.println("icaList匹配失败的有:" + icaList.size());
			System.out.println("dpiList匹配失败的有:" + dpiList.size());

			// 计数
			// 把失败的写入文件
			FileWriter fwIcaFail = new FileWriter(new File("src/com/briup/test/ica_fail"), true);
			FileWriter fwDpiFail = new FileWriter(new File("src/com/briup/test/dpi_fail"), true);
			PrintWriter pwIcaFail = new PrintWriter(fwIcaFail);
			PrintWriter pwDpiFail = new PrintWriter(fwDpiFail);
			for (Object ica : icaList) {
				pwIcaFail.println(ica.toString());
				pwIcaFail.flush();
			}
			for (Object dpi : dpiList) {
				pwDpiFail.println(dpi.toString());
				pwDpiFail.flush();
			}

			pwIcaFail.close();
			pwDpiFail.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}

	}

	/**
	 * 把文件内容读取到对象，然后再存入数组中
	 * 
	 * @param file
	 */
	public List<Object> saveIntList(String path) {
		// 读取文件
		FileReader fr;
		try {
			List<Object> list = new ArrayList<>();
			fr = new FileReader(new File(path));
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			String[] atts = null;
			while ((line = br.readLine()) != null) {
				atts = line.split("	");
				if ("src/com/briup/test/dpi".equals(path)) {
					DPI dpi = new DPI(atts);
					list.add(dpi);
				} else if ("src/com/briup/test/ica".equals(path)) {
					ICA ica = new ICA(atts);
					list.add(ica);
				}
			}
			return list;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void saveInFile(String combine) {
		// 写入文件
		FileWriter fw = null;
		try {
			fw = new FileWriter(new File("src/com/briup/test/combine"), true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(combine);
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
