package pl.akademiakodu.bestroute.model;

public class Funcion {
    public static String getNameWithoutSpace(String name) {
        StringBuilder nameSb = new StringBuilder();
        char c;
        for (int i = 0; i < name.length(); i++) {
            c = name.charAt(i);
            if (c == 32) {
                nameSb.append('_');
            } else {
                nameSb.append(c);
            }
        }
        return nameSb.toString();
    }
}
