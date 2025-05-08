import java.awt.*;
public class ListFonts_Lab03 {
    public static void main(String[] args) {
        String[] fontNames = GraphicsEnvironment
        .getLocalGraphicsEnvironment()
        .getAvailableFontFamilyNames();
        for(String fontName:fontNames)
        System.out.println(fontName);
    }
    
}