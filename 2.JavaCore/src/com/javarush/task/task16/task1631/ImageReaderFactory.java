package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type) {

        if (type != null) {
            if (type.equals(ImageTypes.BMP)) return new BmpReader();
            else if (type.equals(ImageTypes.JPG)) return new JpgReader();
            else if (type.equals(ImageTypes.PNG)) return new PngReader();
        }
        throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
//попробуй вместо
//if (imageTypes.equals(ImageTypes.JPG))
//использовать
//if (imageTypes == ImageTypes.JPG)

//ImageReader toReturn = null;
//        if (type != null) {
//            switch (type) {
//                case JPG:
//                    toReturn = new JpgReader();
//                    break;
//                case BMP:
//                    toReturn = new BmpReader();
//                    break;
//                case PNG:
//                    toReturn = new PngReader();
//                    break;
//                default:
//                    throw new IllegalArgumentException("Неизвестный тип картинки");
//            }
//
//        }
//        return toReturn;
//        }