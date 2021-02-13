package homework.task8;
enum Color{
    RED(0xF00),

    GREEN(0x0F0),

    BLUE(0x00F);

    private final int colorCode;

    Color(int colorCode) {
        this.colorCode = colorCode;
    }

    public int getValue() {
        return colorCode;
    }
}