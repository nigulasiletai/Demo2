package cn.longteng.demo;

/*
 * 在本次程序设计过程中遇到了很多问题。比如0-100的随机数如何产生；
 * 如何处理负数的问题；
 * 还有处理除数为零及算式结果不能为小数的问题；
 * 还有符号之间的选择；
 * 为了处理算式运算过程中不能产生小数。又因本人能力有限，设计的程序大大降低了出题的随机性。
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
	int a, b, c, d, e, f, g, m;
	static int n = 200;
	static int[] s = new int[n];
	String[] st = new String[n];
	static String[] ts = new String[n];
	String[] tk = new String[n];
	static String[] qu = new String[20];
	static int[] an = new int[20];

	public Main() {
		try {
			Num();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 产生随机数和运算：
	public void Num() throws FileNotFoundException {

		FileOutputStream os = new FileOutputStream(new File("src/cn/longteng/demo/QuestionBank.docx"));
		PrintStream p = new PrintStream(os);

		for (int k = 0; k < n; k++) {
			a = (int) (Math.random() * 100 + 1);
			b = (int) (Math.random() * 100 + 1);
			c = (int) (Math.random() * 100 + 1);
			e = (int) (Math.random() * 10 + 1);
			m = (int) (Math.random() * 6);
			d = m * e;
			f = (int) (Math.random() * 5);
			if (f == 0) {
				s[k] = a * b - d / e + c;
				// 处理负数；
				if (a * b - d / e >= 0) {
					ts[k] = a + "*" + b + "-" + d + "/" + e + "+" + c + "=";
					st[k] = a + "*" + b + "-" + d + "/" + e + "+" + c + "=" + s[k];
					// System.out.println(ts[k] + "\n");
				} else {
					s[k] = d / e - a * b + c;
					ts[k] = d + "/" + e + "-" + a + "*" + b + "+" + c + "=";
					st[k] = d + "/" + e + "-" + a + "*" + b + "+" + c + "=" + s[k];
					// System.out.println(ts[k] + "\n");
				}
			} else if (f == 1) {
				s[k] = a + b * d / e - c;
				// 处理负数；
				if (b * d / e - c >= 0) {
					ts[k] = a + "+" + b + "*" + d + "/" + e + "-" + c + "=";
					st[k] = a + "+" + b + "*" + d + "/" + e + "-" + c + "=" + s[k];
					// System.out.println(ts[k] + "\n");
				} else {
					s[k] = c - b * d / e + a;
					ts[k] = c + "-" + b + "*" + d + "/" + e + "+" + a + "=";
					st[k] = c + "-" + b + "*" + d + "/" + e + "+" + a + "=" + s[k];
					// System.out.println(ts[k] + "\n");
				}
			} else if (f == 2) {
				s[k] = d / e - a * c + b;
				// 处理负数；
				if (d / e - a * c >= 0) {
					ts[k] = d + "/" + e + "-" + a + "*" + c + "+" + b + "=";
					st[k] = d + "/" + e + "-" + a + "*" + c + "+" + b + "=" + s[k];
					// System.out.println(ts[k] + "\n");
				} else {
					s[k] = a * c - d / e + b;
					ts[k] = a + "*" + c + "-" + d + "/" + e + "+" + b + "=";
					st[k] = a + "*" + c + "-" + d + "/" + e + "+" + b + "=" + s[k];
					// System.out.println(ts[k] + "\n");
				}
			} else if (f == 3) {
				s[k] = a * c - (b + a) + d / e;
				if (a * c - (b + a) >= 0) {
					ts[k] = a + "*" + c + "-" + "(" + b + "+" + a + ")" + "+" + d + "/" + e + "=";
					st[k] = a + "*" + c + "-" + "(" + b + "+" + a + ")" + "+" + d + "/" + e + "=" + s[k];
					// System.out.println(ts[k]+"\n");
				} else {
					s[k] = (b + a) - a * c + d / e;
					ts[k] = "(" + b + "+" + a + ")" + "-" + a + "*" + c + "+" + d + "/" + e + "=";
					st[k] = "(" + b + "+" + a + ")" + "-" + a + "*" + c + "+" + d + "/" + e + "=" + s[k];
					// System.out.println(ts[k]+"\n");
				}
			} else if (f == 4) {
				s[k] = (a - b) * c - d / e;
				if (a - b >= 0) {
					if ((a - b) * c - d / e >= 0) {
						ts[k] = "(" + a + "-" + b + ")" + "*" + c + "-" + d + "/" + e + "=";
						st[k] = "(" + a + "-" + b + ")" + "*" + c + "-" + d + "/" + e + "=" + s[k];
						// System.out.println(ts[k]+"\n");
					} else {
						s[k] = d / e - (a - b) * c;
						ts[k] = d + "/" + e + "-" + "(" + a + "-" + b + ")" + "*" + c + "=";
						st[k] = d + "/" + e + "-" + "(" + a + "-" + b + ")" + "*" + c + "=" + s[k];
						// System.out.println(ts[k]+"\n");
					}
				} else {
					s[k] = (b - a) * c - d / e;
					if ((b - a) * c - d / e >= 0) {
						ts[k] = "(" + b + "-" + a + ")" + "*" + c + "-" + d + "/" + e + "=";
						st[k] = "(" + b + "-" + a + ")" + "*" + c + "-" + d + "/" + e + "=" + s[k];
						// System.out.println(ts[k]+"\n");
					} else {
						s[k] = d / e - (b - a) * c;
						ts[k] = d + "/" + e + "-" + "(" + b + "-" + a + ")" + "*" + c + "=";
						st[k] = d + "/" + e + "-" + "(" + b + "-" + a + ")" + "*" + c + "=" + s[k];
						// System.out.println(ts[k]+"\n");
					}
				}
			}

			p.println(st[k]);
		}
		p.close();
	}

}
