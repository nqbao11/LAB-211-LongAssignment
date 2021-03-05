
//import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
// import java.util.regex.Matcher;
// import java.util.regex.Pattern;

class testNormalize {
    public String chuanHoa(String str) {
        str = str.trim();
        str = str.replaceAll("\s+", " ");
        return str;
    }

    public String readFile(String path) {
        String empty = "";
        try {
            Scanner sc = new Scanner(new File(path));
            while (sc.hasNext()) {
                String line = sc.nextLine();
                if (!line.isEmpty()) {
                    empty += line;
                    empty += "\n";
                }
            }
        } catch (Exception e) {
        }
        return empty;
    }

    public void writeFile(String str) {
        try {
            FileWriter writer = new FileWriter("test1.txt");
            writer.write(str);
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String chuanHoa2(String str) {

        String[] strArr = str.split("");
        String empty = "";
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].matches("[.,!?]") && strArr[i + 1].matches("[a-zA-Z]"))
                empty += strArr[i] + " ";

            else
                empty += strArr[i];
        }
        return empty;
    }

    public String chuanHoa3(String str) {
        String[] strArr = str.split("");
        String empty = "";
        int flag = -1;
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].matches("[.!?]") && strArr[i + 1].equals(" ")) {
                flag = i + 2;
            }
            if (flag == i) {
                empty += strArr[i].toUpperCase();
            } else
                empty += strArr[i];
        }
        return empty;
    }

    public String chuanHoa4(String str) {
        String[] strArr = str.split("");
        String empty = "";
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals(" ") && strArr[i + 1].matches("[.!,?]"))
                empty += "";
            else
                empty += strArr[i];
        }
        return empty;
    }

    // public String chuanHoa5(String str) {
    // str.replaceAll("/(\s\'\s)/", "(\s\')");
    // return str;
    // }

    public static void main(String[] args) {
        testNormalize program = new testNormalize();
        String str = program.readFile("test.txt");
        System.out.println(str);
        System.out.println(program.chuanHoa(str));
        // System.out.println(program.chuanHoa3("Xin chao cac ban. toi ten la. cai gi
        // do"));
        // System.out.println(program.chuanHoa2("Xin chao cac ban.toi ten la,abxyz"));
        // System.out.println(program.chuanHoa4("Xin chao cac ban . Toi lasdjfnjsdf"));
        // System.out.println(program.chuanHoa5("XIn chao cac ban ( asdsad ) ' asdasd'
        // "));

        // System.out.println(program.readFile("test.txt"));
        program.writeFile(program.chuanHoa(str));
    }
}